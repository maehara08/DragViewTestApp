package com.example.riku.dragviewtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    TextView dragView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dragView = (TextView) findViewById(R.id.textView);
        DragViewListener listener = new DragViewListener(dragView);
        dragView.setOnTouchListener(listener);



        dragView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showToast();


                return false;//trueにすると他のリスナーが呼ばれない
            }
        });
    }
//Toastのメソッド
    private void showToast() {
        Toast.makeText(this, "Toastです", Toast.LENGTH_SHORT).show();
    }
}
