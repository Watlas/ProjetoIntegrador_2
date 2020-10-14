/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import ENUMERADORES.EnumTipoDeUsuario;
import ENUMERADORES.EnumTipoDeStatusUsuario;
import classes.Usuario;
import controle.UsuarioControle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roger
 */
public class TelaCadUsuarios extends javax.swing.JFrame {

    UsuarioControle controle = null;
    Usuario usuario = null;
    Usuario usuarioAntigo = null;

    /**
     * Creates new form TelaCadUsuarios
     */
    public TelaCadUsuarios() throws Exception {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        jFormattedTextFieldMatriculaCpf.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jFormattedTextFieldOAB.setEnabled(false);
        jComboBoxTipoDeUsuario.setEnabled(false);
        jComboBoxTipoDeStatus.setEnabled(false);
        jPasswordFieldAssinEletronica.setEnabled(false);
        jButtonIncluirUsuario.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonSalvarAlteração.setEnabled(false);

        try {

            controle = new UsuarioControle("Usuarios.txt");
            usuario = new Usuario();
            usuarioAntigo = new Usuario();
            jComboBoxTipoDeUsuario.removeAll();
            jComboBoxTipoDeStatus.removeAll();
            jButtonSalvarAlteração.setEnabled(false);

            for (Object tipo : EnumTipoDeUsuario.values()) {
                jComboBoxTipoDeUsuario.addItem(tipo.toString());
            }
            for (Object status : EnumTipoDeStatusUsuario.values()) {
                jComboBoxTipoDeStatus.addItem(status.toString());
            }
            imprimirDadosDoUsuarioNaTabela(controle.recuperar());

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na inicialização de algum componente\n"
                    + erro);
        }

    }

    public void habilitarCampos() {
        jFormattedTextFieldMatriculaCpf.setEnabled(true);
        jTextFieldNome.setEnabled(true);
        jTextFieldEmail.setEnabled(true);
        jFormattedTextFieldTelefone.setEnabled(true);
        jFormattedTextFieldOAB.setEnabled(true);
        jComboBoxTipoDeUsuario.setEnabled(true);
        jComboBoxTipoDeStatus.setEnabled(true);
        jPasswordFieldAssinEletronica.setEnabled(true);
    }

    public void desabilitaCampos() {
        jFormattedTextFieldMatriculaCpf.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jFormattedTextFieldOAB.setEnabled(false);
        jComboBoxTipoDeUsuario.setEnabled(false);
        jComboBoxTipoDeStatus.setEnabled(false);
        jPasswordFieldAssinEletronica.setEnabled(false);
    }

    private void imprimirDadosDoUsuarioNaTabela(ArrayList<Usuario> lista) throws Exception {

        DefaultTableModel model = (DefaultTableModel) jTableCadastroDeUsuario.getModel();
        model.setNumRows(0);
        for (int pos = 0; pos < lista.size(); pos++) {
            String[] linha = new String[8];
            Usuario aux = lista.get(pos);
            linha[0] = "" + aux.getId();
            linha[1] = aux.getMatriculaCpf();
            linha[2] = aux.getNome().toUpperCase();
            linha[3] = aux.getEmail();
            linha[4] = aux.getTelefone();
            linha[5] = "" + aux.getOab();
            linha[6] = aux.getTipoDeUsuario().toString();
            linha[7] = aux.getTipoDeStatus().toString();
            model.addRow(linha);
        }
    }

    public void preencherCamposFormulario() {

        int linha = jTableCadastroDeUsuario.getSelectedRow();

        if (linha >= 0) {

            String campoId = jTableCadastroDeUsuario.getValueAt(linha, 0).toString();
            String campoMatricula = jTableCadastroDeUsuario.getValueAt(linha, 1).toString();
            String campoNome = jTableCadastroDeUsuario.getValueAt(linha, 2).toString();
            String campoEmail = jTableCadastroDeUsuario.getValueAt(linha, 3).toString();
            String campoTelefone = jTableCadastroDeUsuario.getValueAt(linha, 4).toString();
            String campoOab = jTableCadastroDeUsuario.getValueAt(linha, 5).toString();
            String campoTipo = jTableCadastroDeUsuario.getValueAt(linha, 6).toString();
            String campoStatus = jTableCadastroDeUsuario.getValueAt(linha, 7).toString();

            jFormattedTextFieldMatriculaCpf.setText(campoMatricula);
            jTextFieldNome.setText(campoNome);
            jTextFieldEmail.setText(campoEmail);
            jFormattedTextFieldTelefone.setText(campoTelefone);
            jFormattedTextFieldOAB.setText(campoOab);
            jComboBoxTipoDeUsuario.setSelectedItem(campoTipo);
            jComboBoxTipoDeStatus.setSelectedItem(campoStatus);

            usuarioAntigo.setId(Integer.parseInt(campoId));
            usuarioAntigo.setNome(campoNome);
        }
    }

    public void limparCampos() {
        jFormattedTextFieldMatriculaCpf.setText("");
        jTextFieldNome.setText("");
        jTextFieldEmail.setText("");
        jFormattedTextFieldTelefone.setText("");
        jFormattedTextFieldOAB.setText("");
        jPasswordFieldAssinEletronica.setText("");
        jComboBoxTipoDeUsuario.setSelectedIndex(0);
        jComboBoxTipoDeStatus.setSelectedIndex(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonIncluirUsuario = new javax.swing.JButton();
        jButtonSalvarAlteração = new javax.swing.JButton();
        jButtonListagemUsuario = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadastroDeUsuario = new javax.swing.JTable();
        jButtonLimpar = new javax.swing.JButton();
        jComboBoxTipoDeUsuario = new javax.swing.JComboBox<>();
        jComboBoxTipoDeStatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPasswordFieldAssinEletronica = new javax.swing.JPasswordField();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jFormattedTextFieldOAB = new javax.swing.JFormattedTextField();
        jButtonEditar = new javax.swing.JButton();
        jButtonNovoUsuario = new javax.swing.JButton();
        jFormattedTextFieldMatriculaCpf = new javax.swing.JFormattedTextField();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA CONTROLE DE BIBLIOTECA");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(605, 520));

        jLabel1.setText("CADASTRO DE USUÁRIOS");

        jLabel2.setText("MATRÍCULA");

        jLabel3.setText("NOME");

        jLabel5.setText("E-MAIL");

        jLabel6.setText("TELEFONE");

        jButtonIncluirUsuario.setText("INCLUIR");
        jButtonIncluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirUsuarioActionPerformed(evt);
            }
        });

        jButtonSalvarAlteração.setText("SALVAR ALTERAÇÃO");
        jButtonSalvarAlteração.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarAlteraçãoActionPerformed(evt);
            }
        });

        jButtonListagemUsuario.setText("LISTAGEM");
        jButtonListagemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListagemUsuarioActionPerformed(evt);
            }
        });

        jButtonFechar.setText("FECHAR");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyReleased(evt);
            }
        });

        jTableCadastroDeUsuario.setAutoCreateRowSorter(true);
        jTableCadastroDeUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MATRÍC.", "NOME DO USUÁRIO", "EMAIL", "TELEFONE", "OAB", "Tipo Usuário", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadastroDeUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadastroDeUsuarioMouseClicked(evt);
            }
        });
        jTableCadastroDeUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCadastroDeUsuarioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadastroDeUsuario);
        if (jTableCadastroDeUsuario.getColumnModel().getColumnCount() > 0) {
            jTableCadastroDeUsuario.getColumnModel().getColumn(0).setMinWidth(40);
            jTableCadastroDeUsuario.getColumnModel().getColumn(0).setMaxWidth(40);
            jTableCadastroDeUsuario.getColumnModel().getColumn(1).setMinWidth(100);
            jTableCadastroDeUsuario.getColumnModel().getColumn(1).setMaxWidth(100);
            jTableCadastroDeUsuario.getColumnModel().getColumn(4).setMinWidth(100);
            jTableCadastroDeUsuario.getColumnModel().getColumn(4).setMaxWidth(100);
            jTableCadastroDeUsuario.getColumnModel().getColumn(5).setMinWidth(60);
            jTableCadastroDeUsuario.getColumnModel().getColumn(5).setMaxWidth(60);
            jTableCadastroDeUsuario.getColumnModel().getColumn(6).setMinWidth(0);
            jTableCadastroDeUsuario.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTableCadastroDeUsuario.getColumnModel().getColumn(6).setMaxWidth(0);
            jTableCadastroDeUsuario.getColumnModel().getColumn(7).setMinWidth(0);
            jTableCadastroDeUsuario.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTableCadastroDeUsuario.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jButtonLimpar.setText("LIMPAR");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jComboBoxTipoDeUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione o tipo de usuário>" }));
        jComboBoxTipoDeUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxTipoDeUsuarioMouseClicked(evt);
            }
        });
        jComboBoxTipoDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoDeUsuarioActionPerformed(evt);
            }
        });

        jComboBoxTipoDeStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione o tipo de status>" }));

        jLabel4.setText("OAB");

        jLabel7.setText("Assinatura Eletronica");

        jPasswordFieldAssinEletronica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldAssinEletronicaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldAssinEletronicaKeyTyped(evt);
            }
        });

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)-#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jFormattedTextFieldOAB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##-###"))));

        jButtonEditar.setText("EDITAR");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonNovoUsuario.setText("NOVO USUÁRIO");
        jButtonNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoUsuarioActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldMatriculaCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxTipoDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPasswordFieldAssinEletronica, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldOAB, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(23, 23, 23))
                                    .addComponent(jTextFieldEmail)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFormattedTextFieldMatriculaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(141, Short.MAX_VALUE)
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvarAlteração)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonListagemUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFechar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBoxTipoDeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNovoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonIncluirUsuario)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldMatriculaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldOAB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPasswordFieldAssinEletronica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxTipoDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNovoUsuario)
                        .addComponent(jButtonIncluirUsuario))
                    .addComponent(jComboBoxTipoDeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarAlteração)
                    .addComponent(jButtonListagemUsuario)
                    .addComponent(jButtonFechar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonEditar))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonIncluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirUsuarioActionPerformed

        if (jFormattedTextFieldMatriculaCpf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a matrícula do usuário\n");
            jFormattedTextFieldMatriculaCpf.requestFocus();
        } else if (jTextFieldNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome do usuário\n");
            jTextFieldNome.requestFocus();
        } else if (jTextFieldEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o email do usuário\n");
            jTextFieldEmail.requestFocus();
        } else if (jFormattedTextFieldTelefone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o telefone do usuário\n");
            jFormattedTextFieldTelefone.requestFocus();
        } else if (jPasswordFieldAssinEletronica.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma senha de 6 dígitos numéricos\n");
            jPasswordFieldAssinEletronica.requestFocus();
        } else if ((jComboBoxTipoDeUsuario.getSelectedItem().equals(EnumTipoDeUsuario.ADVOGADO.toString())
                && (jFormattedTextFieldOAB.getText().isEmpty()))) {
            JOptionPane.showMessageDialog(null, "Para o tipo de usuário selecionado, o campo da OAB é obrigatório\n");
            jFormattedTextFieldOAB.requestFocus();
        } else if ((!jComboBoxTipoDeUsuario.getSelectedItem().equals(EnumTipoDeUsuario.ADVOGADO.toString()))
                && jFormattedTextFieldOAB.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Para o tipo de usuário selecionado, caso não tenha a matrícula na OAB"
                    + " o preenchimento pode ser 0!\n");
            jFormattedTextFieldOAB.requestFocus();
        } else {

            try {

                usuario = new Usuario(jFormattedTextFieldMatriculaCpf.getText().replace(".", "").replace("-", ""), jTextFieldNome.getText(),
                        jTextFieldEmail.getText(), jFormattedTextFieldTelefone.getText(),
                        EnumTipoDeUsuario.valueOf(jComboBoxTipoDeUsuario.getSelectedItem().toString()),
                        EnumTipoDeStatusUsuario.valueOf(jComboBoxTipoDeStatus.getSelectedItem().toString()),
                        Integer.parseInt(jFormattedTextFieldOAB.getText()), jPasswordFieldAssinEletronica.getText());

                controle.incluir(usuario);
                limparCampos();
                imprimirDadosDoUsuarioNaTabela(controle.recuperar());
                desabilitaCampos();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonIncluirUsuarioActionPerformed

    private void jButtonListagemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListagemUsuarioActionPerformed
        try {
            TelaListaDeUsuarios tela = new TelaListaDeUsuarios();
            tela.setVisible(true);
            this.dispose();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao listar os usuarios\n" + erro);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonListagemUsuarioActionPerformed

    private void jTableCadastroDeUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroDeUsuarioMouseClicked
        preencherCamposFormulario();
        jButtonEditar.setEnabled(true);
    }//GEN-LAST:event_jTableCadastroDeUsuarioMouseClicked

    private void jButtonSalvarAlteraçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarAlteraçãoActionPerformed

        if (jFormattedTextFieldMatriculaCpf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a matrícula do usuário");
            jFormattedTextFieldMatriculaCpf.requestFocus();
        } else if (jTextFieldNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome do usuário");
            jTextFieldNome.requestFocus();
        } else if (jTextFieldEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o email do usuário");
            jTextFieldEmail.requestFocus();
        } else if (jFormattedTextFieldTelefone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o telefone do usuário");
            jFormattedTextFieldTelefone.requestFocus();
        } else if (jPasswordFieldAssinEletronica.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma senha de 6 dígitos numéricos");
            jPasswordFieldAssinEletronica.requestFocus();
        } else if ((jComboBoxTipoDeUsuario.getSelectedItem().equals(EnumTipoDeUsuario.ADVOGADO.toString())
                && (jFormattedTextFieldOAB.getText().isEmpty()))) {
            JOptionPane.showMessageDialog(null, "Para o tipo de usuário selecionado, o campo da OAB é obrigatório\n");
            jFormattedTextFieldOAB.requestFocus();

        } else if ((!jComboBoxTipoDeUsuario.getSelectedItem().equals(EnumTipoDeUsuario.ADVOGADO.toString()))
                && jFormattedTextFieldOAB.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Para o tipo de usuário selecionado, caso não tenha a matrícula na OAB"
                    + " o preenchimento pode ser 0!\n");
            jFormattedTextFieldOAB.requestFocus();
        } else {

            try {

                int opcao = JOptionPane.showConfirmDialog(null, "Deseja alterar "
                        + usuarioAntigo.getNome() + "?");
                // Este if verifica a minha opção de escolha dentro da caixa de diálogo do jPane
                if (opcao == 0) {

                    usuario = new Usuario(jFormattedTextFieldMatriculaCpf.getText().replace(".", "").replace("-", ""), jTextFieldNome.getText(),
                            jTextFieldEmail.getText(), jFormattedTextFieldTelefone.getText(),
                            EnumTipoDeUsuario.valueOf(jComboBoxTipoDeUsuario.getSelectedItem().toString()),
                            EnumTipoDeStatusUsuario.valueOf(jComboBoxTipoDeStatus.getSelectedItem().toString()),
                            Integer.parseInt(jFormattedTextFieldOAB.getText()), jPasswordFieldAssinEletronica.getText());
                    usuario.setId(usuarioAntigo.getId());
                    controle.alterar(usuario);

                }
                jButtonEditar.setEnabled(false);
                jButtonSalvarAlteração.setEnabled(false);
                jButtonIncluirUsuario.setEnabled(false);
                desabilitaCampos();
                imprimirDadosDoUsuarioNaTabela(controle.recuperar());

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar " + usuarioAntigo.getNome() + "\n" + erro);
            }
            limparCampos();

        }

    }//GEN-LAST:event_jButtonSalvarAlteraçãoActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparCampos();
        desabilitaCampos();
        jFormattedTextFieldOAB.setText("");


    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jComboBoxTipoDeUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxTipoDeUsuarioMouseClicked

    }//GEN-LAST:event_jComboBoxTipoDeUsuarioMouseClicked

    private void jTableCadastroDeUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCadastroDeUsuarioKeyReleased
        preencherCamposFormulario();
    }//GEN-LAST:event_jTableCadastroDeUsuarioKeyReleased

    private void jPasswordFieldAssinEletronicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldAssinEletronicaKeyTyped

    }//GEN-LAST:event_jPasswordFieldAssinEletronicaKeyTyped

    private void jPasswordFieldAssinEletronicaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldAssinEletronicaKeyReleased
        jPasswordFieldAssinEletronica.setText(jPasswordFieldAssinEletronica.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_jPasswordFieldAssinEletronicaKeyReleased

    private void jTextFieldNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyReleased
        jTextFieldNome.setText(jTextFieldNome.getText().replaceAll("[^a-z|^A-Z|^ |^é|^ê|^ã|^â|^ó|^õ|^ô|^ç|^á]", ""));
    }//GEN-LAST:event_jTextFieldNomeKeyReleased

    private void jComboBoxTipoDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoDeUsuarioActionPerformed
        if (jComboBoxTipoDeUsuario.getSelectedIndex() == 0) {
            jFormattedTextFieldOAB.setText("");
        } else if (jComboBoxTipoDeUsuario.getSelectedIndex() == 1) {
            if ((jFormattedTextFieldOAB.getText().isEmpty()) || (jFormattedTextFieldOAB.getText().equals("0"))) {
                JOptionPane.showMessageDialog(null, "Para o tipo de usuário selecionado, o campo da OAB é obrigatório\n");
                jFormattedTextFieldOAB.requestFocus();
            }

        } else {
            jFormattedTextFieldOAB.setText("0");
        }
    }//GEN-LAST:event_jComboBoxTipoDeUsuarioActionPerformed

    private void jButtonNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoUsuarioActionPerformed
        habilitarCampos();
        jFormattedTextFieldMatriculaCpf.requestFocus();
        jButtonIncluirUsuario.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonSalvarAlteração.setEnabled(false);
        limparCampos();
    }//GEN-LAST:event_jButtonNovoUsuarioActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        habilitarCampos();
        jFormattedTextFieldMatriculaCpf.requestFocus();
        jButtonSalvarAlteração.setEnabled(true);
        jButtonIncluirUsuario.setEnabled(false);
    }//GEN-LAST:event_jButtonEditarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaCadUsuarios().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaCadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonIncluirUsuario;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonListagemUsuario;
    private javax.swing.JButton jButtonNovoUsuario;
    private javax.swing.JButton jButtonSalvarAlteração;
    private javax.swing.JComboBox<String> jComboBoxTipoDeStatus;
    private javax.swing.JComboBox<String> jComboBoxTipoDeUsuario;
    private javax.swing.JFormattedTextField jFormattedTextFieldMatriculaCpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldOAB;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldAssinEletronica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadastroDeUsuario;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
