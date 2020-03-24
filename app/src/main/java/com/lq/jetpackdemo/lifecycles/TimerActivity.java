package com.lq.jetpackdemo.lifecycles;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.lq.jetpackdemo.R;
import com.lq.jetpackdemo.databinding.ActivityTimerBinding;

/**
 * @author : lq
 * @date : 2020/3/24
 * @desc : 使用lifecycles完成一个计时器
 */
public class TimerActivity extends AppCompatActivity {
    ActivityTimerBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_timer);
        getLifecycle().addObserver(binding.textView5);

    }
}
