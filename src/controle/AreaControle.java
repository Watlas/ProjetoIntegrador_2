/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import classes.AreaDoLivro;
import interfaces.ICRUDareaDoLivro;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import persistencia.AreaPersistencia;

/**
 *
 * @author roger
 */
public class AreaControle implements ICRUDareaDoLivro {

    private ICRUDareaDoLivro objeto = null;
    private String nomeDoArquivo = null;
    
    public AreaControle() {
    }

    public AreaControle(String nomeDoArquivo) throws Exception {
        this.objeto = new AreaPersistencia(nomeDoArquivo);
    }

    @Override
    public void importarTabelaCdd(String nomeDoArquivo) throws Exception {        
         this.objeto.importarTabelaCdd(nomeDoArquivo);
    }
    
    @Override
    public ArrayList<AreaDoLivro> recuperar() throws Exception {
        return this.objeto.recuperar();
    }


    @Override
    public AreaDoLivro buscarId(int id) throws Exception {
        return this.objeto.buscarId(id);
    }
    
}
