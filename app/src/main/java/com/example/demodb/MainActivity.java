package com.example.demodb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
Button addbtn;
String item;    // used for whose item was selected
int indexval;

ArrayList<String> arrayList=new ArrayList<>();
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addbtn=findViewById(R.id.lv_add_std_name);
        listView=findViewById(R.id.listView);
        arrayList.add("gauri");
        arrayList.add("sagar");
        arrayList.add("diu");
        arrayList.add("raj");
        arrayList.add("Pooja");
        arrayList.add("aditay");
        arrayList.add("sanjana");
        arrayList.add("rahul");


    ArrayAdapter<String> adapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
    listView.setAdapter(adapter);

    addbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ShowAddStudentDialoag();
        }
    private void ShowAddStudentDialoag()
    {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.addstudentlalertbox);
        dialog.setTitle("Add Student");
        EditText editTextStudentName = dialog.findViewById(R.id.Ev_addStd);
        Button addButton = dialog.findViewById(R.id.alert_Add_btn);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentName = editTextStudentName.getText().toString();
                if (!studentName.isEmpty()) {
                    arrayList.add(studentName);
                    adapter.notifyDataSetChanged();
                }
                dialog.dismiss();

            }
        });
        dialog.show();

    }
    });
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.update_dialog_box);
            dialog.setTitle("Update Student");

            EditText UPStudent=findViewById(R.id.Ev_updateStd);
            UPStudent.setText(arrayList.get(position));

            dialog.setContentView(R.layout.update_dialog_box);
            UPStudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String UpdateName=UPStudent.getText().toString();
                    arrayList.set(position,UpdateName);
                    adapter.notifyDataSetChanged();
                }
            });
            dialog.dismiss();
        }
    });
    }
}

