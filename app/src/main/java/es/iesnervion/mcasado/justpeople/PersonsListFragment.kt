package es.iesnervion.mcasado.justpeople

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.iesnervion.mcasado.justpeople.adapters.PeopleAdapter
import es.iesnervion.mcasado.justpeople.model.Person
import es.iesnervion.mcasado.justpeople.vm.PeopleVM
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 * Use the [PersonsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonsListFragment : Fragment() {


    private lateinit var recycler : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val peopleViewModel by viewModel<PeopleVM>()

        peopleViewModel.persons.observe(this, Observer { p: List<Person> ->
            recycler.adapter = PeopleAdapter (p)
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_persons_list, container, false)
        recycler = v.findViewById(R.id.persons_list)
        recycler.layoutManager = LinearLayoutManager (context, RecyclerView.VERTICAL , false);

        return v
    }

}