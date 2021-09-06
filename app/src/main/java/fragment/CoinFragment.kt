package fragment

import `object`.User
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.coin.view.*
import kotlinx.android.synthetic.main.item_layout_rcv_list_coin.view.*
import kotlinx.android.synthetic.main.item_layout_rcv_list_coin.view.tvUserName

class CoinFragment : Fragment() {
    var isClickBell = false
    private val args: CoinFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.coin, container, false)
        Log.d("abc", "onCreateView: ${args.userCoin}}")
        view.tvCoinUserName.text = args.userCoin?.userName
        view.tvCoinCurrentMoney.text = args.userCoin?.currentMoney
        view.tvCoinCurrentPercent.text = args.userCoin?.currentPercent
        view.imgBellCoin.setOnClickListener {
            isClickBell = !isClickBell
            if (isClickBell) {
                view.imgBellCoin.setBackgroundResource(R.drawable.bell_blue)
            } else view.imgBellCoin.setBackgroundResource(R.drawable.bell_black)
        }
        return view
    }

}