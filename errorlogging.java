package com.example.errorlogging;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       someOtherMethod();
                                   }
                               }
        );
        if(savedInstanceState != null) {
            Log.d(TAG, "OnCreate restoring to the precious state");
        }
        else {
            Log.d(TAG, "OnCreate No save state");
        }
        Toast.makeText(getApplicationContext(),"first on create called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"on start called", Toast.LENGTH_LONG).show();

    }

    protected void someOtherMethod() {

        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(13);
        arr.add(3);
        arr.add(130);
        arr.add(138);
        try {
            for (int i = 0; i <= arr.size(); i++) {
                System.out.println(arr.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            Log.d(TAG, "someOtherMethod ", e);
            Log.e(TAG, "someOtherMethod ", e);
            Log.w(TAG, "someOtherMethod ", e);
            Log.i(TAG, "someOtherMethod ", e);
            Log.v(TAG, "someOtherMethod ", e);
        }

    }
}
