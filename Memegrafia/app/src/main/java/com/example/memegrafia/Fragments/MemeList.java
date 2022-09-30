package com.example.memegrafia.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memegrafia.R;

import java.util.Arrays;
import java.util.List;

import com.example.memegrafia.Interfaces.OnMemeSelected;

public class MemeList extends Fragment {
    private OnMemeSelected listener;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_list, container, false);
    }

    public void setMemeSelectedListener(OnMemeSelected listener) {
        this.listener = listener;
    }

    @Override
    public void onActivityCreated (@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);

        // el método getActivity regresa una referencia a la actividad que hospeda al framento
        FragmentActivity activity = getActivity ();
        if (activity == null) return;

        String [] namesArray = activity.getResources ().getStringArray (R.array.names);
        List<String> memes = Arrays.asList (namesArray);

        RecyclerView recyclerView = activity.findViewById (R.id.myList);
        if (recyclerView ==  null) return;

        recyclerView.setLayoutManager (new LinearLayoutManager(activity, RecyclerView.VERTICAL, false));

        // se crea un objeto MyAdapter al que se pasan los parámetros necesarios
        // context: la actividad que hospeda al fragmento
        // List<Memes>: la lista con la información al mostrar
        // OnMemeSelected: el objeto listener mediante el cuál se invocará al manejador del evento memeSelected para los elementos de la lista
        recyclerView.setAdapter (new MyAdapter (activity, memes, this.listener));
    }
}


class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<String> memes;
    private OnMemeSelected listener;

    MyAdapter(Context context, List<String> memes, OnMemeSelected listener) {
        this.context = context;
        this.memes = memes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        // se asigna la información en cada fila de la lista y se establece el manejador del evento OnClickListener,
        // de modo que al seleccionarse se invoque al método planetSelected en el objeto que manejará dicho evento
        holder.setData(memes.get(position));
        holder.itemView.setOnClickListener(view -> listener.onMemeSelected(position));
    }

    @Override
    public int getItemCount() {
        return memes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView text1;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(android.R.id.text1);
        }

        void setData(String data) {
            text1.setText(data);
        }
    }
}