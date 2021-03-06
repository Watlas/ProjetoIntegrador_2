/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.Usuario;
import interfaces.IcrudUsuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import utilidades.GeradorIdentificador;

/**
 *
 * @author roger
 */
public class UsuarioPersistencia implements IcrudUsuario {

    private String nomeDoArquivo = null;

    public UsuarioPersistencia() throws Exception {

    }

    public UsuarioPersistencia(String nomeDoArquivo) throws Exception {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    @Override
    public void incluir(Usuario objeto) throws Exception {
        try {
            GeradorIdentificador idUsuario = new GeradorIdentificador();
            objeto.setId(idUsuario.getID());

            FileWriter arquivo = new FileWriter(nomeDoArquivo, true);
            BufferedWriter gravacao = new BufferedWriter(arquivo);
            gravacao.write(objeto.toString() + "\n");
            gravacao.close();
            idUsuario.finalize();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na inclusão deste usuário\n" + erro);
        }
    }

    @Override
    public ArrayList<Usuario> recuperar() throws Exception {
        try {
            ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
            FileReader arquivo = new FileReader(nomeDoArquivo);
            BufferedReader leitura = new BufferedReader(arquivo);
            String linha = "";
            while ((linha = leitura.readLine()) != null) {
                Usuario objetoUsuario = new Usuario(linha);
                listaUsuario.add(objetoUsuario);
            }
            leitura.close();
            Collections.sort(listaUsuario);
            return listaUsuario;
        } catch (Exception erro) {
            throw new Exception( "Ocorreu um erro ao recuperar os dados do usuário no arquivo\n" + erro);
        }
    }

    @Override
    public void alterar(Usuario usuarioAlterado) throws Exception {
        try {
            ArrayList<Usuario> listaUsuario = recuperar();
            FileWriter fw = new FileWriter(nomeDoArquivo);
            BufferedWriter bw= new BufferedWriter(fw);
            
            for (int pos = 0; pos < listaUsuario.size(); pos++) {
                Usuario aux = listaUsuario.get(pos);
                if(usuarioAlterado.getId() == aux.getId()){
                    bw.write(usuarioAlterado.toString() + "\n");
                }else{
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();
            
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao alterar " + usuarioAlterado.getNome() + "\n" + erro);
            
        
        }
    }
    @Override
    public Usuario buscarPeloId(int id) throws Exception {
       try{
           
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";        
        while ((linha = br.readLine()) != null) {           
            Usuario objetoUsuario = new Usuario(linha);
            if (objetoUsuario.getId() == id) {
                br.close();
                return objetoUsuario;
            }            
        }
        br.close();        
         
        return null;
       }catch(Exception erro){
            throw new Exception("Id do usuário não encontrado!" + erro.getMessage());
       }
    }

}
