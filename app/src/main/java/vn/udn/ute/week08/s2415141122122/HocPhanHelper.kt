package vn.udn.ute.week08.s2415141122122

import java.util.Locale

object HocPhanHelper {
    fun loiTen (raw: String ): String? {
        val ten= raw.trim()
        return if (ten.isEmpty() || ten.length > 40 ) "Ten phai tu den 40 ki tu" else null
    }

    fun layDiem(raw: String ): Double?{
        val d = raw.trim().toDoubleOrNull() ?: return null
        return if (d.isFinite() && d in 0.0..10.0) d else null
    }

    fun tinhT(qt: Double,ck: Double):Double = 0.4 * qt + 0.6 * ck

    fun phanLoai(t: Double, ck: Double): String {
        return if (t>=5.0 && ck>=3.0) "Dat" else "Chua Dat"
    }

    fun f(so: Double): String = String.format(Locale.US, "%.2f", so)
}