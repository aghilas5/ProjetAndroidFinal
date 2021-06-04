package com.example.e_sante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MonRecyclerViewAdapterSeances extends RecyclerView.Adapter<MonRecyclerViewAdapterSeances.ConteneurDeDonnee>{

    private List<Seance> donnees;
    private static DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;


    public MonRecyclerViewAdapterSeances(List<Seance> donnees) {
        this.donnees = donnees;
    }
    @Override
    public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_liste_seances, parent, false);
        return new ConteneurDeDonnee(view);
    }
    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int
            position) {
        conteneur.Titre.setText("Seance N°"+position);
        conteneur.Parcours.setText("Un parcours"+position);
        conteneur.Activite.setText("une Activite"+position);
        conteneur.Structure.setText("Une structure"+position);
        conteneur.Date.setText(donnees.get(position).getDate().toString());
        conteneur.Duree.setText(donnees.get(position).getDuree()+"h");

    }
    @Override
    public int getItemCount() {
        return donnees.size();
    }



    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView Titre;
        TextView Parcours;
        TextView Activite;
        TextView  Structure;
        TextView Date;
        TextView Duree;


        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            Titre = (TextView) itemView.findViewById(R.id.titre_Seance);
            Parcours = (TextView) itemView.findViewById(R.id.parcoursSeance);
            Activite = (TextView) itemView.findViewById(R.id.activiteSeance);
            Structure = (TextView) itemView.findViewById(R.id.structureSeance);
            Titre = (TextView) itemView.findViewById(R.id.titre_Seance);
            Date = (TextView) itemView.findViewById(R.id.dateSeance);
            Duree = (TextView) itemView.findViewById(R.id.dureeSeance);


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
