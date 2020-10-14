/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.swing.JComboBox;

/**
 *
 * @author roger
 */
public class AreaDoLivro implements Comparable<AreaDoLivro> {
    
    private int id = 0;
    private String cdd = "";
    private String descricaoDaArea = "";

    public AreaDoLivro() throws Exception {
        this.id = 0;
        this.cdd = "";
        this.descricaoDaArea = "";
    }
    
    public AreaDoLivro(String cdd, String descricao) throws Exception {
        this.cdd = cdd;
        this.descricaoDaArea = descricao;
    }
    
    public AreaDoLivro(int id, String cdd, String descricao) throws Exception {
        this.id = id;
        this.cdd = cdd;
        this.descricaoDaArea = descricao;
    }

    public AreaDoLivro(AreaDoLivro objeto) throws Exception {
        this.id = objeto.id;
        this.cdd = objeto.cdd;
        this.descricaoDaArea = objeto.descricaoDaArea;
    }

    public AreaDoLivro(String strDadosDaArea) throws Exception {
        String vetorString[] = strDadosDaArea.split(";");
       
        id = Integer.parseInt(vetorString[0]);
        cdd = (vetorString[1]);
        descricaoDaArea = vetorString[2];
    }
    
    public void setAreaSplit (String combBox)throws Exception{
        String[] vetorString = combBox.split("-");
        id = Integer.parseInt(vetorString[0]);
        cdd = (vetorString[1]);
        descricaoDaArea = vetorString[2];
        if (vetorString.length < 3) {
            throw new Exception();
        }
    }

    @Override
    public String toString() {
        String saida = id + ";";
        saida += cdd + ";";
        saida += descricaoDaArea + ";";
        return saida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCdd() {
        return cdd;
    }

    public void setCdd(String cdd) {
        this.cdd = cdd;
    }

    public String getDescricaoDaArea() {
        return descricaoDaArea;
    }

    public void setDescricaoDaArea(String descricaoDaArea) {
        this.descricaoDaArea = descricaoDaArea;
    }

    @Override
    public int compareTo(AreaDoLivro objeto) {
        return descricaoDaArea.compareToIgnoreCase(objeto.getDescricaoDaArea());
    }

}
