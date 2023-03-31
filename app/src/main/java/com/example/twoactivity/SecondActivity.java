package com.example.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY="com.example.twoactivity.extra.REPLY";
    private EditText replyMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        replyMessage=findViewById(R.id.editTextTextPersonName);
        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView=findViewById(R.id.textView2);
        textView.setText(message);
    }

    public void returnReply(View view) {
        String reply=replyMessage.getText().toString();
        Intent replyMessage=new Intent();
        replyMessage.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK,replyMessage);
        finish();
    }
}