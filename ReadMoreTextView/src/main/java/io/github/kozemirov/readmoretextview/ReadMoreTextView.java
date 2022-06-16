package io.github.kozemirov.readmoretextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
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
    Float textSize;
    int textColor;
    TextView des;
    TextView button;
    int justification;
    String showLessText;
    String readMoreText;

    public ReadMoreTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme()
                              .obtainStyledAttributes(attrs, R.styleable.ReadMoreTextView, 0, 0);
        try {
            text = a.getString(R.styleable.ReadMoreTextView_text);
            showLessText = a.getString(R.styleable.ReadMoreTextView_showLessText);
            readMoreText = a.getString(R.styleable.ReadMoreTextView_readMoreText);
            text = a.getString(R.styleable.ReadMoreTextView_text);
            hide = a.getBoolean(R.styleable.ReadMoreTextView_hidden, true);
            lineLimit = a.getInteger(R.styleable.ReadMoreTextView_limit, 4);
            textSize = a.getFloat(R.styleable.ReadMoreTextView_textSize, 12);
            textColor = a.getColor(R.styleable.ReadMoreTextView_color, Color.GRAY);
            justification = a.getInteger(R.styleable.ReadMoreTextView_justificationMode, 1);
        } finally {
            a.recycle();
        }

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View parent = inflater.inflate(R.layout.read_more_text_view, this, true);

        if (showLessText == null)
            showLessText = context.getString(R.string.show_less);
        if (readMoreText == null)
            readMoreText = context.getString(R.string.read_more);


        des = parent.findViewById(R.id.description);
        button = parent.findViewById(R.id.button);

        des.setText(text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            des.setJustificationMode(justification);
        }
        des.setMaxLines(MAX_LINES);
        des.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        des.setTextColor(textColor);

        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        button.setTextColor(textColor);

        if (hide) {
            des.setMaxLines(lineLimit);
            button.setText(readMoreText);
        } else {
            button.setText(showLessText);
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
