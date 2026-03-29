package com.example.myapplication.di

import com.example.myapplication.data.repository.AppCatalogRepositoryImpl
import com.example.myapplication.domain.repository.AppCatalogRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindAppCatalogRepository(impl: AppCatalogRepositoryImpl): AppCatalogRepository
}
