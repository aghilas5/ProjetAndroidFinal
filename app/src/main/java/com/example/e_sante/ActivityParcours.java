package com.example.e_sante;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityParcours  extends AppCompatActivity implements DetecteurDeClicSurRecycler{

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapterParcours mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;
    LinearLayout expandable;
    CardView cardview;
    ImageView imageView;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/


        databaseReference= FirebaseDatabase.getInstance().getReference().child("Parcours");

        setContentView(R.layout.liste_parcours);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_parcours);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapterParcours(getDataSource());
        mRecyclerView.setAdapter(mAdapter);
        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout_parcours);

        FloatingActionButton fab = findViewById(R.id.fab_parcours);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentParcours register = FragmentParcours.newInstance("parcours");
                register.show(fm, "fragment_parcours");
            }
        });




        /*RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, R.drawable.divider);
        mRecyclerView.addItemDecoration(itemDecoration);*/

    }

    private ArrayList<Parcours> getDataSource() {

        ArrayList listeParcours = new ArrayList<Parcours>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listeParcours.clear();
                for (DataSnapshot parcoursDataSnap: snapshot.getChildren()){
                    Log.e("parcours", parcoursDataSnap.getKey());
                    Parcours parcours = parcoursDataSnap.getValue(Parcours.class);
                    Log.e("parcours", parcours.getTitre());
                    listeParcours.add(parcours);
                }
                Log.e("Liste parcours", listeParcours.toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("ERREUR DE DATA", error.getMessage());
            }
        });

        return listeParcours;

//        ArrayList listePlanetes = new ArrayList<Parcours>();
//        //ArrayList listePlanetes= new ArrayList();
//        listePlanetes.add (new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours de gros bg sa mere. nous allons nous concentrer sur"));
//        listePlanetes.add (new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours de gros bg sa mere. nous allons nous concentrer sur"));
//        listePlanetes.add (new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours de gros bg sa mere. nous allons nous concentrer sur"));
//        listePlanetes.add (new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours de gros bg sa mere. nous allons nous concentrer sur"));
//
//        listePlanetes.add (new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours de gros bg sa mere. nous allons nous concentrer sur"));
//
//        listePlanetes.add (new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours de gros bg sa mere. nous allons nous concentrer sur"));
//        listePlanetes.add (new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours de gros bg sa mere. nous allons nous concentrer sur"));
//
//
//
//
//
//        return listePlanetes;
    }


    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Parcours");
        mAdapter = new RecyclerViewAdapterParcours(getDataSource());
        mRecyclerView.setAdapter(mAdapter);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void clicSurRecyclerItem(int position, View v) {
        Intent intent = new Intent(v.getContext(), ActivityActivites.class);
        startActivity(intent);
      //  Snackbar.make(mcoordinatorLayout, "Le parcours " ,Snackbar.LENGTH_LONG).show();

       /* expandable = v.findViewById(R.id.expandable);
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
        }*/


    }





}
