package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int record_score = 0;
    RecordDataHelper recordDBconnector;
    Button btn_select,btn_update;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        btn_select = findViewById(R.id.button);
        btn_update=findViewById(R.id.button2);
        edit = findViewById(R.id.edit);
        recordDBconnector = new RecordDataHelper(this);
        record_score = recordDBconnector.select();
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                record_score = recordDBconnector.select();
                textView.setText(record_score+"");


            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                record_score=Integer.parseInt(edit.getText().toString());
                recordDBconnector.update(record_score);
            }
        });
    }
}