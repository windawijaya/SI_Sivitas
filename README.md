# SI_Sivitas
Rest API Asisten dosen untuk Tugas Proyek APAP Gasal 2019/2020

Base url : 

API List:
* [getAllPegawai](#getallpegawai)
* [getPegawai](#getpegawai)
* [addPegawai](#addpegawai)
* [updatePegawai](#updatepegawai)
* [getAllSiswa](#getallsiswa)
* [getSiswa](#getsiswa)
* [addSiswa](#addsiswa)
* [updateSiswa](#updatesiswa)
* [getAllGuru](#getallguru)
* [getGuru](#getguru)
* [addGuru](#addguru)
* [updateGuru](#updateguru)

## getAllPegawai

Mengembalikan daftar semua pegawai

**URL** : [`http://sivitas.herokuapp.com/api/employees`]
(http://sivitas.herokuapp.com/api/employees)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": [
        {
            "idUser": "e9e68e1279d74277b7a0e1bf04b14ec4",
            "nip": "P13121960SE012e9e68e1279d74277b7a0e1bf04b14ec4",
            "nama": "Nabila Keisha Z",
            "tempatLahir": "Bogor",
            "tanggalLahir": "1960-12-13",
            "alamat": "Jl. Mawar",
            "telepon": "08112327590"
        },
        {
            "idUser": "53338ba8258241989aaec882270795c6",
            "nip": "P06061982PL90253338ba8258241989aaec882270795c6",
            "nama": "Dinda Pramata",
            "tempatLahir": "Jakarta",
            "tanggalLahir": "1982-06-06",
            "alamat": "Jl. Melati",
            "telepon": "08123680120"
        }
    ]
}
```

## getPegawai

Mengembalikan info seorang pegawai

**URL** : [`http://sivitas.herokuapp.com/api/employees/{uuid}`]
(http://sivitas.herokuapp.com/api/employees/e9e68e1279d74277b7a0e1bf04b14ec4)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "idUser": "e9e68e1279d74277b7a0e1bf04b14ec4",
        "nip": "P13121960SE012e9e68e1279d74277b7a0e1bf04b14ec4",
        "nama": "Nabila Keisha Z",
        "tempatLahir": "Bogor",
        "tanggalLahir": "1960-12-13",
        "alamat": "Jl. Mawar",
        "telepon": "08112327590"
    }
}
```

## addPegawai

Menambahkan pegawai ke Sivitas

**URL** : `http://sivitas.herokuapp.com/api/employees`

**Method** : `POST`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"idUser": "53338ba8258241989aaec882270795c6",
	"nip": "P06061982PL90253338ba8258241989aaec882270795c6",
	"nama": "Dinda Pramata",
	"tempatLahir": "Jakarta",
	"tanggalLahir": "1982-06-06",
	"alamat": "Jl. Melati",
	"telepon": "08123680120"
}
```

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "idUser": "53338ba8258241989aaec882270795c6",
        "nip": "P06061982PL90253338ba8258241989aaec882270795c6",
        "nama": "Dinda Pramata",
        "tempatLahir": "Jakarta",
        "tanggalLahir": "1982-06-06",
        "alamat": "Jl. Melati",
        "telepon": "08123680120"
    }
}
```

### Failed Response

```json
{
    "timestamp": "2019-11-07T01:05:27.505+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "NIP in request body is invalid",
    "path": "/api/employees"
}
```

## updatePegawai

Mengubah data pegawai.

**URL** : `http://sivitas.herokuapp.com/api/employees/e9e68e1279d74277b7a0e1bf04b14ec4`

**Method** : `PUT`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"idUser": "e9e68e1279d74277b7a0e1bf04b14ec4",
	"nip": "P13121960SE012e9e68e1279d74277b7a0e1bf04b14ec4",
	"nama": "Nabila Keisha Z",
	"tempatLahir": "Bogor",
	"tanggalLahir": "1960-12-13",
	"alamat": "Jl. Mawar",
	"telepon": "08112327590"
}
```

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "idUser": "e9e68e1279d74277b7a0e1bf04b14ec4",
        "nip": "P13121960SE012e9e68e1279d74277b7a0e1bf04b14ec4",
        "nama": "Nabila Keisha Z",
        "tempatLahir": "Bogor",
        "tanggalLahir": "1960-12-13",
        "alamat": "Jl. Mawar",
        "telepon": "08112327590"
    }
}
```

### Failed Response

```json
{
    "timestamp": "2019-11-07T01:07:22.697+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "NIP in request body is invalid",
    "path": "/api/employees/e9e68e1279d74277b7a0e1bf04b14ec4"
}
```

## getAllSiswa

Mengembalikan daftar semua siswa

**URL** : [`http://sivitas.herokuapp.com/api/students`]
(http://sivitas.herokuapp.com/api/students)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": [
        {
            "idUser": "21c19e51e38f47b9930f9c6a3cee2a30",
            "nis": "S07042001AB12321c19e51e38f47b9930f9c6a3cee2a30",
            "nama": "Ratu Mustika",
            "tempatLahir": "Bandung",
            "tanggalLahir": "2001-04-07",
            "alamat": "Jl. Lumba-Lumba",
            "telepon": "08526229304"
        },
        {
            "idUser": "9343bd87247a41b892d8ea49fd3eb03f",
            "nis": "S12102001RE0019343bd87247a41b892d8ea49fd3eb03f",
            "nama": "Insani Lenny",
            "tempatLahir": "Surabaya",
            "tanggalLahir": "2001-10-12",
            "alamat": "Jl. Paus",
            "telepon": "08974329201"
        }
    ]
}
```

## getSiswa

Mengembalikan info seorang siswa

**URL** : [`http://sivitas.herokuapp.com/api/students/{uuid}`]
(http://sivitas.herokuapp.com/api/students/9343bd87247a41b892d8ea49fd3eb03f)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "idUser": "9343bd87247a41b892d8ea49fd3eb03f",
        "nis": "S12102001RE0019343bd87247a41b892d8ea49fd3eb03f",
        "nama": "Insani Lenny",
        "tempatLahir": "Surabaya",
        "tanggalLahir": "2001-10-12",
        "alamat": "Jl. Paus",
        "telepon": "08974329201"
    }
}
```

## addSiswa

Menambahkan siswa ke Sivitas

**URL** : `http://sivitas.herokuapp.com/api/students`

**Method** : `POST`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"idUser": "21c19e51e38f47b9930f9c6a3cee2a30",
	"nis": "S07042001AB12321c19e51e38f47b9930f9c6a3cee2a30",
	"nama": "Ratu Mustika",
	"tempatLahir": "Bandung",
	"tanggalLahir": "2001-04-07",
	"alamat": "Jl. Lumba-Lumba",
	"telepon": "08526229304"
}
```

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "idUser": "21c19e51e38f47b9930f9c6a3cee2a30",
        "nis": "S07042001AB12321c19e51e38f47b9930f9c6a3cee2a30",
        "nama": "Ratu Mustika",
        "tempatLahir": "Bandung",
        "tanggalLahir": "2001-04-07",
        "alamat": "Jl. Lumba-Lumba",
        "telepon": "08526229304"
    }
}
```

### Failed Response

```json
{
    "timestamp": "2019-11-07T01:12:22.721+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "NIS in request body is invalid",
    "path": "/api/students"
}
```

## updateSiswa

Mengubah data siswa.

**URL** : `http://sivitas.herokuapp.com/api/students/e9e68e1279d74277b7a0e1bf04b14ec4`

**Method** : `PUT`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"idUser": "9343bd87247a41b892d8ea49fd3eb03f",
	"nis": "S12102001RE0019343bd87247a41b892d8ea49fd3eb03f",
	"nama": "Insani Hani",
	"tempatLahir": "Surabaya",
	"tanggalLahir": "2001-10-12",
	"alamat": "Jl. Paus",
	"telepon": "08974329201"
}
```

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "idUser": "9343bd87247a41b892d8ea49fd3eb03f",
        "nis": "S12102001RE0019343bd87247a41b892d8ea49fd3eb03f",
        "nama": "Insani Hani",
        "tempatLahir": "Surabaya",
        "tanggalLahir": "2001-10-12",
        "alamat": "Jl. Paus",
        "telepon": "08974329201"
    }
}
```

### Failed Response

```json
{
    "timestamp": "2019-11-07T01:17:22.625+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "NIS in request body is invalid",
    "path": "/api/students/9343bd87247a41b892d8ea49fd3eb03f"
}
```

## getAllGuru

Mengembalikan daftar semua guru

**URL** : [`http://sivitas.herokuapp.com/api/teachers`]
(http://sivitas.herokuapp.com/api/teachers)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": [
        {
            "idUser": "4b9d357ef11548c698feacaa43a0da2c",
            "nig": "G07021980SE0124b9d357ef11548c698feacaa43a0da2c",
            "nama": "Fitri Sara",
            "tempatLahir": "Bogor",
            "tanggalLahir": "1980-02-07",
            "alamat": "Jl. Mawar",
            "telepon": "08112327590"
        },
        {
            "idUser": "cb17f1418aa14d42b042236bd92429a7",
            "nig": "G25081988UI765cb17f1418aa14d42b042236bd92429a7",
            "nama": "Handoko Theodorus",
            "tempatLahir": "Jakarta",
            "tanggalLahir": "1988-08-25",
            "alamat": "Jl. Kopi",
            "telepon": "0852637494"
        }
    ]
}
```

## getGuru

Mengembalikan info seorang guru

**URL** : [`http://sivitas.herokuapp.com/api/teachers/{uuid}`]
(http://sivitas.herokuapp.com/api/teachers/4b9d357ef11548c698feacaa43a0da2c)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "idUser": "4b9d357ef11548c698feacaa43a0da2c",
        "nig": "G07021980SE0124b9d357ef11548c698feacaa43a0da2c",
        "nama": "Fitri Sara",
        "tempatLahir": "Bogor",
        "tanggalLahir": "1980-02-07",
        "alamat": "Jl. Mawar",
        "telepon": "08112327590"
    }
}
```

## addGuru

Menambahkan guru ke Sivitas

**URL** : `http://sivitas.herokuapp.com/api/teachers`

**Method** : `POST`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"idUser": "cb17f1418aa14d42b042236bd92429a7",
	"nig": "G25081988UI765cb17f1418aa14d42b042236bd92429a7",
	"nama": "Handoko Theodorus",
	"tempatLahir": "Jakarta",
	"tanggalLahir": "1988-08-25",
	"alamat": "Jl. Kopi",
	"telepon": "0852637494"
}
```

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "idUser": "cb17f1418aa14d42b042236bd92429a7",
        "nig": "G25081988UI765cb17f1418aa14d42b042236bd92429a7",
        "nama": "Handoko Theodorus",
        "tempatLahir": "Jakarta",
        "tanggalLahir": "1988-08-25",
        "alamat": "Jl. Kopi",
        "telepon": "0852637494"
    }
}
```

### Failed Response

```json
{
    "timestamp": "2019-11-07T01:22:34.715+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "NIG in request body is invalid",
    "path": "/api/teachers"
}
```

## updateGuru

Mengubah data guru.

**URL** : `sivitas.herokuapp.com/api/teachers/4b9d357ef11548c698feacaa43a0da2c`

**Method** : `PUT`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"idUser": "4b9d357ef11548c698feacaa43a0da2c",
	"nig": "G07021980SE0124b9d357ef11548c698feacaa43a0da2c",
	"nama": "Fitri Sara",
	"tempatLahir": "Bogor",
	"tanggalLahir": "1980-02-07",
	"alamat": "Jl. Mawar",
	"telepon": "08112327590"
}
```

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "idUser": "4b9d357ef11548c698feacaa43a0da2c",
        "nig": "G07021980SE0124b9d357ef11548c698feacaa43a0da2c",
        "nama": "Fitri Sara",
        "tempatLahir": "Bogor",
        "tanggalLahir": "1980-02-07",
        "alamat": "Jl. Mawar",
        "telepon": "08112327590"
    }
}
```

### Failed Response

```json
{
    "timestamp": "2019-11-07T01:23:20.045+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "NIG in request body is invalid",
    "path": "/api/teachers/4b9d357ef11548c698feacaa43a0da2c"
}
```
