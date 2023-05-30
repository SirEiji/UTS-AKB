package com.example.notes10112934.ui.dashboard;

/*
    NIM     : 10119234
    NAMA    : ARHAM JUSNI INDRAWAN
    KELAS   : IF-4
 */

import java.io.Serializable;

public class Note implements Serializable {
    String id;
    String judul;
    String kategori;
    String isi;
    String tgl;

    public Note(String id, String judul, String kategori, String isi, String tgl){
        this.id = id;
        this.judul = judul;
        this.kategori = kategori;
        this.isi = isi;
        this.tgl = tgl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String date) {
        this.tgl = tgl;
    }
}
