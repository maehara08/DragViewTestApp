package com.example.riku.dragviewtestapp;


import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.FragmentTransaction;
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


        showNewFragment();


//        dragView = (TextView) findViewById(R.id.textView);
//        DragViewListener listener = new DragViewListener(dragView);
//        dragView.setOnTouchListener(listener);


//        dragView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
////                Toast.makeText(MainActivity.class, "テスト", Toast.LENGTH_LONG).show();
//
////                showNewFragment();
//
//// ダイアログを表示する
//                DialogFragment newFragment = new AlartDialogFragment();
//                newFragment.show(getFragmentManager(), "contact_us");
//
//                return false;//trueにすると他のリスナーが呼ばれない
//            }
//        });


    }


    private void showNewFragment() {
        //Fragmentを設置
        // Fragmentを作成します
        DragViewFragment fragment = new DragViewFragment();
        // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
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

