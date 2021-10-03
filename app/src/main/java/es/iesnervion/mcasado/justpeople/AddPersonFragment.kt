package es.iesnervion.mcasado.justpeople

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import es.iesnervion.mcasado.justpeople.model.Person
import es.iesnervion.mcasado.justpeople.vm.PeopleVM
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
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

        //name
        nameLay = v.findViewById(R.id.nameTxtIL)
        nameEdTx = v.findViewById(R.id.name)
        nameEdTx.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                nameLay.error = null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })



        //surname
        surnameLay = v.findViewById(R.id.surnameTxtIL)
        surnameEdTx = v.findViewById(R.id.surname)
        surnameEdTx.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                surnameLay.error = null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


        //save button
        saveBt = v.findViewById(R.id.saveBtn)
        saveBt.setOnClickListener(View.OnClickListener {
                _: View ->
            nameLay.error = null
            surnameLay.error = null
            if (areRequiredFieldsEmpty()){
                displayErrors();
            } else {
                var p = Person(nameEdTx.text.toString(), surnameEdTx.text.toString())
                this@AddPersonFragment.peopleViewModel.addPerson(p)
            }

        })

        //cancel button
        cancelBt = v.findViewById(R.id.cancelBtn)
        cancelBt.setOnClickListener(View.OnClickListener {
                _ -> requireActivity().onBackPressed()
        })
        //TODO: Navigate back when cancel is pressed

        return v
    }

    private fun displayErrors() {
        if (nameEdTx.text.toString().trim().isEmpty()){
            nameLay.error = getString(R.string.name_required)
        }
        if (surnameEdTx.text.toString().trim().isEmpty()){
            surnameLay.error = getString(R.string.surname_required)
        }

    }

    private fun areRequiredFieldsEmpty(): Boolean {
        var res = false
        if (nameEdTx.text.toString().trim().isEmpty() ||
            surnameEdTx.text.toString().trim().isEmpty()){
            res = true;
        }
        return res
    }


}


