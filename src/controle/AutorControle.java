/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import classes.Autor;
import classes.Editora;
import interfaces.ICRUDautor;
import java.util.ArrayList;
import persistencia.AutorPersistencia;

/**
 *
 * @author roger
 */
public class AutorControle implements ICRUDautor{
    
    private ICRUDautor objeto = null;    

    public AutorControle (String nomeDoArquivo) throws Exception{
     this.objeto = new AutorPersistencia(nomeDoArquivo);
    }

    @Override
    public void incluirAutor(Autor objeto) throws Exception {
        validaDadosAutor(objeto);
        this.objeto.incluirAutor(objeto);
        
    }

    @Override
    public ArrayList<Autor> recuperar() throws Exception {
    return this.objeto.recuperar();
    }
    
    @Override
    public void alterarAutor(Autor autorAlterado) throws Exception {
        validaDadosAutor(autorAlterado);
        this.objeto.alterarAutor(autorAlterado);
    }

    @Override
    public Autor buscarPeloId(int id) throws Exception {
        return this.objeto.buscarPeloId(id);
    }
    
    public void validaDadosAutor(Autor objeto)throws Exception{
        String nome = objeto.getNomeAutor().trim().toLowerCase();
        String invalidos = "1234567890'\"!@#$%¨&*()-_+={[}]/?><;:";
        for (int i = 0; i < invalidos.length(); i++) {
            if (nome.contains("" + invalidos.charAt(i))) {
                throw new Exception("Nome de autor inválido!");
            }
        }
        if (nome.equals("")) {
            throw new Exception("Informe o nome do autor");
        }
         ArrayList<Autor> listaAutores = recuperar();
         for (int pos = 0; pos < listaAutores.size(); pos++) {
             Autor aux = listaAutores.get(pos);
             if ((objeto.getId() != aux.getId()) && (objeto.getNomeAutor().toUpperCase().
                                                  equalsIgnoreCase(aux.getNomeAutor().toUpperCase()))){
                 throw new Exception("O nome --> " + objeto.getNomeAutor() + "\nJá existe no cadastro de autores!\n");
             }
             else if ((objeto.getId() == aux.getId()) && (objeto.getNomeAutor().toUpperCase().
                                                  equalsIgnoreCase(aux.getNomeAutor().toUpperCase()))){
                 throw new Exception("O nome --> " + objeto.getNomeAutor() + "\nNão foi alterado!\n"); 
             }
             
         }
   }
}
