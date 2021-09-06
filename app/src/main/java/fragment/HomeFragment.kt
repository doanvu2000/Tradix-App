package fragment

import `object`.User
import adapter.ListCoinAdapter
import adapter.TitleHomeAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.home.view.*

class HomeFragment : Fragment() {
    private val listCoin: ArrayList<User> = ArrayList()
    var isClickBell = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home, container, false)
        view.imgBell.setOnClickListener {
            isClickBell = !isClickBell
            if (isClickBell)
                view.imgBell.setBackgroundResource(R.drawable.bell_blue)
            else view.imgBell.setBackgroundResource(R.drawable.bell_black)
        }
        view.rcv_listCoin.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_coinFragment)
        }
        //RecyclerView Title _ Home
        val data: ArrayList<String> = ArrayList()
        data.add("INDEX")
        data.add("SHARES")
        data.add("CURRENCIES")
        data.add("FUTURES")
        data.add("CRYPTO")
        view.rcv_title.layoutManager =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        view.rcv_title.adapter = TitleHomeAdapter(context, data, "rcv_item_home")
        //RecyclerView User
        createListData()
        view.rcv_listCoin.layoutManager = LinearLayoutManager(context)
        view.rcv_listCoin.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        val listCoinAdapter = ListCoinAdapter(listCoin)
        view.rcv_listCoin.adapter = listCoinAdapter
        listCoinAdapter.setItemClick {
            val user = listCoin[it]
            //transfer data to coinFragment
            val action = HomeFragmentDirections.actionHomeFragmentToCoinFragment(user)
            findNavController().navigate(action)
        }
        view.btnLoadMore.setOnClickListener {
            addItem()
            listCoinAdapter.notifyDataSetChanged()
            Toast.makeText(context, "load 10 item", Toast.LENGTH_SHORT).show()
        }
        val itemTouchHelper: ItemTouchHelper.SimpleCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                Toast.makeText(
                    context,
                    "delete item ${viewHolder.adapterPosition} " +
                            "- name: ${listCoin[viewHolder.adapterPosition].userName}",
                    Toast.LENGTH_SHORT
                ).show()
                listCoin.removeAt(viewHolder.adapterPosition)
                listCoinAdapter.notifyDataSetChanged()
            }
        }
        ItemTouchHelper(itemTouchHelper).attachToRecyclerView(view.rcv_listCoin)
        return view
    }

    private fun createListData() {
        listCoin.add(User("DOWN JONES", "NYSE 10::44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("FTSE 100", "LONDON 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("IBEX 35", "MADRID 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DAX 35", "XETRA 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DOWN JONES", "NYSE 10::44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("FTSE 100", "LONDON 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("IBEX 35", "MADRID 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DAX 35", "XETRA 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DOWN JONES", "NYSE 10::44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("FTSE 100", "LONDON 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("IBEX 35", "MADRID 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DAX 35", "XETRA 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DOWN JONES", "NYSE 10::44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("FTSE 100", "LONDON 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("IBEX 35", "MADRID 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DAX 35", "XETRA 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DOWN JONES", "NYSE 10::44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("FTSE 100", "LONDON 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("IBEX 35", "MADRID 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DAX 35", "XETRA 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DOWN JONES", "NYSE 10::44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("FTSE 100", "LONDON 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("IBEX 35", "MADRID 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DAX 35", "XETRA 10:44:45", "20.047,50", "+203(+1,04%"))
    }

    private fun addItem() {
        listCoin.add(User("DOWN JONES_1", "NYSE 10::44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("FTSE 100_2", "LONDON 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("IBEX 35_3", "MADRID 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DAX 35_4", "XETRA 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DOWN JONES_5", "NYSE 10::44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DOWN JONES_6", "NYSE 10::44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("FTSE 100_7", "LONDON 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("IBEX 35_8", "MADRID 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DAX 35_9", "XETRA 10:44:45", "20.047,50", "+203(+1,04%"))
        listCoin.add(User("DOWN JONES_10", "NYSE 10::44:45", "20.047,50", "+203(+1,04%"))

    }
}