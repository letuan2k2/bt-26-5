package com.example.sairamkrishna.bttrenlop26_5

import Student.SinhVien
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddStudentActivity : AppCompatActivity() {
    private lateinit var edtMaSV: EditText
    private lateinit var edtHoTen: EditText
    private lateinit var edtTuoi: EditText
    private lateinit var btnLuu: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edtMaSV = findViewById(R.id.edtMaSV)
        edtHoTen = findViewById(R.id.edtHoTen)
        edtTuoi = findViewById(R.id.edtTuoi)
        btnLuu = findViewById(R.id.btnLuu)

        btnLuu.setOnClickListener {
            val maSV = edtMaSV.text.toString()
            val hoTen = edtHoTen.text.toString()
            val tuoi = edtTuoi.text.toString().toIntOrNull() ?: 0

            val sinhVien = SinhVien(maSV, hoTen, tuoi)
            val intent = Intent().apply {
                putExtra("sinhvien", sinhVien)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
    }