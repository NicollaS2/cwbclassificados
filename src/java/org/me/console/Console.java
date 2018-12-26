package org.me.console;

public class Console {
    private int id_console;
    private String descricao;

    public Console(int id, String descricao) {
        this.id_console = id;
        this.descricao = descricao;
    }

    public Console() {
    }

    public int getId() {
        return id_console;
    }
    

    public void setId(int id) {
        this.id_console = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
    
}
