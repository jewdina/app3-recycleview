# Project Kelompok RecyclerView

ini adalah proyek aplikasi Android yang dikerjakan secara berkelompok dengan menggunakan komponen RecycleView untuk menampilkan data secara dinamis dalam bentuk daftar atau grid.

## 📱 Penjelasan Fitur
### A. Fitur Tambah Data
Fitur ini memungkinkan pengguna untuk menambahkan data siswa baru ke dalam daftar. Ketika tombol “Tambah Siswa” ditekan, pengguna akan diarahkan ke halaman input data. Setelah pengguna mengisi data seperti nama, kelas, dan alamat, lalu menekan tombol simpan, data tersebut akan disimpan dan langsung ditampilkan di daftar RecycleView.
#### Alur Fungsinya:
1. Ketika tombol tambah diklik di halaman utama (MainActivity), pengguna diarahkan ke halaman form (AddEditActivity).
2. Di form ini, pengguna mengisi data siswa (nama, kelas, alamat).
3. Saat tombol simpan ditekan, data siswa dikirim balik ke MainActivity dan ditambahkan ke daftar (melalui StudentAdapter).
4. Setelah itu, daftar siswa langsung diperbarui dan tampilannya di-refresh.
#### Komponen yang Terlibat:
- MainActivity → tombol tambah.
- AddEditActivity → form input.
- StudentAdapter → menambahkan item baru ke list.
- StudentDB → menyimpan data siswa dalam ArrayList.

### B. Fitur Edit Data
Fitur ini berfungsi untuk mengubah atau memperbarui data siswa yang sudah ada. Ketika salah satu item daftar ditekan, pengguna akan diarahkan ke halaman edit. Di halaman tersebut, pengguna bisa melihat data yang sudah ada dan mengubahnya sesuai kebutuhan. Setelah data diperbarui dan disimpan, tampilan RecycleView akan langsung menampilkan data yang telah diperbarui.
#### Alur Fungsinya:
1. Setiap item siswa di dalam list memiliki tombol edit.
2. Saat tombol edit ditekan, data siswa yang ingin diedit dikirim ke halaman form (AddEditActivity) dan ditampilkan di field input.
3. Setelah pengguna mengubah data dan menekan simpan, data diperbarui di daftar.
4. Tampilan langsung di-refresh dengan data baru yang diedit.
#### Komponen yang Terlibat:
- StudentAdapter → tombol edit dan pemanggilan halaman form.
- AddEditActivity → menerima dan mengubah data yang sudah ada.
- MainActivity → menerima hasil edit dan memperbarui daftar.
- StudentDB → menyimpan data hasil edit.

### C. Fitur Hapus Data
Fitur ini digunakan untuk menghapus data siswa dari daftar. Di setiap item pada RecycleView terdapat tombol hapus. Ketika tombol tersebut ditekan, data siswa tersebut akan langsung dihapus dari daftar, dan RecycleView akan otomatis menyesuaikan tampilan dengan menghilangkan data yang dihapus.
#### Alur Fungsinya:
1. Setiap item siswa memiliki tombol hapus.
2. Saat tombol hapus diklik, data siswa langsung dihapus dari daftar.
3. Adapter diberi tahu bahwa data berubah, sehingga tampilan RecycleView langsung diperbarui.
#### Komponen yang Terlibat:
- StudentAdapter → tombol hapus dan logika penghapusan data.
- StudentDB → data dihapus dari ArrayList.
- RecycleView → di-notify agar tampilannya diperbarui.

## 🤖 Penjelasan Cara Kerja RecycleView 
RecycleView adalah komponen Android yang digunakan untuk menampilkan data dalam bentuk daftar atau grid secara efisien. Komponen ini bekerja dengan cara mendaur ulang tampilan item yang sudah tidak terlihat untuk digunakan kembali, sehingga tidak perlu membuat tampilan baru setiap kali data discroll. Dibandingkan ListView, RecycleView lebih fleksibel dan hemat memori karena memakai sistem ViewHolder dan hanya membuat tampilan yang benar-benar diperlukan.
### Alur Cara Kerja RecycleView:
1. Menyiapkan Data => Data yang akan ditampilkan disimpan dalam bentuk List atau ArrayList.
2. Membuat Layout Item => File XML dibuat untuk mendesain tampilan satu item dalam daftar (misalnya: gambar dan teks).
3. Membuat ViewHolder => ViewHolder menyimpan referensi tampilan agar lebih efisien dan mempercepat proses scrolling.
4. Membuat Adapter => Adapter menghubungkan data ke tampilan item, membuat item baru, dan menentukan jumlah data yang ditampilkan.
5. Mengatur RecyclerView di Activity/Fragment => RecycleView dikonfigurasi dengan LayoutManager dan dihubungkan dengan adapter untuk menampilkan data ke layar.
### RecycleView terdiri dari tiga komponen utama, yaitu:
1.  LayoutManager : Mengatur tata letak item, bisa berupa daftar vertikal, horizontal, atau grid.
2.  Adapter : Berfungsi sebagai penghubung antara data dan tampilan item. Adapter membuat item baru (ViewHolder), mengisi data ke dalamnya, dan menentukan jumlah data yang akan ditampilkan.
3.  ViewHolder : Menyimpan referensi tampilan item agar proses pengambilan view lebih efisien dan tidak berulang.
Saat aplikasi dijalankan, RecycleView hanya akan membuat sejumlah tampilan item yang cukup untuk mengisi layar. Saat pengguna menggulir (scroll), tampilan item yang sudah tidak terlihat akan digunakan ulang untuk menampilkan data baru.

## 📂 Penjelasan Struktur File dan Alur Data
### 💡 STRUKTUR FILE & FUNGSI UTAMA
#### 📁 manifests/AndroidManifest.xml
•	Tempat mendefinisikan semua komponen aplikasi.
•	Berisi deklarasi MainActivity, EditActivity, dan DetailActivity sebagai halaman-halaman utama.
#### 📁 kotlin+java/com.smkth.app3_recycleview
📄 MainActivity.kt
•	Activity utama yang menampilkan daftar siswa dalam RecycleView.
•	Inisialisasi data dari DummyData.
•	Menangani aksi tambah siswa lewat dialog dan update data dari EditActivity.
📄 EditActivity.kt
•	Untuk mengedit data siswa yang dipilih.
•	Setelah diedit, hasilnya dikirim balik ke MainActivity.
📄 DetailActivity.kt
•	Untuk menampilkan detail data siswa (tidak digunakan untuk edit).
•	Mengambil data dari Intent dan menampilkannya ke tampilan.
#### 📁 adapter/StudentAdapter.kt
•	Adapter untuk menampilkan list siswa di RecycleView.
•	Menangani aksi klik item (lihat detail), edit, dan hapus
#### 📁 model/Student.kt
•	Model data siswa (data class) dengan 3 properti: nama, nis, kelas.
#### 📁 utils/DummyData.kt
•	Menyediakan data dummy (daftar siswa) saat pertama kali aplikasi dibuka.
#### 🎨 LAYOUT FILES (res/layout)
📄 activity_main.xml
•	Layout untuk MainActivity berisi RecycleView dan tombol Tambah.
📄 activity_edit.xml
•	Layout untuk EditActivity berisi 3 input EditText dan tombol Simpan.
📄 activity_detail.xml
•	Layout untuk menampilkan biodata siswa dalam DetailActivity.
📄 dialog_tambah_siswa.xml
•	Digunakan sebagai form dialog untuk menambah siswa baru.
📄 item_student.xml
•	Layout setiap item siswa dalam RecycleView, menampilkan nama, NIS, kelas, dan tombol Edit dan Hapus.

### 🔁 ALUR DATA APLIKASI
1.	Data Awal Ditampilkan
• Di MainActivity, data siswa diambil dari DummyData → ditampilkan pakai StudentAdapter ke RecycleView.
2.	Menambah Data
•	User klik tombol Tambah.
•	Muncul dialog (dialog_tambah_siswa.xml) → user isi data → klik Tambah → data baru ditambahkan ke studentList → adapter diberi tahu (notifyItemInserted()).
3.	Mengedit Data
•	User klik tombol Edit pada item → buka EditActivity bawa data siswa.
•	Setelah diubah, hasilnya dikembalikan ke MainActivity melalui onActivityResult().
•	Data di list diganti lalu adapter diberi tahu (notifyItemChanged()).
4.	Menghapus Data
•	User klik tombol Hapus pada item.
•	Muncul dialog konfirmasi → jika setuju, data dihapus dari list dan adapter diberi tahu (notifyItemRemoved() & notifyItemRangeChanged()).
5.	Melihat Detail
•	Klik item siswa → muncul dialog konfirmasi → jika pilih "Lihat", buka DetailActivity bawa data → data ditampilkan di sana.

### 🧭 URUTAN AKSES FILE (Alur dari pengguna)
<img width="798" height="270" alt="image" src="https://github.com/user-attachments/assets/27729dda-e00a-4539-a883-d46ec0c702b5" />

## 🧩 Penjelasan Code
### 📄 MainActivity.kt
#### Bagian penting:
1. recyclerView.adapter = studentAdapter → Menampilkan daftar siswa dengan adapter yang sudah dibuat.
2. btnAdd.setOnClickListener { ... } → Aksi tombol tambah siswa, membuka AddEditActivity.
3. startActivityForResult(...) dan onActivityResult(...) → Menerima data baru/yang diedit dari AddEditActivity dan memperbarui daftar.
#### Penjelasan umum:
- Menampilkan list data siswa menggunakan RecyclerView.
- Data siswa berasal dari class StudentDB.
- Tombol tambah (FloatingActionButton) digunakan untuk memulai AddEditActivity.
- Saat kembali dari AddEditActivity, data baru akan ditambahkan atau data lama akan diperbarui, lalu adapter akan di-notify supaya tampilannya di-refresh.

### 📄 AddEditActivity.kt
#### Bagian penting:
1. val student = intent.getSerializableExtra(...) → Mendeteksi apakah aktivitas ini untuk edit atau tambah siswa.
2. btnSave.setOnClickListener { ... } → Mengambil data dari input lalu mengirim balik ke MainActivity (untuk tambah atau edit).
3. val resultIntent = Intent() dan setResult(...) → Mengirim data hasil input balik ke MainActivity.
#### Penjelasan umum:
- Form input data siswa: nama, kelas, alamat.
- Jika menerima data lama dari MainActivity, artinya mode edit, maka form akan terisi otomatis.
- Jika tidak ada data lama, artinya mode tambah.
- Setelah tombol simpan diklik, data dikirim balik ke MainActivity menggunakan Intent.

### 📄 StudentAdapter.kt
#### Bagian penting:
1. fun onBindViewHolder(...) → Menampilkan data siswa ke tampilan tiap item di RecycleView.
2. holder.btnDelete.setOnClickListener { ... } → Menghapus data dari daftar ketika tombol hapus ditekan.
3. holder.btnEdit.setOnClickListener { ... } → Mengirim data ke AddEditActivity untuk diedit.
4. notifyDataSetChanged() → Menyegarkan tampilan RecycleView setelah ada perubahan data.
#### Penjelasan umum:
- Menampilkan data siswa di setiap item RecyclerView.
- Di dalam item ada tombol edit dan hapus.
  • Edit: membuka AddEditActivity dengan membawa data lama untuk diedit.
  • Hapus: menghapus item dari list dan memberi tahu adapter agar tampilan diperbarui.
- Adapter menggunakan interface StudentClickInterface dan StudentClickDeleteInterface untuk menangani aksi tombol.

### 📄 StudentDB.kt
#### Bagian penting:
1. val studentList = mutableListOf<Student>() → Penyimpanan data siswa sementara (pakai ArrayList).
2. Fungsi seperti addStudent(...), updateStudent(...), dan deleteStudent(...) → Menangani logika penambahan, pengeditan, dan penghapusan siswa dari list.
#### Penjelasan umum:
- Penyimpanan data sementara pakai ArrayList.
- Memiliki fungsi: getAllStudents(), addStudent(), updateStudent(), deleteStudent().
- Digunakan oleh MainActivity untuk mengelola data siswa.

### 📄 Layout
#### Bagian penting:
1. activity_main.xml: berisi RecyclerView dan tombol tambah siswa.
2. student_item.xml: berisi tampilan satu siswa (nama, kelas, alamat, tombol edit & hapus).
3. activity_add_edit.xml: berisi form input nama, kelas, alamat, dan tombol simpan.
#### Penjelasan umum:
1. activity_main.xml : layout utama aplikasi.
Komponen utamanya:
- RecyclerView: untuk menampilkan daftar siswa dalam bentuk list.
- FloatingActionButton: tombol plus (➕) untuk menambah siswa baru. Letaknya biasanya di pojok kanan bawah.
2. activity_add_edit.xml : menambah atau mengedit data siswa.
Komponennya:
- Tiga buah EditText: input nama, kelas, dan alamat.
- Satu buah Button: tombol simpan, yang akan menyimpan data dan kembali ke MainActivity
3. student_item.xml : Layout satu item dalam daftar siswa di RecyclerView.
Komponennya:
- TextView: menampilkan nama, kelas, dan alamat siswa.
- Dua buah ImageView atau Button: satu untuk edit dan satu untuk hapus data.


