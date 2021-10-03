package es.iesnervion.mcasado.justpeople.repo

import es.iesnervion.mcasado.justpeople.api.PeopleApi
import es.iesnervion.mcasado.justpeople.model.Person

class PeopleRepo (private val peopleApi: PeopleApi) {

    suspend fun getAllPersons() = peopleApi.getAllPersons()

    suspend fun addPerson(p: Person) = peopleApi.addPerson(p)

}