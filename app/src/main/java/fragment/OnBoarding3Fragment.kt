package fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tradixapp.LoginActivity
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.onboarding3.view.*

class OnBoarding3Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.onboarding3, container, false)
        view.btnSkipInStep3.setOnClickListener {
            startActivity(Intent(context, LoginActivity::class.java))
            Toast.makeText(context, "Login Activity", Toast.LENGTH_SHORT).show()
            val edit: SharedPreferences.Editor =
                context?.getSharedPreferences("isDone", Context.MODE_PRIVATE)!!.edit()
            edit.putBoolean("active",true)
            edit.commit()
            requireActivity().finish()
        }
        view.btnBackToStep2.setOnClickListener {
            findNavController().navigateUp()
        }
        view.btnStart.setOnClickListener {
            startActivity(Intent(context, LoginActivity::class.java))
            Toast.makeText(context, "Login Activity", Toast.LENGTH_SHORT).show()
            val edit: SharedPreferences.Editor =
                requireActivity().getSharedPreferences("isDone", Context.MODE_PRIVATE)!!.edit()
            edit.putBoolean("active",true)
            edit.commit()
            requireActivity().finish()
        }
        return view
    }
}