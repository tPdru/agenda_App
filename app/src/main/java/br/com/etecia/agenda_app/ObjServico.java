package br.com.etecia.agenda_app;

public class ObjServico {
    String nome_servico, valor_servico;

    public ObjServico(String nome_servico, String valor_servico) {
        this.nome_servico = nome_servico;
        this.valor_servico = valor_servico;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public String getValor_servico() {
        return valor_servico;
    }

    public void setValor_servico(String valor_servico) {
        this.valor_servico = valor_servico;
    }
}
