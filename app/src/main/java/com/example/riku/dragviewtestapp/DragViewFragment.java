package com.example.riku.dragviewtestapp;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RIKU on 2015/11/27.
 */
//public class DragViewFragment extends Fragment {
public class DragViewFragment extends Fragment implements AlartDialogFragment.ClickListener , AlartDialogFragment.ConfigListener{
    TextView dragTextView;
    int fragmentTag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_view_drag, container, false);

    }

    //Viewが生成し終わった後に呼ばれるメソッド
    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
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
//                Toast.makeText(getActivity().getApplicationContext(), "テスト", Toast.LENGTH_LONG).show();


//              ダイアログを表示する
                DialogFragment newFragment = new AlartDialogFragment();
                newFragment.show(getChildFragmentManager(), "contact_us");


                return false;//trueにすると他のリスナーが呼ばれない
            }
        });
    }


    @Override
    public void  onClick(int id) {
        Log.d("Tag", String.valueOf(id));
        ColorStateList nowColor=dragTextView.getTextColors();
        Log.d("NowColor",(nowColor).toString());
        dragTextView.setTextColor(id);



    }

    @Override
    public void onConfig(String str) {
        dragTextView.setText(str);
    }
}
