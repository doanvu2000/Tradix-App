package adapter

import `object`.User
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tradixapp.R

class ListCoinAdapter(private var listCoin: ArrayList<User>) :
    RecyclerView.Adapter<ListCoinAdapter.ViewHolder>() {
    lateinit var onItemClick: (position: Int) -> Unit

    fun setItemClick(event: (position: Int) -> Unit) {
        onItemClick = event
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvUserName: TextView = view.findViewById(R.id.tvUserName)
        var tvTimeRegister: TextView = view.findViewById(R.id.tvTimeRegister)
        var tvCurrentMoney: TextView = view.findViewById(R.id.tvCurrentMoney)
        var tvCurrentPercent: TextView = view.findViewById(R.id.tvCurrentPercent)
        fun setData(item: User) {
            tvUserName.text = item.userName
            tvTimeRegister.text = item.timeRegister
            tvCurrentMoney.text = item.currentMoney
            tvCurrentPercent.text = item.currentPercent
        }

        init {
            view.setOnClickListener {
                onItemClick.invoke(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_rcv_list_coin, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(listCoin[position])
    }

    override fun getItemCount(): Int {
        return listCoin.size
    }


}