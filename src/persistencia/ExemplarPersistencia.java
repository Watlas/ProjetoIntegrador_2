/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.Exemplar;
import interfaces.ICRUDexemplar;
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
public class ExemplarPersistencia implements ICRUDexemplar {

    private String nomeDoArquivo = null;

    public ExemplarPersistencia() throws Exception {

    }

    public ExemplarPersistencia(String nomeDoArquivo) throws Exception {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    @Override
    public void incluir(Exemplar objeto) throws Exception {
        try {
            GeradorIdentificador idExemplar = new GeradorIdentificador();
            objeto.setId(idExemplar.getID());

            FileWriter fw = new FileWriter(nomeDoArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto.toString() + "\n");
            bw.close();
            idExemplar.finalize();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao incluir esse exemplar\n" + erro);
        }
    }

    @Override
    public ArrayList<Exemplar> recuperar() throws Exception {
        try {
            ArrayList<Exemplar> listaExemplar = new ArrayList<Exemplar>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Exemplar objetoExemplar = new Exemplar(linha);
                listaExemplar.add(objetoExemplar);
            }
            br.close();
            Collections.sort(listaExemplar);
            return listaExemplar;

        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao recuperar este arquivo --> Exemplar.txt\n" + erro);
        }
    }

    @Override
    public void alterar(Exemplar exemplarAlterado) throws Exception {
        try {
            ArrayList<Exemplar> listaExemplar = recuperar();
            FileWriter fw = new FileWriter(nomeDoArquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaExemplar.size(); pos++) {
                Exemplar aux = listaExemplar.get(pos);
                if (exemplarAlterado.getId() == aux.getId()) {
                    bw.write(exemplarAlterado.toString() + "\n");
                } else {
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();

        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro na alteração deste exemplar\n" + erro);
        }

    }

}
