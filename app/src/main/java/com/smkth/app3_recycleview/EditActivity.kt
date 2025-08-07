package com.smkth.app3_recycleview

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {

    private lateinit var etNama: EditText
    private lateinit var etNis: EditText
    private lateinit var etKelas: EditText
    private lateinit var btnSimpan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        etNama = findViewById(R.id.etNama)
        etNis = findViewById(R.id.etNis)
        etKelas = findViewById(R.id.etKelas)
        btnSimpan = findViewById(R.id.btnSimpan)

        // Ambil data dari intent
        val position = intent.getIntExtra("position", -1)
        val nama = intent.getStringExtra("student_nama")
        val nis = intent.getStringExtra("student_nis")
        val kelas = intent.getStringExtra("student_kelas")

        // Tampilkan di EditText
        etNama.setText(nama)
        etNis.setText(nis)
        etKelas.setText(kelas)

        // Tombol Simpan
        btnSimpan.setOnClickListener {
            val editedNama = etNama.text.toString()
            val editedNis = etNis.text.toString()
            val editedKelas = etKelas.text.toString()

            val resultIntent = intent
            resultIntent.putExtra("position", position)
            resultIntent.putExtra("student_nama", editedNama)
            resultIntent.putExtra("student_nis", editedNis)
            resultIntent.putExtra("student_kelas", editedKelas)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}