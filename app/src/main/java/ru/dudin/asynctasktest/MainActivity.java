package ru.dudin.asynctasktest;

/**
 * In this program I used Listener pattern to get data from AsyncTask.
 *
 * @created 07.03.2019
 * @author Andrey Dudin <programmer1973@mail.ru>
 * @version 0.1.0.2019.03.07
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private AsyncTaskTestClass mAsyncTaskTestClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.text_view);

        mAsyncTaskTestClass = new AsyncTaskTestClass();

        mAsyncTaskTestClass.registerListener(new AsyncTaskTestClass.Listener() {
            @Override
            public void setText(String text) {
                mTextView.setText(text);
            }
        });

        findViewById(R.id.button_on_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAsyncTaskTestClass.execute("file1", "file2", "file3", "file4", "file5");
            }
        });

        findViewById(R.id.button_on_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAsyncTaskTestClass.onCancelled();
            }
        });
    }
}