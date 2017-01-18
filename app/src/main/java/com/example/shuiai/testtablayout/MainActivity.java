package com.example.shuiai.testtablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.shuiai.testtablayout.adapter.FramentAdapter;

public class MainActivity extends FragmentActivity  {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] titles = {"黄蓉", "郭靖", "杨过", "小龙女", "尹志平", "金轮法王", "收到货就收到货圣诞节"};
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        FramentAdapter framentAdapter = new FramentAdapter(getSupportFragmentManager(), titles);
        viewPager.setAdapter(framentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(getTabView(i));
        }
    }

    private View getTabView(int position) {
        View view = View.inflate(this, R.layout.item_tab_view, null);
        textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(titles[position]);
        return view;
    }


}
