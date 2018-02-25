package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class One_ExplainTrainingData extends AppCompatActivity {

    TextView takePhotosInstructions;
    TextView takePhotosInstructions2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one__explain_training_data);

        takePhotosInstructions = (TextView) findViewById(R.id.text1);
        takePhotosInstructions.setTextColor(Color.parseColor("#000000"));
        takePhotosInstructions.setTextSize(20);
        takePhotosInstructions.setText("Great! Now lets take a few more photos to teach this pose to the computer.");

        takePhotosInstructions2 = (TextView) findViewById(R.id.text2);
        takePhotosInstructions2.setTextSize(20);
        takePhotosInstructions2.setTextColor(Color.parseColor("#000000"));
        takePhotosInstructions2.setText("Tap next below");


    }

    public void changeActivity(View view){
        Intent intent = new Intent(getApplicationContext(), One_Lemon_LemonResult.class);
        startActivity(intent);
    }
}
