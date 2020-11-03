package com.example.horoscopeapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.horoscopeapp.utils.EventbusDataEvents
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import java.util.*

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{
    var aYear:String?=null
    var aMonth:String?=null
    var aDay:String?=null
    var aHour:String?=null
    var aMin:String?=null
    var aLat:String?=null
    var aLon:String?=null
    var perPlace:Boolean=false
    var perDate:Boolean=false
    var perTime:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            toDetail()
        }

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        btnDate.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    //SetTextView
                    aYear=mYear.toString()
                    aMonth=mMonth.toString()
                    aDay=mDay.toString()
                    perDate=true
                    btnDate.setText(aDay+ "/"+ aMonth+"/"+aYear)

                },
                year,
                month,
                day
            )
            dpd.show()

        }



    var spinnerAdaper=ArrayAdapter.createFromResource(this,R.array.sehirler,R.layout.single_line_spinner)
      spinnerAdaper.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
      spnSehirler.setTitle("Sehir Seçiniz")
      spnSehirler.setPositiveButton("İptal")
      spnSehirler.setOnItemSelectedListener(this)
      spnSehirler.adapter=spinnerAdaper





        btnTime.setOnClickListener{

            val tpd = TimePickerDialog(this,
                object:TimePickerDialog.OnTimeSetListener {
                    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                        var time=hourOfDay.toString()+":"+minute.toString()
                        perTime=true
                        aMin=minute.toString()
                        aHour=hourOfDay.toString()
                        btnTime.text=time
                    }


                }, hour, minute, true)
            tpd.setButton(TimePickerDialog.BUTTON_POSITIVE, "Seç", tpd)
            tpd.setButton(TimePickerDialog.BUTTON_NEGATIVE, "İptal", tpd)
            tpd.show()
        }
      

    }
    fun toDetail()
    {
        if (perDate&&perTime&&perPlace)
        {
            rootLayout.visibility = View.GONE
            mainContainer.visibility=View.VISIBLE

            var transaction = supportFragmentManager.beginTransaction()//yerine getirme
            transaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left,R.anim.slide_in_left, R.anim.slide_out_right)
            EventBus.getDefault().postSticky(EventbusDataEvents.sendInfo(aDay,aMonth,aYear,aHour,aMin,aLat,aLon))
            transaction.replace(R.id.mainContainer, DetailFragment())
            transaction.addToBackStack("detailFragEklendi")
            transaction.commit()

        }else{
            Toast.makeText(this,"Eksik bilgi girdiniz",Toast.LENGTH_SHORT).show()
        }

    }



    override fun onBackPressed() {
        rootLayout.visibility=View.VISIBLE
        mainContainer.visibility=View.INVISIBLE
        super.onBackPressed()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (position==0)
        {
            perPlace=false
        }else{
            var dlat= getResources().getStringArray(R.array.lat)
            aLat=dlat[position].toString()
            var dlon=getResources().getStringArray(R.array.lon)
            aLon=dlon[position].toString()
            perPlace=true
        }

      

    }

}