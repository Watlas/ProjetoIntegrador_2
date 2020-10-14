/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import classes.Login;
import classes.Sugestao;
import interfaces.I_Login;
import interfaces.IcrudSugestao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import persistencia.SugestaoPersistencia;

/**
 *
 * @author roger
 */
public class SugestaoControle implements IcrudSugestao{
    
    private IcrudSugestao objeto = null;
    
    public SugestaoControle()throws Exception{
        
    }
    
    public SugestaoControle (String nomeDoArquivo)throws Exception{
        this.objeto = new SugestaoPersistencia(nomeDoArquivo);
    }

    @Override
    public void incluir(Sugestao objeto) throws Exception {
        validaData(objeto);
        this.objeto.incluir(objeto);
    }

    @Override
    public ArrayList<Sugestao> recuperar() throws Exception {
        return this.objeto.recuperar();
    }

    @Override
    public void alterar(Sugestao objeto) throws Exception {
        validaData(objeto);
        this.objeto.alterar(objeto);
    }
    
    public void validaData(Sugestao objeto)throws Exception{
        Date data = new Date();
        
        if (objeto.getDataDaSugestao().after(data)) {
            throw new Exception("A data da sugestão é inválida!\n");
        }
        
    }

    

   
    
}
