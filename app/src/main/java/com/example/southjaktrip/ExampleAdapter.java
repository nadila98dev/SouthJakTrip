package com.example.southjaktrip;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.squareup.picasso.Picasso;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private OnItemClickLiListener mListener;
    Context context;
    ArrayList<ExampleItem> exampleitems;

    public interface OnItemClickLiListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickLiListener listener) {
        mListener = listener;
    }

    public ExampleAdapter(Context c, ArrayList<ExampleItem> i) {
        context = c;
        exampleitems = i;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExampleViewHolder(LayoutInflater.from(context).inflate(R.layout.example_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        holder.judul.setText(exampleitems.get(position).getJudul());
        holder.shortdesc.setText(exampleitems.get(position).getShortdesc());
        Picasso.get().load(exampleitems.get(position).getImagev()).into(holder.imagev);

    }


    @Override
    public int getItemCount() {
        return exampleitems.size();
    }

    class ExampleViewHolder extends RecyclerView.ViewHolder {
        TextView judul, shortdesc;
        ImageView imagev;


        public ExampleViewHolder(View itemView) {
            super(itemView);;
            judul = (TextView) itemView.findViewById(R.id.textVjudul);
            shortdesc = (TextView) itemView.findViewById(R.id.textVDesc);
            imagev = (ImageView) itemView.findViewById(R.id.imagev);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }

        }
    }