package com.example.dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyDialog.Listener {
    Button mAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAlert = findViewById(R.id.alert);
    }

    public void onClick(View view) {
        if (view == mAlert) {
            MyDialog dialog = new MyDialog();
            dialog.show(getSupportFragmentManager(), "alert");
        }
    }

    @Override
    public void OnAccepted() {
        Toast.makeText(this, "Accepted (activity)!", Toast.LENGTH_SHORT).show();
    }
}
