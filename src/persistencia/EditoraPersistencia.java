package persistencia;

import classes.Editora;
import interfaces.ICRUDeditora;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import utilidades.GeradorIdentificador;

public class EditoraPersistencia implements ICRUDeditora {

    private String nomeDoArquivo;

    public EditoraPersistencia() throws Exception {

    }

    public EditoraPersistencia(String nomeDoArquivo) throws Exception {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    @Override
    public void incluirEditora(Editora objeto) throws Exception {
        try {
            GeradorIdentificador idEditora = new GeradorIdentificador();
            objeto.setId(idEditora.getID());

            FileWriter fw = new FileWriter(nomeDoArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto.toString() + "\n");
            bw.close();
            idEditora.finalize();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao gravar" + erro.getMessage());
        }
    }
    
     @Override
    public ArrayList<Editora> recuperar() throws Exception {
        try {
            ArrayList<Editora> listaEditora = new ArrayList<Editora>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Editora objetoEditora = new Editora(linha);
                listaEditora.add(objetoEditora);
            }
            br.close();
            Collections.sort(listaEditora);
            return listaEditora;

        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao recuperar este arquivo --> Editora.txt\n" + erro);

        }

    }
    
    @Override
    public void alterarEditora(Editora objetoNovo) throws Exception {
        try {
            ArrayList<Editora> listaEditora = recuperar();

            FileWriter fw = new FileWriter(nomeDoArquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaEditora.size(); pos++) {
                Editora aux = listaEditora.get(pos);

                if (aux.getId() == objetoNovo.getId()) {
                    bw.write(objetoNovo.toString() + "\n");
                } else {
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na alteração!" + erro.getMessage());
        }
    }

    public Editora buscarId(int id) throws Exception {

        try {
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Editora objetoEditora = new Editora(linha);
                if (objetoEditora.getId() == id) {
                    br.close();
                    return objetoEditora;
                }
            }
            br.close();
            return null;

        } catch (Exception ex) {
            throw new Exception("Id da Editora não encontrado");
        }
    }

    
}
