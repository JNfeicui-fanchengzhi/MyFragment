package com.fanfan.fragmentapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class FragmentD extends Fragment {
    private TextView mView;
    private Button mbtn_content;
    private String str;
    private int index;
    private String content;
    private Map<String,Object> map=new HashMap<String,Object>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         Bundle b=getArguments();
        index=b.getInt("index");
        content=b.getString("content");
        View view=inflater.inflate(R.layout.fragment_,container,false);
        mView= (TextView) view.findViewById(R.id.txt_content);
        mbtn_content= (Button) view.findViewById(R.id.btn_content);
        final Activity now=getActivity();


        mbtn_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.put("rindex",index+1);
                switch (index){
                    case 0:
                        str=((TextView)now.findViewById(R.id.tv_channel)).getText()+"";
                        map.put("rcontent","方位：东、五行：木、四季：春，为龙形");
                        break;
                    case 1:
                        str=((TextView)now.findViewById(R.id.tv_message)).getText()+"";
                        map.put("rcontent","方位：西、五行：金，四季：秋，为虎形");
                        break;
                    case 2:
                        str=((TextView)now.findViewById(R.id.tv_better)).getText()+"";
                        map.put("rcontent","方位：南、五行：炎、四季：夏，为鸟形");
                        break;
                    case 3:
                        str=((TextView)now.findViewById(R.id.tv_setting)).getText()+"";
                        map.put("rcontent","方位：北、五行：水、四季：冬，为龟形");
                        break;
                    default:
                        str="Nothing";
                        break;
                }
                mbtn_content.setText(index+"||"+str);
            }
        });
        mView.setText(content);
        return view;
    }
    public void setData(IResult result){
       result.getResult(map);
    }
    public interface IResult{
        public void getResult(Map<String,Object> map);
    }
}