package cn.com.yw56.driver.model.bean;

import java.util.ArrayList;

/**
 * Created by DJl on 2017/5/3.
 * email:1554068430@qq.com
 */

public class StationBean2 {
    public String name;
    public String location;
    public String startTime;
    public String endTime;
    public ArrayList<CustomerBean> customerBeen;

    public StationBean2(String name, String location, ArrayList<CustomerBean> customerBeen) {
        this.name = name;
        this.location = location;
        this.customerBeen = customerBeen;
    }
}
