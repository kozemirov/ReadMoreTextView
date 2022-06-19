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

import java.util.Collections;

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
    int newLinesIndentSize = 0;

    public ReadMoreTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme()
                              .obtainStyledAttributes(attrs, R.styleable.ReadMoreTextView, 0, 0);
        try {
            text = a.getString(R.styleable.ReadMoreTextView_text);
            showLessText = a.getString(R.styleable.ReadMoreTextView_showLessText);
            readMoreText = a.getString(R.styleable.ReadMoreTextView_readMoreText);
            hide = a.getBoolean(R.styleable.ReadMoreTextView_hidden, true);
            lineLimit = a.getInteger(R.styleable.ReadMoreTextView_limit, 4);
            textSize = a.getFloat(R.styleable.ReadMoreTextView_textSize, 12);
            textColor = a.getColor(R.styleable.ReadMoreTextView_color, Color.GRAY);
            justification = a.getInteger(R.styleable.ReadMoreTextView_justificationMode, 1);
            newLinesIndentSize = a.getInteger(R.styleable.ReadMoreTextView_newLineIndent, 0);
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


        des.setText(addIndentsForNewLines(text));
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

    private String addIndentsForNewLines(String text) {
        String indent = String.join("",Collections.nCopies(newLinesIndentSize, "\t"));
        text = new StringBuilder(text).insert(0, indent).toString();
        text = text.replaceAll("\n", "\n"+indent);
        return text;
    }

    public void setText(String text) {
        if (des != null)
            des.setText(addIndentsForNewLines(text));
    }

    public String getText() {
        if (des != null)
            return (String) des.getText();
        return "";
    }
}
