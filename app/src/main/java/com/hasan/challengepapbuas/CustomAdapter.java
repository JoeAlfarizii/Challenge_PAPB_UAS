package com.hasan.challengepapbuas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    LayoutInflater mInflater;
    ArrayList<Daftar> daftar;
    Context ctx;

    public CustomAdapter(){

    }

    public CustomAdapter(FragmentActivity context, ArrayList<Daftar> sisop) {
        this.mInflater = LayoutInflater.from(context);
        this.daftar = sisop;
        this.ctx = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.rowhistory, parent, false);
        return new CustomViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
        final Daftar current = daftar.get(position);
        holder.namaItemView.setText(current.nama);
        holder.gambarView.setImageDrawable(ctx.getDrawable(current.idGambar));
        holder.gambarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,current.nama,Toast.LENGTH_LONG).show();
                daftar.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return daftar.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        private ImageView gambarView;
        private CustomAdapter mAdapter;
        private TextView namaItemView;

        public CustomViewHolder(@NonNull View itemView, CustomAdapter adapter) {
            super(itemView);

            namaItemView = (TextView) itemView.findViewById(R.id.text_roulette);
            gambarView = (ImageView) itemView.findViewById(R.id.logo);
            this.mAdapter = adapter;
        }
    }
}
