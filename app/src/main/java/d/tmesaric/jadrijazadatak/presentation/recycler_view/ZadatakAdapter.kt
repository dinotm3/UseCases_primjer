package d.tmesaric.jadrijazadatak.presentation.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import d.tmesaric.jadrijazadatak.R
import d.tmesaric.jadrijazadatak.domain.model.Zadatak

class ZadatakAdapter(
    var zadaci: List<Zadatak>
) : RecyclerView.Adapter<ZadatakAdapter.ZadatakViewHolder>() {

    inner class ZadatakViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZadatakViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_zadatak, parent, false)
        return ZadatakViewHolder(view)
    }

    override fun onBindViewHolder(holder: ZadatakViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.tv_title).text = zadaci[position].title
            findViewById<CheckBox>(R.id.cb_completed).isChecked = zadaci[position].isComplete
        }
    }

    override fun getItemCount(): Int {
        return zadaci.size
    }
}