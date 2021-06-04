package com.example.e_sante;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class FragmentSpinnerAttributionNatureEspaceIntervenant extends DialogFragment {
   // private ArrayList<Intervenant> intervenantList;
    private ArrayList<Patient> patientList;
    private ArrayList<Parcours> parcoursList;
    private ArrayList<Activite> activiteList;
    private PatientAdapterSpinner mAdapter;
    public Spinner spinnerPatient ;
    private ParcoursAdapterSpinner mAdapter2;
    public Spinner spinnerParcours ;
    //private IntervenantAdapterSpinner mAdapter3;
    //public Spinner spinnerIntervenant ;
    private ActiviteAdapterSpinner mAdapter3;
    public Spinner spinnerActivite ;

    public FragmentSpinnerAttributionNatureEspaceIntervenant() {
        // le fragment est créé par la méthode newInstance
    }
    public static FragmentSpinnerAttributionNatureEspaceIntervenant newInstance(String title) {
        FragmentSpinnerAttributionNatureEspaceIntervenant frag = new FragmentSpinnerAttributionNatureEspaceIntervenant();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_attribtion_nature_activite, container);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_carte_bancaire, container, false);
        super.onViewCreated(view, savedInstanceState);
        initList();
        initList2();
        initList3();

        spinnerPatient = view.findViewById(R.id.spinner_patient);
        mAdapter = new PatientAdapterSpinner(getContext(), patientList);
        spinnerPatient.setAdapter(mAdapter);

        spinnerPatient.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Patient clickedItem = (Patient) parent.getItemAtPosition(position);
                String NomPatient = clickedItem.getNom();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerParcours = view.findViewById(R.id.spinner_parcours);
        mAdapter2 = new ParcoursAdapterSpinner(getContext(), parcoursList);
        spinnerParcours.setAdapter(mAdapter2);

        spinnerParcours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Parcours clickedItem = (Parcours) parent.getItemAtPosition(position);
                String NomPatient = clickedItem.getTitre();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //EditText edit1=view.findViewById(R.id.titre_activite);
        spinnerActivite = view.findViewById(R.id.spinner_activite);
        mAdapter3 = new ActiviteAdapterSpinner(getContext(), activiteList);
        spinnerActivite.setAdapter(mAdapter3);

        spinnerActivite.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Activite clickedItem = (Activite) parent.getItemAtPosition(position);
                String TitreActivite = clickedItem.getTitre();
                //edit1.setVisibility(view.VISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    private void initList() {
        patientList = new ArrayList<>();
        patientList.add(new Patient("Ait hadji","Aghilas",5,076543,72873664,"a.aimad1999@gmail.com", "motdepasse","6 Rue Gaspard Coriolis",R.drawable.person));
        patientList.add(new Patient("Ait hadji","Aghilas",5,076543,72873664,"a.aimad1999@gmail.com", "motdepasse","6 Rue Gaspard Coriolis",R.drawable.person));
        patientList.add(new Patient("Ait hadji","Aghilas",5,076543,72873664,"a.aimad1999@gmail.com", "motdepasse","6 Rue Gaspard Coriolis",R.drawable.person));
        patientList.add(new Patient("Ait hadji","Aghilas",5,076543,72873664,"a.aimad1999@gmail.com", "motdepasse","6 Rue Gaspard Coriolis",R.drawable.person));
        patientList.add(new Patient("Ait hadji","Aghilas",5,076543,72873664,"a.aimad1999@gmail.com", "motdepasse","6 Rue Gaspard Coriolis",R.drawable.person));

    }
    private void initList2() {
        parcoursList = new ArrayList<>();
        parcoursList.add(new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours . nous allons nous concentrer sur",R.drawable.parcours));
        parcoursList.add(new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours . nous allons nous concentrer sur",R.drawable.parcours));
        parcoursList.add(new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours . nous allons nous concentrer sur",R.drawable.parcours));
        parcoursList.add(new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours . nous allons nous concentrer sur",R.drawable.parcours));
        parcoursList.add(new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours . nous allons nous concentrer sur",R.drawable.parcours));
        parcoursList.add(new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours . nous allons nous concentrer sur",R.drawable.parcours));
        parcoursList.add(new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours . nous allons nous concentrer sur",R.drawable.parcours));
        parcoursList.add(new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours . nous allons nous concentrer sur",R.drawable.parcours));
        parcoursList.add(new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours . nous allons nous concentrer sur",R.drawable.parcours));
        parcoursList.add(new Parcours("Rééducation de la hanche" ,"Rééducation","ceci est un parcours . nous allons nous concentrer sur",R.drawable.parcours));


    }

    private void initList3() {
        activiteList = new ArrayList<>();
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));
        activiteList.add(new Activite("Faire du sport",30));

    }
}
