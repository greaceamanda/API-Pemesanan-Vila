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
### ✅ Menggunakan Gradle

#### 🔹 PowerShell
```bash
./gradlew bootRun
```
#### 🔹 Command Prompt
```bash
gradlew bootRun
```
![image](https://github.com/user-attachments/assets/ca4195ef-56ce-4251-9362-6bbae484cd3c)

### ✅ Akses API
```bash
http://localhost:8080
```
![image](https://github.com/user-attachments/assets/7b1c8e3e-defe-4e4b-9d99-05e8bcd7b893)

[PENTING! GUNAKAN HEADER X-API-KEY | TBO-API-2025]


### ✅ Struktur Endpoint
Berikut adalah beberapa endpoint utama yang disediakan:
---
🔹 Customers
- GET /customers – Menampilkan semua customer
- GET /customers/{id} – Menampilkan detail customer
- POST /customers – Menambahkan customer baru
- PUT /customers/{id} – Mengubah data customer
- GET /customers/{id}/bookings – Booking customer
- POST /customers/{id}/bookings – Buat booking
- POST /customers/{customerId}/bookings/{bookingId}/reviews – Tambah review

🔹 Villas
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

🔹 Bookings
- GET /bookings – Semua data booking
- GET /bookings/{id} – Detail booking

🔹 Reviews
- GET /reviews/customer/{id} – Review dari customer
- GET /reviews/villa/{id} – Review untuk vila

🔹 Vouchers
- GET /vouchers – Semua voucher
- GET /vouchers/{id} – Detail voucher
- POST /vouchers – Tambah voucher
- PUT /vouchers/{id} – Ubah voucher
- DELETE /vouchers/{id} – Hapus voucher

## PENGUJIAN

### Pengecekan Request Method:
a. Mendapatkan list/detail data (GET)
b. Membuat data baru (POST)
c. Mengubah data (PUT)
note: HTTP 404 jika id tidak ditemukan dan HTTP 400 jika data tidak lengkap

### Hasil Pengujian
1. GET /villas
   ![image](https://github.com/user-attachments/assets/d3503a97-4b9b-4411-91d3-691f6ae8e3c9)
   Endpoint ini digunakan untuk mengambil seluruh daftar vila yang tersedia dalam sistem. Pengujian terhadap endpoint `GET /villas` berhasil menampilkan semua data vila yang tersedia pada database dengan status **200 OK**.
   
2. GET /villas/{id}
   ![image](https://github.com/user-attachments/assets/cb7a2425-ce06-4755-a6cc-5da1d733ce44)
   Endpoint ini digunakan untuk mengambil detail informasi dari sebuah vila berdasarkan ID tertentu. Pengujian terhadap endpoint `GET /villas/{id}` berhasil menampilkan detail vila dengan ID yang valid, ditandai dengan status **200 OK**. Untuk ID yang tidak ditemukan, sistem merespons dengan status **404 Not Found**.
   
4. GET /villas/{id}/rooms
   ![image](https://github.com/user-attachments/assets/e8f3eb20-147d-410e-9f74-63281859ca34)
   Endpoint ini digunakan untuk menampilkan daftar tipe kamar yang dimiliki oleh vila tertentu. Pengujian terhadap endpoint `GET /villas/{id}/rooms` berhasil menampilkan data tipe kamar untuk ID vila yang valid dengan status **200 OK**.

5. GET /villas/{id}/bookings
   ![image](https://github.com/user-attachments/assets/f72c484c-4238-4051-83b7-2aa5d650fa3c)
   Endpoint ini digunakan untuk menampilkan semua data pemesanan (booking) pada vila tertentu. Pengujian terhadap endpoint `GET /villas/{id}/bookings` berhasil menampilkan seluruh riwayat booking untuk vila dengan ID valid dan memberikan respons status **200 OK**.
   
6. GET /villas/{id}/reviews
   ![image](https://github.com/user-attachments/assets/729e07f0-d0c0-402a-83cd-ecfe6b997a15)
   Endpoint ini digunakan untuk menampilkan semua review atau ulasan yang diberikan oleh customer terhadap vila tertentu. Pengujian terhadap endpoint `GET /villas/{id}/reviews` berhasil menampilkan data ulasan dengan status **200 OK**.
  
7. GET /villas?ci_date={checkin}&co_date={checkout}
   ![image](https://github.com/user-attachments/assets/35ad5d3e-5759-4015-8375-8aab176cc244)
   Endpoint ini digunakan untuk mengecek ketersediaan vila berdasarkan rentang tanggal check-in dan check-out. Pengujian terhadap endpoint `GET /villas?ci_date=...&co_date=...` berhasil menampilkan daftar vila yang tersedia dengan status **200 OK**, dan mengembalikan status **400 Bad Request** jika parameter tanggal tidak sesuai format.
   
8. POST /villas
   ![image](https://github.com/user-attachments/assets/46a7daee-0776-460d-b09d-9d2b1c26680c)
    Endpoint ini digunakan untuk menambahkan data vila baru ke dalam sistem. Pengujian terhadap endpoint `POST /villas` berhasil menambahkan data vila baru dengan input yang valid dan memberikan status **200 OK**. Permintaan dengan data tidak lengkap menghasilkan status **400 Bad Request**.
   
10. ![image](https://github.com/user-attachments/assets/02994f6f-6be7-4b94-ba45-285883ceea83)
    
11. ![image](https://github.com/user-attachments/assets/c441893a-fa0f-41ba-b25e-a49b4968b4b4)
    
12. ![image](https://github.com/user-attachments/assets/cb6caad8-e561-46d4-b011-705f329b2409)
    
13. ![image](https://github.com/user-attachments/assets/5e7a4435-858e-48f2-8f59-1348046fead4)
    
14. ![image](https://github.com/user-attachments/assets/a1cfb7bc-513f-43b7-b014-779f8ece5903)
    
15. ![image](https://github.com/user-attachments/assets/c19f3138-ffff-4e9e-9cae-ebd540e71434)
    
16. ![image](https://github.com/user-attachments/assets/c58552b6-207d-42a6-8f7e-6e8d25329807)
    
17. ![image](https://github.com/user-attachments/assets/55f044d2-529f-4cb2-abdd-d735097c6166)
    
18. ![image](https://github.com/user-attachments/assets/83887123-59e5-4f46-a78f-72c50129caf4)
    
19. ![image](https://github.com/user-attachments/assets/d8a575f7-24a7-4f77-9486-b92dea6e286d)
    
20. ![image](https://github.com/user-attachments/assets/949bc56f-e21b-4395-8545-e8dd952161d2)
    
21. ![image](https://github.com/user-attachments/assets/01c66683-dca9-4b3f-8bf7-4813dbc2ebf6)
    
22. ![image](https://github.com/user-attachments/assets/97027176-242e-4745-a567-bb0c468e9141)
    
23. ![image](https://github.com/user-attachments/assets/9f1fa439-8a0c-4e4f-a8b7-78fec83aa528)
    
24. ![image](https://github.com/user-attachments/assets/45ca7b5a-8f73-499d-83fb-ed17b7881095)
    
25. ![image](https://github.com/user-attachments/assets/b102d296-46ce-4654-916a-c2e07ad5d690)
    
26. ![image](https://github.com/user-attachments/assets/bec9ff38-53b4-427c-87d4-48c48ff63077)

27. ![image](https://github.com/user-attachments/assets/34a5f5cb-c5d8-4fe6-8a08-78937845ad10)

28. ![image](https://github.com/user-attachments/assets/4a4a666c-3fe8-4854-bcf0-120ecd9f004a)
