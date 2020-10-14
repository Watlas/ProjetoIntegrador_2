package controle;

import classes.Editora;
import interfaces.ICRUDeditora;
import java.util.ArrayList;
import persistencia.EditoraPersistencia;

public class EditoraControle implements ICRUDeditora {

    private ICRUDeditora objeto = null;

    public EditoraControle() throws Exception {
    }

    public EditoraControle(String nomeDoArquivo) throws Exception {
        this.objeto = new EditoraPersistencia(nomeDoArquivo);
    }

    @Override
    public void incluirEditora(Editora objeto) throws Exception {
        ValidaDadosDescricao(objeto);
        this.objeto.incluirEditora(objeto);
    }

    @Override
    public ArrayList<Editora> recuperar() throws Exception {
        return this.objeto.recuperar();

    }

    @Override
    public void alterarEditora(Editora objetoNovo) throws Exception {
        ValidaDadosDescricao(objetoNovo);
        this.objeto.alterarEditora(objetoNovo);
    }

    public void ValidaDadosDescricao(Editora objeto) throws Exception {
        String descricao = objeto.getDescricaoEditora().trim().toLowerCase();
        String invalidos = "1234567890'\"!@#$%¨&*()-_+={[}]/?><;:";
        for (int i = 0; i < invalidos.length(); i++) {
            if (descricao.contains("" + invalidos.charAt(i))) {
                throw new Exception("Descrição de Editora inválida!");
            }
        }
        if (descricao.equals("")) {
            throw new Exception("Informe a descrição da editora do livro.");
        }
        ArrayList<Editora> listaEditora = recuperar();
        for (int pos = 0; pos < listaEditora.size(); pos++) {
            Editora aux = listaEditora.get(pos);
            if ((objeto.getId() != aux.getId()) && (objeto.getDescricaoEditora().toUpperCase().equalsIgnoreCase(aux.getDescricaoEditora().toUpperCase()))) {
                
                    throw new Exception("A editora -->  " + objeto.getDescricaoEditora() + "\nJá existe no cadastro!\n");
              
            }
            else if ((objeto.getId() == aux.getId()) && (objeto.getDescricaoEditora().toUpperCase().equalsIgnoreCase(aux.getDescricaoEditora().toUpperCase()))) {
                
                    throw new Exception("A editora -->  " + objeto.getDescricaoEditora() + "\nNão foi alterada!\n");
              
            }
        }
    }

    @Override
    public Editora buscarId(int id) throws Exception {
        return this.objeto.buscarId(id);
    }

}
