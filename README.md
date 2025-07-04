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

> **Note:** HTTP 404 jika ID tidak ditemukan dan HTTP 400 jika data tidak lengkap.

### Hasil Pengujian
1. `GET /villas`
   ![image](https://github.com/user-attachments/assets/d3503a97-4b9b-4411-91d3-691f6ae8e3c9)
   Endpoint ini digunakan untuk mengambil seluruh daftar vila yang tersedia dalam sistem. Pengujian terhadap endpoint `GET /villas` berhasil menampilkan semua data vila yang tersedia pada database dengan status **200 OK**.
   
2. `GET /villas/{id}`
   ![image](https://github.com/user-attachments/assets/cb7a2425-ce06-4755-a6cc-5da1d733ce44)
   Endpoint ini digunakan untuk mengambil detail informasi dari sebuah vila berdasarkan ID tertentu. Pengujian terhadap endpoint `GET /villas/{id}` berhasil menampilkan detail vila dengan ID yang valid, ditandai dengan status **200 OK**. Untuk ID yang tidak ditemukan, sistem merespons dengan status **404 Not Found**.
   
3. `GET /villas/{id}/rooms`
   ![image](https://github.com/user-attachments/assets/e8f3eb20-147d-410e-9f74-63281859ca34)
   Endpoint ini digunakan untuk menampilkan daftar tipe kamar yang dimiliki oleh vila tertentu. Pengujian terhadap endpoint `GET /villas/{id}/rooms` berhasil menampilkan data tipe kamar untuk ID vila yang valid dengan status **200 OK**.

4. `GET /villas/{id}/bookings`
   ![image](https://github.com/user-attachments/assets/f72c484c-4238-4051-83b7-2aa5d650fa3c)
   Endpoint ini digunakan untuk menampilkan semua data pemesanan (booking) pada vila tertentu. Pengujian terhadap endpoint `GET /villas/{id}/bookings` berhasil menampilkan seluruh riwayat booking untuk vila dengan ID valid dan memberikan respons status **200 OK**.
   
5. `GET /villas/{id}/reviews`
   ![image](https://github.com/user-attachments/assets/729e07f0-d0c0-402a-83cd-ecfe6b997a15)
   Endpoint ini digunakan untuk menampilkan semua review atau ulasan yang diberikan oleh customer terhadap vila tertentu. Pengujian terhadap endpoint `GET /villas/{id}/reviews` berhasil menampilkan data ulasan dengan status **200 OK**.
  
6. `GET /villas?ci_date=...&co_date=...`
   ![image](https://github.com/user-attachments/assets/35ad5d3e-5759-4015-8375-8aab176cc244)
   Endpoint ini digunakan untuk mengecek ketersediaan vila berdasarkan rentang tanggal check-in dan check-out. Pengujian terhadap endpoint `GET /villas?ci_date=...&co_date=...` berhasil menampilkan daftar vila yang tersedia dengan status **200 OK**, dan mengembalikan status **400 Bad Request** jika parameter tanggal tidak sesuai format.
   
7. `POST /villas`
   ![image](https://github.com/user-attachments/assets/46a7daee-0776-460d-b09d-9d2b1c26680c)
    Endpoint ini digunakan untuk menambahkan data vila baru ke dalam sistem. Pengujian terhadap endpoint `POST /villas` berhasil menambahkan data vila baru dengan input yang valid dan memberikan status **200 OK**. Permintaan dengan data tidak lengkap menghasilkan status **400 Bad Request**.
   
8. `POST /villas/{id}/rooms`
    ![image](https://github.com/user-attachments/assets/02994f6f-6be7-4b94-ba45-285883ceea83)
   Endpoint ini digunakan untuk menambahkan tipe kamar baru ke dalam vila tertentu. Pengujian terhadap endpoint `POST /villas/{id}/rooms` berhasil menyimpan data kamar dengan atribut lengkap dan menghasilkan status **200 OK**.
    
9. `PUT /villas/{id}`
    ![image](https://github.com/user-attachments/assets/c441893a-fa0f-41ba-b25e-a49b4968b4b4)
    Endpoint ini digunakan untuk mengubah informasi vila seperti nama, alamat, dan deskripsi. Pengujian terhadap endpoint `PUT /villas/{id}` berhasil memperbarui data vila dan memberikan status **200 OK**.
    
10. `PUT /villas/{id}/rooms/{id}`
    ![image](https://github.com/user-attachments/assets/cb6caad8-e561-46d4-b011-705f329b2409)
    Endpoint ini digunakan untuk mengubah informasi pada tipe kamar yang dimiliki vila tertentu. Pengujian terhadap endpoint `PUT /villas/{id}/rooms/{id}` berhasil memperbarui data kamar dengan status **200 OK**.
    
11. `DELETE /villas/{id}/rooms/{id}`
    ![image](https://github.com/user-attachments/assets/5e7a4435-858e-48f2-8f59-1348046fead4)
    Endpoint ini digunakan untuk menghapus tipe kamar tertentu dari sebuah vila. Pengujian terhadap endpoint `DELETE /villas/{id}/rooms/{id}` berhasil menghapus data kamar dan memberikan status **200 OK**.
    
12.  `DELETE /villas/{id}`\
    ![image](https://github.com/user-attachments/assets/a1cfb7bc-513f-43b7-b014-779f8ece5903)
    Endpoint ini digunakan untuk menghapus data vila dari sistem. Pengujian terhadap endpoint `DELETE /villas/{id}` berhasil menghapus vila berdasarkan ID yang valid dengan status **200 OK**. 
    
13.  `GET /customers`
    ![image](https://github.com/user-attachments/assets/c19f3138-ffff-4e9e-9cae-ebd540e71434)
   Endpoint ini digunakan untuk mengambil seluruh daftar customer yang terdaftar di sistem. Pengujian terhadap endpoint `GET /customers` berhasil menampilkan semua data customer dengan status **200 OK**.
    
14. `GET /customers/{id}`
    ![image](https://github.com/user-attachments/assets/c58552b6-207d-42a6-8f7e-6e8d25329807)
    Endpoint ini digunakan untuk mengambil detail informasi dari seorang customer berdasarkan ID. Pengujian terhadap endpoint `GET /customers/{id}` berhasil menampilkan data customer yang valid dengan status **200 OK**.
    
15. `GET /customers/{id}/bookings`
    ![image](https://github.com/user-attachments/assets/55f044d2-529f-4cb2-abdd-d735097c6166)
    Endpoint ini digunakan untuk menampilkan daftar booking yang pernah dilakukan oleh customer tertentu. Pengujian terhadap endpoint `GET /customers/{id}/bookings` berhasil menampilkan seluruh data booking dengan status **200 OK**.
    
16. `GET /customers/{id}/reviews`
    ![image](https://github.com/user-attachments/assets/83887123-59e5-4f46-a78f-72c50129caf4)
    Endpoint ini digunakan untuk menampilkan ulasan atau review yang telah diberikan oleh seorang customer. Pengujian terhadap endpoint `GET /customers/{id}/reviews` berhasil menampilkan data review dengan status **200 OK**.
    
17. `POST /customers`
    ![image](https://github.com/user-attachments/assets/d8a575f7-24a7-4f77-9486-b92dea6e286d)
    Endpoint ini digunakan untuk registrasi customer baru ke dalam sistem. Pengujian terhadap endpoint `POST /customers` berhasil menambahkan data customer baru dengan input valid dan status **200 OK**, serta menghasilkan status **400 Bad Request** jika data tidak lengkap.
    
18. `POST /customers/{id}/bookings`
    ![image](https://github.com/user-attachments/assets/949bc56f-e21b-4395-8545-e8dd952161d2)
    Endpoint ini digunakan oleh customer untuk melakukan pemesanan vila. Pengujian terhadap endpoint `POST /customers/{id}/bookings` berhasil membuat data pemesanan dengan status **200 OK**, dan memberikan status **400 Bad Request** jika data tidak valid.
    
19. `PUT /customers/{id}`
   ![image](https://github.com/user-attachments/assets/01c66683-dca9-4b3f-8bf7-4813dbc2ebf6)
    Endpoint ini digunakan untuk mengubah informasi profil dari seorang customer. Pengujian terhadap endpoint `PUT /customers/{id}` berhasil memperbarui data customer dan memberikan status **200 OK**.
    
20. `GET /vouchers`
    ![image](https://github.com/user-attachments/assets/97027176-242e-4745-a567-bb0c468e9141)
    Endpoint ini digunakan untuk menampilkan seluruh daftar voucher yang tersedia. Pengujian terhadap endpoint `GET /vouchers` berhasil menampilkan data voucher dengan status **200 OK**.
    
21. `GET /vouchers/{id}`
    ![image](https://github.com/user-attachments/assets/9f1fa439-8a0c-4e4f-a8b7-78fec83aa528)
    Endpoint ini digunakan untuk menampilkan detail dari voucher tertentu. Pengujian terhadap endpoint `GET /vouchers/{id}` berhasil menampilkan informasi voucher dengan status **200 OK**.
    
22. `POST /vouchers`
    ![image](https://github.com/user-attachments/assets/45ca7b5a-8f73-499d-83fb-ed17b7881095)
    Endpoint ini digunakan untuk membuat voucher baru ke dalam sistem. Pengujian terhadap endpoint `POST /vouchers` berhasil menyimpan data voucher baru dengan status **200 OK**.
    
23. `PUT /vouchers/{id}`
    ![image](https://github.com/user-attachments/assets/b102d296-46ce-4654-916a-c2e07ad5d690)
    Endpoint ini digunakan untuk mengubah informasi dari voucher yang sudah ada. Pengujian terhadap endpoint `PUT /vouchers/{id}` berhasil memperbarui data voucher dan memberikan status **200 OK**.
    
24. `404 Not Found`
    ![image](https://github.com/user-attachments/assets/bec9ff38-53b4-427c-87d4-48c48ff63077)
   Respons ini muncul ketika pengguna mencoba mengakses data yang tidak tersedia dalam sistem. Misalnya, saat melakukan permintaan ke endpoint `GET /villas/{id}` dengan ID yang tidak valid atau tidak terdaftar di database. Pengujian terhadap kasus ini menunjukkan bahwa sistem berhasil memberikan respons **404 Not Found**, yang berarti penanganan terhadap data yang tidak ditemukan telah dilakukan dengan baik.

25. `400 Bad Request`
    ![image](https://github.com/user-attachments/assets/34a5f5cb-c5d8-4fe6-8a08-78937845ad10)
    Status ini dikembalikan ketika permintaan ke server mengandung input yang tidak valid atau kosong, misalnya field yang wajib diisi tidak diberikan saat melakukan `POST /villas` atau `POST /customers`. Pengujian dilakukan dengan sengaja mengosongkan field tertentu dalam JSON body, seperti `name`, `email`, atau `address`, dan server secara tepat merespons dengan status **400 Bad Request**, lengkap dengan pesan validasi.


26. `GET /customers`
    ![image](https://github.com/user-attachments/assets/4a4a666c-3fe8-4854-bcf0-120ecd9f004a)
    Endpoint ini digunakan untuk mengambil seluruh daftar customer yang terdaftar di sistem. Pengujian terhadap endpoint `GET /customers` berhasil menampilkan seluruh data customer dalam bentuk array JSON, dan server merespons dengan status **200 OK**.

