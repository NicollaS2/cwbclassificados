package org.me.jogos_anuncios;

import org.me.console.Console;
import org.me.genero.Genero;
import org.me.user.User;

public class Jogos_anuncios {
    
    
    private int id_jogosAnuncios;
    private String descricao;
    private char ativo;
    private Console console;
    private int id_console;
    private int id_user;
    private User user;
    private Genero genero;
    private int id_genero;
    private String nome;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    
    
   

    //--------------------------------------------------------------------------

    public int getId_jogosAnuncios() {
        return id_jogosAnuncios;
    }

    public void setId_jogosAnuncios(int id_jogosAnuncios) {
        this.id_jogosAnuncios = id_jogosAnuncios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public int getId_console() {
        return id_console;
    }

    public void setId_console(int id_console) {
        this.id_console = id_console;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    

    
    
}
