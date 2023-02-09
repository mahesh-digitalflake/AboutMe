package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.button.setOnClickListener {
            addNickname(it)
        }

//        val button:Button=findViewById(R.id.button)
//        button.setOnClickListener {
//            addNickname(it)
//        }
    }

    private fun addNickname(view: View)
    {
        val nickNameEdit:EditText=findViewById(R.id.nickNameEdit)
        val nickNameDisplay:TextView=findViewById(R.id.nickNameDisplay)

        nickNameDisplay.text=nickNameEdit.text
        nickNameEdit.visibility=View.GONE
        view.visibility=View.GONE
        nickNameDisplay.visibility=View.VISIBLE

        val imm=getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}