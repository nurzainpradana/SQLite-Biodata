package com.zainpradana.sqlitebiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class LihatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnKembali;
    EditText ned1, ned2, ned3, ned4, ned5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);
        dbHelper = new DataHelper(this);
        ned1 = (EditText) findViewById(R.id.ed1);
        ned2 = (EditText) findViewById(R.id.ed2);
        ned3 = (EditText) findViewById(R.id.ed3);
        ned4 = (EditText) findViewById(R.id.ed4);
        ned5 = (EditText) findViewById(R.id.ed5);
        btnKembali = (Button) findViewById(R.id.btn_Kembali);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'" , null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            ned1.setText(cursor.getString(0).toString());
            ned2.setText(cursor.getString(1).toString());
            ned3.setText(cursor.getString(2).toString());
            ned4.setText(cursor.getString(3).toString());
            ned5.setText(cursor.getString(4).toString());
        }
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        } );
    }
}