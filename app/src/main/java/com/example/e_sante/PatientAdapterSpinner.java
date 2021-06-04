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


public class PatientAdapterSpinner extends ArrayAdapter<Patient> {

    public PatientAdapterSpinner(Context context, ArrayList<Patient> PatientList) {
        super(context, 0, PatientList);
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
                    R.layout.spinner_patient, parent, false
            );
        }
        TextView Nom;
        TextView Age;
        ImageView image;
        TextView NumAssurance;
        TextView Tel;

        Nom = convertView.findViewById(R.id.NomPatient);
       Age = convertView.findViewById(R.id.Age);
        image = convertView.findViewById(R.id.imageperson);
        NumAssurance = convertView.findViewById(R.id.NumeroAssurance);
        Tel = convertView.findViewById(R.id.Tel);

        Patient currentItem = getItem(position);

        if (currentItem != null) {
            image.setImageResource(currentItem.getImage());
            Nom.setText(currentItem.getNom());
            Age.setText(currentItem.getAge()+"");
            NumAssurance.setText(currentItem.getNumAssurance()+"");
            Tel.setText(currentItem.getTel()+"");
        }

        return convertView;
    }
}
