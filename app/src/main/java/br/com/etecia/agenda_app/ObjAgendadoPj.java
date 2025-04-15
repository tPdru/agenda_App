package br.com.etecia.agenda_app;

public class ObjAgendadoPj {
    String nome_cliente, valor_total, servicos;
    int img_perfil_cliente;


    public ObjAgendadoPj(int img_perfil_cliente, String nome_cliente, String servicos, String valor_total) {
        this.img_perfil_cliente = img_perfil_cliente;
        this.nome_cliente = nome_cliente;
        this.servicos = servicos;
        this.valor_total = valor_total;
    }


    public int getImg_perfil_cliente() {
        return img_perfil_cliente;
    }

    public void setImg_perfil_cliente(int img_perfil_cliente) {
        this.img_perfil_cliente = img_perfil_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getServicos() {
        return servicos;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }
}
