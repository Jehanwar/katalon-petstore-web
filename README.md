# 🌐 JPetStore Web Automation - Katalon Studio

![Katalon Studio](https://img.shields.io/badge/Katalon%20Studio-v10.3.2-blue?style=flat&logo=katalon)
![Web Automation](https://img.shields.io/badge/Testing-Web%20UI-brightgreen?style=flat)
![Status](https://img.shields.io/badge/Build-PASSED-success?style=flat)
![Framework](https://img.shields.io/badge/Framework-Hybrid%20%7C%20POM-orange?style=flat)

Proyek ini adalah implementasi **Web UI Test Automation** pada aplikasi web e-commerce **JPetStore OctoPerf** menggunakan **Katalon Studio**. Proyek ini dibuat untuk memenuhi tugas **Final Project Bootcamp AfterOffice**.

---

## 🎯 Target Aplikasi (AUT)
* **Aplikasi**: JPetStore Demo (OctoPerf Catalog)
* **URL Target**: [https://petstore.octoperf.com/actions/Catalog.action](https://petstore.octoperf.com/actions/Catalog.action)
* **Browser Target**: Google Chrome (versi terbaru)

---

## 📋 Cakupan Pengujian (Test Scope & Scenarios)

Proyek ini mencakup minimal 5 Test Cases yang dirancang menggunakan pendekatan **Hybrid Mode (Scripting + Page Object Model)** tanpa menggunakan *Record Web*, mencakup skenario positif, skenario negatif, dan Data-Driven Testing (DDT):

| Test Case ID | Nama Test Case | Tipe Pengujian | Deskripsi & Validasi |
|---|---|---|---|
| **TC_01** | `TC_01_Register_New_Account` | **DDT (Data-Driven)** | Mendaftarkan akun baru menggunakan dataset CSV (6 variasi data: user valid, password mismatch, field kosong, invalid email). Menggunakan dynamic timestamp ID (`jehan_master<timestamp>`) untuk mencegah duplikasi registrasi. |
| **TC_02** | `TC_02_Login_Success` | **Positif** | Login menggunakan kredensial valid dari `GlobalVariable`. Memvalidasi teks ucapan selamat datang (`Welcome <User>!`) dan tombol *Sign Out*. |
| **TC_03** | `TC_03_Login_Failed` | **Negatif** | Login menggunakan password salah. Memvalidasi pesan error: `Invalid username or password. Signon failed.`. |
| **TC_04** | `TC_04_Search_Product` | **Positif** | Mencari produk berdasarkan kata kunci katalog (`fish`). Memvalidasi tabel hasil pencarian memuat produk yang sesuai (`Angelfish`, `Tiger Shark`). |
| **TC_05** | `TC_05_Add_Product_To_Cart` | **Positif (E2E)** | Memilih kategori hewan, memilih produk item (`EST-1`), menambahkan ke keranjang belanja, dan memverifikasi item serta kalkulasi subtotal di halaman Cart. |

---

## 🚀 Fitur Utama & Kepatuhan Rubrik

1. **Hybrid Mode & Page Object Model (POM)**:
   - Object Repository dikelompokkan rapi per halaman: `page_Home/`, `page_Sign_in/`, `page_Sign_up/`, `page_Catalog/`, `page_Cart/`.
   - Menggunakan selector CSS dan XPath yang stabil (menghindari absolute hierarchy).
2. **Data-Driven Testing (DDT)**:
   - Dataset registrasi disimpan dalam file CSV (`Register_DDT_Afteroffice.csv`) dan dimuat melalui Katalon Data Files (`DataRegister.dat`).
3. **Penggunaan Global Variables**:
   - `Profiles/default.glbl` menyimpan variabel global seperti `base_url`, `username`, dan `password` untuk menghindari *hardcoding* di dalam script.
4. **Eksekusi via Test Suite**:
   - Seluruh test case dibungkus dalam Test Suite (`TS_Web_Regression`) untuk menghasilkan laporan eksekusi lengkap.

---

## 📁 Struktur Folder Proyek

```text
FinalProject_AfterOffice/
├── Data Files/
│   └── DataRegister.dat          # Data File binding ke CSV DDT
├── Object Repository/            # Page Object Model (POM)
│   ├── page_Home/                # Elemen halaman beranda & navigasi
│   ├── page_Sign_in/             # Form input login
│   ├── page_Sign_up/             # Form registrasi lengkap
│   ├── page_Catalog/             # Elemen katalog dan search
│   └── page_Cart/                # Elemen keranjang belanja
├── Profiles/
│   └── default.glbl              # Konfigurasi Global Variables
├── Reports/                      # Laporan hasil eksekusi (HTML, CSV, JUnit)
├── Scripts/                      # Source code script Groovy tiap test case
├── Test Cases/                   # Definisi test case Katalon
└── Test Suites/
    ├── TS_Register_DDT.ts        # Suite khusus eksekusi data-driven registrasi
    └── TS_Web_Regression.ts      # Suite regresi gabungan 5 test cases
```

---

## 🛠️ Cara Menjalankan Pengujian (Execution Guide)

1. **Clone Repository**:
   ```bash
   git clone https://github.com/Jehanwar/katalon-petstore-web.git
   ```
2. **Buka di Katalon Studio**:
   - Buka Katalon Studio ➡️ Klik **File** ➡️ **Open Project**.
   - Pilih file `FinalProject_AfterOffice.prj`.
3. **Jalankan Test Suite**:
   - Buka folder `Test Suites` di Tests Explorer ➡️ Klik ganda `TS_Web_Regression`.
   - Klik tombol **Run** (panah hijau) ➡️ Pilih browser **Chrome**.
4. **Lihat Laporan Hasil**:
   - Setelah eksekusi selesai, buka folder `Reports/` untuk melihat laporan visual interaktif format `.html` dan tabular format `.csv`.

---

## 📊 Hasil Eksekusi & Laporan Pengujian
Laporan resmi tersimpan di folder `Reports/` proyek ini:
* **HTML Report**: [Reports/TS_Web_Regression/](Reports/)
* **Status**: **PASSED** (Semua skenario pengujian berhasil dieksekusi).

---
*Author: Jehan Khairul Anwar (Final Project AfterOffice Bootcamp)*
