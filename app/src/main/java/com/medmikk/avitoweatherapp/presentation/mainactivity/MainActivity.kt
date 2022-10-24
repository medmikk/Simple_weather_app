package com.medmikk.avitoweatherapp.presentation.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.avitoweatherapp.R
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel : MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et = findViewById<EditText>(R.id.ET)
        val tv = findViewById<TextView>(R.id.TV)
        val bt = findViewById<Button>(R.id.button)

        viewModel.geoPublic.observe(this) { response ->
            tv.text = response.toString()
        }

        bt.setOnClickListener {
            viewModel.getGeoData(et.text.toString())
        }
    }


}