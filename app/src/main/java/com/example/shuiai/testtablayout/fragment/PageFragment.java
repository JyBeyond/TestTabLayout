package com.example.shuiai.testtablayout.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shuiai.testtablayout.R;

/**
 * @author shuiai@dianjia.io
 * @Company 杭州木瓜科技有限公司
 * @date 2017/1/18
 */

public class PageFragment extends Fragment {
    private int position;
    private String[] titles;
  private  Context context;
    public static PageFragment newInstace(int position, String[] titles) {
        Bundle bundle = new Bundle();
        bundle.putInt("POSITION", position);
        bundle.putStringArray("ARRAY", titles);
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("POSITION");
        titles = getArguments().getStringArray("ARRAY");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.item_layout,null);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(titles[position]);
        return view;
    }
}
