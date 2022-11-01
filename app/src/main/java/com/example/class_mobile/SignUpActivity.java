package com.example.class_mobile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private final long finishtimeed = 1000;
    private long presstime = 0;
    EditText editText_id,editText_pw,editText_name,editText_phone,editText_address;
    Button register;

    SharedPreferences preferences;




    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editText_id=findViewById(R.id.id_edittext);
        editText_pw=findViewById(R.id.password_edittext);
        editText_name=findViewById(R.id.name_edittext);
        editText_phone=findViewById(R.id.phone_edittext);
        editText_address=findViewById(R.id.address_edittext);
        register=findViewById(R.id.btn_signup_completed);

        preferences = getSharedPreferences("Userinfo", 0);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userIdValue =  editText_id.getText().toString();
                String passwordValue = editText_pw.getText().toString();
                String nameValue = editText_name.getText().toString();
                String phoneValue = editText_phone.getText().toString();
                String addressValue = editText_address.getText().toString();

                if(userIdValue.length()>1){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("editText_id",userIdValue);
                    editor.putString("editText_pw",passwordValue);
                    editor.putString("editText_name",nameValue);
                    editor.putString("editText_phone",phoneValue);
                    editor.putString("editText_address",addressValue);
                    editor.apply();
                    Toast.makeText(SignUpActivity.this, "저장되었습니다.", Toast.LENGTH_SHORT).show();}


                    else{
                        Toast.makeText(SignUpActivity.this, "비어 있는 값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    }



            }
        });



    }

//    public void btnsignup(View view) {    // Set버튼 클릭 시    SharedPreferences에 값 저장.
//        if(use)
//        { // 공백 또는 size=0이면
//            Toast.makeText(this, "비어 있는 값을 입력해주세요.", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            SharedPreferences sharedPreferences= getSharedPreferences("myPreferences", MODE_PRIVATE);    // test 이름의 기본모드 설정
//            SharedPreferences.Editor editor= sharedPreferences.edit(); //sharedPreferences를 제어할 editor를 선언
//            editor.putString( "inputext" ,editText.getText().toString()); //edtPassword.getText().toString(),edtName.getText().toString(), edtPhone.getText().toString(), edtAddress.getText().toString() ); // key,value 형식으로 저장
//            editor.commit();    //최종 커밋. 커밋을 해야 저장이 된다.
//            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
//
//        }
//    }



//    뒤로가기 버튼
        @Override
        public void onBackPressed () {
            long tempTime = System.currentTimeMillis();
            long intervalTime = tempTime - presstime;

            if (0 <= intervalTime && finishtimeed >= intervalTime) {
                finish();
            } else {
                presstime = tempTime;
                Toast.makeText(getApplicationContext(), "더블클릭시 이전 창으로 이동", Toast.LENGTH_SHORT).show();
            }
        }
     }

