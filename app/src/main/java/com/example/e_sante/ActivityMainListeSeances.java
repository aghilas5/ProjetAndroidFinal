package com.example.e_sante;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class ActivityMainListeSeances extends AppCompatActivity implements DetecteurDeClicSurRecycler
{

    private RecyclerView mRecyclerView_liste_seances;
    private RecyclerView.LayoutManager mLayoutManager_liste_seances;
    CoordinatorLayout mcoordinatorLayout_listeseances;
    private MonRecyclerViewAdapterSeances mAdapter;
    LinearLayout expandable;
    CardView cardview;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_seances);



        mRecyclerView_liste_seances = (RecyclerView) findViewById(R.id.recycler_view_listeseances);
        mRecyclerView_liste_seances.setHasFixedSize(true);
        mLayoutManager_liste_seances=new LinearLayoutManager(this);
        mRecyclerView_liste_seances.setLayoutManager(mLayoutManager_liste_seances);
        mcoordinatorLayout_listeseances = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        mAdapter = new MonRecyclerViewAdapterSeances(getDataSource());
        mRecyclerView_liste_seances.setAdapter(mAdapter);


    }

    private ArrayList<Seance> getDataSource(){
        ArrayList liste =new ArrayList<Seance>();
        liste.add(new Seance(50,"16/05/2021 à 8h50"));
        liste.add(new Seance(50,"16/05/2021 à 8h50"));
        liste.add(new Seance(50,"16/05/2021 à 8h50"));
        liste.add(new Seance(50,"16/05/2021 à 8h50"));
        liste.add(new Seance(50,"16/05/2021 à 8h50"));

        return liste;
    }



    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void clicSurRecyclerItem(int position, View v) {

        Snackbar.make(mcoordinatorLayout_listeseances, "La seance " ,Snackbar.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(),ActivitySeance.class);
        startActivity(intent);


    }
}