package com.example.mobpro2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.mobpro2.database.MahasiswaDao
import com.example.assesment2.model.Mahasiswa

class DetailViewModel(private val dao: MahasiswaDao) : ViewModel() {

    fun insert(nama: String, nim: String, kelas: String) {
        val mahasiswa = Mahasiswa(
            nama = nama,
            nim = nim,
            kelas = kelas
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(mahasiswa)
        }
    }

    suspend fun getMahasiswa(id: Long): Mahasiswa? {
        return dao.getMahasiswaById(id)
    }

    fun update(id: Long, nama: String, nim: String, kelas: String) {
        val mahasiswa = Mahasiswa(
            id = id,
            nama = nama,
            nim   = nim,
            kelas = kelas
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.update(mahasiswa)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}