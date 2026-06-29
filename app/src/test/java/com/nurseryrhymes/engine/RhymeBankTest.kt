package com.nurseryrhymes.engine

import com.nurseryrhymes.domain.model.LearningLanguage
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class RhymeBankTest {

    @Test
    fun allRhymes_haveTamilKannadaMalayalamTranslations() {
        RhymeBank.all.forEach { rhyme ->
            assertFalse("Rhyme ${rhyme.id} missing tamilTitle", rhyme.tamilTitle.isNullOrBlank())
            assertFalse("Rhyme ${rhyme.id} missing kannadaTitle", rhyme.kannadaTitle.isNullOrBlank())
            assertFalse("Rhyme ${rhyme.id} missing malayalamTitle", rhyme.malayalamTitle.isNullOrBlank())
            assertFalse("Rhyme ${rhyme.id} missing tamilLines", rhyme.tamilLines.isNullOrEmpty())
            assertFalse("Rhyme ${rhyme.id} missing kannadaLines", rhyme.kannadaLines.isNullOrEmpty())
            assertFalse("Rhyme ${rhyme.id} missing malayalamLines", rhyme.malayalamLines.isNullOrEmpty())
        }
    }

    @Test
    fun titleFor_returnsLocalizedTamilKannadaMalayalam() {
        val rhyme = RhymeBank.all.first()
        assertNotEquals(rhyme.title, rhyme.titleFor(LearningLanguage.TAMIL))
        assertNotEquals(rhyme.title, rhyme.titleFor(LearningLanguage.KANNADA))
        assertNotEquals(rhyme.title, rhyme.titleFor(LearningLanguage.MALAYALAM))
    }

    @Test
    fun linesFor_returnsLocalizedTamilKannadaMalayalam() {
        val rhyme = RhymeBank.all.first()
        assertTrue(rhyme.linesFor(LearningLanguage.TAMIL).isNotEmpty())
        assertTrue(rhyme.linesFor(LearningLanguage.KANNADA).isNotEmpty())
        assertTrue(rhyme.linesFor(LearningLanguage.MALAYALAM).isNotEmpty())
        assertEquals(rhyme.tamilLines, rhyme.linesFor(LearningLanguage.TAMIL))
        assertEquals(rhyme.kannadaLines, rhyme.linesFor(LearningLanguage.KANNADA))
        assertEquals(rhyme.malayalamLines, rhyme.linesFor(LearningLanguage.MALAYALAM))
    }

    @Test
    fun titleFor_fallsBackToEnglishWhenMissing() {
        val rhyme = RhymeBank.all.first().copy(tamilTitle = null, kannadaTitle = null, malayalamTitle = null)
        assertEquals(rhyme.title, rhyme.titleFor(LearningLanguage.TAMIL))
        assertEquals(rhyme.title, rhyme.titleFor(LearningLanguage.KANNADA))
        assertEquals(rhyme.title, rhyme.titleFor(LearningLanguage.MALAYALAM))
    }

    @Test
    fun linesFor_fallsBackToEnglishWhenMissing() {
        val rhyme = RhymeBank.all.first().copy(tamilLines = null, kannadaLines = null, malayalamLines = null)
        assertEquals(rhyme.lines, rhyme.linesFor(LearningLanguage.TAMIL))
        assertEquals(rhyme.lines, rhyme.linesFor(LearningLanguage.KANNADA))
        assertEquals(rhyme.lines, rhyme.linesFor(LearningLanguage.MALAYALAM))
    }
}
