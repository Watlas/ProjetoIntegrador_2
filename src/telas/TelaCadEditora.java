package telas;

import classes.Editora;
import controle.EditoraControle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaCadEditora extends javax.swing.JFrame {

    EditoraControle editoraControl = null;
    Editora editora = null;
    Editora editoraAntiga = null;

    public TelaCadEditora() throws Exception {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        jTextFieldNomeEditora.setEnabled(false);
        jButtonIncluir.setEnabled(false);
        jButtonSalvarAlteracao.setEnabled(false);
        jButtonEditar.setEnabled(false);

        try {

            editoraControl = new EditoraControle("Editoras.txt");
            editora = new Editora();
            editoraAntiga = new Editora();
            imprimirDadosEditoraGrid(editoraControl.recuperar());

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no carregamento da grid de editoras\n" + erro);
        }
    }

    private void imprimirDadosEditoraGrid(ArrayList<Editora> lista) throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTableCadEditora.getModel();
        model.setNumRows(0);
        for (int pos = 0; pos < lista.size(); pos++) {
            String[] linha = new String[2];
            Editora aux = lista.get(pos);
            linha[0] = "" + aux.getId();
            linha[1] = aux.getDescricaoEditora().toUpperCase();
            model.addRow(linha);
        }
    }

    public void limpaCamposDeEntrada() {
        jTextFieldNomeEditora.setText("");
    }

    public void preencherCamposFormulario() {
        String posicaoId = jTableCadEditora.getValueAt(jTableCadEditora.getSelectedRow(), 0).toString();
        String posicaoNome = jTableCadEditora.getValueAt(jTableCadEditora.getSelectedRow(), 1).toString();
        jTextFieldNomeEditora.setText(posicaoNome);

        editoraAntiga.setId(Integer.parseInt(posicaoId));
        editoraAntiga.setDescricaoEditora(jTextFieldNomeEditora.getText());

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadEditoras = new javax.swing.JPanel();
        jTextFieldNomeEditora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadEditora = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonSalvarAlteracao = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonListagem = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonNovaEditora = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Controle De Biblioteca");
        setResizable(false);

        jTextFieldNomeEditora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNomeEditoraKeyReleased(evt);
            }
        });

        jLabel3.setText("Nome da Editora");

        jTableCadEditora.setAutoCreateRowSorter(true);
        jTableCadEditora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIÇÃO DA EDITORA"
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
        jTableCadEditora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadEditoraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadEditora);
        if (jTableCadEditora.getColumnModel().getColumnCount() > 0) {
            jTableCadEditora.getColumnModel().getColumn(0).setMinWidth(40);
            jTableCadEditora.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jLabel1.setText("CADASTRO DE EDITORAS");

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

        jButtonListagem.setText("LISTAGEM");
        jButtonListagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListagemActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("FECHAR");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonNovaEditora.setText("NOVO");
        jButtonNovaEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaEditoraActionPerformed(evt);
            }
        });

        jButtonEditar.setText("EDITAR");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadEditorasLayout = new javax.swing.GroupLayout(jPanelCadEditoras);
        jPanelCadEditoras.setLayout(jPanelCadEditorasLayout);
        jPanelCadEditorasLayout.setHorizontalGroup(
            jPanelCadEditorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadEditorasLayout.createSequentialGroup()
                .addGroup(jPanelCadEditorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addGroup(jPanelCadEditorasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelCadEditorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCadEditorasLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSalvarAlteracao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonListagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVoltar))
                            .addGroup(jPanelCadEditorasLayout.createSequentialGroup()
                                .addGroup(jPanelCadEditorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCadEditorasLayout.createSequentialGroup()
                                        .addGap(206, 206, 206)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadEditorasLayout.createSequentialGroup()
                                .addComponent(jTextFieldNomeEditora)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelCadEditorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonNovaEditora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonIncluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanelCadEditorasLayout.setVerticalGroup(
            jPanelCadEditorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadEditorasLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanelCadEditorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonNovaEditora, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadEditorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIncluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelCadEditorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarAlteracao)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonListagem)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonEditar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadEditoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadEditoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableCadEditoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadEditoraMouseClicked
        try {
            preencherCamposFormulario();
           jButtonEditar.setEnabled(true);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jTableCadEditoraMouseClicked

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {
             if (jTextFieldNomeEditora.getText().isEmpty()) {
                throw new Exception("O campo da descrição da editora deve ser preenchido");
            }

            editora.setDescricaoEditora(jTextFieldNomeEditora.getText());
            editoraControl.incluirEditora(editora);
            limpaCamposDeEntrada();
            imprimirDadosEditoraGrid(editoraControl.recuperar());
            jTextFieldNomeEditora.setEnabled(false);
            jButtonIncluir.setEnabled(false);
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            jTextFieldNomeEditora.setText("");
            jTextFieldNomeEditora.requestFocus();

        }

    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonSalvarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarAlteracaoActionPerformed
        try {
            if (jTextFieldNomeEditora.getText().isEmpty()) {
                throw new Exception("O campo da descrição da editora deve ser preenchido");
            }
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja alterar "
                    + editoraAntiga.getDescricaoEditora() + "?");
            // Este if verifica a minha opção de escolha dentro da caixa de diálogo do jPane
            if (opcao == 0) {

                editora = new Editora(editoraAntiga.getId(), jTextFieldNomeEditora.getText());
                editoraControl.alterarEditora(editora);
                imprimirDadosEditoraGrid(editoraControl.recuperar());
                jTextFieldNomeEditora.requestFocus();

            }
            limpaCamposDeEntrada();
            jTextFieldNomeEditora.setEnabled(false);
            jButtonEditar.setEnabled(false);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            jTextFieldNomeEditora.setText("");
            jTextFieldNomeEditora.requestFocus();

        }
    }//GEN-LAST:event_jButtonSalvarAlteracaoActionPerformed

    private void jButtonListagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListagemActionPerformed
        try {
            TelaListaEditora tela = new TelaListaEditora();
            tela.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(TelaCadEditora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonListagemActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        try {

            limpaCamposDeEntrada();
            jButtonIncluir.setEnabled(true);
            jTextFieldNomeEditora.requestFocus();

        } catch (Exception ex) {
            Logger.getLogger(TelaCadEditora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        try {
            
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(TelaCadEditora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTextFieldNomeEditoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeEditoraKeyReleased
    }//GEN-LAST:event_jTextFieldNomeEditoraKeyReleased

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
       jTextFieldNomeEditora.setEnabled(true);
       jTextFieldNomeEditora.requestFocus();
       jButtonSalvarAlteracao.setEnabled(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonNovaEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaEditoraActionPerformed
        jTextFieldNomeEditora.setEnabled(true);
        jTextFieldNomeEditora.requestFocus();
        jButtonIncluir.setEnabled(true);
        jTextFieldNomeEditora.setText("");
        jButtonEditar.setEnabled(false);
        jButtonSalvarAlteracao.setEnabled(false);
    }//GEN-LAST:event_jButtonNovaEditoraActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadEditora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadEditora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadEditora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadEditora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaCadEditora().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaCadEditora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonListagem;
    private javax.swing.JButton jButtonNovaEditora;
    private javax.swing.JButton jButtonSalvarAlteracao;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelCadEditoras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadEditora;
    private javax.swing.JTextField jTextFieldNomeEditora;
    // End of variables declaration//GEN-END:variables
}
