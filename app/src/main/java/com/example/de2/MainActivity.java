package com.example.de2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtTenKH,txtSL,txtNguon,txtDich;
    EditText edtTenKH,edtSL;
    Button btnHT,btnNLai;
    static KHDatabase db;
    RadioButton rbtn1,rbtn2,rbtn3,rbtn4,rbtn5,rbtn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTenKH = findViewById(R.id.txtTenKH);
        txtSL = findViewById(R.id.txtSL);
        edtTenKH= findViewById(R.id.edtTenKH);
        edtSL = findViewById(R.id.edtSL);
        txtNguon = findViewById(R.id.txtNguon);
        txtDich = findViewById(R.id.txtDich);
        btnHT = findViewById(R.id.btnHT);
        btnNLai = findViewById(R.id.btnNLai);
        rbtn1=findViewById(R.id.rbtn1);
        rbtn2=findViewById(R.id.rbtn2);
        rbtn3=findViewById(R.id.rbtn3);
        rbtn4=findViewById(R.id.rbtn4);
        rbtn5=findViewById(R.id.rbtn5);
        rbtn6=findViewById(R.id.rbtn6);
        db = new KHDatabase(MainActivity.this);
        btnNLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtTenKH.setText("");
                edtSL.setText("");
            }
        });
        btnHT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenKH = edtTenKH.getText().toString();
                String soLuong = edtSL.getText().toString();
                String nguon = "";
                String dich = "";
                if(rbtn1.isChecked()){
                    nguon+=rbtn1.getText().toString();
                }else if (rbtn2.isChecked()){
                    nguon+=rbtn2.getText().toString();
                }else{
                    nguon+=rbtn3.getText().toString();
                }
                if(rbtn4.isChecked()){
                    dich+=rbtn4.getText().toString();
                }else if (rbtn5.isChecked()){
                    dich+=rbtn5.getText().toString();
                }else{
                    dich+=rbtn6.getText().toString();
                }

                KHModel KHthem = new KHModel(tenKH,soLuong,nguon,dich);
                    db.ThemKH(KHthem);
                    Cursor cursor = db.HT();
                    while (cursor.moveToNext()){
                        int id = cursor.getInt(0);
                        String name = cursor.getString(1);
                        String sl = cursor.getString(2);
                        String n = cursor.getString(3);
                        String d = cursor.getString(4);
                        Toast.makeText(MainActivity.this, name+"\t"+sl+"\t"+n+"\t"+d, Toast.LENGTH_SHORT).show();
                    }

                }
        });
    }
}