package com.example.subramanyam.reciep;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.kimkevin.cachepot.CachePot;

import java.util.ArrayList;

public class ingrediantsRecycler extends RecyclerView.Adapter<ingrediantsRecycler.ViewHolder> {

    private Context mContext;
    private int ids;
    ArrayList<ReciepieData> arrayList;


    public ingrediantsRecycler(Context context,int id)
    {
        this.mContext=context;
        this.ids=id;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ingrediantsdetails,parent,false);
        return new ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


//holder.textView.setText(arrayList.get(ids).getIngridients());


    }



    @Override
    public int getItemCount() {
        return ids;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        TextView textView2;
        TextView textView3;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView3);
            textView2=itemView.findViewById(R.id.textView4);
            textView3=itemView.findViewById(R.id.textView5);
            arrayList= CachePot.getInstance().pop("recd");
        }
    }
}
