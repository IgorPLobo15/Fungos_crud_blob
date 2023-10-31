package model.bean;
//Temos aqui os atributos do banco de dados
/**
 *
 * @author Igor Lobo */
import java.sql.Blob;
import java.util.Date;

import java.sql.Blob;
import java.util.Date;

public class Fungo {
    private int numero;
    private Date data;
    private String nome;
    private byte[] imagem;
    private int id; 

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   

    public Object getImagemFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}



