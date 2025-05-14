package com.example.bookworm;

// Partner 1: סופיה קריבוביאז - 330480781
// Partner 2: תומר כץ - 322770520
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    // Reacts to clicking :)
    public interface OnButtonClick { void click(Book b); }

    private final OnButtonClick listener; // who to tell when it gets clicked
    private final boolean       listMode; // true = “my list”

    // constructor
    public BookAdapter(Context ctx, List<Book> data,
                       OnButtonClick l, boolean listMode) {
        super(ctx, R.layout.book_cardview, data);
        this.listener = l;
        this.listMode = listMode;
    }

    // Gives the ListView one row to display
    @NonNull
    @Override public View getView(int p,@Nullable View v,@NonNull ViewGroup g){
        if(v==null)
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.book_cardview,g,false);

        // current book on display
        Book b = getItem(p);

        // title and author
        ((TextView)v.findViewById(R.id.book_title)).setText(b.title);
        ((TextView)v.findViewById(R.id.author)).setText(b.author);

        // Cover
        ImageView iv = v.findViewById(R.id.book_picture);
        Picasso.get().load(b.coverRes).into(iv);           // local drawable

        // action button
        Button btn = v.findViewById(R.id.add_to_list_btn);
        btn.setText(listMode ? R.string.set_reminder
                : R.string.add_to_list);
        btn.setOnClickListener(view -> listener.click(b));

        return v;
    }
}
