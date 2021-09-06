package fragment

import `object`.Item
import adapter.MenuAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.layout_menu.view.*
import java.util.*
import kotlin.collections.ArrayList

class MenuFragment : Fragment() {
    val listItem: ArrayList<Item> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_menu, container, false)
        view.btnBackToNews.setOnClickListener {
            findNavController().navigateUp()
        }
        view.rcv_item_menu.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.rcv_item_menu.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        listItem.add(Item("Doan Vũ", 1))
        listItem.add(Item("", 2))
        listItem.add(Item("Tools", 3))
        listItem.add(Item("Markets", 3))
        createList(50)
        view.rcv_item_menu.adapter = MenuAdapter(listItem)
        return view
    }

    private fun createList(number: Int) {
        for (i in 1..number) {
            var ran = 0
            while (ran != 2 && ran != 3)
                ran = Random().nextInt(4)
            listItem.add(Item("Item $i", ran))
        }
    }

}