package com.leobilha.covinfo.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leobilha.covinfo.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterVh> {

    private List<Botoes> botoesList;
    private Context context;
    private SelectedBotao selectedBotao;

    public Adapter(List<Botoes> botoesList, SelectedBotao selectedBotao) {
        this.botoesList = botoesList;
        this.selectedBotao = selectedBotao;
    }

    @NonNull
    @Override
    public Adapter.AdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        return new AdapterVh(LayoutInflater.from(context).inflate(R.layout.linha_botao, null));

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.AdapterVh holder, int position) {

        Botoes botoes = botoesList.get(position);

        String nomeBotao = botoes.getNome();

        holder.tvNomeBotao.setText(nomeBotao);
        if (botoes == botoesList.get(0)) {
            holder.imageView.setImageResource(R.drawable.disque_saude);
        } else if (botoes == botoesList.get(1)) {
            holder.imageView.setImageResource(R.drawable.questao);
        } else if (botoes == botoesList.get(2)) {
            holder.imageView.setImageResource(R.drawable.google_maps);
        } else if (botoes == botoesList.get(3)) {
            holder.imageView.setImageResource(R.drawable.linha_do_tempo);
        } else if (botoes == botoesList.get(4)) {
            holder.imageView.setImageResource(R.drawable.news);
        }
    }

    public interface SelectedBotao {
        void selecionandoBotao(Botoes botoes);
    }

    @Override
    public int getItemCount() {
        return botoesList.size();
    }

    public class AdapterVh extends RecyclerView.ViewHolder {

        TextView tvNomeBotao;
        ImageView imageView;

        public AdapterVh(@NonNull View itemView) {
            super(itemView);

            tvNomeBotao = itemView.findViewById(R.id.nomeBotao);
            imageView = itemView.findViewById(R.id.imageViewBotao);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedBotao.selecionandoBotao(botoesList.get(getAdapterPosition()));
                }
            });


        }
    }
}
