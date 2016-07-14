package com.fanfan.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mtv_title, mtv_channel, mtv_message, mtv_better, mtv_setting;
    private FrameLayout mLayout;
    private FragmentD fd1, fd2, fd3, fd4;
    private FragmentManager fm;
    private String mStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getFragmentManager();
        initView();
        //执行单击
//        mtv_channel.performClick();
    }
    //UI组件初始化与事件绑定
    private void initView() {
        mtv_title = (TextView) findViewById(R.id.tv_title);
        mtv_channel = (TextView) findViewById(R.id.tv_channel);
        mtv_message = (TextView) findViewById(R.id.tv_message);
        mtv_better = (TextView) findViewById(R.id.tv_better);
        mtv_setting = (TextView) findViewById(R.id.tv_setting);
        mLayout= (FrameLayout) findViewById(R.id.fl_layout);
        mtv_channel.setOnClickListener(this);
        mtv_message.setOnClickListener(this);
        mtv_better.setOnClickListener(this);
        mtv_setting.setOnClickListener(this);
    }

    //重置所有文本的状态
    public void setSelected() {
        mtv_channel.setSelected(false);
        mtv_message.setSelected(false);
        mtv_better.setSelected(false);
        mtv_setting.setSelected(false);
    }

    //隐藏Fragment
    public void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fd1 != null) {
            fragmentTransaction.hide(fd1);
        }
        if (fd2 != null) {
            fragmentTransaction.hide(fd2);
        }
        if (fd3 != null) {
            fragmentTransaction.hide(fd3);
        }
        if (fd4 != null) {
            fragmentTransaction.hide(fd4);
        }
    }

    @Override
    public void onClick(View v) {
        //FragmentTransaction只能使用一次
        FragmentTransaction ft = fm.beginTransaction();
        hideAllFragment(ft);
        Bundle pram=new Bundle();
        switch (v.getId()){
            case R.id.tv_channel:
                setSelected();
                //给fragment传参
                pram.putString("content","四象之青龙");
                pram.putInt("index",0);
                mtv_channel.setSelected(true);
                if (fd1==null){
                    fd1=new FragmentD();
                    ft.add(R.id.fl_layout,fd1);
                    fd1.setArguments(pram);
                }else {
                    ft.show(fd1);
                }
                fd1.setData(new FragmentD.IResult() {
                    @Override
                    public void getResult(Map<String, Object> map) {
                        mStr =(String)map.get("rcontent");
//                        mStr = (Integer) map.get("rindex")+(String)map.get("rcontent");
                        mtv_title.setText(mStr);
                    }
                });
                break;
            case R.id.tv_message:
                setSelected();
                pram.putInt("index",1);
                pram.putString("content","四象之白虎");
                if (fd2==null){
                    fd2=new FragmentD();
                    ft.add(R.id.fl_layout,fd2);
                    fd2.setArguments(pram);
                }else {
                    ft.show(fd2);
                }
                fd2.setData(new FragmentD.IResult() {
                    @Override
                    public void getResult(Map<String, Object> map) {
                        mStr=(String)map.get("rcontent");
                        mtv_title.setText(mStr);
                    }
                });
                break;
            case R.id.tv_better:
                setSelected();
                pram.putInt("index",2);
                pram.putString("content","四象之朱雀");
                if (fd3==null){
                    fd3=new FragmentD();
                    ft.add(R.id.fl_layout,fd3);
                    fd3.setArguments(pram);
                }else {
                    ft.show(fd3);
                }
                fd3.setData(new FragmentD.IResult() {
                    @Override
                    public void getResult(Map<String, Object> map) {
                        mStr=(String)map.get("rcontent");
                        mtv_title.setText(mStr);
                    }
                });
                break;
            case R.id.tv_setting:
                setSelected();
                pram.putInt("index",3);
                pram.putString("content","四象之玄武");
                if (fd4==null){
                    fd4=new FragmentD();
                    ft.add(R.id.fl_layout,fd4);
                    fd4.setArguments(pram);
                }else {
                    ft.show(fd4);
                }
                fd4.setData(new FragmentD.IResult() {
                    @Override
                    public void getResult(Map<String, Object> map) {
                        mStr=(String)map.get("rcontent");
                        mtv_title.setText(mStr);
                    }
                });
                break;
        }
        ft.commit();
    }
}
