package com.tiketons.questapi_097.viewmodel

import android.annotation.SuppressLint
import android.net.http.HttpException
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import com.tiketons.questapi_097.modeldata.DataSiswa
import com.tiketons.questapi_097.repositori.RepositoryDataSiswa
import okhttp3.Response
import java.io.IOException


sealed interface StatusUIDetail {
    data class Success(val satusiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}
class DetailViewModel (savedStateHandle: SavedStateHandle, private val repositoryDataSiswa: RepositoryDataSiswa): ViewModel() {
    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])
    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private set

    init {
        getSatuSiswa()
    }

    fun getSatuSiswa(){
        viewModelScope.launch {
            statusUIDetail = StatusUIDetail.Loading
            statusUIDetail = try {
                StatusUIDetail.Success(satusiswa = repositoryDataSiswa.getSatuSiswa(idSiswa))
            }
            catch (e: IOException){
                StatusUIDetail.Error
            }
            catch (e: HttpException){
                StatusUIDetail.Error
            }
        }
    }

    @SuppressLint("SuspiciousIndentation")
    suspend fun hapusSatuSiswa(){
        val resp: Response<Void> = repositoryDataSiswa.hapusSatuSiswa(idSiswa)

        if(resp.isSuccessful){
            println("Sukses Hapus Data : ${resp.message()}")
        }else{
            println("Gagal Hapus Data : ${resp.errorBody()}")
        }
    }
}