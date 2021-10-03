package es.iesnervion.mcasado.justpeople.api

import es.iesnervion.mcasado.justpeople.model.Person
import retrofit2.http.GET

interface PeopleApi {

    @GET("person")
    suspend fun getAllPersons (): List<Person>
}