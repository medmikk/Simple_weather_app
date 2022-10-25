package com.medmikk.avitoweatherapp.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.avitoweatherapp.databinding.WeeklyRowBinding
import com.medmikk.avitoweatherapp.domain.models.WeatherDomain
import com.medmikk.avitoweatherapp.presentation.extentions.Helper
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

class WeeklyAdapter : RecyclerView.Adapter<WeeklyAdapter.WeeklyViewHolder>() {

    inner class WeeklyViewHolder(val binding: WeeklyRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<WeatherDomain>() {
        override fun areItemsTheSame(
            oldItem: WeatherDomain,
            newItem: WeatherDomain
        ): Boolean {
            //TODO make normal difference
            return oldItem.dateUnix == newItem.dateUnix
        }

        override fun areContentsTheSame(
            oldItem: WeatherDomain,
            newItem: WeatherDomain
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeeklyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = WeeklyRowBinding.inflate(inflater, parent, false)
        return WeeklyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeeklyViewHolder, position: Int) {
        val forecast = differ.currentList[position]
        with(holder.binding) {
            tempTVWeekly.text = "${forecast.temp!!.roundToInt()}°"
            Log.d("WEATHER", forecast.toString())

            //TODO refactor hardcode
            val secondApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val timestamp = forecast.dateUnix!!.toLong()
            val timestampAsDateString = DateTimeFormatter.ISO_INSTANT
                .format(java.time.Instant.ofEpochSecond(timestamp))
            val date = LocalDate.parse(timestampAsDateString, secondApiFormat)
            val dateString = "${date.dayOfWeek.toString().substring(0, 3)}, " +
                    "${date.dayOfMonth} ${date.month.toString().substring(0, 3)} " +
                    Helper.mapTimeToHHmm(timestamp.times(1000))
                    dateTVWeekly.text = dateString


            val imgURL = "http://openweathermap.org/img/wn/${forecast.ico}@2x.png"
            Glide.with(holder.binding.root).load(imgURL).into(imgIVWeekly)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((WeeklyRowBinding) -> Unit)? = null


}