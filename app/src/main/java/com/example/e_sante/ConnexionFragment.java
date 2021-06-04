package com.example.e_sante;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConnexionFragment extends DialogFragment {
    private EditText email,password,statut;
    //    private PaiementCarteListener listener;
    private Button btn_login;
    FirebaseAuth mAuth;



    public ConnexionFragment() {
        // le fragment est créé par la méthode newInstance
    }

    public static ConnexionFragment newInstance(String title) {

        ConnexionFragment frag = new ConnexionFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_connexion, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        listener = (PaiementCarteListener) getActivity();
        /**nom = view.findViewById(R.id.edit_name);*/
        email = view.findViewById(R.id.inputEmail);
        password = view.findViewById(R.id.inputPassword);
        btn_login = view.findViewById(R.id.btnLogin);
        statut = view.findViewById(R.id.inputstatut);
        mAuth=FirebaseAuth.getInstance();
        MainActivity activity =  (MainActivity) getActivity();
        if(activity.verifRole==1)
        {
            statut.setText("Medecin");
        }
        if(activity.verifRole==2)
        {
            statut.setText("INTERVENANT");
        }
        if(activity.verifRole==3)
        {
            statut.setText("PATIENT");
        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activity.verifRole==1){

                Intent intent = new Intent(getContext(),ActivityMainEspaceMedecin.class);
                startActivity(intent);
                ConnexionFragment.this.dismiss();}
                if(activity.verifRole==2){

                    Intent intent = new Intent(getContext(),ActivityMainEspaceIntervenant.class);
                    startActivity(intent);
                    ConnexionFragment.this.dismiss();}
                if(activity.verifRole==3){
                    checkValue(email,password);

                    mAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){

                                Intent intent = new Intent(getContext(),ActivityMainEspacePatient.class);
                                startActivity(intent);
                                ConnexionFragment.this.dismiss();
                              /*  String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                                DatabaseReference uidRef = rootRef.child("Patient").child(uid);
                                ValueEventListener eventListener = new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        if(dataSnapshot.exists()) {
                                            Intent intent = new Intent(getContext(),ActivityMainEspacePatient.class);
                                            startActivity(intent);
                                            ConnexionFragment.this.dismiss();
                                        }else {
                                            Toast.makeText(getActivity(), "impossible de se connecter", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {}
                                };
                                uidRef.addListenerForSingleValueEvent(eventListener);*/

                            }else {
                                Toast.makeText(getActivity(), "impossible de se connecter", Toast.LENGTH_LONG).show();
                            }
                        }
                    });




                   /* Intent intent = new Intent(getContext(),ActivityMainEspacePatient.class);
                    startActivity(intent);
                    ConnexionFragment.this.dismiss();*/

                }


            }
        });




       /* btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),ActivityMainEspaceMedecin.class);
                startActivity(intent);
                ConnexionFragment.this.dismiss();

            }
        });*/
    }

    public void checkValue(EditText email_edit,EditText password_edit){


        String email =email_edit.getText().toString().trim();
        String password =password_edit.getText().toString().trim();
        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            email_edit.setError("saisissez une adresse mail valide");
            email_edit.requestFocus();
            return;
        }
        if(password.isEmpty() || password.length()<6)
        {
            password_edit.setError("saisissez un mot de passe valide");
            password_edit.requestFocus();
            return;
        }
    }




}
