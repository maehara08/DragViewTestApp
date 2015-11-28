package com.example.riku.dragviewtestapp;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by RIKU on 2015/11/26.
 */
public class DragViewListener implements View.OnTouchListener {

    // ドラッグ対象のView
    private TextView textView12;
    // ドラッグ中に移動量を取得するための変数
    private int oldx;
    private int oldy;

    public DragViewListener(TextView textView) {
        this.textView12 = textView;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        // タッチしている位置取得
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                // 今回イベントでのView移動先の位置
                int left = textView12.getLeft() + (x - oldx);
                int top = textView12.getTop() + (y - oldy);
                // Viewを移動する
                textView12.layout(left, top, left + textView12.getWidth(), top
                        + textView12.getHeight());
                break;
            case MotionEvent.ACTION_UP:
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(textView12.getLeft(), textView12.getTop(), 0, 0);
                textView12.setLayoutParams(lp);
                break;
        }

        // 今回のタッチ位置を保持
        oldx = x;
        oldy = y;
        // falseにしないとほかのリスナーが呼ばれない
        return false;
    }
}
