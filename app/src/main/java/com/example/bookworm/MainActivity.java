package com.example.bookworm;
// Partner 1: סופיה קריבוביאז - 330480781
// Partner 2: תומר כץ - 322770520
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Called when an activity is first created
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Browse books button
        findViewById(R.id.browse_books).setOnClickListener(v ->
                startActivity(new Intent(this, BrowseBooksActivity.class)));

        // My List button
        findViewById(R.id.my_books).setOnClickListener(v ->
                startActivity(new Intent(this, MyListActivity.class)));
    }
}
