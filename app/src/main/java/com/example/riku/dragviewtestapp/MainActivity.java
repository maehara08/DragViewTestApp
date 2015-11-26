package com.example.riku.dragviewtestapp;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
//                showToast();
//                showNewFragment();
// ダイアログを表示する
                DialogFragment newFragment = new AlartDialogFragment();
                newFragment.show(getFragmentManager(), "contact_us");

                return false;//trueにすると他のリスナーが呼ばれない
            }
        });


    }

    private void showNewFragment() {
        //Fragmentを設置
        // Fragmentを作成します
        MainFragment fragment = new MainFragment();
        // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 新しく追加を行うのでaddを使用します
        // 他にも、メソッドにはreplace removeがあります
        // メソッドの1つ目の引数は対象のViewGroupのID、2つ目の引数は追加するfragment
        transaction.add(R.id.container, fragment);
        // 最後にcommitを使用することで変更を反映します
        transaction.commit();
    }



    //Toastのメソッド
    public void showToast() {
        Toast.makeText(this, "Toastです", Toast.LENGTH_SHORT).show();
    }
}

