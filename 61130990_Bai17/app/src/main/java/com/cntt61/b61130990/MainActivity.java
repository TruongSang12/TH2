package com.cntt61.b61130990;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listData;
    ArrayAdapter adapter;
    Context context;
    TextView textView;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        textView = (TextView) findViewById(R.id.textviewlist);
        listView = (ListView) findViewById(R.id.listview);
        button = (Button) findViewById(R.id.buttonNhap);
        editText = (EditText) findViewById(R.id.edt);
        listData = new ArrayList<>();
        listData.add("Tý");
        listData.add("Tèo");
        listData.add("Bin");
        adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editText.getText().toString();
                listData.add(item);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String val = (String) listView.getItemAtPosition(i);
                textView.setText("position: " + i + "\t" + ";" + "\t"  + "value: " + val);
            }
        });

    }
}