package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Five_Add_Data extends AppCompatActivity {

    TextView text;
    TextView numberSamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__add__data);

        text =(TextView) findViewById(R.id.textbox);
        text.setTextSize(20);
        text.setTextColor(Color.parseColor("#000000"));

        numberSamples =(TextView) findViewById(R.id.textbox);
        numberSamples.setTextSize(20);
        numberSamples.setTextColor(Color.parseColor("#000000"));
        numberSamples.setText("Number of training photos: " + Integer.toString(knn.trainingData.rows()));
    }

    public void goToTrainCrouch(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_TrainCrouch.class);
        startActivity(intent);
        this.finish();
    }

    public void goToTrainStand(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_TrainStand.class);
        startActivity(intent);
        this.finish();
    }
}
