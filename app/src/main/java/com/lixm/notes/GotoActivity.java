package com.lixm.notes;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GotoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goto);
    }
    public void onGotoB(View view){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this,BActivity.class));
        startActivity(intent);
    }
}
