package es.iesnervion.mcasado.justpeople.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.iesnervion.mcasado.justpeople.R
import es.iesnervion.mcasado.justpeople.model.Person

class PeopleAdapter (var persons: List<Person> ): RecyclerView.Adapter<PeopleAdapter.ViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTxV.text = persons[position].name
        holder.surnameTxV.text = persons[position].surname
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTxV: TextView = itemView.findViewById(R.id.name)
        val surnameTxV: TextView = itemView.findViewById(R.id.surname)

    }

}