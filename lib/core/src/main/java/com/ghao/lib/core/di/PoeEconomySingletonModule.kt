package com.ghao.lib.core.di

import android.util.Log
import com.ghao.lib.core.TestConfig
import com.ghao.lib.core.network.PoeApiService
import com.ghao.lib.core.network.PoeNinjaService
import com.ghao.lib.core.repository.PoeEconomyRepository
import com.ghao.lib.core.repository.PoeEconomyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface PoeEconomySingletonModule {
    @Singleton
    @Binds
    fun bindRepository(impl: PoeEconomyRepositoryImpl): PoeEconomyRepository

    companion object {
        @Singleton
        @Provides
        fun okHttpClient(): OkHttpClient {
            if (TestConfig.isTest) {
                return OkHttpClient.Builder().build()
            }
            return OkHttpClient.Builder()
                // .addNetworkInterceptor(FlipperOkhttpInterceptor(NetworkFlipperPlugin()))
                .addNetworkInterceptor {
                    val request = it.request()
                    Log.e("HGQQQ", request.url.toUrl().toString())
                    it.proceed(request)
                }
                .build()
        }

        @Singleton
        @Provides
        @Named("PoeNinjaRetrofit")
        fun poeNinjaRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(PoeNinjaService.POE_NINJA_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }

        @Singleton
        @Provides
        fun poeNinjaService(@Named("PoeNinjaRetrofit") retrofit: Retrofit): PoeNinjaService {
            return retrofit.create(PoeNinjaService::class.java)
        }

        @Singleton
        @Provides
        @Named("PoeRetrofit")
        fun poeRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(PoeApiService.POE_API_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }

        @Singleton
        @Provides
        fun poeApiService(@Named("PoeRetrofit") poeRetrofit: Retrofit): PoeApiService {
            return poeRetrofit.create(PoeApiService::class.java)
        }
    }
}
