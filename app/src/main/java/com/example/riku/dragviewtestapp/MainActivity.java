package com.example.riku.dragviewtestapp;
<<<<<<< HEAD
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
=======

>>>>>>> 5df95b23c6c24024d38462dfc4cde077ae994924
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
<<<<<<< HEAD


        //Fragmentを設置
        // Fragmentを作成します
        MainFragment fragment = new MainFragment();
        // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 新しく追加を行うのでaddを使用します
        // 他にも、メソッドにはreplace removeがあります
        // メソッドの1つ目の引数は対象のViewGroupのID、2つ目の引数は追加するfragment
        transaction.add(R.id.container,fragment);
        // 最後にcommitを使用することで変更を反映します
        transaction.commit();
=======
>>>>>>> 5df95b23c6c24024d38462dfc4cde077ae994924
    }
//Toastのメソッド
    private void showToast() {
        Toast.makeText(this, "Toastです", Toast.LENGTH_SHORT).show();
    }
}
