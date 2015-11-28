package com.example.riku.dragviewtestapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.DialogFragment;
import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RIKU on 2015/11/27.
 */
public class DragViewFragment extends Fragment {
    TextView dragTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_view_drag, container, false);

    }

    //Viewが生成し終わった後に呼ばれるメソッド
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        TextViewを紐付ける
        dragTextView = (TextView) view.findViewById(R.id.textView3);

//dragできるようにする
        DragViewListener listener = new DragViewListener(dragTextView);
        dragTextView.setOnTouchListener(listener);

//        長押しクリックされたとき
        dragTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "テスト", Toast.LENGTH_LONG).show();


//              ダイアログを表示する
                DialogFragment newFragment = new AlartDialogFragment();
                newFragment.show(getFragmentManager(), "contact_us");


                return false;//trueにすると他のリスナーが呼ばれない
            }
        });


    }



}
