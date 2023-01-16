package com.ghao.lib.core.network

import android.util.Log
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object Singletons {

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addNetworkInterceptor(FlipperOkhttpInterceptor(NetworkFlipperPlugin()))
            .addNetworkInterceptor(StethoInterceptor())
            .addNetworkInterceptor {
                val request = it.request()
                Log.e("HGQQQ", request.url.toUrl().toString())
                it.proceed(request)
            }
            .build()
    }

    private val poeNinjaRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(PoeNinjaService.POE_NINJA_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    val poeNinjaService: PoeNinjaService by lazy {
        poeNinjaRetrofit.create(PoeNinjaService::class.java)
    }

    private val poeRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(PoeApiService.POE_API_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    val poeApiService: PoeApiService by lazy {
        poeRetrofit.create(PoeApiService::class.java)
    }
}