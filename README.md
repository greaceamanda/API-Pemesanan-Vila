# API-Pemesanan-Vila

Aplikasi ini dibangun menggunakan **Java Spring Boot** dan dapat dijalankan menggunakan **Maven** atau **Gradle**. Berikut instruksi untuk berbagai terminal:

---

### ✅ Menggunakan Maven

#### 🔹 Command Prompt
```bash
mvnw spring-boot:run
```
#### 🔹 PowerShell
```bash
./mvnw spring-boot:run
```
### ✅ Menggunakan Maven

#### 🔹 PowerShell
```bash
./gradlew bootRun
```
#### 🔹 Command Prompt
```bash
gradlew bootRun
```

### ✅ Akses API
```bash
http://localhost:8080
```

### ✅ Struktur Endpoint
Berikut adalah beberapa endpoint utama yang disediakan:
####🔹 Customers
- GET /customers – Menampilkan semua customer
- GET /customers/{id} – Menampilkan detail customer
- POST /customers – Menambahkan customer baru
- PUT /customers/{id} – Mengubah data customer
- GET /customers/{id}/bookings – Booking customer
- POST /customers/{id}/bookings – Buat booking
- POST /customers/{customerId}/bookings/{bookingId}/reviews – Tambah review

####🔹 Villas
- GET /villas – Menampilkan semua vila
- GET /villas/{id} – Detail vila
- POST /villas – Tambah vila
- PUT /villas/{id} – Ubah vila
- DELETE /villas/{id} – Hapus vila
- GET /villas/{id}/rooms – Lihat kamar
- POST /villas/{id}/rooms – Tambah kamar
- PUT /villas/{id}/rooms/{roomId} – Ubah kamar
- DELETE /villas/{id}/rooms/{roomId} – Hapus kamar
- GET /villas/{id}/reviews – Lihat review vila

####🔹 Bookings
- GET /bookings – Semua data booking
- GET /bookings/{id} – Detail booking

####🔹 Reviews
- GET /reviews/customer/{id} – Review dari customer
- GET /reviews/villa/{id} – Review untuk vila

####🔹 Vouchers
- GET /vouchers – Semua voucher
- GET /vouchers/{id} – Detail voucher
- POST /vouchers – Tambah voucher
- PUT /vouchers/{id} – Ubah voucher
- DELETE /vouchers/{id} – Hapus voucher
