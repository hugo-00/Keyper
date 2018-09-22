package com.hugofilipe1501gmail.aula3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PasswordViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_título, tv_senha;

    public PasswordViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_título = itemView.findViewById(R.id.tv_título);
        tv_senha = itemView.findViewById(R.id.tv_senha);
    }

    public void bindViews(Senha senha){
        tv_título.setText(senha.getTipo());
        tv_senha.setText(senha.getSenha());
    }
}
