package com.apple.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> lists;
    private MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
//      mRecyclerView.addItemDecoration();
        //new LinearLayoutManager(getApplicationContext())
        StaggeredGridLayoutManager  StaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, android.support.v7.widget.StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(StaggeredGridLayoutManager);//设置RecyclerView布局管理器为2列垂直排布
        adapter = new MyRecyclerAdapter(this, lists);
        mRecyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new MyRecyclerAdapter.OnItemClickListener() {
            @Override
            public void ItemClickListener(View view, int postion) {
                Toast.makeText(MainActivity.this, "点击了：" + postion, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void ItemLongClickListener(View view, int postion) {
                //长按删除
                lists.remove(postion);
                adapter.notifyItemRemoved(postion);
            }
        });
        ListView
    }

    private void initData() {
        lists = new ArrayList();
        for (int i = 0; i < 100; i++) {
            lists.add("" + i);
        }
    }


}
