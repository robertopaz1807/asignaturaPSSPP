package com.miteris.monetizarconadmob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.miteris.monetizarconadmob.databinding.ActivityBannerBinding

class BannerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBannerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)

        binding = ActivityBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLoadAds()
    }

    private fun initLoadAds() {
        val adRequest = AdRequest.Builder().build()
        binding.banner.loadAd(adRequest)




        binding.banner.adListener = object : AdListener(){
            override fun onAdLoaded() {
            }
            override fun onAdFailedToLoad(adError : LoadAdError) {
            }
            override fun onAdOpened() {
            }
            override fun onAdClicked() {
            }
            override fun onAdClosed() {
            }
        }
    }
}