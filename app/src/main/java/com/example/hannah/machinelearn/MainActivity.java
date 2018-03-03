 package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;

 public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("opencv_java3");
    }

     Button worldOneButton;
     Button worldTwoButton;
     //Button worldThreeButton;
     Button classificationQuiz;
     Button guessThePose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        worldOneButton = (Button) findViewById(R.id.goToWorld1);
        worldTwoButton = (Button) findViewById(R.id.goToWorld2);
        //worldThreeButton = (Button) findViewById(R.id.goToWorld3);
        classificationQuiz = (Button) findViewById(R.id.classificationQuiz);
        guessThePose = (Button) findViewById(R.id.guessThePose);


    }

     public void changeToWorld(View view) {

         Button buttonPressed = (Button) findViewById(view.getId());
         String buttonText = buttonPressed.getText().toString();
         if(buttonText.equals("World one")) {
             Intent intent = new Intent(getApplicationContext(), One_WorldOne.class);
             startActivity(intent);
         }
         else if(buttonText.equals("World two")) {
             Intent intent = new Intent(getApplicationContext(), Two_WorldTwo.class);
             startActivity(intent);
         }
         else if(buttonText.equals("World three")) {
             Intent intent = new Intent(getApplicationContext(), Three_WorldThree.class);
             startActivity(intent);
         }
         else if(buttonText.equals("Classification quiz")) {
             Intent intent = new Intent(getApplicationContext(), Four_ClassificationQuizOne.class);
             startActivity(intent);
         }
         else if(buttonText.equals("Guess the pose")){
             Intent intent = new Intent(getApplicationContext(), Five_GuessThePose.class);
             startActivity(intent);
         }
         else if(buttonText.equals("D")){
             Intent intent = new Intent(getApplicationContext(), Desktop_simulation.class);
             startActivity(intent);
         }
     }

}
