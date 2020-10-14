/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import classes.Exemplar;
import interfaces.ICRUDexemplar;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import persistencia.ExemplarPersistencia;

/**
 *
 * @author roger
 */
public class ExemplarControle implements ICRUDexemplar {

    private ICRUDexemplar objeto = null;

    public ExemplarControle() {

    }

    public ExemplarControle(String nomeDoArquivo) throws Exception {
        this.objeto = new ExemplarPersistencia(nomeDoArquivo);
    }

    @Override
    public void incluir(Exemplar objeto) throws Exception {

        validaEntradaExemplar(objeto);

        this.objeto.incluir(objeto);
    }

    @Override
    public ArrayList<Exemplar> recuperar() throws Exception {
        try {
            return this.objeto.recuperar();
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao recuperar\n" + erro);
        }
    }

    @Override
    public void alterar(Exemplar exemplarAlterado) throws Exception {
        validaEntradaExemplar(exemplarAlterado);
        this.objeto.alterar(exemplarAlterado);
    }

    public void validaEntradaExemplar(Exemplar objeto) throws Exception {
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");

        if (objeto.getDataAquisicao().after(data)) {
            throw new Exception("A data de aquisição do exemplar é inválida.\n");
        }
        if (objeto.getPrecoExemplar() < 0) {
            throw new Exception("O valor informado do exemplar não pode ser menor que 0.\n");
        }

    }

}
