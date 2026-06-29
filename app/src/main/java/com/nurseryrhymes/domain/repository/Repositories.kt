package com.nurseryrhymes.domain.repository

import com.nurseryrhymes.domain.model.Achievement
import com.nurseryrhymes.domain.model.ChallengeRecord
import com.nurseryrhymes.domain.model.ChallengeType
import com.nurseryrhymes.domain.model.NurseryRhymesGame
import com.nurseryrhymes.domain.model.NurseryRhymesLevel
import com.nurseryrhymes.domain.model.Difficulty
import com.nurseryrhymes.domain.model.EconomyState
import com.nurseryrhymes.domain.model.PuzzleProfile
import com.nurseryrhymes.domain.model.UserStats
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    suspend fun createNewGame(difficulty: Difficulty, levelNumber: Int): NurseryRhymesGame
    suspend fun createGameFromSeed(seed: Long, levelNumber: Int, difficulty: Difficulty): NurseryRhymesGame
    suspend fun createTutorialGame(tutorialIndex: Int): NurseryRhymesGame?
    suspend fun createEndlessGame(wave: Int): NurseryRhymesGame
    suspend fun saveGame(game: NurseryRhymesGame): Long
    suspend fun getGame(gameId: Long): NurseryRhymesGame?
    suspend fun getInProgressGame(): NurseryRhymesGame?
    fun observeInProgressGame(): Flow<NurseryRhymesGame?>
    suspend fun completeGame(game: NurseryRhymesGame): NurseryRhymesGame
    suspend fun abandonGame(gameId: Long)
    suspend fun getLevel(seed: Long, levelNumber: Int, difficulty: Difficulty): NurseryRhymesLevel
}

interface ChallengeRepository {
    suspend fun getChallenge(type: ChallengeType, key: String): ChallengeRecord?
    suspend fun createChallenge(type: ChallengeType, key: String, difficulty: Difficulty): ChallengeRecord
    suspend fun resolveActiveChallenge(type: ChallengeType): ChallengeRecord
    fun observeActiveChallenge(type: ChallengeType): Flow<ChallengeRecord?>
    suspend fun completeChallenge(record: ChallengeRecord, timeSeconds: Long, moves: Int): ChallengeRecord
    fun observeChallengeHistory(type: ChallengeType): Flow<List<ChallengeRecord>>
    suspend fun getCurrentStreak(type: ChallengeType): Int
    suspend fun getChallengeGame(record: ChallengeRecord): NurseryRhymesGame
}

interface ProgressionRepository {
    fun observeStats(): Flow<UserStats>
    suspend fun getStats(): UserStats
    suspend fun updateStatsAfterGame(game: NurseryRhymesGame)
    suspend fun grantChallengeRewards(rewardCoins: Int, rewardXp: Int)
    fun observePuzzleProfile(): Flow<PuzzleProfile>
    suspend fun getPuzzleProfile(): PuzzleProfile
    fun observeAchievements(): Flow<List<Achievement>>
    suspend fun checkAndUnlockAchievements(
        game: NurseryRhymesGame,
        sameDevicePlayed: Boolean = false
    ): List<Achievement>
    fun observeEconomy(): Flow<EconomyState>
    suspend fun getEconomy(): EconomyState
    suspend fun spendCoins(amount: Int): Boolean
    suspend fun earnCoins(amount: Int)
    suspend fun unlockTheme(themeId: String): Boolean
}

interface PreferencesRepository {
    fun getUserPreferences(): Flow<com.nurseryrhymes.domain.model.UserPreferences>
    suspend fun updatePreferences(transform: (com.nurseryrhymes.domain.model.UserPreferences) -> com.nurseryrhymes.domain.model.UserPreferences)
    suspend fun getCampaignLevel(difficulty: Difficulty): Int
    suspend fun advanceCampaignLevel(difficulty: Difficulty): Int
}
