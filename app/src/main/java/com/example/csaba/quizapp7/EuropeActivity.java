package com.example.csaba.quizapp7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EuropeActivity extends AppCompatActivity {

    int scoreEu = 16;

    public static final String mypreference = "mypref";
    public SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_europe);

        /**inicialization*/
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
    }

    public void boxInvisible1(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box1);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible2(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box2);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible3(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box3);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible4(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box4);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible5(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box5);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible6(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box6);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible7(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box7);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible8(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box8);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible9(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box9);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible10(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box10);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible11(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box11);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible12(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box12);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible13(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box13);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible14(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box14);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible15(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box15);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void boxInvisible16(View view) {
        ImageView mybox = (ImageView) findViewById(R.id.box16);
        mybox.setVisibility(View.INVISIBLE);
        scoreEu -= 1;
        showScore();
    }

    public void showScore() {
        TextView myscore = (TextView) findViewById(R.id.scoreEurope);
        myscore.setText(this.scoreEu + "");
    }


    //when click on back goes to the main page
    public void backToMain(View view) {

        //back to main and carry the score result there
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("intEu", scoreEu);
        startActivity(i);

    }

    //Submit button checks edittext and give a score
    public void submitEurope(View view) {

        EditText myCountry = (EditText) findViewById(R.id.country);
        String answer = myCountry.getText().toString();

        if (answer.toLowerCase().equals("hungary")||answer.toLowerCase().equals("hungary ")) {
            scoreEu += 20;
            showScore();
            Toast.makeText(this, "good answer! + 20points", Toast.LENGTH_LONG).show();
        } else {
            scoreEu = 0;
            showScore();
            Toast.makeText(this, "wrong answer. press back and try again", Toast.LENGTH_LONG).show();
        }

        //deactivate submit button to prevent repressing
        Button mySubmitAfrica = (Button) findViewById(R.id.submitCountry);
        mySubmitAfrica.setClickable(false);

        hideKeyboard();

        /** save score in sharedpreferences */
        save();
    }

    public void hideKeyboard() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**sharedpreferences saves the result for main activity*/
    public void save () {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("savedEu", scoreEu);
        editor.commit();
    }
}

