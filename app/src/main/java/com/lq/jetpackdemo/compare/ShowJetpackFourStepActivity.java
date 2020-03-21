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
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lq.jetpackdemo.R;
import com.lq.jetpackdemo.compare.viewmodels.ShowJetpackThreeStepViewModel;
import com.lq.jetpackdemo.databinding.ActivityShowjetpackFourstepBinding;

/**
 * @author : lq
 * @date : 2020/3/21
 * @desc :第四步，使用 DataBinding：
 * 1,gradle 中 android 标签下添加对DataBinding的支持
 *    dataBinding {
 *         enabled = true
 *     }
 * 2,布局文件转为 DataBinding layout 形式。
 * 3,activity 中 setContentView 改为 DataBindingUtil.setContentView
 * 4，所有 findViewById 引用可用 binding.id 引用.
 * 5,布局文件绑定数据，在data标签下绑定viewmodel数据.
 * 显示数值的 TextView 中，添加 android:text="@{String.valueOf(data.number)}"
 * +1 按钮 添加呼叫函数 android:onClick="@{()->data.addNumber(1)}"
 * 注释掉activity中对number的监听和button的监听
 * 添加数据绑定和生命周期设置
 *         binding.setData(viewModel);
 *         binding.setLifecycleOwner(this);
 *  完成。
 */
public class ShowJetpackFourStepActivity extends AppCompatActivity {

    //此 ActivityShowjetpackFourstepBinding 名字由布局文件名字生成。
    private ActivityShowjetpackFourstepBinding binding;
    private ShowJetpackThreeStepViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_showjetpack_fourstep);
        //获取 viewModel 对象
        viewModel = new ViewModelProvider(this).get(ShowJetpackThreeStepViewModel.class);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(this.getClass().getSimpleName());
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        binding.setData(viewModel);
        binding.setLifecycleOwner(this);
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
