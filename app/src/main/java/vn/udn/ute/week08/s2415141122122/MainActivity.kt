package vn.udn.ute.week08.s2415141122122

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import vn.udn.ute.week08.s2415141122122.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(R.layout.activity_main)

        binding.btnKiemTra.setOnClickListener{
            xuLyKiemTra()
        }

        binding.btnXoa.setOnClickListener {
            xuLyXoa()
        }
    }

    private fun xuLyKiemTra(){
        val tenRaw = binding.edtTen.text.toString()
        val qtRaw = binding.edtQt.text.toString()
        val ckRaw = binding.edtCk.text.toString()

        val loiTen = HocPhanHelper.loiTen(tenRaw)
        val qt = HocPhanHelper.layDiem(qtRaw)
        val ck = HocPhanHelper.layDiem(ckRaw)

        binding.tilTen.error = loiTen
        binding.tilQt.error = if (qt == null ) "Diem qt tu 0.0 den 10.0" else null
        binding.tilCk.error = if ( ck == null) "Diem ck tu 0.0 den 10.0" else null

        if (loiTen != null || qt == null || ck == null){
            binding.cardKetQua.visibility = View.GONE
            return
        }

        val t = HocPhanHelper.tinhT(qt, ck)
        val ketLuan = HocPhanHelper.phanLoai(t, ck)

        binding.tvKetQua.text = """
            Hoc phan : ${tenRaw.trim()}
            QT: ${HocPhanHelper.f(qt)} | CK: ${HocPhanHelper.f(ck)}
            Diem tong ket (T) : ${HocPhanHelper.f(t)}
            Ket luan : $ketLuan
        """.trimIndent()

        binding.cardKetQua.visibility = View.VISIBLE
    }
    private fun xuLyXoa(){

        binding.edtTen.text?.clear()
        binding.edtQt.text?.clear()
        binding.edtCk.text?.clear()

        binding.tilTen.error = null
        binding.tilQt.error = null
        binding.tilCk.error = null

        binding.cardKetQua.visibility = View.GONE

        binding.edtTen.requestFocus()
    }
}