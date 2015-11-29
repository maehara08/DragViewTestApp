package com.example.riku.dragviewtestapp;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    TextView dragView;
    Button button;
    int count;
    Canvas mCanvas;
    private Deque<Path> mUndoStack = new ArrayDeque<Path>();
    private Deque<Path> mRedoStack = new ArrayDeque<Path>();

    //    テキストやビットマップを描画するための色情報と
//    スタイル情報を保持するPaintクラスを宣言
    Paint mPaint;
    Path mPath;
    Bitmap mBitmap;
    ImageView mImageView;
    float x1, y1;
    int width, height;


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            //指が画面に触れた時のイベント
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                //パスをつなげる
                mPath.quadTo(x1, y1, x, y);
//                Canvasに今のパスを描くよ
                mCanvas.drawPath(mPath, mPaint);
                break;
        }
        //触れられた場所を記憶しておく
        x1 = x;
        y1 = y;
//        表示を更新する
        mImageView.setImageBitmap(mBitmap);

        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setOnTouchListener(this);

        mPaint = new Paint();
//        線の幅を指定
        mPaint.setStrokeWidth(5.0f);
        //グラフィックのスタイルを指定
        mPaint.setStyle(Paint.Style.STROKE);
        //線と線のつなぎ目を丸く指定
        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        線の端を丸く指定
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        //Pathのインスタンスを生成
        mPath = new Path();


        showNewFragment();

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                mCanvas = new Canvas(mBitmap);
                mCanvas.drawColor(Color.WHITE);
                mImageView.setImageBitmap(mBitmap);

            }
        });


    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (mBitmap == null) {
            //mImageViewの幅とは傘に合わせたBitmap画像を作る
//            WidthとHeightを取得する
            width = mImageView.getWidth();
            height = mImageView.getHeight();

            mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

            //新しいCanvasに、その保存先のBitMapをセット
            mCanvas = new Canvas(mBitmap);
            mCanvas.drawColor(Color.WHITE);
            mImageView.setImageBitmap(mBitmap);

        }
    }

    public void showNewFragment() {
        //Fragmentを設置
        // Fragmentを作成します
        DragViewFragment fragment = new DragViewFragment();
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

