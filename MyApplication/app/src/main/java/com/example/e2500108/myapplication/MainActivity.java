package com.example.e2500108.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String SAVED_TEXT = "SAVED_TEXT";

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.nordButton:
                    textView.setText(textView.getText() + "N");
                    break;
                case R.id.sudButton:
                    textView.setText(textView.getText() + "S");
                    break;
                case R.id.estButton:
                    textView.setText(textView.getText() + "E");
                    break;
                case R.id.vestButton:
                    textView.setText(textView.getText() + "V");
                    break;
                case R.id.activ2:
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    String text = textView.getText().toString();
                    intent.putExtra("MY_TEXT", text);
                    startActivityForResult(intent, 1);
                    break;

            }
        }
    }

    private Button butnSud, butnNord, butnEst, butnVest, activion2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (savedInstanceState != null) {
            textView = findViewById(R.id.text);
            textView.setText(savedInstanceState.getString(SAVED_TEXT));
        } else {
            textView = findViewById(R.id.text);
        }

        butnNord = findViewById(R.id.nordButton);
        butnSud =  findViewById(R.id.sudButton);
        butnEst = findViewById(R.id.estButton);
        butnVest = findViewById(R.id.vestButton);
        activion2 = findViewById(R.id.activ2);

        butnNord.setOnClickListener(buttonClickListener);
        butnSud.setOnClickListener(buttonClickListener);
        butnEst.setOnClickListener(buttonClickListener);
        butnVest.setOnClickListener(buttonClickListener);
        activion2.setOnClickListener(buttonClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(SAVED_TEXT, textView.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
