package es.iesnervion.mcasado.justpeople.api

import es.iesnervion.mcasado.justpeople.model.Person
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PeopleApi {

    @GET("person")
    suspend fun getAllPersons (): List<Person>

    @POST("person")
    suspend fun addPerson(@Body p : Person)
}