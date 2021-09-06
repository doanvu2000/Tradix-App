package fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tradixapp.LoginActivity
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.onboarding1.view.*
import kotlin.math.log

class OnBoarding1Fragment : Fragment() {
    lateinit var share: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.onboarding1, container, false)
        view.btnSkipInStep1.setOnClickListener {
            startActivity(Intent(context, LoginActivity::class.java))
            Toast.makeText(context, "Login Activity", Toast.LENGTH_SHORT).show()
            share = requireActivity().getSharedPreferences("isDone", Context.MODE_PRIVATE)!!
            val editor = share.edit()
            editor.putBoolean("active", true)
            editor.apply()
            Log.d("TAG", "onCreateView: " + share.getBoolean("active", false))
            requireActivity().finish()
        }
        view.btnNextStep2.setOnClickListener {
            findNavController().navigate(R.id.action_onBoarding1Fragment_to_onBoarding2Fragment)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        share = requireActivity().getSharedPreferences("isDone", Context.MODE_PRIVATE)
        Log.d("TAG", "onAttach: " + share.getBoolean("isActive", false))
        if (share.getBoolean("active", false)) {
            val it = Intent(context, LoginActivity::class.java)
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(it)
            requireActivity().finish()
        }
    }
}