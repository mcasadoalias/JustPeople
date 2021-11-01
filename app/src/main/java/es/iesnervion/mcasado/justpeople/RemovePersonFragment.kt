package es.iesnervion.mcasado.justpeople

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

/**
 * A simple [Fragment] subclass.
 * Use the [RemovePersonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RemovePersonFragment : Fragment(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_remove_person, container, false)
        val buttonDialog: Button = v.findViewById(R.id.btn_show_dialog)
        buttonDialog.setOnClickListener(this)
        return v
    }

    override fun onClick(v: View?) {
        val dialog = ConfirmationDialogFragment()
        dialog.show(childFragmentManager, ConfirmationDialogFragment.TAG)


    }


    class ConfirmationDialogFragment : DialogFragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val v = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
            val btn_ok = v.findViewById<Button>(R.id.btn_confirm_dialog)
            btn_ok.setOnClickListener { /* TODO onClickListener... */ dialog?.dismiss() }
            return v
        }
/*       override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
            AlertDialog.Builder(requireContext())
                .setMessage(getString(R.string.confirm))
                .setPositiveButton(getString(R.string.ok)) { _,_ -> }
                .setNegativeButton(getString(R.string.cancel)) { _,_ -> }
                .create()*/

        companion object {
            const val TAG = "PurchaseConfirmationDialog"
        }
    }
}