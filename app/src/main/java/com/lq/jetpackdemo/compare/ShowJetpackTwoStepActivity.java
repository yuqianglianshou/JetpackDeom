package com.lq.jetpackdemo.compare;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.lq.jetpackdemo.R;
import com.lq.jetpackdemo.compare.viewmodels.ShowJetpackTwoStepViewModel;

/**
 * @author : lq
 * @date : 2020/3/21
 * @desc :第二步，从 MVC 到 MVVM：
 *      1，添加依赖，2020 年 1 月 22 日	2.2.0  稳定版，具体参考 https://developer.android.google.cn/jetpack/androidx/releases/lifecycle#version_220_3
 *     def lifecycle_version = "2.2.0"
 *     // ViewModel
 *     implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
 *     // LiveData
 *     implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"
 *     // Lifecycles only (without ViewModel or LiveData)
 *     implementation "androidx.lifecycle:lifecycle-runtime:$lifecycle_version"
 *     2，创建viewmodel类，即本例中的 ShowJetpackOneStepViewModel，将计数变量 number 从 activity 中转移到 viewmodel 下。
 *     3，在activity中获取viewmodel对象，将原number替换。
 */
public class ShowJetpackTwoStepActivity extends AppCompatActivity {
    TextView textview;
    ImageButton imageButton;

    ShowJetpackTwoStepViewModel viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showjetpack);
        //获取 viewModel 对象
        viewModel = new ViewModelProvider(this).get(ShowJetpackTwoStepViewModel.class);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(this.getClass().getSimpleName());
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        textview = findViewById(R.id.textView);
        imageButton = findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.number+=1;
                textview.setText(String.valueOf(viewModel.number));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
