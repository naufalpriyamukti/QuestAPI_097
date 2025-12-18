package com.example.questapi_097.repositori

interface RepositoryDataSiswa{
    suspend fun getDataSiswa(): List<DataSiswa>
}
