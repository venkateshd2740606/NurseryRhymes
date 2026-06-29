package com.nurseryrhymes.util

import com.nurseryrhymes.domain.model.LearningLanguage
import org.junit.Assert.assertEquals
import org.junit.Test

class RhymeAudioCatalogTest {

    @Test
    fun rawResourceName_englishFirstLine() {
        assertEquals(
            "rhyme_01_01_en",
            RhymeAudioCatalog.rawResourceName(rhymeId = 1, lineIndex = 0, language = LearningLanguage.ENGLISH)
        )
    }

    @Test
    fun rawResourceName_hindiSecondLine() {
        assertEquals(
            "rhyme_05_02_hi",
            RhymeAudioCatalog.rawResourceName(rhymeId = 5, lineIndex = 1, language = LearningLanguage.HINDI)
        )
    }

    @Test
    fun rawResourceName_teluguPaddedIds() {
        assertEquals(
            "rhyme_15_08_te",
            RhymeAudioCatalog.rawResourceName(rhymeId = 15, lineIndex = 7, language = LearningLanguage.TELUGU)
        )
    }

    @Test
    fun languageCode_mapsAllLearningLanguages() {
        assertEquals("en", RhymeAudioCatalog.languageCode(LearningLanguage.ENGLISH))
        assertEquals("hi", RhymeAudioCatalog.languageCode(LearningLanguage.HINDI))
        assertEquals("te", RhymeAudioCatalog.languageCode(LearningLanguage.TELUGU))
        assertEquals("ta", RhymeAudioCatalog.languageCode(LearningLanguage.TAMIL))
        assertEquals("kn", RhymeAudioCatalog.languageCode(LearningLanguage.KANNADA))
        assertEquals("ml", RhymeAudioCatalog.languageCode(LearningLanguage.MALAYALAM))
    }
}
