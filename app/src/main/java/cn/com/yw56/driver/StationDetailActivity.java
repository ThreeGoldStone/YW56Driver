package cn.com.yw56.driver;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.djl.view.DJLUtils;

import java.util.ArrayList;
import java.util.List;

public class StationDetailActivity extends AppCompatActivity implements BaseRecyclerAdapter.OnItemClickListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private int position;
    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        position = getIntent().getIntExtra("position", 1);
        recyclerView = (RecyclerView) findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<MyItemRecyclerViewAdapter.OperationItem> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new MyItemRecyclerViewAdapter.OperationItem());
        }
        MyItemRecyclerViewAdapter adapter = new MyItemRecyclerViewAdapter();
        if (position > 0) {
            getSupportActionBar().setTitle("上地揽收点");
            adapter.setHeaderView(getLayoutInflater().inflate(R.layout.headview_station, null));
            headerView = adapter.getHeaderView();
            headerView.findViewById(R.id.btArrive).setOnClickListener(this);
            headerView.findViewById(R.id.btFinish).setOnClickListener(this);
        } else {
            getSupportActionBar().setTitle("未分配");
        }
        adapter.setDatas(list);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyItemDecoration());
    }

    public static void start(Activity activity, int position) {
        Intent intent = new Intent(activity, StationDetailActivity.class);
        intent.putExtra("position", position);
        activity.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (position > 0) getMenuInflater().inflate(R.menu.menu_station_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_relocation) {
            MapActivity.start(this);
            return true;
        } else if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position, Object data) {
        Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
        CustomerDetailActivity.start(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btArrive:
                v.setVisibility(View.GONE);
                headerView.findViewById(R.id.tvArriveR).setVisibility(View.VISIBLE);
                headerView.findViewById(R.id.tvArriveTime1R).setVisibility(View.VISIBLE);
                break;
            case R.id.btFinish:
                v.setVisibility(View.GONE);
                headerView.findViewById(R.id.tvFinishR).setVisibility(View.VISIBLE);
                headerView.findViewById(R.id.tvFinishTime1R).setVisibility(View.VISIBLE);
                break;
        }
    }

    static class MyItemDecoration extends RecyclerView.ItemDecoration {

        private final Paint paint;
        private int topGap = 10;

        public MyItemDecoration() {
            paint = new Paint();
            paint.setARGB(0xff, 0xff, 0x00, 0x00);
        }

        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            c.drawColor(0xffd0d0d0);
            DJLUtils.log("onDraw");
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = parent.getChildAt(i);
                int position = parent.getChildAdapterPosition(view);
//                long groupId = callback.getGroupId(position);
//                if (groupId < 0) return;
//                String textLine = callback.getGroupFirstLine(position).toUpperCase();
//                if (position == 0 || isFirstInGroup(position)) {
                float top = view.getTop() - topGap;
                float bottom = view.getTop();
                c.drawRect(left, top, right, bottom, paint);//绘制红色矩形
//                c.drawText(textLine, left, bottom, textPaint);//绘制文本
//                }
            }
        }

        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            DJLUtils.log("onDrawOver");
            c.drawRect(0, 100, 200, 200, paint);
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.top = topGap;
            int position = parent.getChildAdapterPosition(view);
            if (position % 2 == 0) {
                outRect.left = 15;
            }
            DJLUtils.log("getItemOffsets  > " + position);
        }
    }
}
