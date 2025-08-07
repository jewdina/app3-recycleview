package com.smkth.app3_recycleview
import com.smkth.app3_recycleview.model.Student
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smkth.app3_recycleview.adapter.StudentAdapter
import com.smkth.app3_recycleview.utils.DummyData
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog



class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var studentAdapter: StudentAdapter
    private val studentList = mutableListOf<Student>() // <-- Ubah jadi mutable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        studentList.addAll(DummyData.getStudentList()) // <-- Inisialisasi data
        studentAdapter = StudentAdapter(this, studentList)
        recyclerView.adapter = studentAdapter

        // Tombol Tambah
        findViewById<Button>(R.id.btnTambah).setOnClickListener {
            showAddStudentDialog()
        }
    }

    private fun showAddStudentDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_tambah_siswa, null)
        val etNama = dialogView.findViewById<EditText>(R.id.etNama)
        val etNis = dialogView.findViewById<EditText>(R.id.etNis)
        val etKelas = dialogView.findViewById<EditText>(R.id.etKelas)

        AlertDialog.Builder(this)
            .setTitle("Tambah Siswa")
            .setView(dialogView)
            .setPositiveButton("Tambah") { _, _ ->
                val nama = etNama.text.toString()
                val nis = etNis.text.toString()
                val kelas = etKelas.text.toString()

                if (nama.isNotEmpty() && nis.isNotEmpty() && kelas.isNotEmpty()) {
                    val newStudent = Student(nama, nis, kelas)
                    studentList.add(newStudent)
                    studentAdapter.notifyItemInserted(studentList.size - 1)
                }
            }
            .setNegativeButton("Batal", null)
            .show()
    }
}


