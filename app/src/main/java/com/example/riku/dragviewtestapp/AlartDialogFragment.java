package com.example.riku.dragviewtestapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

/**
 * Created by riku_maehara on 2015/11/26.
 */
public class AlartDialogFragment extends DialogFragment {
    Activity activity = getActivity();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] items = {"使い方", "よくある質問", "メール", "閉じる"};


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                switch (which) {
                    case 0:

                        makeToast(items[0]+"が押されました");

                        break;
                    case 1:
                        makeToast(items[1]+"が押されました");

                        break;
                    case 2:
                        makeToast(items[2]+"が押されました");

                        break;
                    case 3:
                        makeToast(items[3]+"が押されました");

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

}
