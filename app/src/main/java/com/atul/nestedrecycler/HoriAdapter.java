package com.atul.nestedrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HoriAdapter extends RecyclerView.Adapter<HoriAdapter.ViewHolder> {
    List<HoriModel>horiModel;

    public HoriAdapter(List<HoriModel> horiModel) {
        this.horiModel = horiModel;
    }

    @NonNull
    @Override
    public HoriAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyc_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoriAdapter.ViewHolder holder, int position) {
           int resource=horiModel.get(position).getImage();
           String string=horiModel.get(position).getName();
           holder.setData(string,resource);
    }

    @Override
    public int getItemCount() {
        return horiModel.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.textView);
            img=itemView.findViewById(R.id.imageView);
        }
        void setData(String nam,int reso)
        {
            img.setImageResource(reso);
            t1.setText(nam);
        }
    }
}
