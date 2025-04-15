package br.com.etecia.agenda_app;

public class ObjServico {
    String nome_servico, descricao_servico;
    Float valor_servico;
    int image_servico;

    public ObjServico(String descricao_servico, String nome_servico, Float valor_servico) {
        this.descricao_servico = descricao_servico;
        //this.image_servico = image_servico;
        this.nome_servico = nome_servico;
        this.valor_servico = valor_servico;
    }


    public String getDescricao_servico() {
        return descricao_servico;
    }

    public void setDescricao_servico(String descricao_servico) {
        this.descricao_servico = descricao_servico;
    }

    public int getImage_servico() {
        return image_servico;
    }

    public void setImage_servico(int image_servico) {
        this.image_servico = image_servico;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public Float getValor_servico() {
        return valor_servico;
    }

    public void setValor_servico(Float valor_servico) {
        this.valor_servico = valor_servico;
    }
}
