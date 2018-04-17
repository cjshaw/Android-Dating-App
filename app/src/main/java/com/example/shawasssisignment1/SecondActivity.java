package com.example.shawasssisignment1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    Button  backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textView);
        backBtn = findViewById(R.id.backBtn);

        StringBuilder msg = new StringBuilder("Hello \n");
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        assert b != null;

        if(b.containsKey(Constants.KEY_USERNAME)){
            String username = b.getString(Constants.KEY_USERNAME);
            msg.append(username).append("\n");
        }

        if(b.containsKey(Constants.KEY_AGE)){
            int age = b.getInt(Constants.KEY_AGE);
            msg.append("Your age is ").append(age);
        }

        textView.setText(msg);
    }

    public void goBack(View v){
        Intent i=new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}