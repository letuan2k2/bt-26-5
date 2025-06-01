package Student

import java.io.Serializable


data class SinhVien(
    var maSV: String,
    var hoTen: String,
    var tuoi: Int
) : Serializable