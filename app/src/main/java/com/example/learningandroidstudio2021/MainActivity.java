package com.example.learningandroidstudio2021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int num1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//end OnCreate

    public void topClick(View v)
    {
        num1++;
        updateTV();
        Toast.makeText(this, "You clicked the top button", Toast.LENGTH_SHORT).show();
        Log.i("info", "The user clicked the top button");
        Log.e("error", "Oh no!, An error occurred!!!!!!!");
    }

    public void bottomClick(View v)
    {
        num1--;
        updateTV();
        Toast.makeText(this, "You clicked the top button", Toast.LENGTH_LONG).show();
        //Log.i("info", "The user clicked the top button");
        Log.e("error", "Warning! this user likes to be argumentative!!!!!");
    }

    public void reset(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you really want to reset the count?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                num1 = 0;
                updateTV();
            }//close onclick for yes
        });//end set positive button
        builder.setNegativeButton("NO!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }//close onclick for no
        });//end set Negative button
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }//end of reset

    private void updateTV()
    {
        TextView outputTextView =  (TextView) findViewById(R.id.output);
        outputTextView.setText("You have now counted " +  num1 + " stars!");
    }
}//end class