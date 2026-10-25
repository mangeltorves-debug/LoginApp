package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import com.example.loginapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Programar la acción del botón de login con navegación
        binding.btnLogin.setOnClickListener(v -> {
            String usuario = binding.etUsername.getText().toString();
            String password = binding.etPassword.getText().toString();

            if (usuario.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "¡Bienvenido, " + usuario + "!", Toast.LENGTH_SHORT).show();

                // Navegación hacia la MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                // Opcional: finaliza LoginActivity para que al pulsar ' atrás' no vuelva al login
                finish();
            }
        });
    }
}