package at.ac.fhstp.intentbsp;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_SUB_ACT = 7; //DEFINE A REQUEST_SUB_ACT NUMBER
    private final static String TAG = "MainActivity"; //DEFINE A TAG WITH A STING MAINACTIVITY

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOnClick(View view) //FUNCTION FOR OPEN ACTIVITY BUTTON
    {
        Intent intent = new Intent(this, SubActivity.class); //CREATE A NEW INTENT CLASS FOR SWITCH TO SUBACTIVITY VIEW
        intent.putExtra("count", 7); //ADD EXTRA INPUTDATA
        intent.putExtra("name", "Max Maier"); //ADD EXTRA INPUTDATA
        //startActivity(intent); //START ACTIVITY OF THE CREATED INTENT
        startActivityForResult(intent, REQUEST_SUB_ACT); //START ACTIVITY FOR RESULT
    }

    public void btnOpenUrl(View view) //FUNCTION FOR OPEN URL BUTTON (FOILSET 2; FOIL 16)
    {
        Log.i(TAG, "TODO open url ..."); //OUTPUT MESSAGE TO LOGCAT FOR LOG IT - LOGLEVELTYPE: i = INFO
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.at")); //CREATE A NEW INTENT CLASS FOR OPEN A URL
        startActivity(intent); //START ACTIVITY OF THE CREATED INTENT
    }

    public void btnOpenMedia(View view) //FUNCTION FOR OPEN MEDIA BUTTON (FOILSET 2; FOIL 16)
    {
        Log.i(TAG, "TODO open Media ..."); //OUTPUT MESSAGE TO LOGCAT FOR LOG IT - LOGLEVELTYPE: i = INFO
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //CREATE A NEW INTENT CLASS FOR MEDIA
        startActivity(intent); //START ACTIVITY OF THE CREATED INTENT
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SUB_ACT) //CHECK IF REQUESTCODE IS REQUEST_SUB_ACT
        {
            Log.i(TAG, "result code" + resultCode); //OUTPUT MESSAGE TO LOGCAT FOR LOG IT - LOGLEVELTYPE: i = INFO
            if (resultCode == RESULT_OK) //CHECK IF RESULTCODE IS RESULT_OK
            {
                Log.i(TAG, "result ok!"); //OUTPUT MESSAGE TO LOGCAT FOR LOG IT - LOGLEVELTYPE: i = INFO
                Log.i(TAG, "score " + data.getFloatExtra("score", 0.0f)); //OUTPUT MESSAGE TO LOGCAT FOR LOG IT - LOGLEVELTYPE: i = INFO
                if (data.hasExtra("address")){ //CHECK IF INTENT I HAS EXTRA DATA BY ADDRESS
                    Log.i(TAG, "address " + data.getStringExtra("address")); //OUTPUT MESSAGE TO LOGCAT FOR LOG IT - LOGLEVELTYPE:i = INFO
                }
            }
            else
            {
                Log.w(TAG, "result code not ok (Canceld)"); //OUTPUT MESSAGE TO LOGCAT FOR LOG IT - LOGLEVELTYPE: w = WARNING
            }
        }
    }
}
