package com.nurseryrhymes.data

import com.nurseryrhymes.domain.model.Difficulty
import com.nurseryrhymes.domain.model.GameStatus
import com.nurseryrhymes.engine.NurseryRhymesEngine
import com.nurseryrhymes.engine.NurseryRhymesGenerator
import com.nurseryrhymes.util.ProgressionCalculator
import org.junit.Assert.assertTrue
import org.junit.Test

class ProgressionCalculatorTest {

    @Test
    fun xpForCompletedGame_isPositive() {
        val level = NurseryRhymesGenerator.generate(1L, 1, Difficulty.EASY)
        val game = NurseryRhymesEngine.createInitialGame(level).copy(status = GameStatus.COMPLETED)
        assertTrue(ProgressionCalculator.xpForGame(game) > 0)
    }

    @Test
    fun xpForGame_withHints_isLowerThanWithoutHints() {
        val level = NurseryRhymesGenerator.generate(1L, 1, Difficulty.EASY)
        val withHints = NurseryRhymesEngine.createInitialGame(level).copy(hintsUsed = 2, status = GameStatus.COMPLETED)
        val noHints = NurseryRhymesEngine.createInitialGame(level).copy(hintsUsed = 0, status = GameStatus.COMPLETED)
        assertTrue(ProgressionCalculator.xpForGame(noHints) >= ProgressionCalculator.xpForGame(withHints))
    }
}
