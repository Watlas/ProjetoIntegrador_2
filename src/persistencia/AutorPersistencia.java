package persistencia;

import classes.Autor;
import interfaces.ICRUDautor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import utilidades.GeradorIdentificador;

public class AutorPersistencia implements ICRUDautor {

    private String nomeDoArquivo;

    public AutorPersistencia() throws Exception {

    }

    public AutorPersistencia(String nomeDoArquivo) throws Exception {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    @Override
    public void incluirAutor(Autor objeto) throws Exception {
        try {
            GeradorIdentificador idAutor = new GeradorIdentificador();            
            objeto.setId(idAutor.getID());
            
            FileWriter fw = new FileWriter(nomeDoArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto.toString() + "\n");
            bw.close();
            idAutor.finalize();
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na gravação deste arquivo!");
        }
    }
    
     @Override
    public ArrayList<Autor> recuperar() throws Exception {
       try{
        ArrayList<Autor> listaDeAutores = new ArrayList<Autor>();
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";        
        while ((linha = br.readLine()) != null) {           
            Autor objetoAutor = new Autor(linha);
            listaDeAutores.add(objetoAutor);
        }
        br.close();
           Collections.sort(listaDeAutores);
        
        return listaDeAutores;
       }catch(Exception erro){
            throw new Exception("O arquivo está vazio!" + erro.getMessage());
       }
    }

    public Autor buscarPeloId(int id) throws Exception {
       try{
           
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";        
        while ((linha = br.readLine()) != null) {           
            Autor objetoAutor = new Autor(linha);
            if (objetoAutor.getId() == id) {
                br.close();
                return objetoAutor;
            }            
        }
        br.close();        
         
        return null;
       }catch(Exception erro){
            throw new Exception("Id do Autor não encontrado!" + erro.getMessage());
       }
    }

    @Override
    public void alterarAutor(Autor autorAlterado) throws Exception {
        try{
        ArrayList<Autor> listaDeAutores = recuperar();
        FileWriter fw = new FileWriter(nomeDoArquivo);
        BufferedWriter br = new BufferedWriter(fw);

        for (int pos = 0; pos < listaDeAutores.size(); pos++) {
            Autor aux = listaDeAutores.get(pos);

            if (aux.getId() == autorAlterado.getId()) {
                br.write(autorAlterado.toString() + "\n");
            }  else {
                br.write(aux.toString() + "\n");
            }
        }
        br.close();
       }catch(Exception erro){
           JOptionPane.showMessageDialog(null, erro.getMessage());
       }
    }
    
    
}
