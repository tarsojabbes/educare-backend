package com.tarsojabbes.educare.domains;

import java.util.Date;

public class CustomError {

    private Date data;
    private String mensagem;

    public CustomError() {

    }

    public CustomError(Date data, String mensagem) {
        this.data = data;
        this.mensagem = mensagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
