package com.example.e_sante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements SimpleDialogListner{
    public Button connexion_medecin;
    public static int verifRole;
    Button inscription_medecin;
    Button connexion_intervenant;
    Button inscription_intervenant;
    Button connexion_patient;
    Button inscription_patient;




    FirebaseDatabase database = FirebaseDatabase.getInstance("https://projetsantemobile-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference myRef = database.getReference("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(database.getReference());



        myRef.setValue("Hello, World!");


     /*   myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });*/







        connexion_intervenant = findViewById(R.id.connexionIntervenant);
        connexion_intervenant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDialogue();
                verifRole = 2;
            }
        });
        inscription_intervenant = findViewById(R.id.inscriptionIntervenant);
        inscription_intervenant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDialogue1();
                verifRole = 2;
            }
        });
        inscription_medecin = findViewById(R.id.inscriptionMedecin);
        inscription_medecin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDialogue1();
                verifRole = 1;
            }
        });
        connexion_medecin = findViewById(R.id.connexionMedecin);
        connexion_medecin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDialogue();
                verifRole = 1;
            }
        });
        connexion_patient = findViewById(R.id.connexionPatient);
        connexion_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDialogue();
                verifRole = 3;
            }
        });
        inscription_medecin = findViewById(R.id.inscriptionMedecin);
        inscription_medecin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDialogue1();
                verifRole = 1;
            }
        });
        inscription_patient = findViewById(R.id.inscriptionPatient);
        inscription_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(v.getContext(), EssayeActivity.class);
                startActivity(intent);*/
                clickDialogue1();
                verifRole = 3;
            }
        });



       // loadData(patientDao);

    }
    public void clickDialogue() {
        FragmentManager paypal = getSupportFragmentManager();
        ConnexionFragment connexionFragment = ConnexionFragment.newInstance("Titre");
        connexionFragment.show(paypal,"connexion");
    };
    public void clickDialogue1() {
        FragmentManager inscription = getSupportFragmentManager();
        InscriptionFragment inscriptionFragment = InscriptionFragment.newInstance("Titre");
        inscriptionFragment.show(inscription,"inscription");
    };
    public void clickDialogue2() {
        FragmentManager connexion = getSupportFragmentManager();
        ConnexionFragment connexionFragment = ConnexionFragment.newInstance("Titre");
        connexionFragment.show(connexion,"connexion");
    };
    public void clickDialogue3() {
        FragmentManager inscription = getSupportFragmentManager();
        InscriptionFragment inscriptionFragment = InscriptionFragment.newInstance("Titre");
        inscriptionFragment.show(inscription,"inscription");
    };

    @Override
    public void onOkClickDialog(String inputText) {

    }




}