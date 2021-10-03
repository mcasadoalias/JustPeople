package es.iesnervion.mcasado.justpeople

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass.
 * Use the [UsersListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UsersListFragment : Fragment() {


    private lateinit var recycler : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_users_list, container, false)
        recycler = v.findViewById(R.id.users_list)
        return v
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment
         * @return A new instance of fragment UsersListFragment.
         */

        @JvmStatic
        fun newInstance() =
            UsersListFragment()
    }
}