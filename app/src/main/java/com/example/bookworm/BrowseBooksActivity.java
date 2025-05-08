package com.example.bookworm;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BrowseBooksActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_browse_books_view);

        ListView lv = findViewById(R.id.books_lv);

        BookAdapter ad = new BookAdapter(
                this,
                LibraryStore.get().catalog,
                b -> {
                    LibraryStore.get().myList.add(b);
                    Toast.makeText(this, R.string.added, Toast.LENGTH_SHORT).show();
                },
                false);
        lv.setAdapter(ad);
    }
}
