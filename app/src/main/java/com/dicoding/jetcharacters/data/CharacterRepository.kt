package com.dicoding.jetcharacters.data

import com.dicoding.jetcharacters.model.CharactersDataSource
import com.dicoding.jetcharacters.model.Character

class CharacterRepository {
    fun getCharacters(): List<Character> {
        return CharactersDataSource.characters
    }

    fun getCharacterById(id: String): Character {
        return CharactersDataSource.characters.find { it.id == id }!!
    }

    fun searchCharacters(query: String): List<Character>{
        return CharactersDataSource.characters.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    companion object {
        @Volatile
        private var instance: CharacterRepository? = null

        fun getInstance(): CharacterRepository =
            instance ?: synchronized(this) {
                CharacterRepository().apply {
                    instance = this
                }
            }
    }
}