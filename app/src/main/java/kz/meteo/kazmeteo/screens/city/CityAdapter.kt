package kz.meteo.kazmeteo.screens.city

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.city_item.view.*
import kz.meteo.kazmeteo.R
import kz.meteo.kazmeteo.databinding.CityItemBinding
import kz.meteo.kazmeteo.interfaces.CityAdapterCallback
import kz.meteo.kazmeteo.models.CurrentCityWeather

class CityAdapter(
    var mListCities: List<CurrentCityWeather>? = listOf(),
    var callback: CityAdapterCallback
) :
    RecyclerView.Adapter<CityAdapter.CityHolder>() {


    class CityHolder(var itemBinding: CityItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)

        val binding: CityItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.city_item,
            parent,
            false
        )

        return CityHolder(binding)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.itemBinding.city = mListCities!![position]

        holder.itemView.setOnClickListener(View.OnClickListener {
            var selectedCity = CurrentCityWeather()

            Log.d("test", holder.itemView.text_view_city_item_lat.text.toString())
            selectedCity.name = holder.itemBinding.textViewCityItemName.text.toString()
            selectedCity.main?.temp =
                holder.itemBinding.textViewCityItemTemperature.text.toString().toDouble()
            selectedCity.weather?.get(0)?.description =
                holder.itemBinding.textViewCityItemTemperature.text.toString()
            selectedCity.coord?.lat =
                holder.itemBinding.textViewCityItemLat.text.toString().toDouble()
            selectedCity.coord?.lon =
                holder.itemBinding.textViewCityItemLat.text.toString().toDouble()



            callback.onMethodCallback(selectedCity)

        })


    }

    override fun getItemCount(): Int = mListCities!!.size

    fun setList(list: List<CurrentCityWeather>) {
        mListCities = list
        notifyDataSetChanged()
    }


}