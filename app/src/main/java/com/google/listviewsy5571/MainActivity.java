package com.google.listviewsy5571;

import android.content.DialogInterface;
import android.graphics.Color;
import androidx.appcompat.app.AlertDialog;
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
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        aradpt = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listItem);
        listView.setAdapter(aradpt);
//        v1.setBackgroundColor(Color.WHITE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.RED);
                 Toast.makeText(MainActivity.this, "you select "+listItem[position], Toast.LENGTH_SHORT).show();
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("you select "+listItem[position]);
                builder.setTitle("your selection is done");
                builder.setCancelable(false);
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      //  view.setBackgroundColor(Color.WHITE);
                        Toast.makeText(MainActivity.this, "you selected "+listItem[position], Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"You not selected any item",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog =builder.create();
                alertDialog.show();
            }
        });


    }
}