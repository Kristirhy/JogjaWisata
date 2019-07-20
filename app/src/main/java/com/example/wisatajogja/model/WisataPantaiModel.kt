package com.example.wisatajogja.model

import com.google.gson.annotations.SerializedName

class WisataPantaiModel {
    @SerializedName("id_wisata")
    lateinit var idWisata: String

    @SerializedName("nama_wisata")
    lateinit var nmWisata: String

    @SerializedName("deskripsi")
    lateinit var deskripsi: String

    @SerializedName("alamat")
    lateinit var alamat: String

    @SerializedName("id_kategori")
    lateinit var idKategori: String

    @SerializedName("foto")
    lateinit var imgWisata: String

    @SerializedName("updated_at")
    lateinit var updated: String

    @SerializedName("created_at")
    lateinit var created: String

    @SerializedName("kategori")
    lateinit var nmKategori: String


    constructor() {}

    constructor(
        idWisata: String, nmWisata: String, deskripsi: String, alamat: String, idKategori: String, imgWisata: String,
        updated: String, created: String, nmKategori: String
    ) {
        this.idWisata = idWisata
        this.nmWisata = nmWisata
        this.deskripsi = deskripsi
        this.alamat = alamat
        this.idKategori = idKategori
        this.imgWisata = imgWisata
        this.updated = updated
        this.created = created
        this.nmKategori = nmKategori

    }
}
