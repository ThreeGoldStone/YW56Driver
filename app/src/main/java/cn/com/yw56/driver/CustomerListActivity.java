package cn.com.yw56.driver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.com.yw56.driver.model.bean.CustomerBean;
import cn.com.yw56.driver.model.bean.StationBean2;

public class CustomerListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("客户列表");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        ExpandableListView exListVIew = (ExpandableListView) findViewById(R.id.exListView);
        ArrayList<StationBean2> stationBeen = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<CustomerBean> customerBeen = new ArrayList<>();
            for (int i1 = 0; i1 < i + 2; i1++) {
                customerBeen.add(new CustomerBean(i + "李四" + i1, i + "  " + i1));
            }
            StationBean2 e = new StationBean2("通州" + i, "通州梨园" + i, customerBeen);
            stationBeen.add(e);
        }
        exListVIew.setAdapter(new CustomerListAdapter(stationBeen, this));
    }

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, CustomerListActivity.class));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_map, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_confirm) {
            Toast.makeText(getApplicationContext(), "更新成功!", Toast.LENGTH_SHORT);
            finish();
            return true;
        } else if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
