package com.example.restexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.restexample.API.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<Track> dades;
    private LayoutInflater mInflater;
    private Context context;

    //CONSTRUCTOR
    public ListAdapter (List<Track> itemList, Context context) {
        this.mInflater = LayoutInflater.from((Context) context);
        this.context = (Context) context;
        this.dades = itemList;
    }


    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = mInflater.inflate(R.layout.activity_object_list, null);
        return new ListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(dades.get(position));
    }


    @Override
    public int getItemCount() {
        return dades.size();
    }

    public void setItems(List<Track> items){
        dades=items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, singer;

        ViewHolder(View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.titleListId);
            singer=itemView.findViewById(R.id.singerListId);
        }

        void bindData(final Track item){
            title.setText(item.getTitle());
            singer.setText(item.getSinger());
        }


    }
}
