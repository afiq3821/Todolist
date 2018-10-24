package com.mochamadahya.mytodolist.model;

public class BarangJava {

    public static final String NAMA_TABEL = "tb_barang";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BARANG = "barang";
    public static final String COLUMN_HARGA = "harga";
    public static final String COLUMN_KATEGORI = "kategori";
    public static final String COLUMN_STOK = "stok";
    public static final String COLUMN_TOTALHARGA = "totalharga";
    public static final String COLUMN_LABA = "laba";
    public static final String COLUMN_RUGI = "rugi";


    public BarangJava(int id, String barang, int harga, String kategori, int stok, int totalharga, int laba) {
        this.id = id;
        this.barang = barang;
        this.harga = harga;
        this.kategori = kategori;
        this.stok = stok;
        this.totalharga = totalharga;
        this.laba = laba;
    }

    private int id;
    private String barang;
    private int harga;
    private String kategori;
    private int stok;
    private int totalharga;
    private int laba;
    private int rugi;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(int totalharga) {
        this.totalharga = totalharga;
    }

    public int getLaba() {
        return laba;
    }

    public void setLaba(int laba) {
        this.laba = laba;
    }

    public int getRugi() {
        return rugi;
    }

    public void setRugi(int rugi) {
        this.rugi = rugi;
    }

    public static final String BUAT_TABEL = "CREATE TABLE"
            + NAMA_TABEL + "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENt,"
            + COLUMN_BARANG +  "TEXT,"
            + COLUMN_HARGA +  "INTEGER,"
            + COLUMN_KATEGORI +  "TEXT,"
            + COLUMN_STOK +  "INTEGER,"
            + COLUMN_TOTALHARGA +  "INTEGER,"
            + COLUMN_LABA +  "INTEGER,"
            + COLUMN_RUGI +  "INTEGER" + ")";






}
