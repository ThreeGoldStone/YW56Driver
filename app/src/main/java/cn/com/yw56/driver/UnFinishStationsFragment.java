package cn.com.yw56.driver;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.djl.view.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import cn.com.yw56.driver.model.bean.StationBean;

/**
 * A placeholder fragment containing a simple view.
 */
public class UnFinishStationsFragment extends Fragment implements AdapterView.OnItemClickListener {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private ListView lv;

    public UnFinishStationsFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static UnFinishStationsFragment newInstance() {
        UnFinishStationsFragment fragment = new UnFinishStationsFragment();
        Bundle args = new Bundle();
//        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        lv = (ListView) rootView.findViewById(R.id.lv);
        ArrayList<StationBean> stationBeen = new ArrayList<>();
        stationBeen.add(new StationBean("张三", "通州", "15:40", "16:00", 10));
        stationBeen.add(new StationBean("李四", "上地", "16:40", "17:00", 1));
        stationBeen.add(new StationBean("王五", "昌平", "18:40", "19:00", 5));
        lv.addHeaderView(inflater.inflate(R.layout.head_unfinish, null));
        lv.setAdapter(new MyAdapter<StationBean>(stationBeen, getActivity()) {
            @Override
            protected void setView(HashMap<Integer, View> holder, StationBean item, int position) {
                ((TextView) holder.get(R.id.tvIStationName)).setText(item.location);
                ((TextView) holder.get(R.id.tvICount)).setText("(" + item.count + ")");
                ((TextView) holder.get(R.id.tvITime)).setText(item.startTime + " - " + item.endTime);
            }

            @Override
            protected ViewWithTag initConvertView() {
                return getViewWithTag(R.layout.item_station, R.id.tvIStationName, R.id.tvICount, R.id.tvITime);
            }
        });

        lv.setOnItemClickListener(this);
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        StationDetailActivity.start(getActivity(),position);
    }
}