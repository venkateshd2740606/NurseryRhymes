package com.nurseryrhymes.util

import com.nurseryrhymes.domain.model.LearningLanguage

object RhymeAudioCatalog {

    fun languageCode(language: LearningLanguage): String = when (language) {
        LearningLanguage.ENGLISH -> "en"
        LearningLanguage.HINDI -> "hi"
        LearningLanguage.TELUGU -> "te"
        LearningLanguage.TAMIL -> "ta"
        LearningLanguage.KANNADA -> "kn"
        LearningLanguage.MALAYALAM -> "ml"
    }

    /** Returns raw resource name without extension, e.g. rhyme_01_01_en */
    fun rawResourceName(rhymeId: Int, lineIndex: Int, language: LearningLanguage): String {
        val lang = languageCode(language)
        val line = lineIndex + 1
        return "rhyme_${rhymeId.toString().padStart(2, '0')}_${line.toString().padStart(2, '0')}_$lang"
    }
}
