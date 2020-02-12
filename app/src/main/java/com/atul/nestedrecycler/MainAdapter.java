package com.atul.nestedrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    List<MainModel> models;
    RecyclerView.RecycledViewPool pool;

    public MainAdapter(List<MainModel> models) {
        this.models = models;
        pool = new RecyclerView.RecycledViewPool();
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case MainModel.HORI:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyc_hori, parent, false);
                return new ViewHolder(view);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        switch (models.get(position).getType()){
            case MainModel.HORI:
                List<HoriModel> m = models.get(position).getHoriModels();
                ((ViewHolder) holder).setHoriData(m);
                break;
                default:
                    return;
        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (models.get(position).getType()) {
            case 0:
                return MainModel.HORI;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerViewHori;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerViewHori = itemView.findViewById(R.id.recHori);
            recyclerViewHori.setRecycledViewPool(pool);
        }

        void setHoriData(List<HoriModel> h) {
            HoriAdapter Adapter = new HoriAdapter(h);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            recyclerViewHori.setLayoutManager(linearLayoutManager);
            recyclerViewHori.setAdapter(Adapter);
            Adapter.notifyDataSetChanged();
        }
    }
}
