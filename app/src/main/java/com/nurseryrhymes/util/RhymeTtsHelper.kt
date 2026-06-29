package com.nurseryrhymes.util

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.nurseryrhymes.domain.model.LearningLanguage
import java.util.Locale

class RhymeTtsHelper(context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = TextToSpeech(context.applicationContext, this)
    private var ready = false

    override fun onInit(status: Int) {
        ready = status == TextToSpeech.SUCCESS
    }

    fun speak(text: String, language: LearningLanguage) {
        if (!ready || text.isBlank()) return
        tts?.language = localeFor(language)
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "rhyme_line")
    }

    fun stop() {
        tts?.stop()
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        ready = false
    }

    private fun localeFor(language: LearningLanguage): Locale = when (language) {
        LearningLanguage.ENGLISH -> Locale("en", "IN")
        LearningLanguage.HINDI -> Locale("hi", "IN")
        LearningLanguage.TELUGU -> Locale("te", "IN")
        LearningLanguage.TAMIL -> Locale("ta", "IN")
        LearningLanguage.KANNADA -> Locale("kn", "IN")
        LearningLanguage.MALAYALAM -> Locale("ml", "IN")
    }
}

@Composable
fun rememberRhymeTts(): RhymeTtsHelper {
    val context = LocalContext.current
    val helper = remember { RhymeTtsHelper(context) }
    DisposableEffect(helper) {
        onDispose { helper.shutdown() }
    }
    return helper
}
