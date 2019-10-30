package com.example.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment implements DialogInterface.OnClickListener{
    private static final String LOG_TAG = "MyDialog";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("Accept", this)
               .setNegativeButton("Cancel", this)
               .setTitle("Alert dialog")
               .setMessage("Confirm action?");
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(getContext(), "Accepted!", Toast.LENGTH_SHORT).show();
                break;

            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(getContext(), "Cancelled!", Toast.LENGTH_SHORT).show();
                break;

            default:
                // This should not happen.
                break;
        }
    }
}
