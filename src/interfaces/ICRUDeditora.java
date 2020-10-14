/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Editora;
import java.util.ArrayList;

public interface ICRUDeditora {

    void incluirEditora(Editora objeto) throws Exception;

    ArrayList<Editora> recuperar() throws Exception;  
    
    public void alterarEditora (Editora objetoNovo)throws Exception;
    
     public Editora buscarId(int id) throws Exception;

}
