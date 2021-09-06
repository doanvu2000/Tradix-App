package fragment

import adapter.TitleHomeAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.login.view.*
import kotlinx.android.synthetic.main.news.*
import kotlinx.android.synthetic.main.news.view.*

class NewsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news, container, false)
        view.rcv_title_news.layoutManager =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        val dataSet: ArrayList<String> = ArrayList()
        dataSet.add("EDITORIAL")
        dataSet.add("CRYPTO NEWS")
        dataSet.add("RAW MATERIAL")
        dataSet.add("ECONOMICS")
        view.rcv_title_news.adapter = TitleHomeAdapter(context, dataSet, "rcv_item_news")
        view.itemNews1.setOnClickListener {
            val action = NewsFragmentDirections.actionNewsFragmentToNewsArticleFragment("ATLANTIA")
            findNavController().navigate(action)
        }
        view.itemNews2.setOnClickListener {
            val action = NewsFragmentDirections.actionNewsFragmentToNewsArticleFragment("XIAOMI")
            findNavController().navigate(action)
        }
        view.itemNews3.setOnClickListener {
            val action = NewsFragmentDirections.actionNewsFragmentToNewsArticleFragment("APPLE")
            findNavController().navigate(action)
        }
        view.btnBackToHome.setOnClickListener {
            findNavController().navigateUp()
        }
        return view
    }

}