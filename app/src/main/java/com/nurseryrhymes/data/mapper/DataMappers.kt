package com.nurseryrhymes.data.mapper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nurseryrhymes.data.local.database.entity.AchievementEntity
import com.nurseryrhymes.data.local.database.entity.ChallengeEntity
import com.nurseryrhymes.data.local.database.entity.EconomyEntity
import com.nurseryrhymes.data.local.database.entity.GameEntity
import com.nurseryrhymes.data.local.database.entity.ProfileEntity
import com.nurseryrhymes.data.local.database.entity.StatsEntity
import com.nurseryrhymes.domain.model.PuzzleArchetype
import com.nurseryrhymes.domain.model.PuzzleProfile
import com.nurseryrhymes.domain.model.PuzzleProfileMetrics
import com.nurseryrhymes.domain.model.SkillCategory
import com.nurseryrhymes.domain.model.Achievement
import com.nurseryrhymes.domain.model.ChallengeRecord
import com.nurseryrhymes.domain.model.ChallengeType
import com.nurseryrhymes.domain.model.NurseryRhymesGame
import com.nurseryrhymes.domain.model.NurseryRhymesLevel
import com.nurseryrhymes.domain.model.Rhyme
import com.nurseryrhymes.domain.model.Difficulty
import com.nurseryrhymes.domain.model.EconomyState
import com.nurseryrhymes.domain.model.GameStatus
import com.nurseryrhymes.domain.model.UserStats

object DataMappers {
    private val gson = Gson()
    private val rhymeListType = object : TypeToken<List<Rhyme>>() {}.type
    private val intSetType = object : TypeToken<Set<Int>>() {}.type

    fun toEntity(game: NurseryRhymesGame): GameEntity {
        val gameState = GameStateJson(
            currentRhymeIndex = game.currentRhymeIndex,
            currentLineIndex = game.currentLineIndex,
            completedRhymeIndices = game.completedRhymeIndices.toList()
        )
        return GameEntity(
            id = game.id,
            seed = game.level.seed,
            levelNumber = game.level.levelNumber,
            difficulty = game.level.difficulty.name,
            status = game.status.name,
            tubeStateJson = gson.toJson(gameState),
            selectedTubeId = game.currentRhymeIndex,
            moves = game.moves,
            hintsUsed = game.hintsUsed,
            elapsedSeconds = game.elapsedSeconds,
            createdAt = game.createdAt,
            lastPlayedAt = game.lastPlayedAt,
            completedAt = game.completedAt,
            isTutorial = game.level.isTutorial,
            isEndless = game.level.isEndless,
            challengeType = game.level.challengeType?.name,
            challengeKey = game.level.challengeKey,
            levelJson = gson.toJson(LevelJson(rhymes = game.level.rhymes)),
            coinsEarned = game.coinsEarned,
            xpEarned = game.xpEarned
        )
    }

    fun fromEntity(entity: GameEntity): NurseryRhymesGame {
        val levelJson = gson.fromJson(entity.levelJson, LevelJson::class.java)
        val gameState = runCatching {
            gson.fromJson(entity.tubeStateJson, GameStateJson::class.java)
        }.getOrNull()

        val rhymes: List<Rhyme> = levelJson?.rhymes
            ?: gson.fromJson(entity.levelJson, rhymeListType)
            ?: emptyList()

        val level = NurseryRhymesLevel(
            id = entity.id,
            seed = entity.seed,
            levelNumber = entity.levelNumber,
            difficulty = Difficulty.valueOf(entity.difficulty),
            rhymes = rhymes,
            isTutorial = entity.isTutorial,
            isEndless = entity.isEndless,
            challengeType = entity.challengeType?.let { ChallengeType.valueOf(it) },
            challengeKey = entity.challengeKey
        )

        return if (gameState != null) {
            NurseryRhymesGame(
                id = entity.id,
                level = level,
                status = GameStatus.valueOf(entity.status),
                currentRhymeIndex = gameState.currentRhymeIndex,
                currentLineIndex = gameState.currentLineIndex,
                completedRhymeIndices = gameState.completedRhymeIndices.toSet(),
                hintsUsed = entity.hintsUsed,
                moves = entity.moves,
                elapsedSeconds = entity.elapsedSeconds,
                createdAt = entity.createdAt,
                lastPlayedAt = entity.lastPlayedAt,
                completedAt = entity.completedAt,
                coinsEarned = entity.coinsEarned,
                xpEarned = entity.xpEarned
            )
        } else {
            NurseryRhymesGame(
                id = entity.id,
                level = level,
                status = GameStatus.valueOf(entity.status),
                currentRhymeIndex = entity.selectedTubeId.coerceAtLeast(0),
                currentLineIndex = 0,
                hintsUsed = entity.hintsUsed,
                moves = entity.moves,
                elapsedSeconds = entity.elapsedSeconds,
                createdAt = entity.createdAt,
                lastPlayedAt = entity.lastPlayedAt,
                completedAt = entity.completedAt,
                coinsEarned = entity.coinsEarned,
                xpEarned = entity.xpEarned
            )
        }
    }

    fun toStatsEntity(stats: UserStats): StatsEntity = StatsEntity(
        gamesPlayed = stats.gamesPlayed,
        gamesWon = stats.gamesWon,
        gamesAbandoned = stats.gamesAbandoned,
        totalPlayTimeSeconds = stats.totalPlayTimeSeconds,
        fastestTimeBeginner = stats.fastestTimeBeginner,
        fastestTimeEasy = stats.fastestTimeEasy,
        fastestTimeMedium = stats.fastestTimeMedium,
        fastestTimeHard = stats.fastestTimeHard,
        fastestTimeExpert = stats.fastestTimeExpert,
        fastestTimeMaster = stats.fastestTimeMaster,
        currentStreak = stats.currentStreak,
        longestStreak = stats.longestStreak,
        lastPlayedDate = stats.lastPlayedDate,
        xpPoints = stats.xpPoints,
        level = stats.level,
        hintsUsedTotal = stats.hintsUsedTotal,
        perfectGames = stats.perfectGames,
        poursTotal = stats.poursTotal,
        endlessHighScore = stats.endlessHighScore
    )

    fun fromStatsEntity(entity: StatsEntity?): UserStats {
        if (entity == null) return UserStats()
        return UserStats(
            gamesPlayed = entity.gamesPlayed,
            gamesWon = entity.gamesWon,
            gamesAbandoned = entity.gamesAbandoned,
            totalPlayTimeSeconds = entity.totalPlayTimeSeconds,
            fastestTimeBeginner = entity.fastestTimeBeginner,
            fastestTimeEasy = entity.fastestTimeEasy,
            fastestTimeMedium = entity.fastestTimeMedium,
            fastestTimeHard = entity.fastestTimeHard,
            fastestTimeExpert = entity.fastestTimeExpert,
            fastestTimeMaster = entity.fastestTimeMaster,
            currentStreak = entity.currentStreak,
            longestStreak = entity.longestStreak,
            lastPlayedDate = entity.lastPlayedDate,
            xpPoints = entity.xpPoints,
            level = entity.level,
            hintsUsedTotal = entity.hintsUsedTotal,
            perfectGames = entity.perfectGames,
            poursTotal = entity.poursTotal,
            endlessHighScore = entity.endlessHighScore
        )
    }

    fun toChallengeEntity(record: ChallengeRecord): ChallengeEntity = ChallengeEntity(
        key = record.key,
        type = record.type.name,
        seed = record.seed,
        difficulty = record.difficulty.name,
        isCompleted = record.isCompleted,
        completionTime = record.completionTime,
        moves = record.moves,
        rewardCoins = record.rewardCoins,
        rewardXp = record.rewardXp,
        streakDay = record.streakDay
    )

    fun fromChallengeEntity(entity: ChallengeEntity): ChallengeRecord = ChallengeRecord(
        key = entity.key,
        type = ChallengeType.valueOf(entity.type),
        seed = entity.seed,
        difficulty = Difficulty.valueOf(entity.difficulty),
        isCompleted = entity.isCompleted,
        completionTime = entity.completionTime,
        moves = entity.moves,
        rewardCoins = entity.rewardCoins,
        rewardXp = entity.rewardXp,
        streakDay = entity.streakDay
    )

    fun toEconomyEntity(state: EconomyState): EconomyEntity = EconomyEntity(
        coins = state.coins,
        totalCoinsEarned = state.totalCoinsEarned,
        totalCoinsSpent = state.totalCoinsSpent,
        unlockedThemes = gson.toJson(state.unlockedThemeIds.toList())
    )

    fun fromEconomyEntity(entity: EconomyEntity?): EconomyState {
        if (entity == null) return EconomyState()
        val type = object : TypeToken<List<String>>() {}.type
        val unlocked: List<String> = gson.fromJson(entity.unlockedThemes, type) ?: emptyList()
        return EconomyState(
            coins = entity.coins,
            totalCoinsEarned = entity.totalCoinsEarned,
            totalCoinsSpent = entity.totalCoinsSpent,
            unlockedThemeIds = unlocked.toSet()
        )
    }

    fun mergeAchievement(def: Achievement, entity: AchievementEntity?): Achievement =
        def.copy(
            isUnlocked = entity?.isUnlocked ?: false,
            unlockedAt = entity?.unlockedAt,
            progress = entity?.progress ?: 0
        )

    fun toProfileEntity(profile: PuzzleProfile): ProfileEntity = ProfileEntity(
        gamesAnalyzed = profile.metrics.gamesAnalyzed,
        totalSolveTimeSeconds = profile.metrics.totalSolveTimeSeconds,
        totalMoves = profile.metrics.totalMoves,
        totalOptimalMoves = profile.metrics.totalOptimalMoves,
        totalHintsUsed = profile.metrics.totalHintsUsed,
        fastCompletions = profile.metrics.fastCompletions,
        slowCompletions = profile.metrics.slowCompletions,
        perfectCompletions = profile.metrics.perfectCompletions,
        complexChainWins = profile.metrics.complexChainWins,
        inefficientWins = profile.metrics.inefficientWins,
        hintHeavyWins = profile.metrics.hintHeavyWins,
        archetype = profile.archetype.name,
        strength = profile.strength.name,
        weakness = profile.weakness.name,
        adaptiveColorModifier = profile.adaptiveColorModifier
    )

    fun fromProfileEntity(entity: ProfileEntity?): PuzzleProfile {
        if (entity == null) return PuzzleProfile()
        val metrics = PuzzleProfileMetrics(
            gamesAnalyzed = entity.gamesAnalyzed,
            totalSolveTimeSeconds = entity.totalSolveTimeSeconds,
            totalMoves = entity.totalMoves,
            totalOptimalMoves = entity.totalOptimalMoves,
            totalHintsUsed = entity.totalHintsUsed,
            fastCompletions = entity.fastCompletions,
            slowCompletions = entity.slowCompletions,
            perfectCompletions = entity.perfectCompletions,
            complexChainWins = entity.complexChainWins,
            inefficientWins = entity.inefficientWins,
            hintHeavyWins = entity.hintHeavyWins
        )
        return PuzzleProfile(
            metrics = metrics,
            archetype = runCatching { PuzzleArchetype.valueOf(entity.archetype) }
                .getOrDefault(PuzzleArchetype.EXPLORER),
            strength = runCatching { SkillCategory.valueOf(entity.strength) }
                .getOrDefault(SkillCategory.PATTERN_RECOGNITION),
            weakness = runCatching { SkillCategory.valueOf(entity.weakness) }
                .getOrDefault(SkillCategory.TIME_PRESSURE),
            adaptiveColorModifier = entity.adaptiveColorModifier
        )
    }

    data class LevelJson(val rhymes: List<Rhyme>)

    data class GameStateJson(
        val currentRhymeIndex: Int,
        val currentLineIndex: Int,
        val completedRhymeIndices: List<Int> = emptyList()
    )
}
