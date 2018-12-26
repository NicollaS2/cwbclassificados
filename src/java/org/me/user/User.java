
package org.me.user;

import org.me.bairro.Bairro;


public class User {
    private int id;
    private String nome;
    private String ultimonome;
    private String email;
    private String senha;
    private Bairro bairro;
    private int id_bairro;
    private boolean status;
    private String telefone_ddd;
    private String telefone_numero;
    private int telefone_id;
    private int telefone_tipo_id;
    private String telefone_descricao;

    public User() {
    }

    public User(int id, String nome, String ultimonome, String email, String senha, Bairro bairro, int id_bairro, boolean status, String telefone_ddd, String telefone_numero, int telefone_id, int telefone_tipo_id, String telefone_descricao) {
        this.id = id;
        this.nome = nome;
        this.ultimonome = ultimonome;
        this.email = email;
        this.senha = senha;
        this.bairro = bairro;
        this.id_bairro = id_bairro;
        this.status = status;
        this.telefone_ddd = telefone_ddd;
        this.telefone_numero = telefone_numero;
        this.telefone_id = telefone_id;
        this.telefone_tipo_id = telefone_tipo_id;
        this.telefone_descricao = telefone_descricao;
    }

    public String getTelefone_ddd() {
        return telefone_ddd;
    }

    public void setTelefone_ddd(String telefone_ddd) {
        this.telefone_ddd = telefone_ddd;
    }

    public String getTelefone_numero() {
        return telefone_numero;
    }

    public void setTelefone_numero(String telefone_numero) {
        this.telefone_numero = telefone_numero;
    }

    public int getTelefone_id() {
        return telefone_id;
    }

    public void setTelefone_id(int telefone_id) {
        this.telefone_id = telefone_id;
    }

    public int getTelefone_tipo_id() {
        return telefone_tipo_id;
    }

    public void setTelefone_tipo_id(int telefone_tipo_id) {
        this.telefone_tipo_id = telefone_tipo_id;
    }

    public String getTelefone_descricao() {
        return telefone_descricao;
    }

    public void setTelefone_descricao(String telefone_descricao) {
        this.telefone_descricao = telefone_descricao;
    }

    
    
    public int getId_bairro() {
        return id_bairro;
    }

    public void setId_bairro(int id_bairro) {
        this.id_bairro = id_bairro;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getUltimonome() {
        return nome;
    }

    public void setUltimonome(String ultimonome) {
        this.ultimonome = ultimonome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
    
}
