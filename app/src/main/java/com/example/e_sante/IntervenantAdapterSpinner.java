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


public class IntervenantAdapterSpinner extends ArrayAdapter<Intervenant> {

    public IntervenantAdapterSpinner(Context context, ArrayList<Intervenant> IntervenantList) {
        super(context, 0, IntervenantList);
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
                    R.layout.spinner_intervenant, parent, false
            );
        }
        TextView NomIntervenant;
        TextView AgeIntervenant;
        ImageView image;
        TextView Specialite;


        NomIntervenant = convertView.findViewById(R.id.NomIntervenant);
        AgeIntervenant = convertView.findViewById(R.id.AgeIntervenant);
        image = convertView.findViewById(R.id.imageperson);
        Specialite = convertView.findViewById(R.id.Specialite);


        Intervenant currentItem = getItem(position);

        if (currentItem != null) {
            image.setImageResource(currentItem.getImage());
            NomIntervenant.setText(currentItem.getNom()+" "+currentItem.getPrenom());
            AgeIntervenant.setText(currentItem.getAge()+"");
            Specialite.setText(currentItem.getSpecialite());

        }

        return convertView;
    }
}
