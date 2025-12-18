package com.tiketons.questapi_097.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tiketons.questapi_097.viewmodel.EntryViewModel
import com.tiketons.questapi_097.viewmodel.HomeViewModel
import com.tiketons.questapi_097.repositori.AplikasiDataSiswa

fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa
        )
object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiDataSiswa().containerApp.repositoryDataSiswa)
        }
        initializer {
            EntryViewModel(aplikasiDataSiswa().containerApp.repositoryDataSiswa)
        }
    }
}