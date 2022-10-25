package com.medmikk.avitoweatherapp.presentation.mainactivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avitoweatherapp.databinding.ActivityMainBinding
import com.medmikk.avitoweatherapp.presentation.adapters.WeeklyAdapter
import com.medmikk.avitoweatherapp.presentation.extentions.Helper.getLocalTime
import com.medmikk.avitoweatherapp.presentation.extentions.Helper.hideKeyboard
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModel()
    private lateinit var weeklyAdapter: WeeklyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        binding.searchET.setText("moscow")

        viewModel.forecastPublic.observe(this) { response ->
            weeklyAdapter.differ.submitList(response)
            binding.currTemperatureTV.text = "${response[0].temp?.roundToInt()}°"
            binding.currDetailsTV.text = response[0].details
            binding.updatedTV.text = "updated ${getLocalTime()}"
        }

        viewModel.toastConditionPublic.observe(this) { response ->
            if (response) {
                showToast("City not found")
                viewModel.toastComplete()
            }
        }

        binding.imageButton.setOnClickListener {
            if (binding.searchET.text.isNotEmpty()) {
                viewModel.getForecastForCity(binding.searchET.text.toString().trim())
                hideKeyboard()
            }
        }
    }

    private fun setupRecyclerView() {
        weeklyAdapter = WeeklyAdapter()
        binding.weeklyRV.apply {
            adapter = weeklyAdapter
            layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}