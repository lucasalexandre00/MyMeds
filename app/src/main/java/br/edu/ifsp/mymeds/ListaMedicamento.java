package br.edu.ifsp.mymeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.mymeds.dao.ConfiguracaoFirebase;
import br.edu.ifsp.mymeds.model.Medicamento;
import br.edu.ifsp.mymeds.view.recyclerview.adapter.ListaMedicamentosAdapter;

public class ListaMedicamento extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListaMedicamentosAdapter listaMedicamentosAdapter;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medicamento);

        databaseReference = ConfiguracaoFirebase.getFirebase().child("medicamentos");

        List<Medicamento> listaMedicamentos = new ArrayList<>();
        listaMedicamentos.add(new Medicamento("Dipirona", "Para dor de cabeca", "1", ZonedDateTime.now()));
        listaMedicamentos.add(new Medicamento("AAS", "Para afinar o sangue", "1", ZonedDateTime.now()));

        databaseReference = ConfiguracaoFirebase.getFirebase().child("medicamentos");
        databaseReference.push().setValue(listaMedicamentos.get(0));
        databaseReference.push().setValue(listaMedicamentos.get(1));


        recyclerView = findViewById(R.id.recycleViewID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listaMedicamentosAdapter = new ListaMedicamentosAdapter(listaMedicamentos, this);
        recyclerView.setAdapter(listaMedicamentosAdapter);
    }
}