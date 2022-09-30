package com.bps.retrofitexample2022.data.network.api

import retrofit2.Response

interface PokemonCardsApi {

    suspend fun pokemonApiCall(): Response<Any>
}
