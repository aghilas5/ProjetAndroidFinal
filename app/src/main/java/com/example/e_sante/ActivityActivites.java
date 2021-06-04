package com.example.e_sante;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ActivityActivites extends AppCompatActivity implements DetecteurDeClicSurRecycler{
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapterActivite mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;
    LinearLayout expandable;
    CardView cardview;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.liste_activite);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_activites);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapterActivite(getDataSource());
        mRecyclerView.setAdapter(mAdapter);
        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout_activite);

        FloatingActionButton fab = findViewById(R.id.fab_activite);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentActivite register = FragmentActivite.newInstance("activity");
                register.show(fm, "fragment_activite");
            }
        });



    }

    private ArrayList<Activite> getDataSource() {
        ArrayList listePlanetes = new ArrayList<Activite>();
        //ArrayList listePlanetes= new ArrayList();
        listePlanetes.add (new Activite("Radiologie du torse" ,50, "aaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaa"));
        listePlanetes.add (new Activite("Course à pied" ,50, "aaaaaaaaaaa aaaaaaaaaaaaaaaaaa aaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaa aaaa"));
        listePlanetes.add (new Activite("activite3" ,50, "aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaa"));
        listePlanetes.add (new Activite("activite4" ,50, "aaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaa"));listePlanetes.add (new Activite("activite" ,50, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        listePlanetes.add (new Activite("activite5" ,50, "aaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaaaaa"));
        listePlanetes.add (new Activite("activite" ,50, "aaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaa"));
        listePlanetes.add (new Activite("activite2" ,50, "aaaaaaaaaaa aaaaaaaaaaaaaaaaaa aaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaa aaaa"));
        listePlanetes.add (new Activite("activite3" ,50, "aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaa"));
        listePlanetes.add (new Activite("activite4" ,50, "aaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaa"));listePlanetes.add (new Activite("activite" ,50, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        listePlanetes.add (new Activite("activite5" ,50, "aaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaaaaa"));

        listePlanetes.add (new Activite("activite" ,50, "aaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaa"));
        listePlanetes.add (new Activite("activite2" ,50, "aaaaaaaaaaa aaaaaaaaaaaaaaaaaa aaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaa aaaa"));
        listePlanetes.add (new Activite("activite3" ,50, "aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaa"));
        listePlanetes.add (new Activite("activite4" ,50, "aaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaa"));listePlanetes.add (new Activite("activite" ,50, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        listePlanetes.add (new Activite("activite5" ,50, "aaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaaaaa"));
        listePlanetes.add (new Activite("activite" ,50, "aaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaa"));
        listePlanetes.add (new Activite("activite2" ,50, "aaaaaaaaaaa aaaaaaaaaaaaaaaaaa aaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaa aaaa"));
        listePlanetes.add (new Activite("activite3" ,50, "aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaa"));
        listePlanetes.add (new Activite("activite4" ,50, "aaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaa"));listePlanetes.add (new Activite("activite" ,50, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        listePlanetes.add (new Activite("activite5" ,50, "aaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaaaaa"));



        return listePlanetes;
    }


    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void clicSurRecyclerItem(int position, View v) {
        TextView titre= v.findViewById(R.id.titre_activite);
        Snackbar.make(mcoordinatorLayout, "La planète " + titre.getText(),Snackbar.LENGTH_LONG).show();
        /*Intent intent = new Intent(v.getContext(), ActivityMainListePatient.class);
        startActivity(intent);*/

        expandable = v.findViewById(R.id.expandable);
        cardview = v.findViewById(R.id.card_view);
        imageView=v.findViewById(R.id.down);

        position = R.id.expandable;
        if (expandable.getVisibility()==View.GONE){
            TransitionManager.beginDelayedTransition(cardview, new AutoTransition());
            expandable.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.up);
        } else {
            //TransitionManager.beginDelayedTransition(cardview, new AutoTransition());
            expandable.setVisibility(View.GONE);
            imageView.setImageResource(R.drawable.down);
        }


    }




}