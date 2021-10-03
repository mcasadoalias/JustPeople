package es.iesnervion.mcasado.justpeople.vm

import androidx.lifecycle.*

import es.iesnervion.mcasado.justpeople.model.Person
import es.iesnervion.mcasado.justpeople.repo.PeopleRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PeopleVM(private val peopleRepo: PeopleRepo) : ViewModel() {
    /*private val _persons = MutableLiveData<ArrayList<Person>>()
    val persons: LiveData<ArrayList<Person>>
        get() = _persons*/
    val persons = liveData(Dispatchers.IO) {
        val data = peopleRepo.getAllPersons()
        emit (data)
    }

    fun addPerson (p : Person) {
        viewModelScope.launch{
            peopleRepo.addPerson(p)
        }
    }
}