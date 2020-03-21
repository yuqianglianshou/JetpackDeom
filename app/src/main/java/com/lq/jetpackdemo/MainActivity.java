package com.lq.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lq.jetpackdemo.compare.ShowJetpackActivity;
import com.lq.jetpackdemo.compare.ShowJetpackFourStepActivity;
import com.lq.jetpackdemo.compare.ShowJetpackTwoStepActivity;
import com.lq.jetpackdemo.compare.ShowJetpackThreeStepActivity;
import com.lq.jetpackdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowJetpackActivity.class));
            }
        });
        binding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowJetpackTwoStepActivity.class));
            }
        });
        binding.imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowJetpackThreeStepActivity.class));
            }
        });
        binding.imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowJetpackFourStepActivity.class));
            }
        });
    }
}
