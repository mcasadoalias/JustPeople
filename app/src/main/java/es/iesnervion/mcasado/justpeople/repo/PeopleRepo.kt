package es.iesnervion.mcasado.justpeople.repo

import es.iesnervion.mcasado.justpeople.api.PeopleApi
import es.iesnervion.mcasado.justpeople.model.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PeopleRepo (private val peopleApi: PeopleApi) {

    suspend fun getAllPersons() = withContext(Dispatchers.IO) {peopleApi.getAllPersons()}

    suspend fun addPerson(p: Person) = withContext(Dispatchers.IO) {peopleApi.addPerson(p)}

}