package com.example.e_sante;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class ParcoursAdapterSpinner extends ArrayAdapter<Parcours> {

    public ParcoursAdapterSpinner(Context context, ArrayList<Parcours> ParcoursList) {
        super(context, 0, ParcoursList);
    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_parcours, parent, false
            );
        }
        TextView titre_parcours;
        TextView categorie_parcours;
        ImageView image;
        TextView description_parcours;


        titre_parcours = convertView.findViewById(R.id.titre_parcours);
        categorie_parcours = convertView.findViewById(R.id.categorie_parcours);
        image = convertView.findViewById(R.id.imageparcours);
        description_parcours = convertView.findViewById(R.id.description_parcours);


        Parcours currentItem = getItem(position);

        if (currentItem != null) {
            image.setImageResource(currentItem.getImage());
            titre_parcours.setText(currentItem.getTitre());
            categorie_parcours.setText(currentItem.getCategorie());
            description_parcours.setText(currentItem.getDescription());

        }

        return convertView;
    }
}
