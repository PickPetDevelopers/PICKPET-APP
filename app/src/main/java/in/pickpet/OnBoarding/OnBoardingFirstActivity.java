package in.pickpet.OnBoarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.xcode.onboarding.OnBoarder;
import com.xcode.onboarding.OnBoardingPage;

import java.util.ArrayList;
import java.util.List;

import in.pickpet.R;

public class OnBoardingFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_first);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//
        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardingFirstActivity.this,OnBoardingSecondActivity.class));
            }
        });
    }
}