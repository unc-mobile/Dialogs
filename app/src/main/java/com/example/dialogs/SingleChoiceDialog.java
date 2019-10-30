package com.example.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Arrays;

public class SingleChoiceDialog extends DialogFragment
        implements DialogInterface.OnClickListener {
    private static final String LOG_TAG = "SingleChoiceDialog";

    private int mSavedChoice = -1;
    private int mTemporaryChoice;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        mTemporaryChoice = mSavedChoice;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("Accept", this)
               .setNegativeButton("Cancel", this)
               .setTitle("Single-choice dialog")
               .setSingleChoiceItems(R.array.items, mTemporaryChoice, this);
        return builder.create();
    }

    @Override   // DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(getContext(), "Accepted!", Toast.LENGTH_SHORT).show();
                mSavedChoice = mTemporaryChoice;
                break;

            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(getContext(), "Cancelled!", Toast.LENGTH_SHORT).show();
                break;

            default:
                mTemporaryChoice = which;
                break;
        }
    }
}
