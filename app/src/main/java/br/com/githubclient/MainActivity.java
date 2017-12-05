package br.com.githubclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.OkHttpClient.*;

public class MainActivity extends AppCompatActivity {

    Button btnProcurar;
    EditText edtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProcurar = (Button) findViewById(R.id.btnProcurar);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
    }

    public void btnProcurarClick(View view)
    {
        Intent abrirTelaListar = new Intent(this, ListRepositoriosActivity.class);
        String pesquisa = edtUsername.getText().toString();
        abrirTelaListar.putExtra("userRepositorio", pesquisa);
        startActivity(abrirTelaListar);
    }
}
