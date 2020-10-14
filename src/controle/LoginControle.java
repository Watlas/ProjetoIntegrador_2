/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import ENUMERADORES.EnumTipoDeStatusUsuario;
import ENUMERADORES.EnumTipoDeUsuario;
import classes.Login;
import classes.Usuario;
import interfaces.I_Login;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author roger
 */
public class LoginControle implements interfaces.I_Login{

    UsuarioControle controle = null;

    private I_Login objeto = null;

    public LoginControle() throws Exception {

    }   

    public boolean validaLogin(Login objeto) throws Exception {
        controle = new UsuarioControle("Usuarios.txt");

        ArrayList<Usuario> listaDeUsuarios = controle.recuperar();
        for (int pos = 0; pos < listaDeUsuarios.size(); pos++) {
            Usuario aux = listaDeUsuarios.get(pos);
            if (objeto.getEmail().equalsIgnoreCase(aux.getEmail())
                    && (objeto.getSenha().equalsIgnoreCase(aux.getAssinaturaEletronica()))) {
                if (aux.getTipoDeStatus().equals(EnumTipoDeStatusUsuario.ATIVO)
                        &&(aux.getTipoDeUsuario().equals(EnumTipoDeUsuario.ADMINISTRADOR))) {
                    return true;
                } else {
                    throw new Exception("O usuário não está ativo no sistema ou não é um administrador!\nProcure um administrador.\n");
                }
            }
        }
        return false;
    }
}
