package cn.com.yw56.driver.model.bean;

import java.util.ArrayList;

/**
 * Created by DJl on 2017/5/3.
 * email:1554068430@qq.com
 */

public class StationBean {
    public final int count;
    public String name;
    public String location;
    public String startTime;
    public String endTime;
    //    public ArrayList<CustomerBean> customerBeen;

    public StationBean(String name, String location, String startTime, String endTime,int count) {
        this.count = count;
        this.name = name;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
