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

public class MultiChoiceDialog extends DialogFragment
        implements DialogInterface.OnMultiChoiceClickListener,
                   DialogInterface.OnClickListener {
    private static final String LOG_TAG = "MultiChoiceDialog";

    private boolean[] mSavedItems;
    private boolean[] mTemporaryItems;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String[] strings = getResources().getStringArray(R.array.items);
        if (mSavedItems!= null) {
            mTemporaryItems = Arrays.copyOf(mSavedItems, mSavedItems.length);
        } else {
            mTemporaryItems = new boolean[strings.length];
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("Accept", this)
               .setNegativeButton("Cancel", this)
               .setTitle("Multi-choice dialog")
               .setMultiChoiceItems(strings, mTemporaryItems, this);
        return builder.create();
    }

    @Override   // DialogInterface.OnMultiChoiceClickListener
    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        mTemporaryItems[which] = isChecked;
    }

    @Override   // DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(getContext(), "Accepted!", Toast.LENGTH_SHORT).show();
                mSavedItems = mTemporaryItems;
                mTemporaryItems = null;
                break;

            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(getContext(), "Cancelled!", Toast.LENGTH_SHORT).show();
                mTemporaryItems = null;
                break;

            default:
                // This should not happen.
                break;
        }
    }
}
