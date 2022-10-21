package com.example.work2;

import android.content.Context;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myviewholder> {

    private List<String> list;
    private Context context;

    public Adapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflater = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        return new myviewholder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        Log.d("adapter","insert");
        //数据插入，插入到viewholder，bind方法自带循环
        holder.textView.setText(list.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, IntroductActivity.class);         //此处更改
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class myviewholder extends RecyclerView.ViewHolder{
        TextView textView;
        public myviewholder( View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
