package com.example.bookworm;

import java.util.ArrayList;
import java.util.List;

public class LibraryStore {
    private static final LibraryStore INSTANCE = new LibraryStore();
    public static LibraryStore get() { return INSTANCE; }

    /** כל הספרים בספריה */
    public final List<Book> catalog   = new ArrayList<>();
    /** ספרי המשתמש */
    public final List<Book> myList    = new ArrayList<>();

    private LibraryStore() {
        catalog.add(new Book("Clean Code", "Robert C. Martin",
                R.color.black));
        catalog.add(new Book("The Pragmatic Programmer",
                "Hunt & Thomas", R.color.black));
        // … add 8-10 total
    }
}
