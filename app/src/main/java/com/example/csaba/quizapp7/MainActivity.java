package com.example.csaba.quizapp7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

//import static com.example.android.quizapp7.R.id.mainScoreAme;

public class MainActivity extends AppCompatActivity {

    public int amScore;
    public int afScore;
    public int euScore;
    public int number;
    public int intEu;
    public int intAm;
    public int intAf;
    public int scoreEu;
    public int scoreAm;
    public int scoreAf;
    public int numberAf;


    public static final String mypreference = "mypref";
    public SharedPreferences sharedpreferences;
    public int valueAfrica;
    public int valueEurope;
    public int valueAmerica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**inicialization*/
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        /**get sharedpreferences from page Africa*/
        valueAfrica = sharedpreferences.getInt("savedAf", 0);
        if (valueAfrica > 0) {
            TextView second = (TextView) findViewById(R.id.mainScoreAfrica);
            second.setText("" + valueAfrica);
        } else {}

        /**get sharedpreferences from page America*/
        valueAmerica = sharedpreferences.getInt("savedAm", 0);
        if (valueAmerica > 0) {
            TextView third = (TextView) findViewById(R.id.mainScoreAme);
            third.setText("" + valueAmerica);
        } else {}

        /**get sharedpreferences from page Europe*/
        valueEurope = sharedpreferences.getInt("savedEu", 0);
        if (valueEurope > 0) {
            TextView fourth = (TextView) findViewById(R.id.mainScoreEu);
            fourth.setText("" + valueEurope);
        } else {}








    }


    //save data if you change orientation
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putInt("amScoreS", amScore);
        savedInstanceState.putInt("euScoreS", euScore);
        savedInstanceState.putInt("afScoreS", afScore);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        if (savedInstanceState != null) {

            amScore = savedInstanceState.getInt("amScoreS");
            euScore = savedInstanceState.getInt("euScoreS");
            afScore = savedInstanceState.getInt("afScoreS");

        }
    }


    /**
     * opens new page on click
     */
    public void openAfricaPage(View view) {
        Intent i = new Intent(this, AfricaActivity.class);
        startActivity(i);
    }

    //opens new page onclick
    public void openAmericaPage(View view) {
        Intent i = new Intent(this, AmericaActivity.class);
        startActivity(i);
    }

    //opens new page onclick
    public void openEuropePage(View view) {
        Intent i = new Intent(this, EuropeActivity.class);
        startActivity(i);
    }

    /** clear high scores and sharedpreferences*/
    public void clearHighScores (View view){
        TextView clear1 = (TextView) findViewById(R.id.mainScoreAfrica);
        clear1.setText("0");
        TextView clear2 = (TextView) findViewById(R.id.mainScoreEu);
        clear2.setText("0");
        TextView clear3 = (TextView) findViewById(R.id.mainScoreAme);
        clear3.setText("0");

        valueEurope = 0;
        valueAmerica = 0;
        valueAfrica = 0;

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("savedAf", valueAfrica);
        editor.putInt("savedAm", valueAmerica);
        editor.putInt("savedEu", valueEurope);
        editor.commit();
    }




}
