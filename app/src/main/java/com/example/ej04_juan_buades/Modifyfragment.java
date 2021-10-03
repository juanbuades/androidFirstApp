package com.example.ej04_juan_buades;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class Modifyfragment extends Fragment implements View.OnClickListener {
    EditText web1;
    EditText web2;
    Button changeWeb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentmodify, container, false);
        web1 = view.findViewById(R.id.newWeb1);
        web2 = view.findViewById(R.id.newWeb2);
        changeWeb = view.findViewById(R.id.changeWeb);
        changeWeb.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        String urlWeb1ToChange = web1.getText().toString();
        String urlWeb2ToChange = web2.getText().toString();
        FragmentActivity activity = getActivity();
        MainActivity mainActivity = (MainActivity) activity;
        if (!urlWeb1ToChange.isEmpty()) {
            mainActivity.web1Receiver(urlWeb1ToChange);
            Snackbar.make(getView(),"Web 1 cambiada",Snackbar.LENGTH_LONG).setAction("ENTENDIDO", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            }).show();
        }
        if (!urlWeb2ToChange.isEmpty()) {
            mainActivity.web2Receiver(urlWeb2ToChange);
            Snackbar.make(getView(),"Web 2 cambiada",Snackbar.LENGTH_LONG).setAction("ENTENDIDO", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            }).show();
        }
    }
}
