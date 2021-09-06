package adapter

import `object`.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.item_menu_1.view.*
import kotlinx.android.synthetic.main.item_menu_2.view.*
import kotlinx.android.synthetic.main.item_menu_3.view.*

private const val ITEM_TYPE_ONE: Int = 1
private const val ITEM_TYPE_TWO: Int = 2
private const val ITEM_TYPE_THREE: Int = 3

class MenuAdapter(var listItem: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //ViewHolder for Item1
    class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: Item) {
            itemView.tvUserNameMenu.text = item.name
        }
    }

    //ViewHolder for Item2
    class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: Item) {
            itemView.tvAlert.text = "Alerts " + item.name
            itemView.tvPrediction.text = "Predictions " + item.name
            itemView.tvSaved.text = "Saved elements " + item.name
            itemView.tvRemove.text = "Remove Ads " + item.name
        }
    }

    //ViewHolder for Item3
    class ViewHolder3(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: Item) {
            itemView.tvNameItem.text = item.name
            itemView.tvSelect.text = "Select Stocks " + item.name
            itemView.tvCurrency.text = "Currency Exchange " + item.name
            itemView.tvWebinar.text = "Webinar " + item.name
            itemView.tvBestBroker.text = "Best Broker " + item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            ITEM_TYPE_ONE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_menu_1, parent, false)
                return ViewHolder1(view)
            }
            ITEM_TYPE_TWO -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_menu_2, parent, false)
                return ViewHolder2(view)
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_menu_3, parent, false)
                return ViewHolder3(view)
            }
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == ITEM_TYPE_ONE) {
            (holder as ViewHolder1).bindData(listItem[position])
        } else if (getItemViewType(position) == ITEM_TYPE_TWO) {
            (holder as ViewHolder2).bindData(listItem[position])
        } else (holder as ViewHolder3).bindData(listItem[position])
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun getItemViewType(position: Int): Int {
        return listItem[position].type
    }
}