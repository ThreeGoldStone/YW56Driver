package cn.com.yw56.driver;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cn.com.yw56.driver.model.bean.CustomerBean;
import cn.com.yw56.driver.model.bean.StationBean2;

/**
 * Created by DJl on 2017/5/3.
 * email:1554068430@qq.com
 */

public class CustomerListAdapter extends BaseExpandableListAdapter {
    ArrayList<StationBean2> stationBeen;
    Activity context;

    public CustomerListAdapter(ArrayList<StationBean2> stationBeen, Activity context) {
        this.stationBeen = stationBeen;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return stationBeen == null ? 0 : stationBeen.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        StationBean2 stationBean = stationBeen.get(groupPosition);
        return stationBeen == null ? 0 :
                (stationBean == null ? 0 :
                        (stationBean.customerBeen == null ? 0 :
                                stationBean.customerBeen.size()));
    }

    @Override
    public StationBean2 getGroup(int groupPosition) {
        return stationBeen.get(groupPosition);
    }

    @Override
    public CustomerBean getChild(int groupPosition, int childPosition) {
        return stationBeen.get(groupPosition).customerBeen.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition * 1000 + childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View inflate = context.getLayoutInflater().inflate(R.layout.item_station2, null);
        TextView name = (TextView) inflate.findViewById(R.id.tvIStationName);
        name.setText(getGroup(groupPosition).name);
        TextView count = (TextView) inflate.findViewById(R.id.tvICount);
        count.setText("(" + getChildrenCount(groupPosition) + ")");
        return inflate;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View inflate = context.getLayoutInflater().inflate(R.layout.item_customer2, null);
        TextView name = (TextView) inflate.findViewById(R.id.tviName);
        name.setText(getChild(groupPosition, childPosition).name);
        return inflate;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
