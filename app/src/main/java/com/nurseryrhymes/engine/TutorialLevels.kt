package com.nurseryrhymes.engine

import com.nurseryrhymes.domain.model.Difficulty
import com.nurseryrhymes.domain.model.NurseryRhymesLevel

object TutorialLevels {

    val all: List<NurseryRhymesLevel> = listOf(
        level1Twinkle(),
        level2BaaBaa(),
        level3JackAndJill(),
        level4HumptyDumpty(),
        level5RowYourBoat()
    )

    fun getTutorialLevel(index: Int): NurseryRhymesLevel? = all.getOrNull(index)

    private fun level1Twinkle(): NurseryRhymesLevel = NurseryRhymesLevel(
        seed = 1,
        levelNumber = 1,
        difficulty = Difficulty.BEGINNER,
        isTutorial = true,
        rhymes = listOf(RhymeBank.byId(1)!!)
    )

    private fun level2BaaBaa(): NurseryRhymesLevel = NurseryRhymesLevel(
        seed = 2,
        levelNumber = 2,
        difficulty = Difficulty.BEGINNER,
        isTutorial = true,
        rhymes = listOf(RhymeBank.byId(2)!!)
    )

    private fun level3JackAndJill(): NurseryRhymesLevel = NurseryRhymesLevel(
        seed = 3,
        levelNumber = 3,
        difficulty = Difficulty.EASY,
        isTutorial = true,
        rhymes = listOf(RhymeBank.byId(3)!!)
    )

    private fun level4HumptyDumpty(): NurseryRhymesLevel = NurseryRhymesLevel(
        seed = 4,
        levelNumber = 4,
        difficulty = Difficulty.EASY,
        isTutorial = true,
        rhymes = listOf(RhymeBank.byId(4)!!)
    )

    private fun level5RowYourBoat(): NurseryRhymesLevel = NurseryRhymesLevel(
        seed = 5,
        levelNumber = 5,
        difficulty = Difficulty.MEDIUM,
        isTutorial = true,
        rhymes = listOf(RhymeBank.byId(5)!!)
    )
}
