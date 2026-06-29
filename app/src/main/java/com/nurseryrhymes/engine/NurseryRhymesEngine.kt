package com.nurseryrhymes.engine

import com.nurseryrhymes.domain.model.GameStatus
import com.nurseryrhymes.domain.model.NurseryRhymesGame
import com.nurseryrhymes.domain.model.NurseryRhymesLevel
import com.nurseryrhymes.domain.model.Rhyme

object NurseryRhymesEngine {

    fun createInitialGame(level: NurseryRhymesLevel): NurseryRhymesGame =
        NurseryRhymesGame(level = level)

    fun validateLevel(level: NurseryRhymesLevel): Boolean =
        level.rhymes.isNotEmpty() && level.rhymes.all { it.lines.isNotEmpty() }

    fun currentRhyme(game: NurseryRhymesGame): Rhyme? =
        game.level.rhymes.getOrNull(game.currentRhymeIndex)

    fun currentLine(game: NurseryRhymesGame): String? =
        currentRhyme(game)?.lines?.getOrNull(game.currentLineIndex)

    fun canNextLine(game: NurseryRhymesGame): Boolean =
        !game.isCompleted && game.status == GameStatus.IN_PROGRESS

    fun canPrevLine(game: NurseryRhymesGame): Boolean =
        !game.isCompleted && (game.currentLineIndex > 0 || game.currentRhymeIndex > 0)

    fun nextLine(game: NurseryRhymesGame): NurseryRhymesGame {
        if (!canNextLine(game)) return game
        val rhyme = currentRhyme(game) ?: return game
        val now = System.currentTimeMillis()

        if (game.currentLineIndex < rhyme.lines.lastIndex) {
            return game.copy(
                currentLineIndex = game.currentLineIndex + 1,
                moves = game.moves + 1,
                lastPlayedAt = now
            )
        }

        val completed = game.completedRhymeIndices + game.currentRhymeIndex
        val nextRhymeIndex = game.currentRhymeIndex + 1
        val hasMoreRhymes = nextRhymeIndex < game.level.rhymes.size

        return if (hasMoreRhymes) {
            game.copy(
                completedRhymeIndices = completed,
                currentRhymeIndex = nextRhymeIndex,
                currentLineIndex = 0,
                moves = game.moves + 1,
                lastPlayedAt = now
            )
        } else {
            game.copy(
                completedRhymeIndices = completed,
                moves = game.moves + 1,
                status = GameStatus.COMPLETED,
                completedAt = now,
                lastPlayedAt = now
            )
        }
    }

    fun prevLine(game: NurseryRhymesGame): NurseryRhymesGame {
        if (!canPrevLine(game)) return game
        val now = System.currentTimeMillis()

        if (game.currentLineIndex > 0) {
            return game.copy(
                currentLineIndex = game.currentLineIndex - 1,
                lastPlayedAt = now
            )
        }

        val prevRhymeIndex = game.currentRhymeIndex - 1
        val prevRhyme = game.level.rhymes.getOrNull(prevRhymeIndex) ?: return game
        return game.copy(
            currentRhymeIndex = prevRhymeIndex,
            currentLineIndex = prevRhyme.lines.lastIndex,
            completedRhymeIndices = game.completedRhymeIndices - prevRhymeIndex,
            lastPlayedAt = now
        )
    }

    fun nextRhyme(game: NurseryRhymesGame): NurseryRhymesGame {
        if (game.isCompleted) return game
        val nextIndex = game.currentRhymeIndex + 1
        if (nextIndex >= game.level.rhymes.size) return game
        return game.copy(
            currentRhymeIndex = nextIndex,
            currentLineIndex = 0,
            lastPlayedAt = System.currentTimeMillis()
        )
    }

    fun prevRhyme(game: NurseryRhymesGame): NurseryRhymesGame {
        if (game.isCompleted) return game
        val prevIndex = game.currentRhymeIndex - 1
        if (prevIndex < 0) return game
        return game.copy(
            currentRhymeIndex = prevIndex,
            currentLineIndex = 0,
            lastPlayedAt = System.currentTimeMillis()
        )
    }

    fun markRhymeComplete(game: NurseryRhymesGame): NurseryRhymesGame {
        if (game.isCompleted) return game
        val rhyme = currentRhyme(game) ?: return game
        val completed = game.completedRhymeIndices + game.currentRhymeIndex
        val now = System.currentTimeMillis()
        val nextRhymeIndex = game.currentRhymeIndex + 1

        return if (nextRhymeIndex < game.level.rhymes.size) {
            game.copy(
                completedRhymeIndices = completed,
                currentRhymeIndex = nextRhymeIndex,
                currentLineIndex = 0,
                lastPlayedAt = now
            )
        } else {
            game.copy(
                completedRhymeIndices = completed,
                currentLineIndex = rhyme.lines.lastIndex,
                status = GameStatus.COMPLETED,
                completedAt = now,
                lastPlayedAt = now
            )
        }
    }

    fun isWon(game: NurseryRhymesGame): Boolean = game.isCompleted

    fun canApplyHint(game: NurseryRhymesGame): Boolean =
        canNextLine(game) && !isOnLastLineOfLastRhyme(game)

    private fun isOnLastLineOfLastRhyme(game: NurseryRhymesGame): Boolean {
        val rhyme = currentRhyme(game) ?: return true
        val isLastRhyme = game.currentRhymeIndex >= game.level.rhymes.lastIndex
        return isLastRhyme && game.currentLineIndex >= rhyme.lines.lastIndex
    }

    fun applyHint(game: NurseryRhymesGame): NurseryRhymesGame {
        if (!canApplyHint(game)) return game
        return nextLine(game).copy(hintsUsed = game.hintsUsed + 1)
    }

    fun optimalMoveCount(game: NurseryRhymesGame): Int =
        game.level.totalLines.coerceAtLeast(1)

    fun formatP2PMove(rhymeIndex: Int, lineIndex: Int): String =
        "line:$rhymeIndex:$lineIndex"

    fun parseP2PMove(payload: String): Pair<Int, Int>? {
        if (!payload.startsWith("line:")) return null
        val parts = payload.removePrefix("line:").split(":")
        if (parts.size != 2) return null
        val rhymeIndex = parts[0].toIntOrNull() ?: return null
        val lineIndex = parts[1].toIntOrNull() ?: return null
        return rhymeIndex to lineIndex
    }

    fun applyRemoteLineMove(game: NurseryRhymesGame, rhymeIndex: Int, lineIndex: Int): NurseryRhymesGame {
        if (game.isCompleted) return game
        val rhyme = game.level.rhymes.getOrNull(rhymeIndex) ?: return game
        if (lineIndex !in rhyme.lines.indices) return game

        val isForward = rhymeIndex > game.currentRhymeIndex ||
            (rhymeIndex == game.currentRhymeIndex && lineIndex > game.currentLineIndex)
        if (!isForward) return game

        var updated = game.copy(
            currentRhymeIndex = rhymeIndex,
            currentLineIndex = lineIndex,
            moves = game.moves + 1,
            lastPlayedAt = System.currentTimeMillis()
        )

        val completed = buildSet {
            addAll(updated.completedRhymeIndices)
            for (index in 0 until rhymeIndex) {
                add(index)
            }
            if (lineIndex >= rhyme.lines.lastIndex) {
                add(rhymeIndex)
            }
        }
        updated = updated.copy(completedRhymeIndices = completed)

        if (rhymeIndex >= game.level.rhymes.lastIndex && lineIndex >= rhyme.lines.lastIndex) {
            updated = updated.copy(
                status = GameStatus.COMPLETED,
                completedAt = System.currentTimeMillis()
            )
        }
        return updated
    }
}
