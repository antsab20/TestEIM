package com.example.e2500108.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.cancel:
                    setResult(RESULT_CANCELED, null);
                    break;
                case R.id.Ok_button:
                    setResult(RESULT_OK, null);
                    break;
            }

            finish();
        }
    }

    private Button cancel, ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        textView = findViewById(R.id.text_show);
        if (intent != null) {
            String text = intent.getStringExtra("MY_TEXT");
            textView.setText(text);
        }

        cancel = findViewById(R.id.cancel);
        ok = findViewById(R.id.Ok_button);

        cancel.setOnClickListener(buttonClickListener);
        ok.setOnClickListener(buttonClickListener);

    }
}
