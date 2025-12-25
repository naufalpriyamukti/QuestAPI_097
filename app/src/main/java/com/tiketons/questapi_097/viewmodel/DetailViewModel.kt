package com.tiketons.questapi_097.viewmodel


sealed interface StatusUIDetail {
    data class Success(val satusiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}
class DetailViewModel {
}