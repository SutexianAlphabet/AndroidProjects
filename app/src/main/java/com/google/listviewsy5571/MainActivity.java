package com.google.listviewsy5571;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String [] listItem = {"Sutex","bank","college","of","computer","Applications","and","Science"};
    ArrayAdapter aradpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        aradpt = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listItem);
        listView.setAdapter(aradpt);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "you select "+listItem[i], Toast.LENGTH_SHORT).show();
            }
        });

    }
}