package com.bwie.liushi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bwie.liushi.witget.CustomView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText edt;
    private Button but;
    private CustomView afl_cotent;
    private LayoutInflater layoutInflater;
    private TextView tvAttrTag;
    private List<String> list2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        edt =  findViewById(R.id.edt);
        but = findViewById(R.id.but);
        afl_cotent =findViewById(R.id.afl_cotent);
        layoutInflater = LayoutInflater.from(this);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edt.getText().toString();
                View item = layoutInflater.inflate(R.layout.sub_item, null);
                tvAttrTag =item.findViewById(R.id.tv_attr_tag);
                list2.add(s);
                for (int i = 0; i < list2.size(); i++) {
                    tvAttrTag.setText(list2.get(i));
                    tvAttrTag.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, CartActivity.class);
                            startActivity(intent);
                        }
                    });
                }
                afl_cotent.addView(item);
            }
        });
    }

}
