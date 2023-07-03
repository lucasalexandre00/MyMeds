package br.edu.ifsp.mymeds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.edu.ifsp.mymeds.dao.ConfiguracaoFirebase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonNovoUsuario;

    Intent intentCadastro;

    Intent intentLogin;

    FirebaseAuth firebaseAuth = ConfiguracaoFirebase.getFirebaseAuth();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //firebaseAuth.createUserWithEmailAndPassword("lucas@hotmail.com", "lucas123");

        textViewLogin = findViewById(R.id.textViewLogin);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonNovoUsuario = findViewById(R.id.buttonNovoUsuario);

        buttonLogin.setOnClickListener(this);
        buttonNovoUsuario.setOnClickListener(this);

        if (usuarioLogado()){
            abrirListaMedicamentos();
        }
    }

    @Override
    public void onClick(View view) {

        if (view == buttonNovoUsuario ){
            intentCadastro = new Intent(this, CadastroActivity.class);
            startActivity(intentCadastro);
        }
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                abrirListaMedicamentos();
                            }else {
                                Toast.makeText(MainActivity.this,"Falha no login", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
    }

    private void abrirListaMedicamentos(){
        intentLogin = new Intent(this, ListaMedicamento.class);
        startActivity(intentLogin);
    }

    private boolean usuarioLogado(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null){
            return true;
        }
        return false;
    }

}