package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.browse_books).setOnClickListener(v ->
                startActivity(new Intent(this, BrowseBooksActivity.class)));

        findViewById(R.id.my_books).setOnClickListener(v ->
                startActivity(new Intent(this, MyListActivity.class)));
    }
}
