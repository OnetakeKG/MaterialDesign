package net.nov.materialdesign.view.api.earth

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import net.nov.materialdesign.R
import net.nov.materialdesign.databinding.FragmentEarthBinding
import net.nov.materialdesign.databinding.FragmentMainBinding
import net.nov.materialdesign.view.MainActivity
import net.nov.materialdesign.view.api.ApiActivity
import net.nov.materialdesign.view.api.ApiBottomActivity
import net.nov.materialdesign.view.chips.SettingsFragment
import net.nov.materialdesign.viewmodel.PictureOfTheDayState
import net.nov.materialdesign.viewmodel.PictureOfTheDayViewModel
import java.text.SimpleDateFormat
import java.util.*


class EarthFragment : Fragment() {

    private var _binding: FragmentEarthBinding? = null
    val binding: FragmentEarthBinding
        get() {
            return _binding!!
        }

    private val viewModel: EarthFragmentViewModel by lazy {
        ViewModelProvider(this).get(EarthFragmentViewModel::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, Observer {
            renderData1(it)
        })
        viewModel.sendServerRequest()















    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEarthBinding.inflate(inflater, container, false)
        return binding.root
    }
    companion object {
        fun newInstance(): EarthFragment {
            return EarthFragment()
        }
    }
    fun renderData1(state: EarthFragmentState) {
        when (state) {
            is EarthFragmentState.Error -> {
                state.error.message
            }
            is EarthFragmentState.Loading -> {
                binding.imageView1.load(R.drawable.ic_no_photo_vector)
            }
            is EarthFragmentState.Success -> {
                val pictureOfTheDayResponseData = state.pictureOfTheDayResponseData
                val url = pictureOfTheDayResponseData.url
                binding.imageView1.load(url) {
                    lifecycle(this@EarthFragment)
                    error(R.drawable.ic_load_error_vector)
                    placeholder(R.drawable.ic_no_photo_vector)
                }
            }
        }
    }
}
