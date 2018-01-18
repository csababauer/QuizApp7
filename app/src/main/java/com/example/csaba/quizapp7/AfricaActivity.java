package com.example.csaba.quizapp7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;

public class AfricaActivity extends AppCompatActivity {

    public int scoreAf = 0;
    public boolean flag = true;

    public static final String mypreference = "mypref";
    public SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_africa);

        /**inicialization*/
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
    }

    public void submitScoreAfrica (View view){

        if (flag) {
        //checking the checkboxes for question 1
        CheckBox checkBoxLibya = (CheckBox) findViewById(R.id.libya);
        boolean checkedLibya = checkBoxLibya.isChecked();
        CheckBox checkBoxSudan = (CheckBox) findViewById(R.id.sudan);
        boolean checkedSudan = checkBoxSudan.isChecked();
        CheckBox checkBoxAlgeria = (CheckBox) findViewById(R.id.algeria);
        boolean checkedAlgeria = checkBoxAlgeria.isChecked();
        CheckBox checkBoxMorocco = (CheckBox) findViewById(R.id.morocco);
        boolean checkedMorocco = checkBoxMorocco.isChecked();


        //checking the checkboxes for question 2
        CheckBox checkBoxNamibia = (CheckBox) findViewById(R.id.namibia);
        boolean checkedNamibia = checkBoxNamibia.isChecked();
        CheckBox checkBoxEthiopia = (CheckBox) findViewById(R.id.ethiopia);
        boolean checkedEthiopia = checkBoxEthiopia.isChecked();
        CheckBox checkBoxKenya = (CheckBox) findViewById(R.id.kenya);
        boolean checkedKenya = checkBoxKenya.isChecked();

        //checking the checkboxes for question
        CheckBox checkBoxSS = (CheckBox) findViewById(R.id.southsudan);
        boolean checkedSS = checkBoxSS.isChecked();
        CheckBox checkBoxTZ = (CheckBox) findViewById(R.id.tanzania);
        boolean checkedTZ = checkBoxTZ.isChecked();
        CheckBox checkBoxTun = (CheckBox) findViewById(R.id.tunisia);
        boolean checkedTun = checkBoxTun.isChecked();

        // Q 1 is checked
        if (checkedLibya && checkedSudan && !checkedMorocco && !checkedAlgeria)
            scoreAf += 1;

        // Q2 is checked
        if (checkedEthiopia && !checkedNamibia && !checkedKenya)
            scoreAf += 1;

        // Q3 is checked
        if (checkedSS && checkedTun && !checkedTZ)
            scoreAf += 1;

        setscoreAf ();

        //highlight the correct answers
        highlightAnswer();

        //make flags visible
            flagVisible ();

        //deactivate submit button to prevent repressing if "clickCheck" is true
            Button myButton = (Button) findViewById(R.id.submitAfrica);
            myButton.setClickable(false);
            flag = false;

            //Toast message about score
            Toast.makeText(this,"Your score is: " + " " + scoreAf + "", Toast.LENGTH_LONG).show();

        }

    }

    public void setscoreAf (){
        TextView score = (TextView) findViewById(R.id.scoreAfrica);
        score.setText(this.scoreAf + "/3");

        /**save score*/
        save();
    }







    //highlight the correct answers
    public void highlightAnswer () {
        CheckBox checkBoxLibya = (CheckBox) findViewById(R.id.libya);
        checkBoxLibya.setBackgroundColor(rgb(101,52,255));
        CheckBox checkBoxSudan = (CheckBox) findViewById(R.id.sudan);
        checkBoxSudan.setBackgroundColor(rgb(101,52,255));
        CheckBox checkBoxEthiopia = (CheckBox) findViewById(R.id.ethiopia);
        checkBoxEthiopia.setBackgroundColor(rgb(101,52,255));
        CheckBox checkBoxSS = (CheckBox) findViewById(R.id.southsudan);
        checkBoxSS.setBackgroundColor(rgb(101,52,255));
        CheckBox checkBoxTun = (CheckBox) findViewById(R.id.tunisia);
        checkBoxTun.setBackgroundColor(rgb(101,52,255));
    }

    //make flags visible
    public void flagVisible() {
        ImageView myflag = (ImageView) findViewById(R.id.ssFlag);
        myflag.setVisibility(View.VISIBLE);
        ImageView myflagTz = (ImageView) findViewById(R.id.tzFlag);
        myflagTz.setVisibility(View.VISIBLE);
        ImageView myflagTn = (ImageView) findViewById(R.id.tnFlag);
        myflagTn.setVisibility(View.VISIBLE);
    }

    //onClick back to main and carry the points
    public void backToMain(View view) {

        Intent intAf = new Intent(this, MainActivity.class);
        startActivity(intAf);

    }

    //save data if you change orientation
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        //protected values
        savedInstanceState.putInt("scoreAfS", scoreAf);
        savedInstanceState.putBoolean("flagS", flag);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        //restore data
        if (savedInstanceState != null) {
            scoreAf = savedInstanceState.getInt("scoreAfS");
            flag = savedInstanceState.getBoolean("flagS");
        }

        //display score after rotation
        setscoreAf();

        //keep correct answers highlighted if submit was clicked
        if (!flag) {
            highlightAnswer();
            flagVisible();
        }
    }

    /**sharedpreferences saves the result for main activity*/
    public void save () {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("savedAf", scoreAf);
        editor.commit();
    }

}
