package com.example.riku.dragviewtestapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by riku_maehara on 2015/11/26.
 */
public class AlartDialogFragment extends DialogFragment {
    Activity activity = getActivity();
    int tagNumber;
    int nowColor;
    private ClickListener listener;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] items = {"NewCard", "Change Text Color", "DeleteCard", "EditCard"};


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0: {
                        tagNumber++;
                        makeToast(items[0] + "が押されました");
                        //Fragmentを設置
                        // Fragmentを作成します
                        //Fragmentを設置
                        // Fragmentを作成します
                        DragViewFragment fragment = new DragViewFragment();
                        // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        // 新しく追加を行うのでaddを使用します
                        // 他にも、メソッドにはreplace removeがあります
                        // メソッドの1つ目の引数は対象のViewGroupのID、2つ目の引数は追加するfragment
                        transaction.add(R.id.container, fragment, String.valueOf(tagNumber));
                        Log.d("Tag", fragment.getTag());
                        // 最後にcommitを使用することで変更を反映します
                        transaction.commit();
                        break;
                    }
                    case 1: {
                        makeToast(items[1] + "が押されました");

//                        Fragment fragment = getParentFragment();
//                        if (fragment instanceof ClickListener) {
//                            nowColor = Color.BLUE;
//                            ((ClickListener) fragment).onClick(Color.BLUE);
//                        }
                    }
                    createColorDialog();


                    break;
                    case 2:

                        makeToast(items[2] + "が押されました");

//                        //Fragmentを設置
//                        // Fragmentを作成します
//                        //Fragmentを設置
//                        // Fragmentを作成します
//                        DragViewFragment fragment = new DragViewFragment();
//                        // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
//                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                        // 新しく追加を行うのでaddを使用します
//                        // 他にも、メソッドにはreplace removeがあります
//                        // メソッドの1つ目の引数は対象のViewGroupのID、2つ目の引数は追加するfragment
//                        transaction.remove(fragment);
//                        // 最後にcommitを使用することで変更を反映します
//                        transaction.commit();
                        fragmentRemover();


                        break;
                    case 3:
                        makeToast(items[3] + "が押されました");
                        createConfigDialog();

                        break;
                    default:
                        break;
                }
            }
        });
        return builder.create();
    }

    public void makeToast(String message) {
        Toast toast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);

        toast.show();
    }

    public interface ClickListener {
        void onClick(int id);


    }

    public interface ConfigListener {
        void onConfig(String str);


    }

    private void createConfigDialog() {
        View rootView = getActivity().getLayoutInflater().inflate(R.layout.sticky_config_dialog, null);
        final EditText input_editText_cfg_text = (EditText) rootView.findViewById(R.id.editText_text);

//        final EditText input_editText_cfg_url = (EditText) rootView.findViewById(R.id.eText_url_cfg);
//        input_editText_cfg_url.setInputType(InputType.TYPE_TEXT_VARIATION_URI);


        AlertDialog.Builder alartDialog = new AlertDialog.Builder(getActivity());
        final Fragment fragment = getParentFragment();
        alartDialog.setTitle("EditText");
        alartDialog.setView(rootView);


        alartDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Fragment fragment = getParentFragment();
                if (fragment instanceof ConfigListener) {
                    ((ConfigListener) fragment).onConfig(input_editText_cfg_text.getText().toString());
                }
            }
        });
        alartDialog.create();
        alartDialog.show();
    }
    private void fragmentRemover(){
        Fragment fragment =getParentFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
        transaction.commit();

    }


    private void createColorDialog() {
        final String[] items = {"Black","Blue", "Red", "Yellow","Green"};
//        デフォルトで選択されているアイテム
        final int[] selectedItem = {0};
        new AlertDialog.Builder(getActivity())
                .setTitle("Set Colour")
                .setSingleChoiceItems(items, selectedItem[0], new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedItem[0] = which;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which1) {
                        Fragment fragment = getParentFragment();
                        switch (selectedItem[0]) {
                            case 0:
                                if (fragment instanceof ClickListener) {
                                    ((ClickListener) fragment).onClick(Color.BLACK);
                                    break;

                                }
                            case 1:
                                if (fragment instanceof ClickListener) {
                                    ((ClickListener) fragment).onClick(Color.BLUE);
                                    break;

                                }
                            case 2:
                                if (fragment instanceof ClickListener) {
                                    ((ClickListener) fragment).onClick(Color.RED);
                                    break;

                                }
                            case 3:
                                if (fragment instanceof ClickListener) {
                                    ((ClickListener) fragment).onClick(Color.YELLOW);
                                    break;

                                }
                            case 4:
                                if (fragment instanceof ClickListener) {
                                    ((ClickListener) fragment).onClick(Color.GREEN);
                                    break;

                                }

                        }
                        Log.d("Select", String.valueOf(which1));


                    }
                }).setNegativeButton("Cancel", null).create().show();


    }
}