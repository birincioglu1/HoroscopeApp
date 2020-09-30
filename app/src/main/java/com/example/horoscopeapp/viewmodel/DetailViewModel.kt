package com.example.horoscopeapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.horoscopeapp.model.Horoscope

import com.example.horoscopeapp.service.HoroscopeAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class DetailViewModel:ViewModel() {
    private val horoscopeAPIService=HoroscopeAPIService()
    private val disposable=CompositeDisposable()


    val horoscopeDetail=MutableLiveData<Horoscope>()
    val detailError=MutableLiveData<Boolean>()
    val detailLoading=MutableLiveData<Boolean>()

    fun refreshData(day: String, month: String,year: String,hour: String,min: String,lat: String,lon: String,tzone:String)
    {
        detailLoading.value=true
        disposable.add(
            horoscopeAPIService.getDetail(day,month,year,hour,min,lat,lon,tzone)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<Horoscope>(){
                    override fun onSuccess(t: Horoscope) {
                        horoscopeDetail.value=t
                        detailError.value=false
                        detailLoading.value=false
                    }

                    override fun onError(et: Throwable) {
                        detailError.value=true
                        detailLoading.value=false
                       Log.e("HATA",""+et.message)

                    }
                })
        )




    }

}