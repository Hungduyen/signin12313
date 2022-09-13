package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.ControlButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText taikhoan, matkhau;
    Button dangnhap, dangky;
    String ten,mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ControlButton();

    }
    private void ControlButton(){
        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Hộp thoại đăng kí");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.signup);
                EditText dktk = (EditText) dialog.findViewById(R.id.dktk);
                EditText dkmk = (EditText) dialog.findViewById(R.id.dkmk);
                Button dk = (Button) dialog.findViewById(R.id.dk);
                Button dn = (Button) dialog.findViewById(R.id.dn);
                dk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = dktk.getText().toString().trim();
                        mk = dkmk.getText().toString().trim();

                        taikhoan.setText(ten);
                        matkhau.setText(mk);


                        dialog.cancel();
                    }
                });
                dn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        dangnhap.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (taikhoan.getText().length() != 0 && matkhau.getText().length() !=0 ){
                    if (taikhoan.getText().toString().equals(ten) && matkhau.getText().toString().equals(mk)){
                        Toast.makeText(MainActivity.this, "Bạn đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }else if(taikhoan.getText().toString().equals("hung") && matkhau.getText().toString().equals("hung")){
                        Toast.makeText(MainActivity.this, "Bạn đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        }));
    }
    public void AnhXa(){
        taikhoan = (EditText) findViewById(R.id.taikhoan);
        matkhau = (EditText) findViewById(R.id.matkhau);
        dangnhap = (Button) findViewById(R.id.dangnhap);
        dangky = (Button) findViewById(R.id.dangki);
    }
}