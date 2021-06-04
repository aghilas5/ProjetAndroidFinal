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


public class ActiviteAdapterSpinner extends ArrayAdapter<Activite> {

    public ActiviteAdapterSpinner(Context context, ArrayList<Activite> ActiviteList) {
        super(context, 0, ActiviteList);
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
                    R.layout.spinner_activite, parent, false
            );
        }
        TextView titre_activite;
        TextView duree_activite;




        titre_activite = convertView.findViewById(R.id.titre_activite);
        duree_activite = convertView.findViewById(R.id.duree_activite);




        Activite currentItem = getItem(position);

        if (currentItem != null) {

            titre_activite.setText(currentItem.getTitre());
            duree_activite.setText(currentItem.getDuree()+" ");


        }

        return convertView;
    }
}
