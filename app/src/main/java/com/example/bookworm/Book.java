package com.example.bookworm;
// Partner 1: סופיה קריבוביאז - 330480781
// Partner 2: תומר כץ - 322770520
import androidx.annotation.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** מודל בסיסי */
public class Book {

    // book title
    public final String title;
    // book author
    public final String author;
    // book cover
    public final int    coverRes;

    // Return date chosen by the user – null until they pick one
    public @Nullable LocalDate dueDate;

    // constructor
    public Book(String t, String a, int r) {
        title = t;  author = a;  coverRes = r;
    }
}
