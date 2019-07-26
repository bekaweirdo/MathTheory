package com.example.maththeory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.maththeory.algebra.AlgebraActivity
import com.example.maththeory.geometry.GeometryActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this).load(R.drawable.algebra).into(Algebra)
        Glide.with(this).load(R.drawable.gemoethry).into(Geometry)

        Algebra.setOnClickListener(clicklistener)
        Geometry.setOnClickListener(clicklistener)


    }
       private val clicklistener = View.OnClickListener { view ->
            when (view.id) {
                R.id.Geometry -> {
                    val intent = Intent(this,GeometryActivity::class.java)
                    startActivity(intent)
                }
                R.id.Algebra -> {
                    val intent = Intent(this,AlgebraActivity::class.java)
                    startActivity(intent)
                }
            }
        }

}
