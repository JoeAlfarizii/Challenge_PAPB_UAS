package com.hasan.challengepapbuas;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class fragment_history extends Fragment {
    private RecyclerView rv;
    private View myView;
    private ArrayList<Daftar> daftarRoulette = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_history, container, false);
        //kode anda
        daftarRoulette.add(new Daftar("863", R.drawable.ic_baseline_history_24));
        daftarRoulette.add(new Daftar("777", R.drawable.ic_baseline_history_24));

        CustomAdapter adapter = new CustomAdapter(getActivity(), daftarRoulette);
        rv = (RecyclerView) myView.findViewById(R.id.rv);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        return myView;
    }
}