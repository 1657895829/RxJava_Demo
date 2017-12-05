package app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.R;
import app.dhw.com.rxjava_retrofitfrescorecyclerviewmvp.bean.Bean;
import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * //RecyclerView展示数据适配器
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<Bean.NewslistBean> list;

    public MyAdapter(Context context) {
        this.context = context;
    }

    //声明数据来源，添加数据
    public void addData(Bean bean) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(bean.getNewslist());
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建视图
        View view = LayoutInflater.from(context).inflate(R.layout.adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //加载布局
        holder.draweeView.setImageURI(list.get(position).getPicUrl());
        holder.title.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0: list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.draweeView)
        SimpleDraweeView draweeView;
        @BindView(R.id.title)
        TextView title;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
