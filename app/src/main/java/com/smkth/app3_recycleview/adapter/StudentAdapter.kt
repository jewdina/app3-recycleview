package com.smkth.app3_recycleview.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.app.Activity
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.smkth.app3_recycleview.DetailActivity
import com.smkth.app3_recycleview.R
import com.smkth.app3_recycleview.model.Student
import com.smkth.app3_recycleview.EditActivity


class StudentAdapter(
    private val activity: Activity,
    private val studentList: MutableList<Student>
) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvNama)
        val tvNis: TextView = itemView.findViewById(R.id.tvNis)
        val tvKelas: TextView = itemView.findViewById(R.id.tvKelas)
        val btnDelete: View = itemView.findViewById(R.id.btnDelete)
        val btnEdit: View = itemView.findViewById(R.id.btnEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = studentList.size

//    @Suppress("DEPRECATION")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = studentList[position]
        holder.tvName.text = student.nama
        holder.tvNis.text = "NIS: ${student.nis}"
        holder.tvKelas.text = "Kelas: ${student.kelas}"

        holder.itemView.setOnClickListener {
            Toast.makeText(activity, "Memilih ${student.nama}", Toast.LENGTH_SHORT).show()

            AlertDialog.Builder(activity)
                .setTitle("Lihat Detail?")
                .setMessage("Ingin melihat detail dari ${student.nama}?")
                .setPositiveButton("Lihat") { _, _ ->
                    val intent = Intent(activity, EditActivity::class.java)
                    intent.putExtra("student_nama", student.nama)
                    intent.putExtra("student_nis", student.nis)
                    intent.putExtra("student_kelas", student.kelas)
                    activity.startActivityForResult(intent, 100)
                }
                .setNegativeButton("Batal", null)
                .show()
        }

        holder.btnEdit.setOnClickListener {
            val intent = Intent(activity, EditActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("student_nama", student.nama)
            intent.putExtra("student_nis", student.nis)
            intent.putExtra("student_kelas", student.kelas)
            @Suppress("DEPRECATION")
            activity.startActivityForResult(intent, 100)
        }

        holder.btnDelete.setOnClickListener {
            AlertDialog.Builder(activity)
                .setTitle("Hapus Siswa")
                .setMessage("Yakin ingin menghapus ${student.nama}?")
                .setPositiveButton("Ya") { _, _ ->
                    studentList.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, studentList.size)
                    Toast.makeText(activity, "${student.nama} dihapus", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Batal", null)
                .show()
        }
    }
}