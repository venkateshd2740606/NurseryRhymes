package com.nurseryrhymes.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nurseryrhymes.R
import com.nurseryrhymes.domain.model.LearningLanguage
import com.nurseryrhymes.domain.model.NurseryRhymesGame
import com.nurseryrhymes.engine.NurseryRhymesEngine
import com.nurseryrhymes.util.RhymeSpeechHelper

@Composable
fun NurseryRhymesBoard(
    game: NurseryRhymesGame,
    learningLanguage: LearningLanguage,
    reducedMotion: Boolean,
    soundEnabled: Boolean,
    rhymeSpeech: RhymeSpeechHelper,
    onNextLine: () -> Unit,
    onPrevLine: () -> Unit,
    onRhymeSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val boardDescription = stringResource(R.string.color_sort)
    val rhyme = game.currentRhyme ?: return
    val localizedLines = rhyme.linesFor(learningLanguage)
    val totalLines = game.level.totalLines
    val progress = if (totalLines > 0) {
        game.linesRead.toFloat() / totalLines
    } else {
        0f
    }
    val canPrev = NurseryRhymesEngine.canPrevLine(game)
    val canNext = NurseryRhymesEngine.canNextLine(game)
    val currentLineText = localizedLines.getOrNull(game.currentLineIndex).orEmpty()

    LaunchedEffect(
        game.currentRhymeIndex,
        game.currentLineIndex,
        learningLanguage,
        soundEnabled,
        currentLineText
    ) {
        if (soundEnabled && currentLineText.isNotBlank()) {
            rhymeSpeech.speak(rhyme.id, game.currentLineIndex, currentLineText, learningLanguage)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .semantics { contentDescription = boardDescription },
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = rhyme.category.displayName,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = stringResource(
                    R.string.line_progress,
                    game.currentLineIndex + 1,
                    localizedLines.size
                ),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        LinearProgressIndicator(
            progress = { progress.coerceIn(0f, 1f) },
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp)),
        )

        Text(
            text = rhyme.illustration,
            fontSize = 72.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = rhyme.titleFor(learningLanguage),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            tonalElevation = 2.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = currentLineText,
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 16.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    lineHeight = MaterialTheme.typography.headlineMedium.lineHeight
                )
                IconButton(
                    onClick = {
                        if (soundEnabled && currentLineText.isNotBlank()) {
                            rhymeSpeech.speak(rhyme.id, game.currentLineIndex, currentLineText, learningLanguage)
                        }
                    },
                    enabled = soundEnabled && currentLineText.isNotBlank()
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.VolumeUp,
                        contentDescription = stringResource(R.string.speak_line)
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onPrevLine, enabled = canPrev) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.prev_line)
                )
            }
            IconButton(onClick = onNextLine, enabled = canNext) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = stringResource(R.string.next_line)
                )
            }
        }

        if (game.level.rhymes.size > 1) {
            Text(
                text = stringResource(R.string.rhyme_picker_title),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(top = 8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                game.level.rhymes.forEachIndexed { index, levelRhyme ->
                    val isSelected = index == game.currentRhymeIndex
                    val isComplete = index in game.completedRhymeIndices
                    RhymePickerChip(
                        emoji = levelRhyme.illustration,
                        title = levelRhyme.titleFor(learningLanguage),
                        isSelected = isSelected,
                        isComplete = isComplete,
                        onClick = { onRhymeSelected(index) }
                    )
                }
            }
        }

        Spacer(Modifier.height(8.dp))
    }
}

@Composable
private fun RhymePickerChip(
    emoji: String,
    title: String,
    isSelected: Boolean,
    isComplete: Boolean,
    onClick: () -> Unit
) {
    val borderColor = when {
        isSelected -> MaterialTheme.colorScheme.primary
        isComplete -> MaterialTheme.colorScheme.tertiary
        else -> MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
    }
    val backgroundColor = when {
        isSelected -> MaterialTheme.colorScheme.primaryContainer
        isComplete -> MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.5f)
        else -> MaterialTheme.colorScheme.surfaceVariant
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .border(1.5.dp, borderColor, RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = emoji, fontSize = 24.sp)
            Text(
                text = title,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1
            )
        }
    }
}

@Composable
fun GameStatChip(label: String, value: String, modifier: Modifier = Modifier) {
    Text(
        text = "$label: $value",
        style = MaterialTheme.typography.labelLarge,
        modifier = modifier
    )
}
