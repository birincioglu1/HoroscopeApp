package com.example.horoscopeapp

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders
import com.example.horoscopeapp.databinding.FragmentDetailBinding
import com.example.horoscopeapp.utils.EventbusDataEvents
import com.example.horoscopeapp.viewmodel.DetailViewModel
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    lateinit var gelenDay:String
    lateinit var gelenAy:String
    lateinit var gelenYil:String
    lateinit var gelenSaat:String
    lateinit var gelenDk:String
    lateinit var gelenLat:String
    lateinit var gelenLon:String
    private lateinit var dataBinding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            //"25.67","82.11","5.5"
        viewModel=ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.refreshData(gelenDay,gelenAy,gelenYil,gelenSaat,gelenDk,gelenLat,gelenLon,"5.5")
        observeLiveData()
        dataBinding=DataBindingUtil.inflate(inflater ,R.layout.fragment_detail,container,false)
        dataBinding.imageView2.setOnClickListener {
            activity!!.onBackPressed()
        }
        return dataBinding.root
    }
    fun observeLiveData()
    {
        viewModel.horoscopeDetail.observe(viewLifecycleOwner, Observer { detail->
            detail?.let {
                dataBinding.horoscope=detail
                dataBinding.pbLoading.visibility=View.INVISIBLE
                dataBinding.linearLay.visibility=View.VISIBLE
            }
        })
        viewModel.detailError.observe(viewLifecycleOwner, Observer { error->
            error?.let {
                if (it)
                {
                    //detail error visibility visible
                }else{

                }
            }
        })
        viewModel.detailLoading.observe(viewLifecycleOwner, Observer { loading->
            loading?.let {
                if (it)
                {
                    dataBinding.pbLoading.visibility=View.VISIBLE
                    dataBinding.linearLay.visibility=View.INVISIBLE
                    //loading visibil  visible
                    //list invisible
                }else{
                    //loading invis
                    dataBinding.pbLoading.visibility=View.INVISIBLE
                    dataBinding.linearLay.visibility=View.VISIBLE
                }

            }
        })
    }

    @Subscribe(sticky = true)
    internal fun onSecilenFotoEvent(gelenPosition: EventbusDataEvents.sendInfo){

        gelenDay=gelenPosition.day!!
        gelenAy=gelenPosition.mon!!
        gelenYil=gelenPosition.year!!
        gelenSaat=gelenPosition.hour!!
        gelenDk=gelenPosition.min!!
        gelenLat=gelenPosition.aLat!!
        gelenLon=gelenPosition.aLon!!
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        EventBus.getDefault().register(this)
    }

    override fun onDetach() {
        super.onDetach()
        EventBus.getDefault().unregister(this)
    }


}
