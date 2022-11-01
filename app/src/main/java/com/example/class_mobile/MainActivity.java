package com.example.class_mobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;





public class MainActivity extends AppCompatActivity {
    private final long finishtimeed = 1000;
    private long presstime = 0;
    EditText edtUserId, edtUerPw;
    Button btnLogin, btnSignup;
    SharedPreferences preferences;
    TextView txtInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //회원가입 버튼 클릭 시 회원가입 페이지로 이동

        Button signup_button = (Button) findViewById(R.id.signup_button);
        signup_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });


        // 홈 화면 버튼 클릭 상품 페이지로 이동
        ImageButton market_button = (ImageButton) findViewById(R.id.market_button);
        market_button.setBackgroundResource(R.drawable.market_icon);
        market_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ProductActivity.class);
                startActivity(intent);
            }
        });

        edtUserId = findViewById(R.id.login_id_edittext);
        edtUerPw = findViewById(R.id.login_password_edittext);
        btnLogin = findViewById(R.id.login_button);
        btnSignup = findViewById(R.id.signup_button);

        preferences = getSharedPreferences("Userinfo", 0);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userIdValue = edtUserId.getText().toString();
                String passwordValue = edtUerPw.getText().toString();

                String registerUserid = preferences.getString("editText_id","");
                String registerPassword = preferences.getString("editText_pw","");

                if(userIdValue.equals(registerUserid) && passwordValue.equals(registerPassword) ){
                    Intent intent = new Intent(getApplicationContext(),ProductActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.", Toast.LENGTH_SHORT).show();
                }


            }
        });




       }












    // 뒤로가기버튼
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - presstime;

        if (0 <= intervalTime && finishtimeed >= intervalTime)
        {
            finish();
        }
        else
        {
            presstime = tempTime;
            Toast.makeText(getApplicationContext(), "더블클릭시 이전 창으로 이동", Toast.LENGTH_SHORT).show();
        }
    }




}