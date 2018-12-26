package org.me.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.jms.ConnectionFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.me.database.Database;

@ManagedBean
public class UpImgMB {

    private Part arquivo;
    private static final String SAVE_DIR = "\\site\\img\\file";

    public void importa() {
        try {

            String contentType = arquivo.getContentType();
            System.out.println(contentType);
            String fileName = arquivo.getSubmittedFileName();
            System.out.println(fileName);
            long fileSize = arquivo.getSize();
            System.out.println(fileSize);

            String currentTime = String.valueOf(DATE.getDate().getTime());
            fileName = MD5.encode(fileName + currentTime) + "." + fileName.split("[.]")[1];

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String appPath = request.getServletContext().getRealPath("");

            System.out.println(appPath);

            String savePath = appPath + SAVE_DIR;
            System.out.println(savePath);
            File fileSaveDir = new File(savePath);
            fileSaveDir.mkdir();

            InputStream input = arquivo.getInputStream();

            Files.copy(input, new File(savePath + File.separator + fileName).toPath());
            
            gravarImagem(fileName);

        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public void gravarImagem(String urlImagem) throws Exception {
            System.out.println("urlImagem = " + urlImagem);
        
            Database myDb = new Database();
            String sql = "call atualiza_img(?);";
            myDb.setQuerySql(sql);
            myDb.setQueryParameter().setString(1, urlImagem);
            int result = myDb.setQueryParameter().executeUpdate();

    }

    public Part getArquivo() {
        return arquivo;
    }

    public void setArquivo(Part arquivo) {
        this.arquivo = arquivo;
    }

}
