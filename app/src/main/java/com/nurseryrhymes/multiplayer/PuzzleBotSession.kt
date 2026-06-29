package com.nurseryrhymes.multiplayer

import com.nurseryrhymes.domain.model.NurseryRhymesGame
import com.nurseryrhymes.domain.model.Difficulty
import com.nurseryrhymes.domain.model.MultiplayerMode
import com.nurseryrhymes.domain.model.MultiplayerSession
import com.nurseryrhymes.engine.NurseryRhymesEngine
import com.nurseryrhymes.engine.NurseryRhymesGenerator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PuzzleBotSession @Inject constructor() {
    private val _session = MutableStateFlow<MultiplayerSession?>(null)
    val session: StateFlow<MultiplayerSession?> = _session.asStateFlow()

    private var playerGame: NurseryRhymesGame? = null
    private var botGame: NurseryRhymesGame? = null
    private var playerName = "You"
    private val botName = "AI Bot"

    fun start(player: String, difficulty: Difficulty, seed: Long = System.currentTimeMillis()) {
        playerName = player
        val level = NurseryRhymesGenerator.generate(seed, 1, difficulty)
        val game = NurseryRhymesEngine.createInitialGame(level)
        playerGame = game
        botGame = game
        _session.value = MultiplayerSession(
            mode = MultiplayerMode.SAME_DEVICE,
            localPlayerName = playerName,
            remotePlayerName = botName,
            activePlayerName = playerName,
            isActive = true,
            seed = seed,
            difficulty = difficulty
        )
    }

    fun getPlayerGame(): NurseryRhymesGame? = playerGame

    fun applyPlayerNextLine(): NurseryRhymesGame? {
        val game = playerGame ?: return null
        val updated = NurseryRhymesEngine.nextLine(game)
        playerGame = updated
        botGame = updated
        return updated
    }

    fun applyBotMove(): NurseryRhymesGame? {
        val game = botGame ?: return null
        if (!NurseryRhymesEngine.canNextLine(game)) return game
        val updated = NurseryRhymesEngine.nextLine(game)
        playerGame = updated
        botGame = updated
        return updated
    }

    fun onPlayerWon() {
        val session = _session.value ?: return
        _session.value = session.copy(
            localScore = session.localScore + 1,
            activePlayerName = playerName
        )
        startNewRound(session)
    }

    fun onBotWon() {
        val session = _session.value ?: return
        _session.value = session.copy(
            remoteScore = session.remoteScore + 1,
            activePlayerName = playerName
        )
        startNewRound(session)
    }

    private fun startNewRound(session: MultiplayerSession) {
        val newSeed = session.seed + session.localScore + session.remoteScore
        val level = NurseryRhymesGenerator.generate(
            newSeed,
            session.localScore + session.remoteScore + 1,
            session.difficulty
        )
        val game = NurseryRhymesEngine.createInitialGame(level)
        playerGame = game
        botGame = game
    }

    fun isBotThinking(): Boolean = false

    fun end() {
        _session.value = null
        playerGame = null
        botGame = null
    }
}
