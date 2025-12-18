package com.example.questapi_97.repositori

import android.app.Application
import com.example.questapi_097.apiservice.ServiceApiSiswa
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import kotlin.getValue

interface ContainerApp{
    val repositoryDataSiswa: RepositoryDataSiswa
}

class DefaultContainerApp : ContainerApp{

    private val baseurl = "http://10.0.1.3/tiumy/"

    val logging = HttpLoggingInterceptor().apply {
        level= HttpLoggingInterceptor.Level.BODY

    }

}