
package utilidades;
import javax.swing.JOptionPane;

public class ProjetoID {
   
    public static void main(String[] args) {
        try {
            GeradorIdentificador objetoId = new GeradorIdentificador();
            System.out.println("ID: " + objetoId.getID());
            //System.out.println("ID: " + objetoId.getID());
            //System.out.println("ID: " + objetoId.getID());
            objetoId.finalize();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }
    
}
