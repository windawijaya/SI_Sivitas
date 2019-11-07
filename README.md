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

**URL** : [`http://sivitas.herokuapp.com/api/pegawai`]
(http://sivitas.herokuapp.com/api/pegawai)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": [
        {
            "uuidUser": "e9e68e1279d74277b7a0e1bf04b14ec4",
            "nip": "P13121960SE012e9e68e1279d74277b7a0e1bf04b14ec4",
            "nama": "Nabila Keisha Z",
            "tempatLahir": "Bogor",
            "tanggalLahir": "1960-12-13",
            "alamat": "Jl. Mawar",
            "telepon": "08112327590"
        },
        {
            "uuidUser": "53338ba8258241989aaec882270795c6",
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

**URL** : [`http://sivitas.herokuapp.com/api/pegawai/{uuid}`]
(http://sivitas.herokuapp.com/api/pegawai/e9e68e1279d74277b7a0e1bf04b14ec4)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "uuidUser": "e9e68e1279d74277b7a0e1bf04b14ec4",
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

**URL** : `http://sivitas.herokuapp.com/api/pegawai`

**Method** : `POST`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"uuidUser": "53338ba8258241989aaec882270795c6",
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
        "uuidUser": "53338ba8258241989aaec882270795c6",
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
    "path": "/api/pegawai"
}
```

## updatePegawai

Mengubah data pegawai.

**URL** : `http://sivitas.herokuapp.com/api/pegawai/e9e68e1279d74277b7a0e1bf04b14ec4`

**Method** : `POST`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"uuidUser": "e9e68e1279d74277b7a0e1bf04b14ec4",
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
        "uuidUser": "e9e68e1279d74277b7a0e1bf04b14ec4",
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
    "path": "/api/pegawai/e9e68e1279d74277b7a0e1bf04b14ec4"
}
```

## getAllSiswa

Mengembalikan daftar semua siswa

**URL** : [`http://sivitas.herokuapp.com/api/siswa`]
(http://sivitas.herokuapp.com/api/siswa)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": [
        {
            "uuidUser": "21c19e51e38f47b9930f9c6a3cee2a30",
            "nis": "S07042001AB12321c19e51e38f47b9930f9c6a3cee2a30",
            "nama": "Ratu Mustika",
            "tempatLahir": "Bandung",
            "tanggalLahir": "2001-04-07",
            "alamat": "Jl. Lumba-Lumba",
            "telepon": "08526229304"
        },
        {
            "uuidUser": "9343bd87247a41b892d8ea49fd3eb03f",
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

**URL** : [`http://sivitas.herokuapp.com/api/siswa/{uuid}`]
(http://sivitas.herokuapp.com/api/siswa/9343bd87247a41b892d8ea49fd3eb03f)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "uuidUser": "9343bd87247a41b892d8ea49fd3eb03f",
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

**URL** : `http://sivitas.herokuapp.com/api/siswa`

**Method** : `POST`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"uuidUser": "21c19e51e38f47b9930f9c6a3cee2a30",
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
        "uuidUser": "21c19e51e38f47b9930f9c6a3cee2a30",
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
    "path": "/api/siswa"
}
```

## updateSiswa

Mengubah data siswa.

**URL** : `http://sivitas.herokuapp.com/api/siswa/e9e68e1279d74277b7a0e1bf04b14ec4`

**Method** : `POST`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"uuidUser": "9343bd87247a41b892d8ea49fd3eb03f",
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
        "uuidUser": "9343bd87247a41b892d8ea49fd3eb03f",
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
    "path": "/api/siswa/9343bd87247a41b892d8ea49fd3eb03f"
}
```

## getAllGuru

Mengembalikan daftar semua guru

**URL** : [`http://sivitas.herokuapp.com/api/guru`]
(http://sivitas.herokuapp.com/api/guru)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": [
        {
            "uuidUser": "4b9d357ef11548c698feacaa43a0da2c",
            "nig": "G07021980SE0124b9d357ef11548c698feacaa43a0da2c",
            "nama": "Fitri Sara",
            "tempatLahir": "Bogor",
            "tanggalLahir": "1980-02-07",
            "alamat": "Jl. Mawar",
            "telepon": "08112327590"
        },
        {
            "uuidUser": "cb17f1418aa14d42b042236bd92429a7",
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

**URL** : [`http://sivitas.herokuapp.com/api/guru/{uuid}`]
(http://sivitas.herokuapp.com/api/guru/4b9d357ef11548c698feacaa43a0da2c)

**Method** : `GET`

### Success Response

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "uuidUser": "4b9d357ef11548c698feacaa43a0da2c",
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

**URL** : `http://sivitas.herokuapp.com/api/guru`

**Method** : `POST`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"uuidUser": "cb17f1418aa14d42b042236bd92429a7",
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
        "uuidUser": "cb17f1418aa14d42b042236bd92429a7",
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
    "path": "/api/guru"
}
```

## updateGuru

Mengubah data guru.

**URL** : `sivitas.herokuapp.com/api/guru/4b9d357ef11548c698feacaa43a0da2c`

**Method** : `POST`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"uuidUser": "4b9d357ef11548c698feacaa43a0da2c",
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
        "uuidUser": "4b9d357ef11548c698feacaa43a0da2c",
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
    "path": "/api/guru/4b9d357ef11548c698feacaa43a0da2c"
}
```
