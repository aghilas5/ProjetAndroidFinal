package com.example.e_sante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MonRecyclerViewAdapterStructure extends RecyclerView.Adapter<MonRecyclerViewAdapterStructure.ConteneurDeDonnee> {

    private List<Structure> donnees;
    private static DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;

    public MonRecyclerViewAdapterStructure(List<Structure> donnees) {
        this.donnees = donnees;
    }
    @Override
    public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_liste_structures, parent, false);
        return new ConteneurDeDonnee(view);
    }
    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int
            position) {
        conteneur.Nom_structures.setText(donnees.get(position).getNom());
        conteneur.discipline_structure.setText(donnees.get(position).getDiscipline());
        conteneur.Adresse_Parcours.setText(donnees.get(position).getAdresse());

    }
    @Override
    public int getItemCount() {
        return donnees.size();
    }

    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Nom_structures;
        TextView discipline_structure;
        TextView Adresse_Parcours;


        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            Nom_structures = (TextView) itemView.findViewById(R.id.Nom_structures);
            discipline_structure = (TextView) itemView.findViewById(R.id.discipline_structure);
            Adresse_Parcours= (TextView) itemView.findViewById(R.id.Adresse_Parcours);

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
