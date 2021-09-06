package fragment

import adapter.TitleHomeAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.news_article.view.*

class NewsArticleFragment : Fragment() {
    val args: NewsArticleFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_article, container, false)
        view.tvTitleNews.text = args.itemNew
        Toast.makeText(context, args.itemNew, Toast.LENGTH_SHORT).show()
        view.btnBackToNewsInArticle.setOnClickListener {
            findNavController().navigateUp()
        }
        val dataSet: ArrayList<String> = ArrayList()
        dataSet.add("EDITORIAL")
        dataSet.add("CRYPTO NEWS")
        dataSet.add("RAW MATERIAL")
        dataSet.add("ECONOMICS")
        view.rcv_title_news_article.adapter = TitleHomeAdapter(context, dataSet, "rcv_item_news")
        view.rcv_title_news_article.layoutManager =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        return view
    }

}