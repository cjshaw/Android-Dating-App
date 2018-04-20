package com.example.shawasssisignment1;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.net.URI;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    Button  backBtn;
    ImageView profileImg;

    /**
     * onCreate function that displays message to user with information gathered from the form.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textView);
        profileImg = findViewById(R.id.profileImg);
        backBtn = findViewById(R.id.backBtn);

        StringBuilder msg = new StringBuilder("Thanks for Signing Up: ");
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        assert b != null;

        if(b.containsKey(Constants.KEY_USERNAME)){
            String username = b.getString(Constants.KEY_USERNAME);
            msg.append(username).append("!");
        }
        textView.setText(msg);

        Uri img = null;
        if(b.containsKey(Constants.KEY_IMG)) {
            img = b.getParcelable(Constants.KEY_IMG);
        }
        profileImg.setImageURI(img);

    }

    /**
     * goes back to MainActivity and clears the stack of activities
     * @param v
     */
    public void goBack(View v){
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
