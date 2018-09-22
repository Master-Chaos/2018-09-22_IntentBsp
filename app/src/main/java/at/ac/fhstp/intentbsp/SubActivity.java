package at.ac.fhstp.intentbsp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SubActivity extends AppCompatActivity {
    private static final String TAG = "SubActi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent i = getIntent();
        Log.i(TAG, "intent data:");
        if (i.hasExtra("count")){
            int cnt = i.getIntExtra("count", 0); //i für info I ist loglevel d für debug, e für error
            Log.e(TAG, "error with error count " + cnt + "!!!");
        }
        else {
            Log.i(TAG, "no count defined");
        }

        if (i.hasExtra("name")){
            Log.i(TAG, "name:" + i.getStringExtra("name")); //OUTPUT IN CATLOG
        }

        i.putExtra("score", 0.77f); //Wert soll zwischen 0 oder 1 sein fügt die werte hinzu zum mainwerte
        i.putExtra("address", "1120 Vienna"); //fügt die werte hinzu zum mainwerte
        setResult(RESULT_OK, i);

    }
}
