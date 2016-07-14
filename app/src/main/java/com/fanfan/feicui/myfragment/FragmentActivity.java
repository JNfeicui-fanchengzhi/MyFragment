package com.fanfan.feicui.myfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentActivity extends Fragment implements View.OnClickListener {
    private Button mbtn1,mbtn2;
    private TextView mView;

    private LinearLayout mll_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view=inflater.inflate(R.layout.fragment_fragment_demo,container,false);
        mbtn1= (Button) view.findViewById(R.id.btn1);
        mbtn2= (Button) view.findViewById(R.id.btn2);
        mView= (TextView) view.findViewById(R.id.tv_show);
        mbtn1.setOnClickListener(this);
        mbtn2.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
//        Button b=(Button) v;
//        mView.setText(((Button) v).getText());
//        FragmentManager fm=getActivity().getFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        if (v.getId()==R.id.btn1){
//            Fragment1 f1=new Fragment1();
//            ft.replace(R.id.ll_layout,f1);
//        }else {
//            Fragment2 f2=new Fragment2();
//            ft.replace(R.id.ll_layout,f2);
//        }
//        ft.commit();
        Button b=(Button) v;
        FragmentManager fm=getActivity().getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        switch (v.getId()){
            case R.id.btn1:
                mView.setText(b.getText());
                Fragment1 f1=new Fragment1();
                ft.replace(R.id.ll_layout,f1);
                break;
            case R.id.btn2:
                mView.setText(b.getText());
                Fragment2 f2=new Fragment2();
                ft.replace(R.id.ll_layout,f2);
                break;
        }
        ft.commit();
    }
}