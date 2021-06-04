package com.example.e_sante;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class ActivityMainEspaceMedecin extends AppCompatActivity  {
    private RecyclerView mRecyclerView_liste_patient;
    //private MonRecyclerViewAdapter mAdapter_liste_patient;
    private RecyclerView.LayoutManager mLayoutManager_liste_patient;
    RelativeLayout relativeLayout;

    private MonRecyclerViewAdapterPatient mAdapter;
    private CardView card1,card2,card3,card4,card5;
    private FirebaseDatabase database;
    private DatabaseReference userRef;
    public  TextView nom,prenom,specialite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.espacemedecin);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        String uid = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid();

        nom=findViewById(R.id.nomMedecin);
        prenom=findViewById(R.id.prenomMedecin);
        specialite=findViewById(R.id.specialiteMedecin);

        userRef=FirebaseDatabase.getInstance().getReference().child("Medecin").child(uid);
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){

                    String nomm = snapshot.child("nom").getValue().toString();
                    String prenomm = snapshot.child("prenom").getValue().toString();
                    String specialitee = snapshot.child("specialite").getValue().toString();
                    nom.setText(nomm);
                    prenom.setText(prenomm);
                    specialite.setText(specialitee);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        card1=(CardView) findViewById(R.id.Mespatients);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(v.getContext(), ActivityMainListePatient.class);
                startActivity(intent);

            }
        });

        card2=(CardView) findViewById(R.id.Lesparcours);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
            Intent intent = new Intent(v.getContext(), ActivityParcours.class);
            startActivity(intent);

            }
        });

        card3=(CardView) findViewById(R.id.Lesintervenants);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(v.getContext(), ActivityMainListeIntervenant.class);
                startActivity(intent);
                Snackbar.make(v, "La planète ",Snackbar.LENGTH_LONG).show();
            }
        });

        card4=(CardView) findViewById(R.id.Lestructures);
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(v.getContext(), ActivityMainListeStructure.class);
                startActivity(intent);
                Snackbar.make(v, "La planète ",Snackbar.LENGTH_LONG).show();
            }
        });

        card5=(CardView) findViewById(R.id.AttributionDesParcoursEtActivite);
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
            /*Intent intent = new Intent(v.getContext(), SecondActivity.class);
            startActivity(intent);*/

                FragmentManager fm = getSupportFragmentManager();
                FragmentSpinnerAttributionEspaceMedecin register = FragmentSpinnerAttributionEspaceMedecin.newInstance("fragment_attribution_patient_parcours");
                register.show(fm, "fragment");
                Snackbar.make(v, "La planète ",Snackbar.LENGTH_LONG).show();
            }
        });
    

    }

}
