package com.nurseryrhymes.domain.model

enum class Difficulty(val stars: Int, val xpMultiplier: Float) {
    BEGINNER(1, 0.5f),
    EASY(2, 1.0f),
    MEDIUM(3, 1.5f),
    HARD(4, 2.0f),
    EXPERT(5, 2.5f),
    MASTER(6, 3.0f),
    ENDLESS(0, 1.0f);

    val displayName: String get() = name.lowercase().replaceFirstChar { it.uppercase() }
}

enum class GameStatus { IN_PROGRESS, COMPLETED, FAILED, PAUSED }

enum class AppTheme(val displayName: String) {
    SYSTEM("System"),
    LIGHT("Light"),
    DARK("Dark"),
    AMOLED("AMOLED"),
    NEON("Neon"),
    CYBER("Cyber"),
    SPACE("Space"),
    NATURE("Nature")
}

enum class ColorBlindMode { NONE, DEUTERANOPIA, PROTANOPIA, TRITANOPIA }

enum class ChallengeType { DAILY, WEEKLY, MONTHLY }

enum class PlayerRank(val minLevel: Int, val title: String) {
    NOVICE(1, "Novice"),
    APPRENTICE(5, "Apprentice"),
    PUZZLER(10, "Puzzler"),
    STRATEGIST(20, "Strategist"),
    EXPERT(35, "Expert"),
    MASTER(50, "Master"),
    GRANDMASTER(75, "Grandmaster"),
    LEGEND(100, "Legend");

    companion object {
        fun fromLevel(level: Int): PlayerRank =
            entries.filter { level >= it.minLevel }.maxByOrNull { it.minLevel } ?: NOVICE
    }
}

enum class MultiplayerMode {
    SAME_DEVICE,
    LOCAL_P2P
}

enum class P2PConnectionType(val displayName: String) {
    NEARBY("Nearby (Bluetooth + Wi-Fi)"),
    WIFI_LAN("Same Wi-Fi"),
    WIFI_DIRECT("Wi-Fi Direct")
}

enum class P2PRole { HOST, CLIENT }

enum class P2PSessionState {
    IDLE, ADVERTISING, DISCOVERING, CONNECTING, CONNECTED, ERROR
}

enum class PuzzleArchetype(val title: String, val description: String) {
    ARCHITECT("The Architect", "You plan several moves ahead and rarely waste a turn."),
    SPRINTER("The Sprinter", "You solve quickly with confident, direct moves."),
    ANALYST("The Analyst", "You take your time, prefer accuracy, and use hints when needed."),
    EXPLORER("The Explorer", "You experiment with different approaches before finding the path."),
    STRATEGIST("The Strategist", "You excel when puzzles involve layered chains and depth.")
}

enum class SkillCategory(val label: String) {
    PATTERN_RECOGNITION("Pattern Recognition"),
    PLANNING("Planning"),
    SPEED("Speed"),
    ACCURACY("Accuracy"),
    COMPLEX_CHAINS("Complex Chains"),
    TIME_PRESSURE("Time Pressure")
}

data class PuzzleProfileMetrics(
    val gamesAnalyzed: Int = 0,
    val totalSolveTimeSeconds: Long = 0,
    val totalMoves: Int = 0,
    val totalOptimalMoves: Int = 0,
    val totalHintsUsed: Int = 0,
    val fastCompletions: Int = 0,
    val slowCompletions: Int = 0,
    val perfectCompletions: Int = 0,
    val complexChainWins: Int = 0,
    val inefficientWins: Int = 0,
    val hintHeavyWins: Int = 0
)

data class PuzzleProfile(
    val metrics: PuzzleProfileMetrics = PuzzleProfileMetrics(),
    val archetype: PuzzleArchetype = PuzzleArchetype.EXPLORER,
    val strength: SkillCategory = SkillCategory.PATTERN_RECOGNITION,
    val weakness: SkillCategory = SkillCategory.TIME_PRESSURE,
    val adaptiveColorModifier: Int = 0
)

enum class RhymeCategory(val displayName: String) {
    RHYME("Rhyme"),
    STORY("Story")
}

enum class LearningLanguage(val displayName: String) {
    ENGLISH("English"),
    HINDI("हिंदी"),
    TELUGU("తెలుగు"),
    TAMIL("தமிழ்"),
    KANNADA("ಕನ್ನಡ"),
    MALAYALAM("മലയാളം")
}

data class Rhyme(
    val id: Int,
    val title: String,
    val lines: List<String>,
    val category: RhymeCategory,
    val illustration: String,
    val hindiTitle: String? = null,
    val teluguTitle: String? = null,
    val tamilTitle: String? = null,
    val kannadaTitle: String? = null,
    val malayalamTitle: String? = null,
    val hindiLines: List<String>? = null,
    val teluguLines: List<String>? = null,
    val tamilLines: List<String>? = null,
    val kannadaLines: List<String>? = null,
    val malayalamLines: List<String>? = null
) {
    init {
        require(lines.isNotEmpty()) { "Each rhyme must have at least one line" }
    }

    fun titleFor(language: LearningLanguage): String = when (language) {
        LearningLanguage.ENGLISH -> title
        LearningLanguage.HINDI -> hindiTitle ?: title
        LearningLanguage.TELUGU -> teluguTitle ?: title
        LearningLanguage.TAMIL -> tamilTitle ?: title
        LearningLanguage.KANNADA -> kannadaTitle ?: title
        LearningLanguage.MALAYALAM -> malayalamTitle ?: title
    }

    fun linesFor(language: LearningLanguage): List<String> = when (language) {
        LearningLanguage.ENGLISH -> lines
        LearningLanguage.HINDI -> hindiLines ?: lines
        LearningLanguage.TELUGU -> teluguLines ?: lines
        LearningLanguage.TAMIL -> tamilLines ?: lines
        LearningLanguage.KANNADA -> kannadaLines ?: lines
        LearningLanguage.MALAYALAM -> malayalamLines ?: lines
    }
}

data class GenerationProfile(
    val rhymeSpreadModifier: Int = 0
)

data class NurseryRhymesLevel(
    val id: Long = 0,
    val seed: Long,
    val levelNumber: Int,
    val difficulty: Difficulty,
    val rhymes: List<Rhyme>,
    val isTutorial: Boolean = false,
    val isEndless: Boolean = false,
    val challengeType: ChallengeType? = null,
    val challengeKey: String? = null
) {
    val rhymeCount: Int get() = rhymes.size
    val totalLines: Int get() = rhymes.sumOf { it.lines.size }
}

data class NurseryRhymesGame(
    val id: Long = 0,
    val level: NurseryRhymesLevel,
    val status: GameStatus = GameStatus.IN_PROGRESS,
    val currentRhymeIndex: Int = 0,
    val currentLineIndex: Int = 0,
    val completedRhymeIndices: Set<Int> = emptySet(),
    val moves: Int = 0,
    val hintsUsed: Int = 0,
    val elapsedSeconds: Long = 0,
    val createdAt: Long = System.currentTimeMillis(),
    val lastPlayedAt: Long = System.currentTimeMillis(),
    val completedAt: Long? = null,
    val coinsEarned: Int = 0,
    val xpEarned: Int = 0
) {
    val isCompleted: Boolean get() = status == GameStatus.COMPLETED
    val currentRhyme: Rhyme? get() = level.rhymes.getOrNull(currentRhymeIndex)
    val currentLine: String? get() = currentRhyme?.lines?.getOrNull(currentLineIndex)
    val linesRead: Int get() {
        var count = completedRhymeIndices.sumOf { level.rhymes.getOrNull(it)?.lines?.size ?: 0 }
        count += currentLineIndex + 1
        return count.coerceAtMost(level.totalLines)
    }
    val completionTimeFormatted: String get() {
        val mins = elapsedSeconds / 60
        val secs = elapsedSeconds % 60
        return String.format("%02d:%02d", mins, secs)
    }
}

data class UserStats(
    val gamesPlayed: Int = 0,
    val gamesWon: Int = 0,
    val gamesAbandoned: Int = 0,
    val totalPlayTimeSeconds: Long = 0,
    val fastestTimeBeginner: Long = Long.MAX_VALUE,
    val fastestTimeEasy: Long = Long.MAX_VALUE,
    val fastestTimeMedium: Long = Long.MAX_VALUE,
    val fastestTimeHard: Long = Long.MAX_VALUE,
    val fastestTimeExpert: Long = Long.MAX_VALUE,
    val fastestTimeMaster: Long = Long.MAX_VALUE,
    val currentStreak: Int = 0,
    val longestStreak: Int = 0,
    val lastPlayedDate: String = "",
    val xpPoints: Long = 0,
    val level: Int = 1,
    val hintsUsedTotal: Int = 0,
    val perfectGames: Int = 0,
    val poursTotal: Int = 0,
    val endlessHighScore: Int = 0
) {
    val winRate: Float get() = if (gamesPlayed > 0) gamesWon.toFloat() / gamesPlayed else 0f
    val rank: PlayerRank get() = PlayerRank.fromLevel(level)
}

data class Achievement(
    val id: String,
    val titleRes: Int,
    val descriptionRes: Int,
    val iconName: String,
    val xpReward: Int,
    val coinReward: Int = 0,
    val isUnlocked: Boolean = false,
    val unlockedAt: Long? = null,
    val progress: Int = 0,
    val maxProgress: Int = 1
)

data class ChallengeRecord(
    val key: String,
    val type: ChallengeType,
    val seed: Long,
    val difficulty: Difficulty,
    val isCompleted: Boolean = false,
    val completionTime: Long? = null,
    val moves: Int = 0,
    val rewardCoins: Int = 0,
    val rewardXp: Int = 0,
    val streakDay: Int = 0
)

data class UserPreferences(
    val appTheme: AppTheme = AppTheme.SYSTEM,
    val hapticFeedback: Boolean = true,
    val soundEnabled: Boolean = true,
    val reducedMotion: Boolean = false,
    val highContrastMode: Boolean = false,
    val colorBlindMode: ColorBlindMode = ColorBlindMode.NONE,
    val fontScale: Float = 1.0f,
    val timerVisible: Boolean = true,
    val adsEnabled: Boolean = true,
    val onboardingCompleted: Boolean = false,
    val consentGiven: Boolean = false,
    val analyticsEnabled: Boolean = true,
    val personalizedAds: Boolean = false,
    val language: String = "system",
    val learningLanguage: LearningLanguage = LearningLanguage.ENGLISH,
    val unlockedThemes: Set<String> = setOf(AppTheme.SYSTEM.name, AppTheme.LIGHT.name, AppTheme.DARK.name)
)

data class EconomyState(
    val coins: Int = 100,
    val totalCoinsEarned: Int = 100,
    val totalCoinsSpent: Int = 0,
    val unlockableThemes: List<String> = listOf(
        AppTheme.AMOLED.name, AppTheme.NEON.name, AppTheme.CYBER.name,
        AppTheme.SPACE.name, AppTheme.NATURE.name
    ),
    val unlockedThemeIds: Set<String> = emptySet()
)

data class MultiplayerSession(
    val mode: MultiplayerMode,
    val localPlayerName: String,
    val remotePlayerName: String? = null,
    val activePlayerName: String = localPlayerName,
    val localScore: Int = 0,
    val remoteScore: Int = 0,
    val isActive: Boolean = false,
    val seed: Long = 0L,
    val difficulty: Difficulty = Difficulty.EASY
)
