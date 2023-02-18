package com.miteris.myviewbinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.miteris.myviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

/*        val buttonCoche = findViewById<Button>(R.id.action_goto_cocheActivity)
        buttonCoche.setOnClickListener {
            val intent = Intent(this, CochesActivity::class.java)
            startActivity(intent)
        }*/

        binding.actionGotoCocheActivity.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                startActivity(Intent(this@MainActivity, CochesActivity::class.java))
            }
        })


 /*       val buttonAvion = findViewById<Button>(R.id.action_goto_avionActivity)
        buttonAvion.setOnClickListener {
            val intent = Intent(this, AvionesActivity::class.java)
            startActivity(intent)
        }*/
        binding.actionGotoAvionActivity.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                startActivity(Intent(this@MainActivity, AvionesActivity::class.java))
            }
        })

/*        val buttonBarco = findViewById<Button>(R.id.action_goto_barcoActivity)
        buttonBarco.setOnClickListener {
            val intent = Intent(this, BarcosActivity::class.java)
            startActivity(intent)
        }*/
        binding.actionGotoBarcoActivity.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                startActivity(Intent(this@MainActivity, BarcosActivity::class.java))
            }
        })

 /*       val buttonTren = findViewById<Button>(R.id.action_goto_trenActivity)
        buttonTren.setOnClickListener {
            val intent = Intent(this, TrenesActivity::class.java)
            startActivity(intent)
        }*/
        binding.actionGotoTrenActivity.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                startActivity(Intent(this@MainActivity, TrenesActivity::class.java))
            }
        })
    }
}