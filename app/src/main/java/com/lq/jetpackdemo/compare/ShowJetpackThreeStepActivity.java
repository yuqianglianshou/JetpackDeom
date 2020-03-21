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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lq.jetpackdemo.R;
import com.lq.jetpackdemo.compare.viewmodels.ShowJetpackThreeStepViewModel;

/**
 * @author : lq
 * @date : 2020/3/21
 * @desc :第三步，使用LiveData感知数据变化：
 * 1，使用 MutableLiveData 封装viewmodel下的number变量，添加获取和修改number的方法。
 * 2，在activity中添加对 viewmodel 中 number 变量的观察。
 * 3，在activity中同步对number的获取、修改操作。
 *
 */
public class ShowJetpackThreeStepActivity extends AppCompatActivity {
    TextView textview;
    ImageButton imageButton;

    ShowJetpackThreeStepViewModel viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showjetpack);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(this.getClass().getSimpleName());
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        textview = findViewById(R.id.textView);
        imageButton = findViewById(R.id.imageButton2);

        //获取 viewModel 对象
        viewModel = new ViewModelProvider(this).get(ShowJetpackThreeStepViewModel.class);
        //添加number变量的改变监听
        viewModel.getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textview.setText(String.valueOf(integer));
            }
        });


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addNumber(1);
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
