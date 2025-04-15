package br.com.etecia.agenda_app;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class TesteInfo {
    // 1. Atributo estático que armazena a única instância da classe
    private static final TesteInfo instance = new TesteInfo();

    // 2. Dados que você quer guardar. Pode ser Intent, Strings, objetos, etc
    public String nome_cli, servico_cli, valor_cli;
    public boolean new_item;
    List<ObjServico> lista_servico_info = new ArrayList<>();
    List<ObjAgendadoPj> lista_agendado_pj_info = new ArrayList<>();



    // 3. Construtor privado impede que outras classes criem novos objetos TesteInfo
    private TesteInfo(){}


    //metodo publico para acessar
    public static TesteInfo getInstance(){
        return instance;
    }



}
