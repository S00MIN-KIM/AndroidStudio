package com.example.study8_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";
//앱을 실행할 때 실행
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);
        //임시저장한 내용 불러옴 (앱 삭제하면 삭제되는 데이터)
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("저장된 문구", "");
        et_save.setText(value);


    }
//앱을 종료 시킬 때. 액티비티 빠져나올 때 실행
    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        //항상 에디터 불러와야함
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //문구 받아서 스트링으로 저장
        String value = et_save.getText().toString();
        //에디터에 보냄
        editor.putString("저장된 문구", value);
        //세이브 완료
        editor.commit();
    }
}