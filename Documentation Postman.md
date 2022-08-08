
# Project Tabungan



<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->


## Variables

| Key | Value | Type |
| --- | ------|-------------|
| base_url | http://localhost:8000 | string |



## Endpoints

* [Nasabah](#nasabah)
    1. [Find All Nasabah](#1-find-all-nasabah)
    1. [Find By ID Nasabah](#2-find-by-id-nasabah)
    1. [Insert Nasabah](#3-insert-nasabah)
    1. [Update Nasabah](#4-update-nasabah)
    1. [Delete Nasabah](#5-delete-nasabah)
* [Rekening](#rekening)
    1. [Cek Rekening Nasabah](#1-cek-rekening-nasabah)
    1. [Insert Rekening](#2-insert-rekening)
* [Transaksi](#transaksi)
    1. [Insert Transaksi](#1-insert-transaksi)
    1. [Delete Transaksi](#2-delete-transaksi)
    1. [FInd Transaksi By Date](#3-find-transaksi-by-date)
    1. [Find Transaksi By Rekening](#4-find-transaksi-by-rekening)

--------



## Nasabah



### 1. Find All Nasabah



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/api/nasabah/find-all
```



### 2. Find By ID Nasabah



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/api/nasabah/find-by-id/1
```



### 3. Insert Nasabah



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/nasabah/insert
```



***Body:***

```js        
{
    "namaDepan" : "Ary",
    "namaBelakang" : "Herdanu",
    "tempatLahir" : "Jakarta",
    "tanggalLahir" : "01/11/1997",
    "jenisKelamin" : "laki-laki",
    "alamat" : "GDC Depok",
    "noHandphone" : "081278909111"
}
```



### 4. Update Nasabah



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/api/nasabah/update/5
```



***Body:***

```js        
{
    "namaDepan": "Muhammad",
    "namaBelakang": "Farizi",
    "tempatLahir": "Jakarta",
    "tanggalLahir": "31/07/2000",
    "jenisKelamin": "laki-laki",
    "alamat": "Permata Duta",
    "noHandphone": "081152394832"
}
```



### 5. Delete Nasabah



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/nasabah/delete/11
```



## Rekening



### 1. Cek Rekening Nasabah



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/rekening/cek-nasabah/7708001
```



### 2. Insert Rekening



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/api/rekening/insert/21
```



***Body:***

```js        
{}
```



## Transaksi



### 1. Insert Transaksi



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{base_url}}/transaksi/insert/121002080039
```



### 2. Delete Transaksi



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/transaksi/delete/2
```



### 3. FInd Transaksi By Date



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/transaksi/date/14062022
```



### 4. Find Transaksi By Rekening



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/transaksi/no-rekening/7708002
```



---
[Back to top](#project-tabungan)

>Generated at 2022-08-08 16:55:22 by [docgen](https://github.com/thedevsaddam/docgen)
