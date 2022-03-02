package in.pickpet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;

import in.pickpet.OnBoarding.OnBoardingFirstActivity;

public class SplashActivity extends AppCompatActivity {

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        builder = new AlertDialog.Builder(this);

//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                startActivity(new Intent(SplashActivity.this, OnBoardingFirstActivity.class));
//                finish();
//            }
//        },3000);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()==true )
        {

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user!=null){
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                        finish();
                    }
                },3000);

            }else {
                startActivity(new Intent(SplashActivity.this,OnBoardingFirstActivity.class));
            }


        }
        else
        {

            //Uncomment the below code to Set the message and title from the strings.xml file
            builder.setMessage("") .setTitle("No Internet");

            //Setting message manually and performing action on button click
            builder.setMessage("No internet connection !!")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    });
            //Creating dialog box
            AlertDialog alert = builder.create();
            alert.show();

        }

    }
}