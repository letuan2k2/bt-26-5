package com.example.sairamkrishna.bttrenlop26_5

import Student.SinhVien
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var btnThem: Button
    private lateinit var danhSach: ArrayList<SinhVien>
    private lateinit var adapter: ArrayAdapter<String>

    private val REQUEST_ADD = 1
    private val REQUEST_UPDATE = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView = findViewById(R.id.listView)
        btnThem = findViewById(R.id.btnThem)

        danhSach = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, danhSach.map { it.hoTen; it.tuoi ; it.maSV  })
        listView.adapter = adapter

        btnThem.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivityForResult(intent, REQUEST_ADD)
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("sinhvien", danhSach[position])
            intent.putExtra("position", position)
            startActivityForResult(intent, REQUEST_UPDATE)
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && data != null) {
            val sv = data.getSerializableExtra("sinhvien") as SinhVien

            when (requestCode) {
                REQUEST_ADD -> {
                    danhSach.add(sv)
                }

                REQUEST_UPDATE -> {
                    val pos = data.getIntExtra("position", -1)
                    if (pos != -1) danhSach[pos] = sv
                }
            }

            adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, danhSach.map { it.hoTen })
            listView.adapter = adapter
        }
    }
    }