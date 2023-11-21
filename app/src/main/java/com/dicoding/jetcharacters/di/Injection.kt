package com.dicoding.jetcharacters.di

import com.dicoding.jetcharacters.data.CharacterRepository

object Injection {
    fun provideRepository(): CharacterRepository {
        return CharacterRepository.getInstance()
    }
}