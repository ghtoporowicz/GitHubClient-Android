package br.com.githubclient;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class ListRepositoriosActivity extends Activity implements   AdapterView.OnItemClickListener {

    private ListView lstRepositorios;
    private AdapterRepositorios adapterRepositorios;
    private ArrayList<GitHubRepo> listRepositorios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repositorios);

        lstRepositorios = (ListView) findViewById(R.id.lstRepositorios);
        //Define o Listener quando alguem clicar no item.
        lstRepositorios.setOnItemClickListener(this);

        listRepositorios = new ArrayList();

        String userRepositorio = getIntent().getStringExtra("userRepositorio");

        Retrofit retrofit = RetrofitConection.getInstance();

        GitHubClient client =  retrofit.create(GitHubClient.class);

        // Fetch a list of the Github repositories.
        Call<List<GitHubRepo>> call =
                client.reposForUser(userRepositorio);

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, retrofit2.Response<List<GitHubRepo>> response) {
                for(int i = 0 ; i < response.body().size() ;i++){
                    GitHubRepo responseclass = response.body().get(i);
                    listRepositorios.add(responseclass);
                }

                criarAdapter();

            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Log.d("ERROR", "Erro ao popular a lista vinda do banco.");
            }
        });
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
        //Pega o item que foi selecionado.
        GitHubRepo item = (GitHubRepo) adapterRepositorios.getItem(arg2);
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("linkRepositorio", item.getHtml_url());
        startActivity(intent);
    }

    private void criarAdapter(){

        //Cria o adapter
        adapterRepositorios = new AdapterRepositorios(this, listRepositorios);
        //Define o Adapter
        lstRepositorios.setAdapter(adapterRepositorios);
        //Cor quando a lista é selecionada para ralagem.
        lstRepositorios.setCacheColorHint(Color.TRANSPARENT);
    }
}
