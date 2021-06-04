package com.example.e_sante;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ActivityMainListeIntervenant extends AppCompatActivity implements DetecteurDeClicSurRecycler{


    private RecyclerView mRecyclerView_liste_Intervenant;
    private RecyclerView.LayoutManager mLayoutManager_liste_intervenant;
    CoordinatorLayout mcoordinatorLayout_listeIntervenant;
    private MonRecyclerViewAdapterIntervenant mAdapter;
    LinearLayout expandable;
    CardView cardview;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_intervenants);



        mRecyclerView_liste_Intervenant = (RecyclerView) findViewById(R.id.recycler_view_listeIntervenants);
        mRecyclerView_liste_Intervenant.setHasFixedSize(true);
        mLayoutManager_liste_intervenant=new LinearLayoutManager(this);
        mRecyclerView_liste_Intervenant.setLayoutManager(mLayoutManager_liste_intervenant);
        mcoordinatorLayout_listeIntervenant = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        mAdapter = new MonRecyclerViewAdapterIntervenant(getDataSource());
        mRecyclerView_liste_Intervenant.setAdapter(mAdapter);
    }

    private ArrayList<Intervenant> getDataSource(){
        ArrayList liste =new ArrayList<Intervenant>();
        liste.add(new Intervenant("Ait hadji","Aghilas",5,076543,"Kinééééé","aghilas@gmail.com", "motdepasse","6 Rue Gaspard Coriolis"));

        return liste;
    }



    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void clicSurRecyclerItem(int position, View v) {

        Snackbar.make(mcoordinatorLayout_listeIntervenant, "Le Intervenants " ,Snackbar.LENGTH_LONG).show();

        expandable = v.findViewById(R.id.expandable);
        cardview = v.findViewById(R.id.card_view);
        imageView=v.findViewById(R.id.down);

        position = R.id.expandable;
        if (expandable.getVisibility()==View.GONE){
            TransitionManager.beginDelayedTransition(cardview, new AutoTransition());
            expandable.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.up);
        } else {
            expandable.setVisibility(View.GONE);
            imageView.setImageResource(R.drawable.down);
        }
    }
}
