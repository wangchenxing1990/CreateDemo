package mvp.wangyukui.com.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenvo on 2018/10/8.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter {
    private static final int HEAD_ITEM = 0;
    private static final int NORMAL_ITEM = 1;
    private List<String> listData;
    private Activity activity;

    public MyRecyclerAdapter(Activity activity, List<String> listData) {
        this.listData = listData;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
            ItemViewHolder itemViewHolder = new ItemViewHolder(viewItem);
            return itemViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder)holder).text.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

//
//    @Override
//    public int getItemViewType(int position) {
//        if (position == 0) {
//            return HEAD_ITEM;
//        } else {
//            return NORMAL_ITEM;
//        }
//    }

//    public class HeadViewHolder extends RecyclerView.ViewHolder {
//
//        public HeadViewHolder(View itemView) {
//            super(itemView);
//
//        }
//    }
//
//    MyRecyclerTwoAdapter myItemAdapter;

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public ItemViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text_view);

        }
    }


}
