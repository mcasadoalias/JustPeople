package es.iesnervion.mcasado.justpeople.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import es.iesnervion.mcasado.justpeople.model.Person
import es.iesnervion.mcasado.justpeople.repo.PeopleRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PeopleVM(private val peopleRepo: PeopleRepo) : ViewModel() {
    /*private val _persons = MutableLiveData<ArrayList<Person>>()
    val persons: LiveData<ArrayList<Person>>
        get() = _persons*/
    val persons = liveData(Dispatchers.IO) {
        val data = peopleRepo.getAllPersons()
        emit (data)
    }

    suspend fun addPerson (p : Person) {
        withContext(Dispatchers.IO){
            peopleRepo.addPerson(p)
        }
    }
}