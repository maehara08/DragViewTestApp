package com.example.riku.dragviewtestapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by riku_maehara on 2015/11/26.
 */
public class MainFragment extends Fragment {
    TextView mTextView;

    //Fragmentで表示するViewを作成するメソッド


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    //Viewが生成し終わった後に呼ばれるメソッド

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        TextViewを紐付ける
        mTextView=(TextView) view.findViewById(R.id.textView2);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText()+"!");
            }
        });


    }
}
