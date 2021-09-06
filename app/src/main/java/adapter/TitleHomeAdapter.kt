package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.tradixapp.R

class TitleHomeAdapter(
    private val context: Context?,
    private val dataSet: ArrayList<String>,
    private val styleItem: String
) :
    RecyclerView.Adapter<TitleHomeAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tvTitle)

        fun setData(s: String) {
            textView.text = s
        }

        fun setBackGroundItem() {
            when (styleItem) {
                "rcv_item_home" -> {
                    textView.setBackgroundResource(R.drawable.button_pink_radius)
                    textView.setTextColor(ContextCompat.getColor(context!!, R.color.white_three))
                }
                "rcv_item_news" -> textView.setBackgroundResource(R.drawable.border_item_green)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = when (styleItem) {
            "rcv_item_home" -> LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_rcv_title_home, parent, false)
            "rcv_item_news" -> LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_rcv_title_news, parent, false)
            else -> LayoutInflater.from(parent.context)
                .inflate(R.layout.support_simple_spinner_dropdown_item, parent, false)
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(dataSet[position])
        if (position == 0) {
            holder.setBackGroundItem()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}