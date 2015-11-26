package com.example.riku.dragviewtestapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import static android.widget.Toast.*;

/**
 * Created by riku_maehara on 2015/11/26.
 */
public class AlartDialogFragment extends DialogFragment {
    Activity activity = getActivity();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        CharSequence[] items = {"使い方", "よくある質問", "メール", "閉じる"};


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        makeText(activity, "使い方が押された", LENGTH_LONG).show();

                    break;
                    case 1:
                        makeText(activity, "よくある質問が押された", LENGTH_LONG).show();
                        break;
                    case 2:
                        makeText(activity, "メールが押された", LENGTH_LONG).show();
                        break;
                    case 3:
                        makeText(activity, "閉じる", LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
            }
        });
        return builder.create();
    }

}
