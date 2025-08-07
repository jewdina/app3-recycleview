# Project Kelompok RecyclerView

ini adalah proyek aplikasi Android yang dikerjakan secara berkelompok dengan menggunakan komponen RecyclerView untuk menampilkan data secara dinamis dalam bentuk daftar atau grid.

## 📱 Penjelasan Fitur
### A. Edit 
Fitur Edit RecyclerView adalah kemampuan aplikasi untuk mengubah data yang sudah ada dalam daftar RecyclerView. Fitur ini memungkinkan pengguna memperbarui informasi pada item tertentu, seperti mengganti Nama, NIS, Kelas.
### B. Delete
Fitur Delete RecyclerView adalah kemampuan aplikasi untuk menghapus item tertentu dari daftar data yang ditampilkan oleh RecyclerView. Fitur ini disertai tombol hapus (delete) di setiap item, dan setelah item dihapus, tampilan RecyclerView langsung diperbarui.
### C. Tambah
Fitur Tambah RecyclerView adalah kemampuan aplikasi untuk menambahkan data baru ke dalam daftar yang ditampilkan oleh RecyclerView. Saat pengguna ingin menambahkan biodata siswa baru, yang berisi Nama, NIS, dan Kelas maka akan entri baru tersebut dapat bertambah di tampilan RecyclerView-nya.

## 🤖 Penjelasan Cara Kerja RecyclerView 
RecyclerView adalah komponen Android yang digunakan untuk menampilkan data dalam bentuk daftar atau grid secara efisien. Komponen ini bekerja dengan cara mendaur ulang tampilan item yang sudah tidak terlihat untuk digunakan kembali, sehingga tidak perlu membuat tampilan baru setiap kali data discroll. Dibandingkan ListView, RecyclerView lebih fleksibel dan hemat memori karena memakai sistem ViewHolder dan hanya membuat tampilan yang benar-benar diperlukan.
### Alur Cara Kerja RecyclerView:
1. Menyiapkan Data => Data yang akan ditampilkan disimpan dalam bentuk List atau ArrayList.
2. Membuat Layout Item => File XML dibuat untuk mendesain tampilan satu item dalam daftar (misalnya: gambar dan teks).
3. Membuat ViewHolder => ViewHolder menyimpan referensi tampilan agar lebih efisien dan mempercepat proses scrolling.
4. Membuat Adapter => Adapter menghubungkan data ke tampilan item, membuat item baru, dan menentukan jumlah data yang ditampilkan.
5. Mengatur RecyclerView di Activity/Fragment => RecyclerView dikonfigurasi dengan LayoutManager dan dihubungkan dengan adapter untuk menampilkan data ke layar.
### RecyclerView terdiri dari tiga komponen utama, yaitu:
1.  LayoutManager : Mengatur tata letak item, bisa berupa daftar vertikal, horizontal, atau grid.
2.  Adapter : Berfungsi sebagai penghubung antara data dan tampilan item. Adapter membuat item baru (ViewHolder), mengisi data ke dalamnya, dan menentukan jumlah data yang akan ditampilkan.
3.  ViewHolder : Menyimpan referensi tampilan item agar proses pengambilan view lebih efisien dan tidak berulang.
Saat aplikasi dijalankan, RecyclerView hanya akan membuat sejumlah tampilan item yang cukup untuk mengisi layar. Saat pengguna menggulir (scroll), tampilan item yang sudah tidak terlihat akan digunakan ulang untuk menampilkan data baru.

## 📂 Penjelasan Struktur File dan Alur Data

## 🧩 Penjelasan Code
