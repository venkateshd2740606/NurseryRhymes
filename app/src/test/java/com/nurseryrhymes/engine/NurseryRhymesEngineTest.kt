package com.nurseryrhymes.engine

import com.nurseryrhymes.domain.model.Difficulty
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class NurseryRhymesEngineTest {

    @Test
    fun tutorialLevel_isValid() {
        val level = TutorialLevels.getTutorialLevel(0)!!
        assertTrue(NurseryRhymesEngine.validateLevel(level))
    }

    @Test
    fun nextLine_advancesThroughRhyme() {
        val level = TutorialLevels.getTutorialLevel(0)!!
        var game = NurseryRhymesEngine.createInitialGame(level)
        assertEquals(0, game.currentLineIndex)
        game = NurseryRhymesEngine.nextLine(game)
        assertEquals(1, game.currentLineIndex)
        assertEquals(1, game.moves)
    }

    @Test
    fun nextLine_onLastLine_completesGame() {
        val level = TutorialLevels.getTutorialLevel(0)!!
        var game = NurseryRhymesEngine.createInitialGame(level)
        val lineCount = level.rhymes.first().lines.size
        repeat(lineCount) {
            game = NurseryRhymesEngine.nextLine(game)
        }
        assertTrue(NurseryRhymesEngine.isWon(game))
        assertTrue(game.isCompleted)
        assertEquals(lineCount, game.moves)
    }

    @Test
    fun generatedLevel_isValid() {
        val level = NurseryRhymesGenerator.generate(12345L, 1, Difficulty.EASY)
        assertTrue(NurseryRhymesEngine.validateLevel(level))
        assertEquals(1, level.rhymes.size)
    }

    @Test
    fun generator_sameSeed_producesSameRhyme() {
        val a = NurseryRhymesGenerator.generate(999L, 5, Difficulty.MEDIUM)
        val b = NurseryRhymesGenerator.generate(999L, 5, Difficulty.MEDIUM)
        assertEquals(a.rhymes.first().id, b.rhymes.first().id)
    }

    @Test
    fun generator_cyclesRhymesByLevelNumber() {
        val level1 = NurseryRhymesGenerator.generate(1L, 1, Difficulty.EASY)
        val level16 = NurseryRhymesGenerator.generate(2L, 16, Difficulty.EASY)
        assertEquals(level1.rhymes.first().id, level16.rhymes.first().id)
    }

    @Test
    fun applyHint_advancesLine() {
        val level = NurseryRhymesGenerator.generate(42L, 1, Difficulty.EASY)
        val game = NurseryRhymesEngine.createInitialGame(level)
        assertTrue(NurseryRhymesEngine.canApplyHint(game))
        val updated = NurseryRhymesEngine.applyHint(game)
        assertEquals(1, updated.hintsUsed)
        assertEquals(1, updated.currentLineIndex)
    }

    @Test
    fun p2pMoveFormat_roundTrips() {
        val payload = NurseryRhymesEngine.formatP2PMove(2, 3)
        assertEquals("line:2:3", payload)
        val parsed = NurseryRhymesEngine.parseP2PMove(payload)
        assertNotNull(parsed)
        assertEquals(2, parsed!!.first)
        assertEquals(3, parsed.second)
    }

    @Test
    fun rhymeBank_has15Rhymes() {
        assertEquals(15, RhymeBank.all.size)
    }

    @Test
    fun prevLine_goesBack() {
        val level = TutorialLevels.getTutorialLevel(0)!!
        var game = NurseryRhymesEngine.createInitialGame(level)
        game = NurseryRhymesEngine.nextLine(game)
        game = NurseryRhymesEngine.prevLine(game)
        assertEquals(0, game.currentLineIndex)
    }

    @Test
    fun optimalMoveCount_equalsLineCount() {
        val level = TutorialLevels.getTutorialLevel(0)!!
        val game = NurseryRhymesEngine.createInitialGame(level)
        assertEquals(level.totalLines, NurseryRhymesEngine.optimalMoveCount(game))
    }
}
