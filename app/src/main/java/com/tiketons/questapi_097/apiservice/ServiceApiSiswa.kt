package com.example.questapi_097.apiservice
interface ServiceApiSiswa{
    @GET("bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertTM.php")
    suspend fun  postSiswa(@Body dataSiswa: DataSiswa):retrofit2.Response<Void>
}