package com.tarsojabbes.educare.domains.enums;

public enum TipoUser {

    ALUNO(1, "Aluno"),
    PROFESSOR(2, "Professor");

    private int cod;
    private String descricao;

    TipoUser(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod(){
        return cod;
    }

    public String getDescricao(){
        return descricao;
    }

    public static TipoUser toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for (TipoUser x : TipoUser.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido:" + cod);
    }
}
