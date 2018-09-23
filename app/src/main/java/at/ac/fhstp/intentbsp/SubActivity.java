package at.ac.fhstp.intentbsp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SubActivity extends AppCompatActivity {
    private static final String TAG = "SubActi";  //DEFINE A TAG WITH A STING SUBACTI

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent i = getIntent(); //GET THE INTENT FROM MAIN AN SAVE IT IN A NEW INTENT VAR I
        Log.i(TAG, "intent data:"); //OUTPUT MESSAGE TO LOGCAT FOR LOG IT - LOGLEVELTYPE: i = INFO
        if (i.hasExtra("count")){ //CHECK IF INTENT I HAS EXTRA DATA BY COUNT
            int cnt = i.getIntExtra("count", 0); //CREATE INT CNT TO SAVE VALUE OF COUNT i für info I ist loglevel d für debug, e für error
            Log.e(TAG, "error with error count " + cnt + "!!!"); //OUTPUT MESSAGE AND VALUE OF CNT TO LOGCAT FOR LOG IT - LOGLEVELTYPE: e = ERROR
        }
        else {
            Log.i(TAG, "no count defined"); //OUTPUT MESSAGE TO LOGCAT FOR LOG IT - LOGLEVELTYPE: i = INFO
        }

        if (i.hasExtra("name")){ //CHECK IF INTENT I HAS EXTRA DATA BY NAME
            Log.i(TAG, "name:" + i.getStringExtra("name")); //OUTPUT MESSAGE TO LOGCAT FOR LOG IT - LOGLEVELTYPE: i = INFO
        }

        i.putExtra("score", 0.77f); //ADD VALUE FOR SCORE TO I (VALUE MUST BE BETWEEN 0 AND 1)
        i.putExtra("address", "1120 Vienna"); //ADD VALUE FOR ADDRESS TO I
        setResult(RESULT_OK, i); //SET RESULT TO RESULTVALUE RESULT_OK

    }
}
