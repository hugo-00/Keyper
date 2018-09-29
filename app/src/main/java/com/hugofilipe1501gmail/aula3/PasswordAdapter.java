package com.hugofilipe1501gmail.aula3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PasswordAdapter extends RecyclerView.Adapter<PasswordViewHolder> {

    private ArrayList<Senha> dados = new ArrayList<>();
    private SenhaDatabase sdatabase;

    @NonNull
    @Override
    public PasswordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.linha_password, viewGroup, false);
        PasswordViewHolder vh = new PasswordViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PasswordViewHolder passwordViewHolder, int i) {
        Senha s = dados.get(i);
        passwordViewHolder.bindViews(s);
        final int a = i;
        passwordViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder Builder = new AlertDialog.Builder(v.getContext());
                Builder.setMessage("Tem certeza que deseja eliminar?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //usar delete e remover a
                                removeItem(a);
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        });
                Builder.show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public void add(Senha mSenha){
        dados.add(mSenha);
        notifyDataSetChanged();
    }

    public void add(List<Senha> List){
        dados.addAll(List);
        notifyDataSetChanged();
    }

    private void removeItem(int pos) {
        Senha s = dados.get(pos);
        dados.remove(pos);
        notifyDataSetChanged();
    }
}
