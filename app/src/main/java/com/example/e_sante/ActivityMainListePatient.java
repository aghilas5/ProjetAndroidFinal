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

public class ActivityMainListePatient extends AppCompatActivity implements DetecteurDeClicSurRecycler{


    private RecyclerView mRecyclerView_liste_patient;
    private RecyclerView.LayoutManager mLayoutManager_liste_patient;
    CoordinatorLayout mcoordinatorLayout_listePatient;
    private MonRecyclerViewAdapterPatient mAdapter;
    LinearLayout expandable;
    CardView cardview;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_patients);



        mRecyclerView_liste_patient = (RecyclerView) findViewById(R.id.recycler_view_listepatient);
        mRecyclerView_liste_patient.setHasFixedSize(true);
        mLayoutManager_liste_patient=new LinearLayoutManager(this);
        mRecyclerView_liste_patient.setLayoutManager(mLayoutManager_liste_patient);
        mcoordinatorLayout_listePatient = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        mAdapter = new MonRecyclerViewAdapterPatient(getDataSource());
        mRecyclerView_liste_patient.setAdapter(mAdapter);
    }

    private ArrayList<Patient> getDataSource(){
        ArrayList liste =new ArrayList<Patient>();
        liste.add(new Patient("Ait hadji","Aghilas",5,076543,72873664,"a.aimad1999@gmail.com","6 Rue Gaspard Coriolis"));
        liste.add(new Patient("Abdelouhab","Aimad",10,076543,72873664,"a.aimad1999@gmail.com", "6 Rue Gaspard Coriolislknklnzgn lkzgnelknkg lflnklgf"));
        liste.add(new Patient("Ait hadji","Aghilas",5,076543,72873664,"a.aimad1999@gmail.com", "6 Rue Gaspard Coriolis"));
        liste.add(new Patient("Abdelouhab","Aimad",10,076543,72873664,"a.aimad1999@gmail.com", "6 Rue Gaspard Coriolis"));
        liste.add(new Patient("Ait hadji","Aghilas",5,076543,72873664,"a.aimad1999@gmail.com", "6 Rue Gaspard Coriolis"));
        liste.add(new Patient("Abdelouhab","Aimad",10,076543,72873664,"a.aimad1999@gmail.com", "6 Rue Gaspard Coriolis"));
        liste.add(new Patient("Ait hadji","Aghilas",5,076543,72873664,"a.aimad1999@gmail.com", "6 Rue Gaspard Coriolis"));
        liste.add(new Patient("Abdelouhab","Aimad",10,076543,72873664,"a.aimad1999@gmail.com", "6 Rue Gaspard Coriolis"));
        liste.add(new Patient("Ait hadji","Aghilas",5,076543,72873664,"a.aimad1999@gmail.com", "6 Rue Gaspard Coriolis"));
        liste.add(new Patient("Abdelouhab","Aimad",10,076543,72873664,"a.aimad1999@gmail.com", "6 Rue Gaspard Coriolis"));
        return liste;
    }



    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void clicSurRecyclerItem(int position, View v) {

        Snackbar.make(mcoordinatorLayout_listePatient, "Le parcours " ,Snackbar.LENGTH_LONG).show();

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
