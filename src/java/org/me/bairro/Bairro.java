package org.me.bairro;

public class Bairro {
    

    private int id;
    private String bairroNome;

    public Bairro() {
    }

    public Bairro(int id, String bairroNome) {
        this.id = id;
        this.bairroNome = bairroNome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBairroNome() {
        return bairroNome;
    }

    public void setBairroNome(String bairroNome) {
        this.bairroNome = bairroNome;
    }

}
