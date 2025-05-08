package com.example.bookworm;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;

public class MyListActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_my_list);

        ListView lv = findViewById(R.id.my_books_lv);

        BookAdapter ad = new BookAdapter(
                this,
                LibraryStore.get().myList,
                this::openDatePicker,
                true);
        lv.setAdapter(ad);

        checkOverdue();
    }

    // Pick a return date and attach to the book
    private void openDatePicker(Book book) {
        LocalDate today = LocalDate.now();
        DatePickerDialog dlg = new DatePickerDialog(
                this,
                (view, y, m, d) -> {
                    book.dueDate = LocalDate.of(y, m + 1, d);
                    Toast.makeText(this, R.string.reminder_set,
                            Toast.LENGTH_SHORT).show();
                },
                today.getYear(), today.getMonthValue() - 1, today.getDayOfMonth());
        dlg.show();
    }

    private void checkOverdue() {
        LocalDate now = LocalDate.now();
        boolean late = false;
        for (Book b : LibraryStore.get().myList)
            if (b.dueDate != null && b.dueDate.isBefore(now))
                late = true;
        if (late)
            Toast.makeText(this, R.string.overdue, Toast.LENGTH_LONG).show();
    }
}
