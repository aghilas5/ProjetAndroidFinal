package com.example.e_sante;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class EssayeActivity extends AppCompatActivity {

    private EditText nom,prenom,email,password,statut,age,tel,numeroAssurance,adresse;
    //    private PaiementCarteListener listener;
    private Button btn_inscription;
    public FirebaseAuth mAuth ;
    String TAG1="m";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_inscription);

        mAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance());
        // mAuth = FirebaseAuth.getInstance();
        //        listener = (PaiementCarteListener) getActivity();
        /**nom = view.findViewById(R.id.edit_name);*/
        nom = findViewById(R.id.inputNom);
        prenom = findViewById(R.id.inputPrenom);
        email = findViewById(R.id.inputEmailI);
        age=findViewById(R.id.inputAge);
        tel=findViewById(R.id.inputTel);
        numeroAssurance=findViewById(R.id.inputNumAssurance);
        adresse=findViewById(R.id.inputAdresse);

        password =findViewById(R.id.inputPasswordI);
        btn_inscription =findViewById(R.id.btnInscription);
        statut =findViewById(R.id.inputstatutI);

        if(MainActivity.verifRole==1)
        {
            statut.setText("Medecin");
            numeroAssurance.setVisibility(View.GONE);



        }
        if(MainActivity.verifRole==2)
        {
            statut.setText("INTERVENANT");
            numeroAssurance.setVisibility(View.GONE);
        }
        if(MainActivity.verifRole==3)
        {
            statut.setText("PATIENT");
            numeroAssurance.setVisibility(View.VISIBLE);
            btn_inscription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nomm= nom.getText().toString();
                    String prenomm= prenom.getText().toString();
                    int agee=Integer.parseInt(age.getText().toString());
                    int tell=Integer.parseInt(tel.getText().toString());
                    int numeroassurancee=Integer.parseInt(numeroAssurance.getText().toString());
                    String emaill=email.getText().toString();
                    String passwordd=password.getText().toString();
                    String adressee=adresse.getText().toString();

                    mAuth.createUserWithEmailAndPassword(emaill,passwordd).
                            addOnCompleteListener(EssayeActivity.this,new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Patient p= new Patient(nomm,prenomm,agee,tell,numeroassurancee,emaill,adressee);
                                        FirebaseDatabase.getInstance().getReference("Patient").
                                                child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(p).addOnCompleteListener(EssayeActivity.this,new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){

                                                    System.out.println("C'est bon a khaliiiiiiiiiiiiiiiiiiii");

                                                }else Toast.makeText(EssayeActivity.this,"user  NOT registered", Toast.LENGTH_LONG).show();
                                            }
                                        });



                                    }else { Log.d(TAG1, "onComplete: Failed paskou=" + task.getException().getMessage());}
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        public void onFailure(@NonNull Exception e) {
                            Log.e("exception",e.getMessage());
                        }
                    });

                }
            });
        }
        /*btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),EspacePatient.class);
                startActivity(intent);
                InscriptionFragment.this.dismiss();

            }
        });*/



    }

}
