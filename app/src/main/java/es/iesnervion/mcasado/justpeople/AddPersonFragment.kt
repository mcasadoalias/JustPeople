package es.iesnervion.mcasado.justpeople

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import es.iesnervion.mcasado.justpeople.model.Person
import es.iesnervion.mcasado.justpeople.vm.PeopleVM
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 */
class AddPersonFragment : Fragment() {

    private lateinit var nameEdTx: TextInputEditText
    private lateinit var nameLay: TextInputLayout
    private lateinit var surnameEdTx : TextInputEditText
    private lateinit var surnameLay: TextInputLayout
    private lateinit var saveBt : Button
    private lateinit var cancelBt : Button
    private val peopleViewModel by viewModel<PeopleVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_add_person, container, false)

        nameEdTx = v.findViewById(R.id.name)
        nameLay = v.findViewById(R.id.nameTxtIL)
        surnameEdTx = v.findViewById(R.id.surname)
        surnameLay = v.findViewById(R.id.surnameTxtIL)

        //save button
        saveBt = v.findViewById(R.id.saveBtn)
        saveBt.setOnClickListener(View.OnClickListener {
                _: View ->
                    var p = Person(nameEdTx.text.toString(),surnameEdTx.text.toString())
                    GlobalScope.launch{this@AddPersonFragment.peopleViewModel.addPerson(p)}

        })

        //cancel button
        cancelBt = v.findViewById(R.id.cancelBtn)
        cancelBt.setOnClickListener(View.OnClickListener {
                _ -> requireActivity().onBackPressed()
        })
        //TODO: Navigate back when cancel is pressed

        return v
    }


}


