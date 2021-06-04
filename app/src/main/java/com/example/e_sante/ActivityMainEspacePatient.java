package com.example.e_sante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ActivityMainEspacePatient extends AppCompatActivity {

    private RecyclerView mRecyclerView_liste_patient;
    //private MonRecyclerViewAdapter mAdapter_liste_patient;
    private RecyclerView.LayoutManager mLayoutManager_liste_patient;
    RelativeLayout relativeLayout;

    private MonRecyclerViewAdapterPatient mAdapter;
    private CardView card1,card2;
    private FirebaseDatabase database;
    private DatabaseReference userRef;
   public  TextView nom,prenom,email;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        String uid = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid();

        setContentView(R.layout.espacepatient);
        nom=findViewById(R.id.nomPatient);
        prenom=findViewById(R.id.prenomPatient);
        email=findViewById(R.id.emailPatient);
        userRef=FirebaseDatabase.getInstance().getReference().child("Patient").child(uid);

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){

                    String nomm = snapshot.child("nom").getValue().toString();
                    String prenomm = snapshot.child("prenom").getValue().toString();
                    String emaill = snapshot.child("email").getValue().toString();
                    nom.setText(nomm);
                    prenom.setText(prenomm);
                    email.setText(emaill);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        card1=(CardView) findViewById(R.id.listeMedecins);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(v.getContext(), ActivityMainListeMedecins.class);
                startActivity(intent);

            }
        });

        card2=(CardView) findViewById(R.id.listeSeances);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(v.getContext(), ActivityMainListeSeances.class);
                startActivity(intent);

            }
        });




    }
}