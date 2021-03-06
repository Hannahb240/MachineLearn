package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

public class One_WorldOne extends AppCompatActivity {

    //Tree buttons
    ImageButton treeButton1;
    ImageButton treeButton2;
    ImageButton treeButton3;
    ImageButton treeButton4;
    ImageButton treeButton5;
    ImageButton treeButton6;
    ImageButton treeButton7;
    ImageButton treeButton8;

    boolean isClicked = true;
    PopupWindow popUpWindow;
    ActionBar.LayoutParams layoutParams;
    LinearLayout mainLayout;
    Button btnClickHere;
    LinearLayout containerLayout;
    TextView tvMsg;


    //Tree types:
    //1 = Lemon
    //2 = Orange
    //3 = Apple
    //4 = Pear

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_world_one);


        treeButton1 = (ImageButton) findViewById(R.id.selectTree1);
        treeButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), One_ResultOfImage.class);
                    Bundle b = new Bundle();
                    b.putInt("key", 1);
                    intent.putExtras(b);
                    startActivity(intent);
                    findViewById(R.id.selectTree1).setBackgroundResource(R.drawable.lemontree);
                    finish();

            }
        });

        treeButton2 = (ImageButton) findViewById(R.id.selectTree2);
        treeButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), One_ResultOfImage.class);
                    Bundle b = new Bundle();
                    b.putInt("key", 2);
                    intent.putExtras(b);
                    startActivity(intent);
                    findViewById(R.id.selectTree2).setBackgroundResource(R.drawable.orangetree);
            }
        });

        treeButton3 = (ImageButton) findViewById(R.id.selectTree3);
        treeButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), One_ResultOfImage.class);
                Bundle b = new Bundle();
                b.putInt("key", 3);
                intent.putExtras(b);
                startActivity(intent);
                findViewById(R.id.selectTree3).setBackgroundResource(R.drawable.appletree);
            }
        });

        treeButton4 = (ImageButton) findViewById(R.id.selectTree4);
        treeButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), One_ResultOfImage.class);
                Bundle b = new Bundle();
                b.putInt("key", 4);
                intent.putExtras(b);
                startActivity(intent);
                findViewById(R.id.selectTree4).setBackgroundResource(R.drawable.peartree);
            }
        });

        treeButton5 = (ImageButton) findViewById(R.id.selectTree5);
        treeButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), One_ResultOfImage.class);
                Bundle b = new Bundle();
                b.putInt("key", 2); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                findViewById(R.id.selectTree5).setBackgroundResource(R.drawable.orangetree);
            }
        });

        treeButton6 = (ImageButton) findViewById(R.id.selectTree6);
        treeButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), One_ResultOfImage.class);
                Bundle b = new Bundle();
                b.putInt("key", 3);
                intent.putExtras(b);
                startActivity(intent);
                findViewById(R.id.selectTree6).setBackgroundResource(R.drawable.appletree);
            }
        });

        treeButton7 = (ImageButton) findViewById(R.id.selectTree7);
        treeButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), One_ResultOfImage.class);
                Bundle b = new Bundle();
                b.putInt("key", 4);
                intent.putExtras(b);
                startActivity(intent);
                findViewById(R.id.selectTree7).setBackgroundResource(R.drawable.peartree);
            }
        });

        treeButton8 = (ImageButton) findViewById(R.id.selectTree8);
        treeButton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), One_ResultOfImage.class);
                Bundle b = new Bundle();
                b.putInt("key", 3);
                intent.putExtras(b);
                startActivity(intent);
                findViewById(R.id.selectTree8 ).setBackgroundResource(R.drawable.appletree);
            }
        });

    }

    public void changeActivity(View view){
        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if(buttonText.equals("Back")){
            this.finish();
        }
        if(buttonText.equals("Rules")){
            Intent intent = new Intent(getApplicationContext(), One_Rules.class);
            startActivity(intent);
        }
    }
}
