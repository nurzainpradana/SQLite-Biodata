package com.zainpradana.sqlitebiodata;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbbiodata.db" ;
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE biodata(nomor integer PRIMARY KEY, nama text, tgl text, jk text, alamat text)");
        db.execSQL("INSERT INTO biodata (nomor, nama, tgl, jk, alamat) VALUES (101, 'Mia', '2002-07-12', 'Perempuan','Bekasi')");
        db.execSQL("INSERT INTO biodata (nomor, nama, tgl, jk, alamat) VALUES (102, 'Dani', '1996-07-12', 'Laki-laki','Jakarta')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE biodata");
    }
}