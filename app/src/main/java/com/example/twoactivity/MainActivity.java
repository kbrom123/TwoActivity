package com.example.twoactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG=MainActivity.class.getSimpleName();
    public static  final String EXTRA_MESSAGE="com.example.twoactivity.extra.MESSAGE";
    private EditText editText;
    public  static final int TEXT_REQUEST=1;
    private TextView textHeader;
    private TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextTextPersonName);
        textHeader=findViewById(R.id.text_header_reply);
        textMessage=findViewById(R.id.text_message_reply);
    }

    public void LaunchSecondActivity(View view) {
        Log.d(LOG_TAG,"button clicked");
        Intent intent=new Intent(this,SecondActivity.class);
        String message=editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==TEXT_REQUEST){
            if (resultCode==RESULT_OK){
                String reply=data.getStringExtra(SecondActivity.EXTRA_REPLY);
                textHeader.setVisibility(View.VISIBLE);
                textMessage.setText(reply);
                textMessage.setVisibility(View.VISIBLE);
            }
        }
    }
}