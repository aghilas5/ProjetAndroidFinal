package com.example.e_sante;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ActivityMainListeStructure  extends AppCompatActivity implements DetecteurDeClicSurRecycler{

    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapterStructure mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;
    LinearLayout expandable;
    CardView cardview;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        setContentView(R.layout.liste_structure);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_structures);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapterStructure(getDataSource());
        mRecyclerView.setAdapter(mAdapter);
        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout_structures);

        FloatingActionButton fab = findViewById(R.id.fab_structure);
        if(MainActivity.verifRole==2){fab.setVisibility(View.VISIBLE);}


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentAjoutStructure register = FragmentAjoutStructure.newInstance("Structure");
                register.show(fm, "fragment_ajout_structure");
            }
        });






        /*RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, R.drawable.divider);
        mRecyclerView.addItemDecoration(itemDecoration);*/

    }

    private ArrayList<Structure> getDataSource() {
        ArrayList liste = new ArrayList<Structure>();
        //ArrayList listePlanetes= new ArrayList();
        liste.add (new Structure("CHU Trousseau" ,"orthophnie","Parc de grandmont"));
        liste.add (new Structure("CHU Trousseau" ,"orthophnie","Parc de grandmont"));
        liste.add (new Structure("CHU Trousseau" ,"orthophnie","Parc de grandmont"));
        liste.add (new Structure("CHU Trousseau" ,"orthophnie","Parc de grandmont"));






        return liste;
    }


    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void clicSurRecyclerItem(int position, View v) {
      /*  Intent intent = new Intent(v.getContext(), ActivityActivites.class);
        startActivity(intent);*/
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
