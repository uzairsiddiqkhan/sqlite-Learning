package com.example.booklibrarysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.booklibrarysqlite.databinding.ActivityAddBinding;


public class add_activity extends AppCompatActivity {
    ActivityAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // the label of the book is change through mainfest
        // and the main Activity is declare as aparent to that activity through manifest

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myHelper m =new myHelper(add_activity.this);
                m.addBooks(binding.bookTitle.getText().toString().trim(),
                        binding.bookAuthor.getText().toString().trim(),
//                Integer.parseInt(binding.bookPages.getText().toString().trim()) // the method by me
                        Integer.valueOf(binding.bookPages.getText().toString().trim())
                );
            }
        });






        }
}