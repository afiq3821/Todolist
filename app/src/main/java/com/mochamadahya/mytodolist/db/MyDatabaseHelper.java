package com.mochamadahya.mytodolist.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mochamadahya.mytodolist.fragment.Todo;
import com.mochamadahya.mytodolist.model.TodoJava;

import java.util.ArrayList;
import java.util.List;


public class MyDatabaseHelper extends SQLiteOpenHelper{

    //nama database
    private static final String NAMA_DATABASE = "db_todo";
    //versi database
    private static final int VERSI_DATABASE = 1;

    //Constructor
    public MyDatabaseHelper (Context context){
        super(context, NAMA_DATABASE, null,VERSI_DATABASE);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        //menjalankan perintah sekali, ketika pertama kali di install
        db.execSQL(TodoJava.BUAT_TABEL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //jika table ada sebelumnya, maka hapus table yang telah ada
        db.execSQL("DROP TABLE IF EXISTS " + TodoJava.NAMA_TABEL);

        //buat table lagi
        onCreate(db);
    }

    //fungsi untuk menyimpan data
    public long simpanData(String nama, String deskripsi,String kategori){
        // akses database untuk menambah data
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // komponen untuk menyimpan value data
        ContentValues contentValues = new ContentValues();
        // memasukkan data ke dalam contentValues
        contentValues.put(TodoJava.COLUMN_NAMA, nama);
        contentValues.put(TodoJava.COLUMN_DESKRIPSI, deskripsi);
        contentValues.put(TodoJava.COLUMN_KATEGORI, kategori);


        //memasukkan data row
        long id = sqLiteDatabase.insert(TodoJava.NAMA_TABEL, null,contentValues);

        //tutup database
        sqLiteDatabase.close();

        //keluarkan hasil id dari proses menyimpan data
        return id;

    }

    // mengambil 1 row data berdasarkan id
    public TodoJava getTodo (long id){
        //minta akses mengambil data
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //posisikan cursor tabel ke data yang di tuju
        Cursor cursor = sqLiteDatabase.query(TodoJava.NAMA_TABEL, new String[]{TodoJava.COLUMN_ID, TodoJava.COLUMN_NAMA,
        TodoJava.COLUMN_DESKRIPSI, TodoJava.COLUMN_WAKTU, TodoJava.COLUMN_KATEGORI}, TodoJava.COLUMN_ID + "?=",
                new String[]{String.valueOf(id)}, null,null,null,null);

        //posisikan data yang dipilih cursor ke paling atas
        //posisikan cursor ke data

        if (cursor != null){
            cursor.moveToFirst();
        }

        //data yang ditemukan cursor dimasukkan ke dalam model
        TodoJava todoJava = new TodoJava(
                cursor.getInt(cursor.getColumnIndex(TodoJava.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(TodoJava.COLUMN_NAMA)),
                cursor.getString(cursor.getColumnIndex(TodoJava.COLUMN_DESKRIPSI)),
                cursor.getString(cursor.getColumnIndex(TodoJava.COLUMN_WAKTU)),
                cursor.getString(cursor.getColumnIndex(TodoJava.COLUMN_KATEGORI))
        );

        //hilangkan cursor beserta koneksi database
        cursor.close();

        //kembalikan data
        return todoJava;

    }

    // mengambil seluruh data
    public List<TodoJava> ambilSemuaData(){
        List<TodoJava>listTodo = new ArrayList<>();

        //Query mengambil semua data
        String query = "SELECT * FROM WHERE" + TodoJava.NAMA_TABEL + " ORDER BY " + TodoJava.COLUMN_WAKTU + " DESC";
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);


        if (cursor.moveToFirst()){
            do {
                TodoJava todoJava =  new TodoJava();

                todoJava.setId(cursor.getInt(cursor.getColumnIndex(TodoJava.COLUMN_ID)));
                todoJava.setNama(cursor.getString(cursor.getColumnIndex(TodoJava.COLUMN_NAMA)));
                todoJava.setDeskripsi(cursor.getString(cursor.getColumnIndex(TodoJava.COLUMN_DESKRIPSI)));
                todoJava.setWaktu(cursor.getString(cursor.getColumnIndex(TodoJava.COLUMN_WAKTU)));
                todoJava.setKategori(cursor.getString(cursor.getColumnIndex(TodoJava.COLUMN_KATEGORI)));


                listTodo.add(todoJava);
            } while (cursor.moveToNext());
        }
        // tutup koneksi
        sqLiteDatabase.close();

        //
        return listTodo;
    }

    public int ambilJumlahData(){
        // query mengambil seluruh data
        String query = "SELECT * FROM " + TodoJava.NAMA_TABEL;
        //buka database, izin membaca data
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        // arahkan cursor pada data yang dituju
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        // tampung jumlah seluruh data di variable
        int jumlah = cursor.getCount();
        //tutup database
        cursor.close();
        // hasilkan jumlah data
        return jumlah;
    }

    public int updateTodo(TodoJava todoJava){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TodoJava.COLUMN_NAMA, todoJava.getNama());
        values.put(TodoJava.COLUMN_DESKRIPSI, todoJava.getDeskripsi());
        values.put(TodoJava.COLUMN_KATEGORI, todoJava.getKategori());

        return sqLiteDatabase.update(TodoJava.NAMA_TABEL, values, TodoJava.COLUMN_ID + " =? ",
                new String[]{String.valueOf(todoJava.getId())});
    }

    public void hapusData(TodoJava todoJava){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TodoJava.NAMA_TABEL, TodoJava.COLUMN_ID + " =?",
                new String[]{String.valueOf(todoJava.getId())});
    }
}
