package com.leobilha.covinfo.linhadotempo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.leobilha.covinfo.R;

public class AdapterLinhaDoTempo extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public AdapterLinhaDoTempo(Context context) {
        this.context = context;
    }

    public String[] titulo = {

            "08/12/2019 >",
            "< 29/12/2019 >",
            "< 30/12/2019 >",
            "< 03/01/2020 >",
            "< 05/01/2020 >",
            "< 09/01/2020 >",
            "< 10/01/2020 >",
            "< 16/01/2020 >",
            "< 20/01/2020 >",
            "< 21/01/2020 >",
            "< 22/01/2020 >",
            "< 27/01/2020 >",
            "< 28/01/2020 >",
            "< 30/01/2020 >",
            "< 31/01/2020 >",
            "< 03/02/2020 >",
            "< 04/02/2020 >",
            "< 04/02/2020 e 05/02/2020 >",
            "< 05/02/2020 >",
            "< 06/02/2020 >",
            "< 07/02/2020 >",
            "< 09/02/2020 >",
            "< 19/02/2020 >",
            "< 21/02/2020 >",
            "< 23/02/2020 >",
            "< 24/02/2020 >",
            "< 26/02/2020"
    };

    public String[] descricao = {

            "• Primeiros casos\nPneumonia em hospital de Wuhan/China",
            "• Identificação do vírus\nDivulgado o código genético do coronavírus na China",
            "• Notificação para OMS\nCluster de casos de “pneumonia de causa desconhecida”",
            "• Ministério da Saúde detecta\n“pneumonia de causa desconhecida” na China\n• Solicitação de esclarecimento\nBrasil pede informações à OMS",
            "• 1º Comunicado da OMS\n44 casos de “pneumonia de causa desconhecida” relacionada ao Mercado de Frutos do Mar de Wuhan/China",
            "• Identificação do vírus\nDivulgado o código genético do coronavírus na China",
            "• Monitoramento\nComitê de Monitoramento de Eventos do Ministério da Saúde é acionado",
            "• Boletim Epidemiológico\nMinistério da Saúde publica a primeira informação sobre o que se sabia sobre a doença",
            "• OPAS/OMS\nReunião para alinhamento da estratégia internacional de resposta",
            "• 1º Boletim Epidemiológico da OMS\nRisco moderado",
            "• Ativação do COE-nCoV\nComitê de Operações de Emergência (COE) é ativado em nível 1 de alerta, sem casos suspeitos",
            "• 1º caso suspeito\n• Alteração do COE para nível 2 (perigo iminente) com mudança na definição de caso",
            "• OMS ALTERA POSICIONAMENTO\nOrganismo admite erro e eleva risco para “alto”",
            "• ESPII\nOMS declara Emergência Internacional",
            "• GEI-ESP\nAcionado o Grupo Executivo Interministerial",
            "• Emergência Nacional\nBrasil declara Emergência de Saúde Pública de Importância Nacional (ESPIN)\n1ª Reunião GEI-ESPII\nRealizada primeira reunião do Grupo Executivo Interministerial em Saúde Pública (GEI-ESPII)",
            "• Projeto de Lei de Quarentena\nMinistério da Saúde envia Projeto de Lei ao Congresso Nacional",
            "• Congresso Nacional aprova Projeto de Lei\nLegislativo aprova lei sobre quarentena",
            "• Brasil realiza missão para repatriamento de 34 brasileiros que viviam na cidade de Wuhan, na China",
            "• CIT sobre o coronavírus\nReunião na Comissão Intergestores Tripartite (CIT) sobre o coronavírus com secretários de saúde dos Estados e capitais",
            "• Sancionada Lei de Quarentena\nPresidente da República sanciona Lei de Quarentena\n• Ministério da Saúde e Fiocruz realizam capacitação técnica de representantes de 9 países das Américas do Sul e Central para diagnóstico laboratorial do coronavírus\n• Operação Regresso - Decolagem de Wuhan com destino ao Brasil (início da quarentena)",
            "• Chegada ao Brasil dos 58 envolvidos na Operação Regresso",
            "• Brasil apresenta ações para enfrentamento ao coronavírus durante reunião dos ministros da Saúde do Mercosul em Assunção, no Paraguai",
            "• Ampliação para mais sete países em alerta para casos suspeitos da doença, além da China",
            "• Os brasileiros repatriados, que estavam de quarentena na base militar de Anápolis (GO), são liberados",
            "• Ampliação da lista de países em alerta para casos suspeitos para mais 8 países, totalizando 16 países",
            "• Confirmado o primeiro caso de coronavírus no Brasil, em São Paulo-SP :/"
    };

    @Override
    public int getCount() {
        return titulo.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        TextView titulo1 = (TextView) view.findViewById(R.id.tituloDetalhes);
        TextView descricao2 = (TextView) view.findViewById(R.id.descricao);

        titulo1.setText(titulo[position]);
        descricao2.setText(descricao[position]);

        container.addView(view);

        return view;
    };


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);


    }
}
