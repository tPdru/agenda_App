package br.com.etecia.agenda_app;

public class ObjAgendado {
    String nome_agendado;
    String valor_agendado;


    public ObjAgendado(String nome_agendado, String valor_agendado) {
        this.nome_agendado = nome_agendado;
        this.valor_agendado = valor_agendado;
    }


    public String getValor_agendado() {
        return valor_agendado;
    }

    public void setValor_agendado(String valor_agendado) {
        this.valor_agendado = valor_agendado;
    }

    public ObjAgendado(String nome_agendado) {
        this.nome_agendado = nome_agendado;
    }


    public String getNome_agendado() {
        return nome_agendado;
    }

    public void setNome_agendado(String nome_agendado) {
        this.nome_agendado = nome_agendado;
    }
}
