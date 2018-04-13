package com.example.subramanyam.reciep;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.kimkevin.cachepot.CachePot;

import java.util.ArrayList;

public class RecRece extends RecyclerView.Adapter<RecRece.ViewHolder> {
    public LayoutInflater layoutInflater;
    public Context mContext;
    private int food;
    private ArrayList<String>  string;


    public RecRece(Context context, ArrayList<String> strings)
    {
        mContext=context;
        this.string=strings;


    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.receipelist,parent,false);
        return new ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.textView.setText(string.get(position));

        Log.i("wse", String.valueOf(position));

        CachePot.getInstance().push("rec",position);



        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,RecipList.class);
                mContext.startActivity(intent);







            }
        });



    }



    @Override
    public int getItemCount() {
        return string.size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.textView);

        }
    }

}
