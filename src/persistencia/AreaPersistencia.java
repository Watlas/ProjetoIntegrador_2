/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.AreaDoLivro;
import interfaces.ICRUDareaDoLivro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import utilidades.GeradorIdentificador;

/**
 *
 * @author roger
 */
public class AreaPersistencia implements ICRUDareaDoLivro {

    private String nomeDoArquivo;

    public AreaPersistencia() throws Exception {

    }

    public AreaPersistencia(String nomeDoArquivo) throws Exception {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    @Override
    public void importarTabelaCdd(String nomeDoArquivo) throws Exception {

        try {
            GeradorIdentificador idArea = new GeradorIdentificador();
            
            FileReader arquivo = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(arquivo);
          
            FileWriter fw = new FileWriter("Areas.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            String linha = "";
            while ((linha = br.readLine()) != null) {
                String[] cdd = linha.split(";");
                AreaDoLivro objetoCDD = new AreaDoLivro();
                if (cdd.length != 2) {
                    throw new Exception("Faltam dados do arquivo CDD\n");
                }
                objetoCDD.setId(idArea.getID());
                objetoCDD.setCdd(cdd[0]);
                objetoCDD.setDescricaoDaArea(cdd[1]);
               
                bw.write(objetoCDD.toString() + "\n");
                
            }

            bw.close();
            br.close();
            idArea.finalize();

        } catch (Exception erro) {

            throw new Exception("Ocorreu um erro ao importar o arquivo CDD\n" + erro.getMessage());
        }
    }

    @Override

    public ArrayList<AreaDoLivro> recuperar() throws Exception {
        try {
            ArrayList<AreaDoLivro> listaArea = new ArrayList<AreaDoLivro>();
            FileReader fr = new FileReader("Areas.txt");
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            AreaDoLivro objetoArea = null;
            while ((linha = br.readLine()) != null) {
                objetoArea = new AreaDoLivro(linha);
                listaArea.add(objetoArea);
            }
            br.close();
            Collections.sort(listaArea);
            return listaArea;
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao recuperar o arquivo!" + erro.getMessage());

        }
    }

    @Override
    public AreaDoLivro buscarId(int id) throws Exception {
        try {
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                AreaDoLivro objetoArea = new AreaDoLivro(linha);
                if (objetoArea.getId() == id) {
                    br.close();
                    return objetoArea;
                }
            }
            br.close();
            return null;
        } catch (Exception erro) {
            throw new Exception("Id da Área não encontrado!" + erro.getMessage());

        }
    }

}
