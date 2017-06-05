package it.greenriver.edu.snapdisney;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mMickeyButton;
    private Button mMinnieButton;
    private Button mDonaldButton;

    //Create 3 buttons (Mickey, Minnie, Donald)
    //onclick send explicit intent with drawable ears to in-app camera
    //onclick play sound of selected character
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mMickeyButton = (Button)findViewById(R.id.mickey_button);
        mMickeyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeActivity("mickey");
            }

        });

        mMinnieButton = (Button)findViewById(R.id.minnie_button);
        mMinnieButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeActivity("minnie");
            }

        });

        mDonaldButton = (Button)findViewById(R.id.donald_button);
        mDonaldButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeActivity("donald");
            }

        });


    }

    private void changeActivity(String charFilter){
        //add a "playsound" function based on charFilter, gets sound from resources

        //send intent to CameraActivity with selected character filter

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, charFilter, duration);
        toast.show();
    }


}
