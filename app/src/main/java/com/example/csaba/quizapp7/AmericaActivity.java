package com.example.csaba.quizapp7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;

public class AmericaActivity extends AppCompatActivity {

    public static final String mypreference = "mypref";
    public SharedPreferences sharedpreferences;


    public int scoreAm = 0;
    public boolean flagAm = true;

    public int rb1State;
    public int rb2State;
    public int rb3State;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_america);

        /**inicialization*/
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        }

    public void submitScore(View view) {

        if (flagAm) {

            //Checks whether the correct radio button is clicked in Question 1,2,3
            RadioButton radioButtonOne = (RadioButton) findViewById(R.id.firstQTrue);
            boolean checkedOne = radioButtonOne.isChecked();
            if (checkedOne)
                scoreAm += 1;

            RadioButton radioButtonTwo = (RadioButton) findViewById(R.id.secondQTrue);
            boolean checkedTwo = radioButtonTwo.isChecked();
            if (checkedTwo)
                scoreAm += 1;

            RadioButton radioButtonThree = (RadioButton) findViewById(R.id.thirdQTrue);
            boolean checkedThree = radioButtonThree.isChecked();
            if (checkedThree)
                scoreAm += 1;

            //show score
            setScore();

            //highlight the correct answers
            highlightAnswers();


            //submit button can press only once
            Button mySubmit = (Button) findViewById(R.id.submit);
            mySubmit.setClickable(false);

            //Toast message about score
            Toast.makeText(this, "Your score is: " + " " + scoreAm + "", Toast.LENGTH_LONG).show();

            //set flafAm false to avoid submit clicked again
            flagAm = false;
        }
    }

    // set score and show
    public void setScore() {
        TextView score = (TextView) findViewById(R.id.scoreAmerica);
        score.setText("" + this.scoreAm + "/3");

        /** save score in sharedpreferences*/
        save();
    }


    //back to main page on click
    public void backToMain(View view) {

        Intent intAm = new Intent(this, MainActivity.class);
        intAm.putExtra("intAm", scoreAm);
        startActivity(intAm);
    }

    //highlight the correct answers
    public void highlightAnswers (){
        RadioButton radioButtonOne = (RadioButton) findViewById(R.id.firstQTrue);
        radioButtonOne.setBackgroundColor(rgb(101, 52, 255));
        RadioButton radioButtonTwo = (RadioButton) findViewById(R.id.secondQTrue);
        radioButtonTwo.setBackgroundColor(rgb(101, 52, 255));
        RadioButton radioButtonThree = (RadioButton) findViewById(R.id.thirdQTrue);
        radioButtonThree.setBackgroundColor(rgb(101, 52, 255));
    }

    //save data if you change orientation
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.



        //protected values
        savedInstanceState.putInt("scoreAmS", scoreAm);
        savedInstanceState.putBoolean("flagAmS", flagAm);

        RadioGroup rg1 = (RadioGroup) findViewById(R.id.firstQGroup);
        int rb1State = rg1.getCheckedRadioButtonId();
        savedInstanceState.putInt("rb1S", rb1State);

        RadioGroup rg2 = (RadioGroup) findViewById(R.id.secondQGroup);
        int rb2State = rg2.getCheckedRadioButtonId();
        savedInstanceState.putInt("rb2S", rb2State);

        RadioGroup rg3 = (RadioGroup) findViewById(R.id.thirdQGroup);
        int rb3State = rg3.getCheckedRadioButtonId();
        savedInstanceState.putInt("rb3S", rb3State);


    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        //restore data
        if (savedInstanceState != null) {
            scoreAm = savedInstanceState.getInt("scoreAmS");
            flagAm = savedInstanceState.getBoolean("flagAmS");

            // Restore the saved value
            rb1State = savedInstanceState.getInt("rb1S");
            // Apply the restored value
            RadioGroup rg1 = (RadioGroup) findViewById(R.id.firstQGroup);
            rg1.check(rb1State);

            rb2State = savedInstanceState.getInt("rb2S");
            RadioGroup rg2 = (RadioGroup) findViewById(R.id.secondQGroup);
            rg2.check(rb2State);

            rb3State = savedInstanceState.getInt("rb3S");
            RadioGroup rg3 = (RadioGroup) findViewById(R.id.thirdQGroup);
            rg3.check(rb3State);



            //show score in the new orientation
            setScore();

            //keep correct answers highlighted if submit was clicked and phone was rotated
            if (!flagAm) {
                highlightAnswers();
            }
        }
    }

    /**sharedpreferences saves the result for main activity*/
    public void save () {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("savedAm", scoreAm);
        editor.commit();
    }


}