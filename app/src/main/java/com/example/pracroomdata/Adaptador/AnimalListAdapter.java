package com.example.pracroomdata.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pracroomdata.R;
import com.example.pracroomdata.RoomDataBase.Animal;

import java.util.List;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder> {

    private final LayoutInflater mInflater;
    private List<Animal> mAnimal;

    public AnimalListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalListAdapter.AnimalViewHolder holder, int position) {
        if (mAnimal != null){
            Animal animal = mAnimal.get(position);
            holder.txt_nombre.setText(animal.getNombreAnimal());
            holder.txt_estructura.setText(animal.getEstructuraAnimal());
            holder.txt_alimentacion.setText(animal.getAlimentacionAnimal());
            holder.txt_continente.setText(animal.getNombreContinente());
        } else {
            holder.txt_nombre.setText("Sin animal");
            holder.txt_estructura.setText("Sin estructura");
            holder.txt_alimentacion.setText("Sin alimentacion");
            holder.txt_continente.setText("Sin continente");
        }

    }

    @Override
    public int getItemCount() {
        if (mAnimal != null){
            return mAnimal.size();
        } else {
            return 0;
        }

    }

    class AnimalViewHolder extends  RecyclerView.ViewHolder{
        private final TextView txt_nombre;
        private final TextView txt_estructura;
        private final TextView txt_alimentacion;
        private final TextView txt_continente;

        private AnimalViewHolder(View itemView) {
            super(itemView);
            txt_nombre = itemView.findViewById(R.id.txt_nombre);
            txt_estructura = itemView.findViewById(R.id.txt_estructura);
            txt_alimentacion = itemView.findViewById(R.id.txt_alimentacion);
            txt_continente = itemView.findViewById(R.id.txt_continente);
        }
    }

    public void setAnimales(List<Animal> animales){
        mAnimal = animales;
        notifyDataSetChanged();
    }
}
