/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import classes.AreaDoLivro;
import java.util.ArrayList;
/**
 *
 * @author roger
 */
public interface ICRUDareaDoLivro {
    
    public void importarTabelaCdd(String nomeDoArquivo) throws Exception;
    ArrayList<AreaDoLivro> recuperar() throws Exception;
    public AreaDoLivro buscarId(int id) throws Exception;
}
