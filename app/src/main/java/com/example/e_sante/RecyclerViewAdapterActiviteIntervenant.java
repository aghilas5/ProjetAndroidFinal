package com.example.e_sante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterActiviteIntervenant extends RecyclerView.Adapter<RecyclerViewAdapterActiviteIntervenant.ConteneurDeDonnee> {

    private List<Activite> donnees;
    private static DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;

    public RecyclerViewAdapterActiviteIntervenant(List<Activite> donnees) {
        this.donnees = donnees;
    }
    @Override
    public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_activite_intervenant, parent, false);
        return new ConteneurDeDonnee(view);
    }
    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int position) {
        conteneur.Titre.setText(donnees.get(position).getTitre());
        conteneur.duree.setText(donnees.get(position).getDuree()+" h");
        conteneur.description.setText(donnees.get(position).getDescription()+" h");

    }
    @Override
    public int getItemCount() {
        return donnees.size();
    }

    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Titre;
        TextView duree;
        TextView description;


        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            Titre = (TextView) itemView.findViewById(R.id.titre_activite);
            duree = (TextView) itemView.findViewById(R.id.duree_activite);
            description= (TextView) itemView.findViewById(R.id.description);
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
