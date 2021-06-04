package com.example.e_sante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class MonRecyclerViewAdapterPatient extends RecyclerView.Adapter<MonRecyclerViewAdapterPatient.ConteneurDeDonnee> {
    private List<Patient> donnees;
    private static DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;


    public MonRecyclerViewAdapterPatient(List<Patient> donnees) {
        this.donnees = donnees;
    }
    @Override
    public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_liste_patient, parent, false);
        return new ConteneurDeDonnee(view);
    }
    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int
            position) {
        conteneur.Nom.setText(donnees.get(position).getNom()+"  "+donnees.get(position).getPrenom());
        conteneur.Age.setText(donnees.get(position).getAge()+" ans");
        conteneur.Tel.setText(donnees.get(position).getTel()+"");
        conteneur.NumAssurance.setText(donnees.get(position).getNumAssurance()+"");
        conteneur.email.setText(donnees.get(position).getEmail());
        conteneur.adresse.setText(donnees.get(position).getAdresse());

    }
    @Override
    public int getItemCount() {
        return donnees.size();
    }



    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView Nom;
        TextView Age;
        ImageView image;
        TextView NumAssurance;
        TextView Tel;
        TextView email;
        TextView adresse;


        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            Nom = (TextView) itemView.findViewById(R.id.NomPatient);
            Age = (TextView) itemView.findViewById(R.id.Age);
            Tel = (TextView) itemView.findViewById(R.id.Tel);
            image=(ImageView) itemView.findViewById(R.id.image);
            NumAssurance = (TextView) itemView.findViewById(R.id.NumeroAssurance);
            email = (TextView) itemView.findViewById(R.id.email);
            adresse = (TextView) itemView.findViewById(R.id.adressepatient);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            detecteurDeClicSurRecycler.clicSurRecyclerItem(getAdapterPosition(), v);

        }


    }
    public void setDetecteurDeClicSurRecycler(DetecteurDeClicSurRecycler
                                                      detecteurDeClicSurRecycler) {
        this.detecteurDeClicSurRecycler = detecteurDeClicSurRecycler;
    }
}
