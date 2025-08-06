package edu.unikom.formfgd.model

data class AttendanceModel(
    val nama: String,
    val telepon: String,
    val email: String,
    val gender: String,
    val skillset: List<String> = emptyList(),
    val kategori: String
)
