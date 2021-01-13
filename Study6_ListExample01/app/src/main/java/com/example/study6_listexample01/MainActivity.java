package com.example.study6_listexample01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        //실제 데이터
        List<String> data = new ArrayList<String>();
        //중간 연결 역할
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data); //현재 엑티비티
        //리스트뷰에 세팅
        list.setAdapter(adapter);
        data.add("item1");
        data.add("item2");
        data.add("item3");
        //변경사항 저장
        adapter.notifyDataSetChanged();
    }

}