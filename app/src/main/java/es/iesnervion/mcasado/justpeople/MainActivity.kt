package es.iesnervion.mcasado.justpeople

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import es.iesnervion.mcasado.justpeople.model.Person
import es.iesnervion.mcasado.justpeople.vm.PeopleVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botNav: BottomNavigationView = findViewById(R.id.navigation)
        val navH = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val peopleViewModel by viewModel<PeopleVM>()

        botNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.users_list -> {
                    // Respond to users_list
                    val action = NavGraphDirections.actionGlobalUsersListFragment()
                    navH?.findNavController()?.navigate(action)

                    true
                }
                R.id.add_user -> {
                    // Respond to add_user
                    val action = NavGraphDirections.actionGlobalAddUserFragment()
                    navH?.findNavController()?.navigate(action)
                    true
                }
                R.id.remove_user -> {
                    // Respond to remove_user
                    val action = NavGraphDirections.actionGlobalRemoveUserFragment()
                    navH?.findNavController()?.navigate(action)
                    true
                }
                else -> false
            }
        }
        botNav.selectedItemId = R.id.users_list
    }

}