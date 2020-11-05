package com.lixm.notes.circle;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.lixm.notes.R;

public class CircleActivity extends AppCompatActivity {
    private DonutProgress donutProgress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        donutProgress = findViewById(R.id.dpDonut);

    }
}
