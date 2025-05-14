package com.example.bookworm;
// Partner 1: סופיה קריבוביאז - 330480781
// Partner 2: תומר כץ - 322770520
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
        catalog.add(new Book("The Master and Margarita", "Mikhail Bulgakov", R.drawable.cover2));
        catalog.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", R.drawable.cover1));
        // … add 8-10 total
    }
}
