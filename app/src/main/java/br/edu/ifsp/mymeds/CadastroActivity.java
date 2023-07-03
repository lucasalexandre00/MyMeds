package br.edu.ifsp.mymeds;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextPassword;

    private Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editTextEmail = findViewById(R.id.editTextTextEmailAddressCadastro);
        editTextPassword = findViewById(R.id.editTextTextPasswordCadastro);
        buttonCadastrar = findViewById(R.id.buttonCadastro);

        buttonCadastrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}