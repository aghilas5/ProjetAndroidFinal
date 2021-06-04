package com.example.e_sante;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityMainListeMedecins extends AppCompatActivity implements DetecteurDeClicSurRecycler{


    private RecyclerView mRecyclerView_liste_medecin;
    private RecyclerView.LayoutManager mLayoutManager_liste_medecin;
    CoordinatorLayout mcoordinatorLayout_listemedecin;
    private MonRecyclerViewAdapterMedecin mAdapter;
    LinearLayout expandable;
    CardView cardview;
    ImageView imageView;
    DatabaseReference medecinRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_medecins);



        medecinRef= FirebaseDatabase.getInstance().getReference().child("Medecin");

        mRecyclerView_liste_medecin = (RecyclerView) findViewById(R.id.recycler_view_listemedecins);
        mRecyclerView_liste_medecin.setHasFixedSize(true);
        mLayoutManager_liste_medecin=new LinearLayoutManager(this);
        mRecyclerView_liste_medecin.setLayoutManager(mLayoutManager_liste_medecin);
        mcoordinatorLayout_listemedecin = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        System.out.println("hellllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloooooooooooooooooooooo"+getDataSource());
        mAdapter = new MonRecyclerViewAdapterMedecin(getDataSource());
        mRecyclerView_liste_medecin.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.fab_medecin);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentParcours register = FragmentParcours.newInstance("parcours");
                register.show(fm, "fragment_parcours");
            }
        });
    }

    private ArrayList<Medecin> getDataSource(){
        ArrayList liste =new ArrayList<Medecin>();

        medecinRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            /*    String name=snapshot.child("nom").getValue().toString();
                String prenom=snapshot.child("prenom").getValue().toString();
                String email=snapshot.child("email").getValue().toString();
                String adresse=snapshot.child("adresse").getValue().toString();
                String tel=snapshot.child("tel").getValue().toString();
                String specialite=snapshot.child("specialite").getValue().toString();
                liste.add(new Medecin(name,email,adresse,34,R.drawable.doctor,prenom,specialite));*/


               long count = snapshot.getChildrenCount();
                Log.e("salut",  " | AllCheckIns | Count is: " + count);
                liste.clear();
                for(DataSnapshot medecinDatasnap: snapshot.getChildren()){
                    Medecin medecin=medecinDatasnap.getValue(Medecin.class);
                    //liste.add(new Medecin(medecin.getNom(), medecin.getEmail(), medecin.getAdresse(),medecin.getTel(), R.drawable.doctor, medecin.getPrenom(), medecin.getSpecialite()));
                    Log.e("listeee", " | AllCheckIns | Value " + medecin.age);
                   liste.add(medecin);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
       // liste.add(new Medecin("Aziz","a.aziz@gmail.com","mot de passe","6 rue gaârd coriolis, 37200 tours",77980,R.drawable.doctor,"scofield","Spécialiste Gynecologue"));

      /*  liste =new ArrayList<Medecin>();
        liste.add(new Medecin("Aziz","a.aziz@gmail.com","mot de passe","6 rue gaârd coriolis, 37200 tours",77980,R.drawable.doctor,"scofield","Spécialiste Gynecologue"));*/
            return liste;
    }



    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void clicSurRecyclerItem(int position, View v) {

        Snackbar.make(mcoordinatorLayout_listemedecin, "Le parcours " ,Snackbar.LENGTH_LONG).show();

        new AlertDialog.Builder(ActivityMainListeMedecins.this)
                .setTitle("Nouveau medecin?")
                .setMessage("Voulez vous consulter ce medecin?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })
                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }
}