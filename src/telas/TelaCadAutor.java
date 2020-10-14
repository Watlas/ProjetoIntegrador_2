package telas;

import classes.Autor;
import controle.AutorControle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaCadAutor extends javax.swing.JFrame {

    AutorControle autorControle;
    Autor autorAntigo = null;
    Autor autorNovo = null;

    public TelaCadAutor() {
        try {
            initComponents();
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            
            jTextFieldNomeAutor.setEnabled(false);
            jButtonIncluir.setEnabled(false);
            jButtonSalvarAlteracao.setEnabled(false);
            jButtonEditar.setEnabled(false);
            

            autorControle = new AutorControle("Autores.txt");
            autorAntigo = new Autor();
            autorNovo = new Autor();
            
            imprimirDadosAutorNaGrid(autorControle.recuperar());
        } catch (Exception ex) {
            Logger.getLogger(TelaCadAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void imprimirDadosAutorNaGrid(ArrayList<Autor> listaAutores) throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTableCadAutor.getModel();
        model.setNumRows(0);
        for (int pos = 0; pos < listaAutores.size(); pos++) {
            String[] linha = new String[2];
            Autor aux = listaAutores.get(pos);
            linha[0] = "" + aux.getId();
            linha[1] = aux.getNomeAutor().toUpperCase();
            model.addRow(linha);

        }

    }

    public void limpaCamposDeEntrada() {
        jTextFieldNomeAutor.setText("");
    }

    public void preencherCamposFormulario() {


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAutor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadAutor = new javax.swing.JTable();
        jTextFieldNomeAutor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonSalvarAlteracao = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonListaDeAutores = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jButtonNovoAutor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA CONTROLE BIBLIOTECA");
        setResizable(false);

        jTableCadAutor.setAutoCreateRowSorter(true);
        jTableCadAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME DO AUTOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadAutorMouseClicked(evt);
            }
        });
        jTableCadAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCadAutorKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadAutor);
        if (jTableCadAutor.getColumnModel().getColumnCount() > 0) {
            jTableCadAutor.getColumnModel().getColumn(0).setMinWidth(40);
            jTableCadAutor.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jTextFieldNomeAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNomeAutorKeyReleased(evt);
            }
        });

        jLabel3.setText("Nome do Autor");

        jButtonIncluir.setText("INCLUIR");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonSalvarAlteracao.setText("SALVAR ALTERAÇÃO");
        jButtonSalvarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarAlteracaoActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("LIMPAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonListaDeAutores.setText("LISTAGEM");
        jButtonListaDeAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaDeAutoresActionPerformed(evt);
            }
        });

        jButtonFechar.setText("FECHAR");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jLabel1.setText("CADASTRO DE AUTORES");

        jButtonEditar.setText("EDITAR");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonNovoAutor.setText("NOVO");
        jButtonNovoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAutorLayout = new javax.swing.GroupLayout(jPanelAutor);
        jPanelAutor.setLayout(jPanelAutorLayout);
        jPanelAutorLayout.setHorizontalGroup(
            jPanelAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAutorLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                    .addGroup(jPanelAutorLayout.createSequentialGroup()
                        .addComponent(jTextFieldNomeAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonIncluir))
                    .addGroup(jPanelAutorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvarAlteracao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonListaDeAutores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonFechar))
                    .addGroup(jPanelAutorLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNovoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelAutorLayout.setVerticalGroup(
            jPanelAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAutorLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanelAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonNovoAutor, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIncluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarAlteracao)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonListaDeAutores)
                    .addComponent(jButtonFechar)
                    .addComponent(jButtonEditar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableCadAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadAutorMouseClicked
        try {

                   int indiceDaLinha = jTableCadAutor.getSelectedRow();
        String campoId = jTableCadAutor.getValueAt(indiceDaLinha, 0).toString();
        String campoNome = jTableCadAutor.getValueAt(indiceDaLinha, 1).toString();

        jTextFieldNomeAutor.setText(campoNome);
     
        autorAntigo.setId(Integer.parseInt(campoId));
        autorAntigo.setNomeAutor(jTextFieldNomeAutor.getText());
         

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jTableCadAutorMouseClicked

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        try {
            limpaCamposDeEntrada();
            jButtonIncluir.setEnabled(true);
            jTextFieldNomeAutor.requestFocus();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        try {
            
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(TelaCadAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {
            if (jTextFieldNomeAutor.getText().isEmpty()) {
                throw new Exception("O campo --> nome do autor deve ser preenchido");
            }
            autorNovo.setNomeAutor(jTextFieldNomeAutor.getText());
            autorControle.incluirAutor(autorNovo);
            limpaCamposDeEntrada();
            imprimirDadosAutorNaGrid(autorControle.recuperar());
            jTextFieldNomeAutor.setEnabled(false);
            jButtonIncluir.setEnabled(false);
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            jTextFieldNomeAutor.setText("");
            jTextFieldNomeAutor.requestFocus();
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonSalvarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarAlteracaoActionPerformed
        try {
        
                 
                autorNovo = new Autor(autorAntigo.getId(), jTextFieldNomeAutor.getText());
                autorControle.alterarAutor(autorNovo);
                imprimirDadosAutorNaGrid(autorControle.recuperar());
                jTextFieldNomeAutor.requestFocus();

          
            limpaCamposDeEntrada();
            jTextFieldNomeAutor.setEnabled(false);
            jButtonEditar.setEnabled(false);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            jTextFieldNomeAutor.setText("");
            jTextFieldNomeAutor.requestFocus();

        }
    }//GEN-LAST:event_jButtonSalvarAlteracaoActionPerformed

    private void jButtonListaDeAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaDeAutoresActionPerformed
        TelaListaDeAutores tela = new TelaListaDeAutores();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonListaDeAutoresActionPerformed

    private void jTableCadAutorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCadAutorKeyReleased
        preencherCamposFormulario();
    }//GEN-LAST:event_jTableCadAutorKeyReleased

    private void jTextFieldNomeAutorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeAutorKeyReleased
        jTextFieldNomeAutor.setText(jTextFieldNomeAutor.getText().replaceAll("[^a-z|^A-Z|^ |^é|^ê|^ã|^â|^ó|^õ|^ô]", ""));
    }//GEN-LAST:event_jTextFieldNomeAutorKeyReleased

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
       
        jTextFieldNomeAutor.setEnabled(true);
        jTextFieldNomeAutor.requestFocus();
        jButtonSalvarAlteracao.setEnabled(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonNovoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoAutorActionPerformed
        jTextFieldNomeAutor.setEnabled(true);
        jButtonIncluir.setEnabled(true);
        jTextFieldNomeAutor.setText("");
        jTextFieldNomeAutor.requestFocus();
        jButtonEditar.setEnabled(false);
        jButtonSalvarAlteracao.setEnabled(false);
    }//GEN-LAST:event_jButtonNovoAutorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonListaDeAutores;
    private javax.swing.JButton jButtonNovoAutor;
    private javax.swing.JButton jButtonSalvarAlteracao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelAutor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadAutor;
    private javax.swing.JTextField jTextFieldNomeAutor;
    // End of variables declaration//GEN-END:variables
}
