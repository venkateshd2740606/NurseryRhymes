package com.nurseryrhymes.di

import com.nurseryrhymes.data.repository.ChallengeRepositoryImpl
import com.nurseryrhymes.data.repository.GameRepositoryImpl
import com.nurseryrhymes.data.repository.PreferencesRepositoryImpl
import com.nurseryrhymes.data.repository.ProgressionRepositoryImpl
import com.nurseryrhymes.domain.repository.ChallengeRepository
import com.nurseryrhymes.domain.repository.GameRepository
import com.nurseryrhymes.domain.repository.PreferencesRepository
import com.nurseryrhymes.domain.repository.ProgressionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds @Singleton abstract fun bindGameRepository(impl: GameRepositoryImpl): GameRepository
    @Binds @Singleton abstract fun bindChallengeRepository(impl: ChallengeRepositoryImpl): ChallengeRepository
    @Binds @Singleton abstract fun bindProgressionRepository(impl: ProgressionRepositoryImpl): ProgressionRepository
    @Binds @Singleton abstract fun bindPreferencesRepository(impl: PreferencesRepositoryImpl): PreferencesRepository
}
