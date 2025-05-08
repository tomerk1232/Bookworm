package com.example.bookworm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public interface OnButtonClick { void click(Book b); }

    private final OnButtonClick listener;
    private final boolean       listMode; // true = “my list”

    public BookAdapter(Context ctx, List<Book> data,
                       OnButtonClick l, boolean listMode) {
        super(ctx, R.layout.book_cardview, data);
        this.listener = l;
        this.listMode = listMode;
    }

    @NonNull
    @Override public View getView(int p,@Nullable View v,@NonNull ViewGroup g){
        if(v==null)
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.book_cardview,g,false);

        Book b = getItem(p);

        ((TextView)v.findViewById(R.id.book_title)).setText(b.title);
        ((TextView)v.findViewById(R.id.author)).setText(b.author);

        // Cover
        ImageView iv = v.findViewById(R.id.book_picture);
        iv.setImageResource(b.coverRes);           // local drawable
        //  Bonus Glide:
        //  Glide.with(getContext()).load(b.coverUrl).into(iv);

        Button btn = v.findViewById(R.id.add_to_list_btn);
        btn.setText(listMode ? R.string.set_reminder
                : R.string.add_to_list);
        btn.setOnClickListener(view -> listener.click(b));

        return v;
    }
}
