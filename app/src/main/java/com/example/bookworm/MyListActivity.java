package com.example.bookworm;
// Partner 1: סופיה קריבוביאז - 330480781
// Partner 2: תומר כץ - 322770520
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;

public class MyListActivity extends AppCompatActivity {

    // Runs when an activity is first created
    @Override protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_my_list);

        // 1. Get the listview from xml
        ListView lv = findViewById(R.id.my_books_lv);

        // 2. Create the adapter in my-list mode (true)
        BookAdapter ad = new BookAdapter(
                this,
                LibraryStore.get().myList, // the books the user added
                this::openDatePicker,   // what to do when the button is pressed
                true); // listmode = true
        lv.setAdapter(ad);

        // 3. Check for overdue books
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
    /**
     * If at least one book’s due date is earlier than today
     * we warn the user with a long Toast.
     */
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
