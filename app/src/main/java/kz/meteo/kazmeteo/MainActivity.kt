package kz.meteo.kazmeteo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kz.meteo.kazmeteo.databinding.ActivityMainBinding
import kz.meteo.kazmeteo.utilits.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    lateinit var mToolbar: Toolbar
    lateinit var mNavController: NavController
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        mToolbar = mBinding.toolbarActivityMain
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main)
        setSupportActionBar(mToolbar)
        title = getString(R.string.app_title)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}