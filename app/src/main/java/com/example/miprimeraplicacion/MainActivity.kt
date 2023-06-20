package com.example.miprimeraplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.miprimeraplicacion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /** Indica que vista se mostrará**/
        //setContentView(R.layout.activity_main)
        //setName("Manuel");

        setUpView()
        setUpListeners()
        showToast()

        Log.e("Royal","On create")


    }

    fun setName(name:String){
        binding.tvActivityMainText.text =name



    }

    override fun onStart() {
        super.onStart()
        Log.e("Royal","On Start");
    }

    override fun onResume(){
        super.onResume()
        Log.e("Royal","On Resume");

    }

    fun showToast(){

    }

    private fun setUpView(){
        Toast.makeText(this,"La vista ha sido cargada", Toast.LENGTH_SHORT).show()
    }

    private fun setUpListeners(){
        binding.btnActivityMainShow.setOnClickListener{

            with(binding){
                val name : String = etActivityMainTitle.editableText.toString()
                if(name.trim().isEmpty()) {
                    Toast.makeText(this@MainActivity, "Capture el nombre", Toast.LENGTH_SHORT).show()
                    //return@setOnClickListener
                }else {
                    Toast.makeText(this@MainActivity, "El nombre es: $name", Toast.LENGTH_SHORT).show()
                    tvActivityMainText.text = name
                }
                if(name.equals("Alan")){
                    tvActivityMainTextHidden.visibility= View.VISIBLE
                    tvActivityMainTextHidden.text = "Hola $name !"
                }else{
                    tvActivityMainTextHidden.visibility= View.INVISIBLE
                    tvActivityMainTextHidden.text = ""
                }
            }

        }
    }
}