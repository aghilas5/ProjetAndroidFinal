package com.example.e_sante;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentParcours extends DialogFragment {
    private EditText  edit_titre, edit_description, edit_categorie;
    private Button ajouter;
    TextView titre;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    public FragmentParcours() {
        // le fragment est créé par la méthode newInstance
    }

    public static FragmentParcours newInstance(String title) {
        FragmentParcours frag = new FragmentParcours();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_parcours, container);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_carte_bancaire, container, false);
        super.onViewCreated(view, savedInstanceState);
        titre=view.findViewById(R.id.textView2);

        edit_titre = view.findViewById(R.id.titreParcours);
        edit_description = view.findViewById(R.id.descriptionParcours);
        edit_categorie = view.findViewById(R.id.categorieParcours);
        ajouter = view.findViewById(R.id.btnAjouterParcours);

        if(MainActivity.verifRole==3){
            edit_description.setVisibility(View.GONE);
            edit_categorie.setVisibility(View.GONE);
            titre.setText("Rechercher le medecin");
            ajouter.setText("Rechercher");
        }

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("Parcours");
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titre =edit_titre.getText().toString().trim();
                String categorie = edit_categorie.getText().toString().trim();
                String descrption = edit_description.getText().toString().trim();
                Parcours parcours = new Parcours(titre, categorie, descrption);
                Log.e("Erreur ta3 khra", parcours.getTitre());
                databaseReference.push().setValue(parcours);
                FragmentParcours.this.dismiss();
                Toast.makeText(getActivity(), "Parcours Ajouté", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
