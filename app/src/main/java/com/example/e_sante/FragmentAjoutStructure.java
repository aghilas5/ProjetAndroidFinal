package com.example.e_sante;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class FragmentAjoutStructure extends DialogFragment {
    private EditText NomStructure, disciplineStructure, listePathologie;
    private Button ajouter;
    public FragmentAjoutStructure() {
        // le fragment est créé par la méthode newInstance
    }

    public static FragmentAjoutStructure newInstance(String title) {
        FragmentAjoutStructure frag = new FragmentAjoutStructure();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_ajout_structure, container);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_carte_bancaire, container, false);
        super.onViewCreated(view, savedInstanceState);

        NomStructure = view.findViewById(R.id.NomStructure);
        disciplineStructure = view.findViewById(R.id.disciplineStructure);
        listePathologie = view.findViewById(R.id.listePathologie);
        ajouter = view.findViewById(R.id.btnAjouter);


    }
}
