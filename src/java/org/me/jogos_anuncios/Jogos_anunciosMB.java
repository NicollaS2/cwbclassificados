package org.me.jogos_anuncios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import static jdk.nashorn.internal.runtime.JSType.toInteger;
import org.me.exception.ExceptionError;
import org.me.user.User;
import org.me.util.MessageMB;
import org.me.util.RedirectMB;
import org.me.util.SessionMB;

@ManagedBean(name = "jogos_anunciosMB")
@RequestScoped

public class Jogos_anunciosMB {

    private SessionMB sessionMB = new SessionMB();
    private Jogos_anuncios jogos = new Jogos_anuncios();
    private User user = (User) sessionMB.getAttribute("user");
    private String PesquisaUser = "";
    private String filterGenero = "";
    private String filterBairro = "";
    private String filterHTTPResquest= "";
    private String filterConsole= "";
    private String filterAnuncio= "";
    private int anuncio = 0;
    int status = 0;
    
    private HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    public Jogos_anunciosMB() {
        //Jogos_filtro();
        this.filterGenero = request.getParameter("genero");
        this.filterBairro = request.getParameter("bairro");
        this.filterConsole = request.getParameter("console");
        this.filterAnuncio = request.getParameter("anuncio");
        this.filterHTTPResquest = request.getQueryString();
        System.out.println("generoMB " + filterGenero);
        System.out.println("bairroMB " + filterBairro);
        System.out.println("consoleMB " + filterConsole);
        System.out.println("anuncioMB " + filterAnuncio);
        System.out.println("totalMB " + filterHTTPResquest);
        
        if(request.getQueryString() == null){
            
            
            this.filterGenero = "50";
            this.filterBairro = "60";
            this.filterConsole = "70";
            this.filterAnuncio = "70";
            this.filterHTTPResquest = "ultimasAtualizacoes";
        }
    }

    public void cadastroJogos() throws IOException, ExceptionError {
        jogos.setId_user(user.getId());

        Jogos_anunciosController jogosContreoller = new Jogos_anunciosController();
        Jogos_anuncios resultado = jogosContreoller.cadastro(this.jogos);

        if (resultado != null) {
            //new MessageMB("msgInfo", "Login realizado com sucesso!", "", 1);
            //return "/site/index.xhtml";

            sessionMB.getAttribute("user");

            String url = "/site/index.xhtml";
            new RedirectMB(url);
        } else {
            new MessageMB("msgInfo", "Algo deu errado!", "", 3);
            //return null;
        }
    }
    
    
    public void excluirAnuncio(int game) throws IOException, ExceptionError {
        
        Jogos_anunciosController jogosContreoller = new Jogos_anunciosController();
        Jogos_anuncios resultado = jogosContreoller.excluir(game);

        if (resultado != null) {
            //new MessageMB("msgInfo", "Login realizado com sucesso!", "", 1);
            //return "/site/index.xhtml";

            sessionMB.getAttribute("user");

            String url = "/site/anuncio/meus_anuncios.xhtml";
            new RedirectMB(url);
        } else {
            new MessageMB("msgInfo", "", "", 3);
            //return null;
        }
    }
    
    public void alterar() throws IOException {
        try {
            Jogos_anunciosController userContreoller = new Jogos_anunciosController();
            jogos.setId_jogosAnuncios(user.getId());
            System.out.println("jogos anuncio: "+jogos.getId_jogosAnuncios());
            
            boolean resultado = userContreoller.Alterar(this.jogos);
            
            if(resultado){
                //new MessageMB("msgInfo", "Login realizado com sucesso!", "", 1);
                //return "/site/index.xhtml";
                
                String url = "/site/anuncio/meus_anuncios.xhtml";
                new RedirectMB(url);
            } else {
                new MessageMB("msgInfo", "", "", 3);
                //return null;
            }
        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }
        
    }

    public List<Jogos_anuncios> listarJogos() throws IOException, SQLException {
        List jogosList = new ArrayList<User>();

        try {
            Jogos_anunciosController jogosController = new Jogos_anunciosController();

            jogosList = jogosController.getJogos(filterGenero,filterBairro,filterConsole, filterHTTPResquest);

        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }

        return jogosList;
    }

    public List<Jogos_anuncios> listarJogosUser() throws IOException, SQLException {
        List jogosList = new ArrayList<User>();
        jogos.setId_user(user.getId());
        
        try {
            Jogos_anunciosController jogosController = new Jogos_anunciosController();

            jogosList = jogosController.getJogosUser(jogos);

        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }

        return jogosList;
    }
    
    public String  idUltimo(int id) throws IOException, SQLException{
        this.anuncio = id;
        TelaAnuncio();
        System.out.println("idultimo" +id);
        
        status = toInteger(sessionMB.getAttribute("auth"));
        
        if(status != 0){
            System.out.println("logado "+status);
            return "/site/anuncio/anuncioDescricaoLogado.xhtml"+id;
        }
        else{
            System.out.println("só anuncio "+status);
            return "/site/anuncio/anuncioDescricao.xhtml"+id;
        }
        
        
        
    }
    // MÉTODO QUE RETORNA UM ARRAYLIST PARA TELA DE ANUNCIOS INDIVIDUAIS
    public List<Jogos_anuncios> TelaAnuncio() throws IOException, SQLException {
        System.out.println("this.anuncio" + this.anuncio);
        List jogosList = new ArrayList<User>();
            /*String url = "/../ProjetoIntegrador/site/auth/anuncioDescricao.xhtml";
                new RedirectMB(url);*/
        try {
            
            Jogos_anunciosController jogosController = new Jogos_anunciosController();
            System.out.println("MB TELANUNCIO id "+this.anuncio);
            jogosList = jogosController.TelaAnuncioController( this.anuncio);
            
            
        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }
        
        return jogosList;
    }

    public Jogos_anuncios getJogos() {
        return jogos;
    }

    public void setJogos(Jogos_anuncios jogos) {
        this.jogos = jogos;
    }

}
