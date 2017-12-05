package br.com.githubclient;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by Gustavo Toporowicz on 29/11/2017.
 */

public class AdapterRepositorios extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<GitHubRepo> itens;

    public AdapterRepositorios(Context context, ArrayList<GitHubRepo> itens)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Pega o item de acordo com a posção.
        GitHubRepo item = itens.get(position);
        //infla o layout para podermos preencher os dados
        convertView = mInflater.inflate(R.layout.list_item, null);

        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) convertView.findViewById(R.id.txtNomeRepositorio)).setText(item.getName());
        ((TextView) convertView.findViewById(R.id.txtLinkRepositorio)).setText(item.getHtml_url());

        return convertView;
    }
}
