package mvp.wangyukui.com.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenvo on 2018/10/8.
 */

public class MyRecyclerTwoAdapter extends RecyclerView.Adapter {
    private  List<String> listData;

    public MyRecyclerTwoAdapter(List<String> listData) {
        this.listData=listData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text,parent,false);
        MyItemViewHolder viewHolder=new MyItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyItemViewHolder)holder).text_view.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public  class MyItemViewHolder extends RecyclerView.ViewHolder{

        private TextView text_view;
        public MyItemViewHolder(View itemView) {
            super(itemView);
            text_view=itemView.findViewById(R.id.text_view);
        }
    }
}
