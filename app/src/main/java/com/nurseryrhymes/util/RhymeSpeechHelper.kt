package com.nurseryrhymes.util

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.nurseryrhymes.domain.model.LearningLanguage

class RhymeSpeechHelper(
    private val context: Context,
    private val ttsHelper: RhymeTtsHelper,
    private val useBundledAudio: Boolean = true
) {
    private var mediaPlayer: MediaPlayer? = null
    var usingTtsFallback: Boolean = false
        private set

    fun speak(rhymeId: Int, lineIndex: Int, text: String, language: LearningLanguage) {
        stopPlaybackOnly()
        if (text.isBlank()) return

        if (!useBundledAudio) {
            usingTtsFallback = true
            ttsHelper.speak(text, language)
            return
        }

        val resName = RhymeAudioCatalog.rawResourceName(rhymeId, lineIndex, language)
        val resId = context.resources.getIdentifier(resName, "raw", context.packageName)
        if (resId == 0) {
            usingTtsFallback = true
            ttsHelper.speak(text, language)
            return
        }

        try {
            val player = MediaPlayer.create(context, resId)
            if (player == null) {
                usingTtsFallback = true
                ttsHelper.speak(text, language)
                return
            }
            mediaPlayer = player.apply {
                setOnCompletionListener { releasePlayer() }
                setOnErrorListener { _, _, _ ->
                    releasePlayer()
                    usingTtsFallback = true
                    ttsHelper.speak(text, language)
                    true
                }
                start()
            }
            usingTtsFallback = false
        } catch (_: Exception) {
            releasePlayer()
            usingTtsFallback = true
            ttsHelper.speak(text, language)
        }
    }

    fun stop() {
        releasePlayer()
        ttsHelper.stop()
    }

    fun shutdown() {
        releasePlayer()
        ttsHelper.shutdown()
    }

    private fun stopPlaybackOnly() {
        releasePlayer()
    }

    private fun releasePlayer() {
        mediaPlayer?.run {
            runCatching {
                if (isPlaying) stop()
            }
            release()
        }
        mediaPlayer = null
    }
}

@Composable
fun rememberRhymeSpeech(useBundledAudio: Boolean = true): RhymeSpeechHelper {
    val context = LocalContext.current
    val ttsHelper = remember { RhymeTtsHelper(context) }
    val helper = remember(useBundledAudio) {
        RhymeSpeechHelper(context, ttsHelper, useBundledAudio)
    }
    DisposableEffect(helper) {
        onDispose { helper.shutdown() }
    }
    return helper
}
