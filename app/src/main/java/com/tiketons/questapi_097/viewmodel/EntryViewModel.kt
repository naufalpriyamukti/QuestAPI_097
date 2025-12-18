package com.tiketons.questapi_097.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.questapi_097.repositori.RepositoryDataSiswa
import com.tiketons.questapi_097.modeldata.DetailSiswa
import com.tiketons.questapi_097.modeldata.UIStateSiswa
import com.tiketons.questapi_097.modeldata.toDataSiswa
import retrofit2.Response

class EntryViewModel (private val repositoryDataSiswa: RepositoryDataSiswa) : ViewModel(){
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa){
        uiStateSiswa = UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    suspend fun addSiswa(){
        if (validasiInput()){
            val sip: Response<Void> = repositoryDataSiswa.postDataSiswa(uiStateSiswa.detailSiswa.toDataSiswa())
            if (sip.isSuccessful){
                println("Sukses Tambah Data : ${sip.message()}")
            }else {
                println("Gagal Tambah Data : ${sip.message()}")
            }
        }
    }
}