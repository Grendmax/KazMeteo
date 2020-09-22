package kz.meteo.kazmeteo.screens.city

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import kz.meteo.kazmeteo.R
import kz.meteo.kazmeteo.databinding.FragmentCityBinding
import kz.meteo.kazmeteo.interfaces.CityAdapterCallback
import kz.meteo.kazmeteo.models.CurrentCityWeather
import kz.meteo.kazmeteo.models.CurrentWeather
import kz.meteo.kazmeteo.models.FutureCityWeather
import kz.meteo.kazmeteo.screens.WeatherFragment


class CityFragment : Fragment(), CityAdapterCallback {

    private var _binding: FragmentCityBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: CityFragmentViewModel
    private lateinit var mAdapter: CityAdapter
    private lateinit var mRecyclerView: RecyclerView
    private var mContext: Context? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCityBinding.inflate(layoutInflater, container, false)
        mContext = context
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization(this)
        initializeObservers()
    }


    private fun initialization(callback: CityAdapterCallback) {
        mViewModel = ViewModelProvider(this).get(CityFragmentViewModel::class.java)
        mViewModel.initDatabase()
        mAdapter = CityAdapter(callback = callback)
        mRecyclerView = mBinding.recyclerViewFragmentCity
        mRecyclerView.adapter = mAdapter

    }

    private fun initializeObservers() {


        var cityList = arrayListOf("Karaganda", "Astana", "Aktau", "Shymkent", "Taraz")

        for (item in cityList) {
            var mList = mutableListOf<CurrentCityWeather>()
            mViewModel.fetchCountriesFromServer(mContext!!, item).observe(this, Observer { kt ->
                mList.add(kt)
                mAdapter.setList(mList)
            })

        }

    }

    override fun onMethodCallback(futureWeather: CurrentCityWeather) {

        var fragment: WeatherFragment = WeatherFragment()
        var bundle: Bundle = Bundle()
        bundle.putParcelable("cityFromCityFragment", futureWeather)
        fragment.arguments = bundle

        fragmentManager?.beginTransaction()?.add(
            R.id.nav_host_fragment_activity_main,
            fragment
        )?.hide(this)?.addToBackStack("currentWeather")?.commit()

    }


}