package com.example.bookworm;
// Partner 1: סופיה קריבוביאז - 330480781
// Partner 2: תומר כץ - 322770520
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BrowseBooksActivity extends AppCompatActivity {
    // Called when an activity is first created
    @Override protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_browse_books_view);

        // 1. Find ListView in the layout
        ListView lv = findViewById(R.id.books_lv);

        // Create the adapter (false = browse mode, shows "Add to list")
        BookAdapter ad = new BookAdapter(
                this,
                LibraryStore.get().catalog, // all the books in the library
                b -> {
                    LibraryStore.get().myList.add(b); // add to list
                    Toast.makeText(this, R.string.added, Toast.LENGTH_SHORT).show(); // quick message
                },
                false);
        // 3. Attach the adapter to the ListView
        lv.setAdapter(ad);
    }
}
