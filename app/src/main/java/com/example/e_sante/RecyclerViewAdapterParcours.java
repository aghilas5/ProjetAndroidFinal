package com.example.e_sante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterParcours extends RecyclerView.Adapter<RecyclerViewAdapterParcours.ConteneurDeDonnee> {

    private List<Parcours> donnees;
    private static DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;

    public RecyclerViewAdapterParcours(List<Parcours> donnees) {
        this.donnees = donnees;
    }
    @Override
    public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_unparcours, parent, false);
        return new ConteneurDeDonnee(view);
    }
    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int
            position) {
        conteneur.Titre.setText(donnees.get(position).getTitre());
        conteneur.Categorie.setText(donnees.get(position).getCategorie());
        conteneur.Descrption.setText(donnees.get(position).getDescription());

    }
    @Override
    public int getItemCount() {
        return donnees.size();
    }

    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Titre;
        TextView Categorie;
        TextView Descrption;


        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            Titre = (TextView) itemView.findViewById(R.id.titre_parcours);
            Categorie = (TextView) itemView.findViewById(R.id.categorie_parcours);
            Descrption= (TextView) itemView.findViewById(R.id.description_parcours);

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
