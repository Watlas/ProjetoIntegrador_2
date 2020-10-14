/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.Sugestao;
import interfaces.IcrudSugestao;
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
public class SugestaoPersistencia implements IcrudSugestao{
    
    private String nomeDoArquivo = null;
    
    public SugestaoPersistencia()throws Exception{
        
    }
    
    public SugestaoPersistencia (String nomeDoArquivo)throws Exception{
        this.nomeDoArquivo = nomeDoArquivo;
    }

    @Override
    public void incluir(Sugestao objeto) throws Exception {
        try {
            GeradorIdentificador idSugestao = new GeradorIdentificador();
            objeto.setId(idSugestao.getID());
            
            FileWriter fw = new FileWriter(nomeDoArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto.toString() + "\n");
            bw.close();
            idSugestao.finalize();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na inclusão deste objeto!\n" +  erro);
        
        }
    }

    @Override
    public ArrayList<Sugestao> recuperar() throws Exception {
        try {
            ArrayList<Sugestao> listaDeSugestoes = new ArrayList<Sugestao>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while((linha = br.readLine()) != null){
                Sugestao objetoSugestao = new Sugestao(linha);
                listaDeSugestoes.add(objetoSugestao);
            }
            br.close();
            Collections.sort(listaDeSugestoes);
            return listaDeSugestoes;
        } catch (Exception erro) {
            throw new Exception( "Ocorreu um erro ao recuperar dados das sugestões" + erro);
        }
    }

    @Override
    public void alterar(Sugestao objetoAlterado) throws Exception {
        try {
            FileWriter fw = new FileWriter(nomeDoArquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            ArrayList<Sugestao> listaDeSugestoes = recuperar();
            for (int pos = 0; pos < listaDeSugestoes.size(); pos++) {
                Sugestao aux = listaDeSugestoes.get(pos);
                if (objetoAlterado.getId() == aux.getId()) {
                    bw.write(objetoAlterado.toString() + "\n");
                }else {
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();
            
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro na alteração desta sugestão!\n" + erro);
        }
    }
    
}
