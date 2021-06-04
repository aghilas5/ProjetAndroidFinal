package com.example.e_sante;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class InscriptionFragment extends DialogFragment {
    private EditText nom,prenom,email,password,statut,age,tel,numeroAssurance,adresse,specialite;
    //    private PaiementCarteListener listener;
    private Button btn_inscription;
    public  FirebaseAuth mAuth ;
    String TAG1="m";



    public InscriptionFragment() {
        // le fragment est créé par la méthode newInstance
    }

    public static InscriptionFragment newInstance(String title) {

        InscriptionFragment frag = new InscriptionFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_inscription, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
       // mAuth = FirebaseAuth.getInstance();
        //        listener = (PaiementCarteListener) getActivity();
        /**nom = view.findViewById(R.id.edit_name);*/
        nom = view.findViewById(R.id.inputNom);
        prenom = view.findViewById(R.id.inputPrenom);
        email = view.findViewById(R.id.inputEmailI);
        age=view.findViewById(R.id.inputAge);
        tel=view.findViewById(R.id.inputTel);
        numeroAssurance=view.findViewById(R.id.inputNumAssurance);
        adresse=view.findViewById(R.id.inputAdresse);
        specialite=view.findViewById(R.id.inputSpecialite);

        password = view.findViewById(R.id.inputPasswordI);
        btn_inscription = view.findViewById(R.id.btnInscription);
        statut = view.findViewById(R.id.inputstatutI);
        MainActivity activity =  (MainActivity) getActivity();
        if(activity.verifRole==1)
        {
            statut.setText("Medecin");
            numeroAssurance.setVisibility(View.GONE);
            specialite.setVisibility(View.VISIBLE);


            btn_inscription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Nom= nom.getText().toString();
                    String Prenom= prenom.getText().toString();
                    int Age=Integer.parseInt(age.getText().toString());
                    int Tel=Integer.parseInt(tel.getText().toString());
                    String Email=email.getText().toString();
                    String Password=password.getText().toString();
                    String Adresse=adresse.getText().toString();
                    String Specialite=specialite.getText().toString();


                    mAuth.createUserWithEmailAndPassword(Email,Password).
                            addOnCompleteListener(getActivity(),new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Medecin medecin= new Medecin(Nom,Prenom,Age,Tel,Email,Adresse,Specialite);
                                        FirebaseDatabase.getInstance().getReference("Medecin").
                                                child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(medecin).addOnCompleteListener(getActivity(),new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    InscriptionFragment.this.dismiss();

                                                    System.out.println("C'est bon a khaliiiiiiiiiiiiiiiiiiii");

                                                }else Toast.makeText(getActivity(),"user  NOT registered", Toast.LENGTH_LONG).show();
                                            }
                                        });



                                    }else {
                                        Log.d(TAG1, "onComplete: Failed paskou=" + task.getException().getMessage());}
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        public void onFailure(@NonNull Exception e) {
                            Log.e("exception",e.getMessage());
                        }
                    });

                }
            });



        }
        if(activity.verifRole==2)
        {
            statut.setText("INTERVENANT");
            numeroAssurance.setVisibility(View.GONE);
            specialite.setVisibility(View.VISIBLE);
            btn_inscription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Nom= nom.getText().toString();
                    String Prenom= prenom.getText().toString();
                    int Age=Integer.parseInt(age.getText().toString());
                    int Tel=Integer.parseInt(tel.getText().toString());
                    String Email=email.getText().toString();
                    String Password=password.getText().toString();
                    String Adresse=adresse.getText().toString();
                    String Specialite=specialite.getText().toString();

                    mAuth.createUserWithEmailAndPassword(Email,Password).
                            addOnCompleteListener(getActivity(),new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Intervenant intervenant= new Intervenant(Nom,Prenom,Age,Tel,Specialite,Email,Adresse);
                                        FirebaseDatabase.getInstance().getReference("Intervenant").
                                                child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(intervenant).addOnCompleteListener(getActivity(),new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    InscriptionFragment.this.dismiss();

                                                    System.out.println("C'est bon a khaliiiiiiiiiiiiiiiiiiii");

                                                }else Toast.makeText(getActivity(),"user  NOT registered", Toast.LENGTH_LONG).show();
                                            }
                                        });



                                    }else {
                                        Log.d(TAG1, "onComplete: Failed paskou=" + task.getException().getMessage());}
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        public void onFailure(@NonNull Exception e) {
                            Log.e("exception",e.getMessage());
                        }
                    });

                }
            });
        }
        if(activity.verifRole==3)
        {
            statut.setText("PATIENT");
            numeroAssurance.setVisibility(View.VISIBLE);
            btn_inscription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Nom= nom.getText().toString();
                    String Prenom= prenom.getText().toString();
                    int Age=Integer.parseInt(age.getText().toString());
                    int Tel=Integer.parseInt(tel.getText().toString());
                    int NumeroAssurance=Integer.parseInt(numeroAssurance.getText().toString());
                    String Email=email.getText().toString();
                    String Password=password.getText().toString();
                    String Adresse=adresse.getText().toString();

                    mAuth.createUserWithEmailAndPassword(Email,Password).
                            addOnCompleteListener(getActivity(),new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Patient p= new Patient(Nom,Prenom,Age,Tel,NumeroAssurance,Email,Adresse);
                                        FirebaseDatabase.getInstance().getReference("Patient").
                                                child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(p).addOnCompleteListener(getActivity(),new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    InscriptionFragment.this.dismiss();

                                                    System.out.println("C'est bon a khaliiiiiiiiiiiiiiiiiiii");

                                                }else Toast.makeText(getActivity(),"user  NOT registered", Toast.LENGTH_LONG).show();
                                            }
                                        });



                                    }else {
                                        Log.d(TAG1, "onComplete: Failed paskou=" + task.getException().getMessage());}
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
