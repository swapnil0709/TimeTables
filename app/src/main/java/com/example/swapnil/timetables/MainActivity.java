package com.example.swapnil.timetables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView myListView;

    public void func(int k) {
        myListView = (ListView) findViewById(R.id.myListView);
        final ArrayList<String> tableArray = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            tableArray.add(Integer.toString(k * i));
        }

        ArrayAdapter<String> integerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tableArray);
        myListView.setAdapter(integerArrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SeekBar tableSeekBar = (SeekBar) findViewById(R.id.tableSeekBar);
        int max = 20;
        int startingPosition = 1;

        tableSeekBar.setMax(max);
        tableSeekBar.setProgress(startingPosition);
        func(startingPosition);
        tableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int val;
                int min = 1;
                if (progress < min) {
                    tableSeekBar.setProgress(min);
                    val = min;
                } else {
                    val = progress;
                }
                Log.i("value of k is", Integer.toString(progress));
                func(val);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
