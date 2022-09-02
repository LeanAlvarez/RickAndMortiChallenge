package com.mirai.challengeflow.data.model

import java.util.*

/*
* {
  "info": {
    "count": 826,
    "pages": 42,
    "next": "https://rickandmortyapi.com/api/character/?page=20",
    "prev": "https://rickandmortyapi.com/api/character/?page=18"
  },
  "results": [
    {
      "id": 361,
      "name": "Toxic Rick",
      "status": "Dead",
      "species": "Humanoid",
      "type": "Rick's Toxic Side",
      "gender": "Male",
      "origin": {
        "name": "Alien Spa",
        "url": "https://rickandmortyapi.com/api/location/64"
      },
      "location": {
        "name": "Earth",
        "url": "https://rickandmortyapi.com/api/location/20"
      },
      "image": "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
      "episode": [
        "https://rickandmortyapi.com/api/episode/27"
      ],
      "url": "https://rickandmortyapi.com/api/character/361",
      "created": "2018-01-10T18:20:41.703Z"
    },
    // ...
  ]
}
* */




data class RickAndMortyModel(
            val id: Int = -1,
            val name: String = "",
            val status: String = "",
            val species: String = "",
            val type: String = "",
            val gender: String = "",
            val origin: OriginData,
            val location: LocationData,
            val image: String = "",
            val episode: List<String> = listOf(),
            val url: String = "",
            val created: String
            )


data class LocationData(val name: String= "" ,val url: String = "")

data class OriginData(val name: String = "", val url: String = "")

data class RickAndMortyList(val results: List<RickAndMortyModel> = listOf())