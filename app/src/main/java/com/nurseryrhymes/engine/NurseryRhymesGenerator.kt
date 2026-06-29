package com.nurseryrhymes.engine

import com.nurseryrhymes.domain.model.Difficulty
import com.nurseryrhymes.domain.model.GenerationProfile
import com.nurseryrhymes.domain.model.NurseryRhymesLevel
import com.nurseryrhymes.domain.model.Rhyme

object NurseryRhymesGenerator {

    fun generate(
        seed: Long,
        levelNumber: Int,
        difficulty: Difficulty,
        generationProfile: GenerationProfile = GenerationProfile()
    ): NurseryRhymesLevel {
        val rhyme = selectRhymeForLevel(levelNumber, generationProfile)
        return NurseryRhymesLevel(
            seed = seed,
            levelNumber = levelNumber,
            difficulty = difficulty,
            rhymes = listOf(rhyme),
            isEndless = difficulty == Difficulty.ENDLESS
        )
    }

    fun generateForChallenge(
        seed: Long,
        levelNumber: Int,
        difficulty: Difficulty
    ): NurseryRhymesLevel = generate(seed, levelNumber, difficulty)

    fun seedFromLevelNumber(levelNumber: Int, difficulty: Difficulty): Long {
        val difficultyOffset = difficulty.ordinal * 100_000L
        return levelNumber.toLong() * 9973L + difficultyOffset + 42L
    }

    fun formatShareText(seed: Long, levelNumber: Int, difficulty: Difficulty): String =
        "Nursery Rhymes\nSeed: $seed\nLevel: $levelNumber\nDifficulty: ${difficulty.name}"

    fun selectRhymeForLevel(
        levelNumber: Int,
        profile: GenerationProfile = GenerationProfile()
    ): Rhyme {
        val bank = RhymeBank.all
        val offset = profile.rhymeSpreadModifier.coerceIn(-1, 2)
        val index = ((levelNumber - 1 + offset).coerceAtLeast(0)) % bank.size
        return bank[index]
    }
}
