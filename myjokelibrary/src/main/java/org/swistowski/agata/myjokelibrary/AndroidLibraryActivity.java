package org.swistowski.agata.myjokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_library);
        Intent intent = getIntent();
        String joke = intent.getStringExtra("joke");
        TextView jokeTextView = findViewById(R.id.joke_text_view);
        jokeTextView.setText(joke);
    }
}
