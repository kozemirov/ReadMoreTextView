package io.github.kozemirov.readmoretextview.sample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import io.github.kozemirov.readmoretextview.ReadMoreTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReadMoreTextView view = (ReadMoreTextView) findViewById(R.id.readMoreTextView);
    }
}
