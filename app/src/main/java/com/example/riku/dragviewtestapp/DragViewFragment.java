package com.example.riku.dragviewtestapp;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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


        DragViewListener listener = new DragViewListener(dragTextView);
        dragTextView.setOnTouchListener(listener);
        dragTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                Toast.makeText(MainActivity.class, "テスト", Toast.LENGTH_LONG).show();

//                showNewFragment();

// ダイアログを表示する
                DialogFragment newFragment = new AlartDialogFragment();
                newFragment.show(getFragmentManager(), "contact_us");

                return false;//trueにすると他のリスナーが呼ばれない
            }
        });


    }


}
