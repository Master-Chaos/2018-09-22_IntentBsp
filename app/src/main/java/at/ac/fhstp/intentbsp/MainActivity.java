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
    private final static int REQUEST_SUB_ACT = 7;
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOnClick(View view)
    {
        //..
        Intent intent = new Intent(this, SubActivity.class); //ERSTELLT DIE KLASSEN
        intent.putExtra("count", 7);
        intent.putExtra("name", "Max Maier");
        //startActivity(intent);
        startActivityForResult(intent, REQUEST_SUB_ACT);
    }

    public void btnOpenUrl(View view) //URL ÖFFNEN Foliensatz 2 Folie 16
    {
        Log.i(TAG, "TODO open url ...");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.at"));
        startActivity(intent);
    }

    public void btnOpenMedia(View view) //Media ÖFFNEN Foliensatz 2 Folie 16
    {
        Log.i(TAG, "TODO open Media ...");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SUB_ACT)
        {
            Log.i(TAG, "result code" + resultCode);
            if (resultCode == RESULT_OK)
            {
                Log.i(TAG, "result ok!");
                Log.i(TAG, "score " + data.getFloatExtra("score", 0.0f));
                if (data.hasExtra("address")){
                    Log.i(TAG, "address " + data.getStringExtra("address"));
                }
            }
            else
            {
                Log.w(TAG, "result code not ok (Canceld)"); //w = warning
            }
        }
    }
}
