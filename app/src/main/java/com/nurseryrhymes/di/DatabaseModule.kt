package com.nurseryrhymes.di

import android.content.Context
import androidx.room.Room
import com.nurseryrhymes.data.local.database.NurseryRhymesDatabase
import com.nurseryrhymes.data.local.database.dao.AchievementDao
import com.nurseryrhymes.data.local.database.dao.ChallengeDao
import com.nurseryrhymes.data.local.database.dao.EconomyDao
import com.nurseryrhymes.data.local.database.dao.GameDao
import com.nurseryrhymes.data.local.database.dao.ProfileDao
import com.nurseryrhymes.data.local.database.dao.StatsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NurseryRhymesDatabase =
        Room.databaseBuilder(context, NurseryRhymesDatabase::class.java, "nurseryrhymes.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides fun provideGameDao(db: NurseryRhymesDatabase): GameDao = db.gameDao()
    @Provides fun provideStatsDao(db: NurseryRhymesDatabase): StatsDao = db.statsDao()
    @Provides fun provideAchievementDao(db: NurseryRhymesDatabase): AchievementDao = db.achievementDao()
    @Provides fun provideChallengeDao(db: NurseryRhymesDatabase): ChallengeDao = db.challengeDao()
    @Provides fun provideEconomyDao(db: NurseryRhymesDatabase): EconomyDao = db.economyDao()
    @Provides fun provideProfileDao(db: NurseryRhymesDatabase): ProfileDao = db.profileDao()
}
