package com.other.horoscope.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.other.horoscope.R;
import com.other.horoscope.model.Sunsign;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by thinh.vo on 04/11/2016.
 */

public class SunsignAdapter extends RecyclerView.Adapter<SunsignAdapter.ViewHolder> {

    public List<Sunsign> getList() {
        return list;
    }

    private List<Sunsign> list;

    public SunsignAdapter(List<Sunsign> list, AdapterView.OnItemClickListener onItemClickListener) {
        this.list = list;
        this.mOnItemClickListener=onItemClickListener;
    }

    AdapterView.OnItemClickListener mOnItemClickListener;

    @Override
    public SunsignAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rvhoroscope_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SunsignAdapter.ViewHolder holder, int position) {
        Sunsign item =list.get(position);
        holder.txtborder.setBackgroundColor(item.getColor());
        holder.txtday.setText(item.getDate());
        holder.txtname.setText(item.getSunsign().toUpperCase());
        holder.imgSunsign.setImageResource(item.getRes());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.txtday)
        public TextView txtday;
        @BindView(R.id.txtborder)
        public TextView txtborder;
        @BindView(R.id.txtname)
        public TextView txtname;
        @BindView(R.id.imghoro)
        public ImageView imgSunsign;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mOnItemClickListener!=null)
            {
                mOnItemClickListener.onItemClick(null,v,getLayoutPosition(),v.getId());
            }
        }
    }
}
