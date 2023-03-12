package com.miteris.monetizarconadmob

import android.app.Application
import com.google.android.gms.ads.MobileAds

class MonitizarConAdmobApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
    }

}