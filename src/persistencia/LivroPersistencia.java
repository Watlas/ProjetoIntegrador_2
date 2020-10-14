/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.Livro;
import interfaces.ICRUDlivro;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import utilidades.GeradorIdentificador;

/**
 *
 * @author roger
 */
public class LivroPersistencia implements ICRUDlivro{
    
    private String nomeDoArquivo = null;
    
    public LivroPersistencia()throws Exception {
        
    }
    
    public LivroPersistencia (String nomeDoArquivo)throws Exception{
        this.nomeDoArquivo = nomeDoArquivo;
    }   
    
    @Override
    public void incluir(Livro objeto) throws Exception {
        try {
            
            GeradorIdentificador idLivro = new GeradorIdentificador();
            objeto.setId(idLivro.getID());
            
            FileWriter fw = new FileWriter(nomeDoArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto.toString() + "\n");
            bw.close();
            idLivro.finalize();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao incluir este livro\n!\n" + erro);           
        }
        
    }
    
     @Override
    public ArrayList<Livro> recuperar() throws Exception {
        try {
            ArrayList<Livro> listaLivro = new ArrayList<Livro>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null){
             Livro objetoLivro = new Livro(linha);
             listaLivro.add(objetoLivro);
            }
            br.close();
            Collections.sort(listaLivro);
            return listaLivro;
            
        } catch (Exception erro) {
         throw new Exception("Ocorreu um erro ao recuperar este arquivo --> Livro.txt\n" + erro);
        }     
    }

    @Override
    public void alterarDadosDoLivro(Livro livroAlterado) throws Exception {
        try {
            ArrayList<Livro> listaLivro = recuperar();            
            FileWriter fw = new FileWriter(nomeDoArquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int pos = 0; pos < listaLivro.size(); pos++) {
                Livro aux = listaLivro.get(pos);
                if (livroAlterado.getId() == aux.getId()) {
                    bw.write(livroAlterado.toString() + "\n");
                }else {
                    bw.write(aux.toString() + "\n");
                } 
            }
            bw.close();
            
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro na alteração deste livro\n" + erro);
        }   
    }
    @Override
    public void emprestarOuDevolver() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Livro buscarPeloId(int id) throws Exception {
       try{
           
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";        
        while ((linha = br.readLine()) != null) {           
            Livro objetoLivro = new Livro(linha);
            if (objetoLivro.getId() == id) {
                br.close();
                return objetoLivro;
            }            
        }
        br.close();        
         
        return null;
       }catch(Exception erro){
            throw new Exception("Id do Autor não encontrado!" + erro.getMessage());
       }
    }
}
