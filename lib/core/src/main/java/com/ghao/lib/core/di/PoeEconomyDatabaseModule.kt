package com.ghao.lib.core.di

import com.ghao.lib.core.repository.PoeEconomyRepository
import com.ghao.lib.core.repository.PoeEconomyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface PoeEconomyDatabaseModule {
    @Singleton
    @Binds
    fun bindRepository(impl: PoeEconomyRepositoryImpl): PoeEconomyRepository
}
