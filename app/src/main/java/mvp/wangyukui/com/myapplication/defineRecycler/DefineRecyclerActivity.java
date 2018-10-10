package mvp.wangyukui.com.myapplication.defineRecycler;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mvp.wangyukui.com.myapplication.MyRecyclerTwoAdapter;
import mvp.wangyukui.com.myapplication.R;
import mvp.wangyukui.com.myapplication.defineRecycler.PullRefreshRecyclerView;


/**
 * Created by lenvo on 2018/10/10.
 */

public class DefineRecyclerActivity extends AppCompatActivity {
    private PullRefreshRecyclerView pullRefreshRecyclerView;
    private List<String> listData = new ArrayList();
    private MyRecyclerTwoAdapter myRecyclerTwoAdapter;
    private MessageRelativeLayout messageRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_recycler);
        initData();
        messageRelativeLayout = findViewById(R.id.messageRelativeLayout);
        pullRefreshRecyclerView = findViewById(R.id.pullRefreshRecyclerView);
        pullRefreshRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerTwoAdapter = new MyRecyclerTwoAdapter(listData);
        pullRefreshRecyclerView.setAdapter(myRecyclerTwoAdapter);
        pullRefreshRecyclerView.setOnRefreshListener(onRefreshListener);
    }

    private PullRefreshRecyclerView.OnRefreshListener onRefreshListener = new PullRefreshRecyclerView.OnRefreshListener() {

        @Override
        public void onRefresh() {
            new MyThread().start();
            messageRelativeLayout.setMessage("更新了800条数据");
            pullRefreshRecyclerView.stopRefresh();
        }

        @Override
        public void onLoadMore() {
            new MyThread().start();
            pullRefreshRecyclerView.stopLoadMore();
        }
    };

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            SystemClock.sleep(2000);
        }
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            listData.add("这是第  " + i + "  数据");
        }
    }
}
