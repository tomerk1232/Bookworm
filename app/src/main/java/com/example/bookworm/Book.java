package com.example.bookworm;

import androidx.annotation.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** מודל בסיסי */
public class Book {
    public final String title;
    public final String author;
    public final int    coverRes;      // drawable (for Glide: keep a URL string)
    public @Nullable LocalDate dueDate;

    public Book(String t, String a, int r) {
        title = t;  author = a;  coverRes = r;
    }
}
