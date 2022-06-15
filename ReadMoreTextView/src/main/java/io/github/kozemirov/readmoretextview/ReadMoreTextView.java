package io.github.kozemirov.readmoretextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;

/**
 * Created by pavel on 15.06.2022.
 */
public class ReadMoreTextView extends LinearLayoutCompat {
    final static int MAX_LINES = 10000;
    boolean hide = true;
    int lineLimit = 4;
    String text;

    TextView des;
    TextView button;

    public ReadMoreTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme()
                              .obtainStyledAttributes(attrs, R.styleable.ReadMoreTextView, 0, 0);
        try {
            text = a.getString(R.styleable.ReadMoreTextView_text);
            hide = a.getBoolean(R.styleable.ReadMoreTextView_hidden, true);
            lineLimit = a.getInteger(R.styleable.ReadMoreTextView_limit, 4);
        } finally {
            a.recycle();
        }

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View parent = inflater.inflate(R.layout.read_more_text_view, this, true);
        des = parent.findViewById(R.id.description);
        button = parent.findViewById(R.id.button);

        des.setMaxLines(MAX_LINES);
        des.setText(text);

        if (hide) {
            des.setMaxLines(lineLimit);
            button.setText(R.string.read_more);
        } else {
            button.setText(R.string.show_less);
        }

        button.setOnClickListener((View v) -> {
            if (hide) {
                des.setMaxLines(MAX_LINES);
                button.setText(R.string.show_less);
                hide = false;
            } else {
                des.setMaxLines(lineLimit);
                button.setText(R.string.read_more);
                hide = true;
            }
        });
    }
}
