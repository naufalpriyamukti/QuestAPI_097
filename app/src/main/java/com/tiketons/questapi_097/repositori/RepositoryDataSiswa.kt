package com.tiketons.questapi_097.repositori

import com.tiketons.questapi_097.apiservice.ServiceApiSiswa
import com.tiketons.questapi_097.modeldata.DataSiswa

interface RepositoryDataSiswa{
    suspend fun getDataSiswa(): List<DataSiswa>

    suspend fun postDataSiswa(dataSiswa: DataSiswa) :retrofit2.Response<Void>

    suspend fun getSatuSiswa(id:Int) : DataSiswa

}

class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
):RepositoryDataSiswa{
    override suspend fun getDataSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()
    override suspend fun postDataSiswa(dataSiswa: DataSiswa): retrofit2.Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
}
