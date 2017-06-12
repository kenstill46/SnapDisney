package it.greenriver.edu.snapdisney;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button mMickeyButton;
    private Button mGoofyButton;
    private Button mDonaldButton;

    //Create 3 buttons (Mickey, Minnie, Donald)
    //onclick send explicit intent with drawable ears to in-app camera
    //onclick play sound of selected character
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change to appropriate files once acquired
        final MediaPlayer mickeyPlayer = MediaPlayer.create(this, R.raw.hotdog);
        final MediaPlayer goofyPlayer = MediaPlayer.create(this, R.raw.goofy);
        //change donald to a donald sound once acquired
        final MediaPlayer donaldPlayer = MediaPlayer.create(this, R.raw.goofy);

        mMickeyButton = (Button)findViewById(R.id.mickey_button);
        mMickeyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                changeActivity("Mickey");
                mickeyPlayer.start();
            }

        });

        mGoofyButton = (Button)findViewById(R.id.goofy_button);
        mGoofyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                changeActivity("Goofy");
                goofyPlayer.start();
            }

        });

        mDonaldButton = (Button)findViewById(R.id.donald_button);
        mDonaldButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                changeActivity("Donald");
                donaldPlayer.start();
            }

        });


    }

    private void changeActivity(String charFilter){

        Intent cameraIntent = new Intent(this, CameraActivity.class);
        startActivity(cameraIntent);

        //send intent to CameraActivity with selected character filter

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, charFilter, duration);
        toast.show();
    }


}
