package br.com.etecia.agenda_app;

public class ObjListaAgendamento {
    String txtNomePerfilPJ, txtValorAgendamento, txtEnderecoAgendamento,txtAvaliacaoPerfilPJ, txtDataHoraAgendamento;
    Integer imgPerfilPJ;

    public String getTxtNomePerfilPJ() {
        return txtNomePerfilPJ;
    }

    public void setTxtNomePerfilPJ(String txtNomePerfilPJ) {
        this.txtNomePerfilPJ = txtNomePerfilPJ;
    }

    public String getTxtValorAgendamento() {
        return txtValorAgendamento;
    }

    public void setTxtValorAgendamento(String txtValorAgendamento) {
        this.txtValorAgendamento = txtValorAgendamento;
    }

    public String getTxtEnderecoAgendamento() {
        return txtEnderecoAgendamento;
    }

    public void setTxtEnderecoAgendamento(String txtEnderecoAgendamento) {
        this.txtEnderecoAgendamento = txtEnderecoAgendamento;
    }

    public String getTxtAvaliacaoPerfilPJ() {
        return txtAvaliacaoPerfilPJ;
    }

    public void setTxtAvaliacaoPerfilPJ(String txtAvaliacaoPerfilPJ) {
        this.txtAvaliacaoPerfilPJ = txtAvaliacaoPerfilPJ;
    }

    public String getTxtDataHoraAgendamento() {
        return txtDataHoraAgendamento;
    }

    public void setTxtDataHoraAgendamento(String txtDataHoraAgendamento) {
        this.txtDataHoraAgendamento = txtDataHoraAgendamento;
    }

    public Integer getImgPerfilPJ() {
        return imgPerfilPJ;
    }

    public void setImgPerfilPJ(Integer imgPerfilPJ) {
        this.imgPerfilPJ = imgPerfilPJ;
    }

    public ObjListaAgendamento(String txtNomePerfilPJ, String txtValorAgendamento, String txtEnderecoAgendamento, String txtAvaliacaoPerfilPJ, String txtDataHoraAgendamento, Integer imgPerfilPJ) {
        this.txtNomePerfilPJ = txtNomePerfilPJ;
        this.txtValorAgendamento = txtValorAgendamento;
        this.txtEnderecoAgendamento = txtEnderecoAgendamento;
        this.txtAvaliacaoPerfilPJ = txtAvaliacaoPerfilPJ;
        this.txtDataHoraAgendamento = txtDataHoraAgendamento;
        this.imgPerfilPJ = imgPerfilPJ;
    }
}
