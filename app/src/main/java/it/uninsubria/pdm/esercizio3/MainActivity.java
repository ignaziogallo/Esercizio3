package it.uninsubria.pdm.esercizio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SemaphoreView circularProgressbar1 = findViewById(R.id.circularProgressbar1);
        SemaphoreView circularProgressbar2 = findViewById(R.id.circularProgressbar2);
        SemaphoreView circularProgressbar3 = findViewById(R.id.circularProgressbar3);

        circularProgressbar1.setLightOn("RED");
        circularProgressbar2.setLightOn("YELLOW");
        circularProgressbar3.setLightOn("GREEN");

    }
}
