package com.example.sairamkrishna.bttrenlop26_5

import Student.SinhVien
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class EditStudentActivity : AppCompatActivity() {
    private lateinit var edtMaSV: EditText
    private lateinit var edtHoTen: EditText
    private lateinit var edtTuoi: EditText
    private lateinit var btnCapNhat: Button

    private var position: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edtMaSV = findViewById(R.id.edtMaSV)
        edtHoTen = findViewById(R.id.edtHoTen)
        edtTuoi = findViewById(R.id.edtTuoi)
        btnCapNhat = findViewById(R.id.btnCapNhat)

        val sv = intent.getSerializableExtra("sinhvien") as? SinhVien
        position = intent.getIntExtra("position", -1)

        sv?.let {
            edtMaSV.setText(it.maSV)
            edtHoTen.setText(it.hoTen)
            edtTuoi.setText(it.tuoi.toString())
        }

        btnCapNhat.setOnClickListener {
            val maSV = edtMaSV.text.toString()
            val hoTen = edtHoTen.text.toString()
            val tuoi = edtTuoi.text.toString().toIntOrNull() ?: 0

            val sinhVien = SinhVien(maSV, hoTen, tuoi)
            val resultIntent = Intent().apply {
                putExtra("sinhvien", sinhVien)
                putExtra("position", position)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
    }


