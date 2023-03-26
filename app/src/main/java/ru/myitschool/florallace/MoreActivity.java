package ru.myitschool.florallace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MoreActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

//        ImageButton person = findViewById(R.id.more_button); // находим кнопку по id
//        person.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MoreActivity.this, MainActivity.class);
//                startActivity(intent);
//                overridePendingTransition(0, 0);
//            }
//        });

    }



}