package cn.com.yw56.driver;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * {@link RecyclerView.Adapter} that can display a {@link OperationItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends BaseRecyclerAdapter<MyItemRecyclerViewAdapter.OperationItem> {
    public MyItemRecyclerViewAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        return new MyHolder(layout);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, OperationItem data) {
//        if (viewHolder instanceof MyHolder) {
//            ((MyHolder) viewHolder).text.setText(data.toString());
//        }
    }

    class MyHolder extends BaseRecyclerAdapter.Holder {
        TextView text;

        public MyHolder(View itemView) {
            super(itemView);
//            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    public static class OperationItem {
    }
}
