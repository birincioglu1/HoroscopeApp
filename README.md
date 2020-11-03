# HoroscopeApp
https://api.vedicrishiastro.com/ üzerinden burc detay bilgileri alınarak uygulamaya eklendi.<br/>
Kullanıcının doğum tarihi,doğum saati ve doğum yeri bilgisi alınarak, burcuyla ilgili bilgi kullanıcıya sunulmaktadır.<br/>

## Kullanılan Kütüphaneler
`implementation 'com.squareup.retrofit2:converter-gson:2.3.0'`<br/>
`implementation 'com.squareup.retrofit2:retrofit:2.3.0'`<br/>
`implementation 'android.arch.lifecycle:extensions:1.1.1'`<br/>
`implementation "io.reactivex.rxjava2:rxjava:2.2.6"`<br/>
`implementation 'android.arch.lifecycle:extensions:1.1.1'`<br/>
`implementation 'org.greenrobot:eventbus:3.1.1'`<br/>
`implementation 'net.alhazmy13.hijridatepicker:library:2.0.2'`<br/>
`implementation 'com.github.delight-im:Android-SimpleLocation:v1.0.1'`<br/>
`implementation 'com.github.glomadrian:Grav:1.1`<br/>
`implementation 'com.toptoche.searchablespinner:searchablespinnerlibrary:1.3.1`<br/>


## Kullanılan Mimari 

"MVVM"<br/>

## Uygulama İçeriği

- API client olarak Retrofit ile yapıldı.<br/>
- LiveData/ ViewModel , Single, RxJava gibi tool'lar kullanıldı.<br/>
- Eventbus ile fragmentler arası bilgi aktarıldı.<br/>
- Fragmentler arası geçişlerde animasyon kullanıldı.<br/>
- Custom font ve Splash ekranı eklendi eklendi.<br/>

## Uygulama Görselleri
> Splash Ekranı<br/><br/>
<img src="https://github.com/birincioglu1/HoroscopeApp/blob/master/app/src/main/res/drawable-v24/screen_splash.PNG" width="400" height="700"><br/><br/>
> Ana Ekran<br/><br/>
<img src="https://github.com/birincioglu1/HoroscopeApp/blob/master/app/src/main/res/drawable-v24/screen_main.PNG" width="400" height="700"><br/><br/>
> Burc Detay Ekranı <br/><br/>
<img src="https://github.com/birincioglu1/HoroscopeApp/blob/master/app/src/main/res/drawable-v24/screen_detail.PNG" width="400" height="700">

