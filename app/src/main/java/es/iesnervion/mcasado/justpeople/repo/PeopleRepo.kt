package es.iesnervion.mcasado.justpeople.repo

import es.iesnervion.mcasado.justpeople.api.PeopleApi

class PeopleRepo (private val peopleApi: PeopleApi) {

    suspend fun getAllPersons() = peopleApi.getAllPersons()

}