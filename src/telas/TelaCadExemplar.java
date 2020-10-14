/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import ENUMERADORES.EnumDisponibilidadeExemplar;
import ENUMERADORES.EnumSituacaoExemplar;
import classes.Exemplar;
import classes.Livro;
import controle.ExemplarControle;
import controle.LivroControle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roger
 */
public class TelaCadExemplar extends javax.swing.JFrame {

    ExemplarControle controleExemplar = null;
    Exemplar exemplar = null;
    Exemplar exemplarAnterior = null;
    LivroControle controleLivro = null;
    Date data = null;
    SimpleDateFormat formatar = null;
    String dataAtual = null;

    /**
     * Creates new form TelaCadExemplar
     */
    public TelaCadExemplar() throws Exception {
        initComponents();
            data = new Date();
            formatar = new SimpleDateFormat("dd/MM/yyyy");
            dataAtual = formatar.format(data);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        desabilitaCampos();
        jButtonIncluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonSalvarAlteraracao.setEnabled(false);
        
        
        jButtonSalvarAlteraracao.setEnabled(false);

        try {
           
            controleExemplar = new ExemplarControle("Exemplar.txt");
            exemplarAnterior = new Exemplar();

            controleLivro = new LivroControle("livro.txt");

            ArrayList<Livro> listaDeLivros = controleLivro.recuperar();
            for (int pos = 0; pos < listaDeLivros.size(); pos++) {
                Livro aux = listaDeLivros.get(pos);
                jComboBoxLivros.addItem(aux.getId() + "-" + aux.getTituloLivro().toUpperCase());
            }

            for (EnumSituacaoExemplar situacao : EnumSituacaoExemplar.values()) {
                jComboBoxSituacao.addItem(situacao.toString());
            }

            for (EnumDisponibilidadeExemplar disponibilidade : EnumDisponibilidadeExemplar.values()) {
                jComboBoxDisponibilidade.addItem(disponibilidade.toString());
            }
            imprimirDadosDoExemplarNaTabela(controleExemplar.recuperar());

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na inicialização de algum componente\n" + erro);
        }
    }
    
    public void habilitaCampos(){
        jFormattedTextFieldDataAquisicao.setEnabled(true);
        jFormattedTextFieldPrecoExemplar.setEnabled(true);
        jComboBoxSituacao.setEnabled(true);
        jComboBoxLivros.setEnabled(true);
        jComboBoxDisponibilidade.setEnabled(true);
        jTextFieldMotivoInativacao.setEnabled(true);
        
    }
    
    public void desabilitaCampos(){
    jFormattedTextFieldDataAquisicao.setEnabled(false);
        jFormattedTextFieldPrecoExemplar.setEnabled(false);
        jComboBoxSituacao.setEnabled(false);
        jComboBoxLivros.setEnabled(false);
        jComboBoxDisponibilidade.setEnabled(false);
        jTextFieldMotivoInativacao.setEnabled(false);    
    }

    private void imprimirDadosDoExemplarNaTabela(ArrayList<Exemplar> lista) throws Exception {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableCadExemplares.getModel();
            model.setNumRows(0);
            for (int pos = 0; pos < lista.size(); pos++) {
                String[] linha = new String[7];
                Exemplar aux = lista.get(pos);
                linha[0] = "" + aux.getId();
                linha[1] = aux.getLivro().getId() + "-" + aux.getLivro().getTituloLivro().toUpperCase();
                linha[2] = "" + new SimpleDateFormat("dd/MM/yyyy").format(aux.getDataAquisicao());
                linha[3] = String.format("%.2f", aux.getPrecoExemplar());
                linha[4] = aux.getSituacao().toString();
                linha[5] = aux.getDisponibilidade().toString();
                linha[6] = aux.getMotivoInativacao().toUpperCase();
                model.addRow(linha);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao imprimir dados do exemplar na tabela\n" + erro);
        }
    }

    public void limpaCampos() {
        jFormattedTextFieldDataAquisicao.setText("");
        jFormattedTextFieldPrecoExemplar.setText("");
        jTextFieldMotivoInativacao.setText("");
        jComboBoxLivros.setSelectedIndex(0);
        jComboBoxSituacao.setSelectedIndex(0);
        jComboBoxDisponibilidade.setSelectedIndex(0);

    }

    public void preencherFormulario() {
        try {
            int linha = jTableCadExemplares.getSelectedRow();

            if (linha >= 0) {
                String campoID = jTableCadExemplares.getValueAt(linha, 0).toString();
                String campoLivro = jTableCadExemplares.getValueAt(linha, 1).toString();
                String campoData = jTableCadExemplares.getValueAt(linha, 2).toString();
                String campoPreco = jTableCadExemplares.getValueAt(linha, 3).toString();
                String campoSituacao = jTableCadExemplares.getValueAt(linha, 4).toString();
                String campoDisponibilidade = jTableCadExemplares.getValueAt(linha, 5).toString();
                String campoMotivo = jTableCadExemplares.getValueAt(linha, 6).toString();

                exemplarAnterior.setId(Integer.parseInt(campoID));

                jComboBoxLivros.setSelectedItem(campoLivro);
                jFormattedTextFieldDataAquisicao.setText(campoData);
                jFormattedTextFieldPrecoExemplar.setText(campoPreco);
                jComboBoxSituacao.setSelectedItem(campoSituacao);
                jComboBoxDisponibilidade.setSelectedItem(campoDisponibilidade);
                jTextFieldMotivoInativacao.setText(campoMotivo);

            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao preencher os campos de cadastro\n" + erro);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadExemplar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextFieldDataAquisicao = new javax.swing.JFormattedTextField();
        jComboBoxLivros = new javax.swing.JComboBox<>();
        jComboBoxSituacao = new javax.swing.JComboBox<>();
        jComboBoxDisponibilidade = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCadExemplares = new javax.swing.JTable();
        jButtonFechar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonListagem = new javax.swing.JButton();
        jButtonSalvarAlteraracao = new javax.swing.JButton();
        jButtonIncluir = new javax.swing.JButton();
        jTextFieldMotivoInativacao = new javax.swing.JTextField();
        jFormattedTextFieldPrecoExemplar = new javax.swing.JFormattedTextField();
        jButtonEditar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Controle de Biblioteca");
        setResizable(false);

        jLabel1.setText("Cadastro de Exemplares");

        jLabel2.setText("Data da Aquisição:");

        jLabel3.setText("Preço  R$");

        jLabel4.setText("Livro Correspondente:");

        jLabel5.setText("Situação deste Exemplar:");

        jLabel6.setText("Disponibilidade deste Exemplar:");

        jLabel7.setText("Motivo da Desativação/Estado Físico do livro:");

        try {
            jFormattedTextFieldDataAquisicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jComboBoxLivros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione o Livro>" }));

        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione a Situação do Exemplar>" }));
        jComboBoxSituacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxSituacaoMouseClicked(evt);
            }
        });
        jComboBoxSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSituacaoActionPerformed(evt);
            }
        });

        jComboBoxDisponibilidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione a Disponibilidade do Exemplar>" }));

        jTableCadExemplares.setAutoCreateRowSorter(true);
        jTableCadExemplares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Exem.", "Livro", "Dt. Aquisição", "Preço  R$", "Situação", "Disponibilidade", "Motivo de Inativação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadExemplares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadExemplaresMouseClicked(evt);
            }
        });
        jTableCadExemplares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCadExemplaresKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCadExemplares);
        if (jTableCadExemplares.getColumnModel().getColumnCount() > 0) {
            jTableCadExemplares.getColumnModel().getColumn(0).setMinWidth(50);
            jTableCadExemplares.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableCadExemplares.getColumnModel().getColumn(1).setMinWidth(200);
            jTableCadExemplares.getColumnModel().getColumn(1).setMaxWidth(200);
            jTableCadExemplares.getColumnModel().getColumn(2).setMinWidth(80);
            jTableCadExemplares.getColumnModel().getColumn(2).setMaxWidth(80);
            jTableCadExemplares.getColumnModel().getColumn(3).setMinWidth(60);
            jTableCadExemplares.getColumnModel().getColumn(3).setMaxWidth(60);
            jTableCadExemplares.getColumnModel().getColumn(4).setMinWidth(70);
            jTableCadExemplares.getColumnModel().getColumn(4).setMaxWidth(70);
            jTableCadExemplares.getColumnModel().getColumn(5).setMinWidth(100);
            jTableCadExemplares.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonListagem.setText("Listagem");
        jButtonListagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListagemActionPerformed(evt);
            }
        });

        jButtonSalvarAlteraracao.setText("Salvar Alteração");
        jButtonSalvarAlteraracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarAlteraracaoActionPerformed(evt);
            }
        });

        jButtonIncluir.setText("Incluir");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jFormattedTextFieldPrecoExemplar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0,00"))));

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadExemplarLayout = new javax.swing.GroupLayout(jPanelCadExemplar);
        jPanelCadExemplar.setLayout(jPanelCadExemplarLayout);
        jPanelCadExemplarLayout.setHorizontalGroup(
            jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadExemplarLayout.createSequentialGroup()
                .addGroup(jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadExemplarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvarAlteraracao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonListagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFechar))
                    .addGroup(jPanelCadExemplarLayout.createSequentialGroup()
                        .addGroup(jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCadExemplarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelCadExemplarLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldPrecoExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addGap(33, 33, 33)
                                .addGroup(jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanelCadExemplarLayout.createSequentialGroup()
                                .addGap(322, 322, 322)
                                .addComponent(jLabel1)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadExemplarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(180, 180, 180))
            .addGroup(jPanelCadExemplarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldMotivoInativacao, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCadExemplarLayout.setVerticalGroup(
            jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadExemplarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCadExemplarLayout.createSequentialGroup()
                        .addGroup(jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelCadExemplarLayout.createSequentialGroup()
                                .addGroup(jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jFormattedTextFieldDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldPrecoExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addGap(1, 1, 1))
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28))
                    .addGroup(jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMotivoInativacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanelCadExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFechar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonListagem)
                    .addComponent(jButtonSalvarAlteraracao)
                    .addComponent(jButtonIncluir)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonNovo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadExemplar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadExemplar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed

        if (jFormattedTextFieldDataAquisicao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A data de aquisição do exemplar deve ser informada.\n");
            jFormattedTextFieldDataAquisicao.requestFocus();
        } else if (jFormattedTextFieldPrecoExemplar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O preço do exemplar dese ser informado.\n");
            jFormattedTextFieldPrecoExemplar.requestFocus();
        } else if (jComboBoxLivros.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "O livro deste exemplar deve ser informado.\n");
        } else if (jComboBoxSituacao.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "A situação deste exemplar deve ser informada.\n");
        } else if (jComboBoxDisponibilidade.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "A disponibilidade do exemplar deve ser informada.\n");
        } else if (jTextFieldMotivoInativacao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O estado físico do exemplar deve ser informado.\n");
            jTextFieldMotivoInativacao.requestFocus();
        } else {

            try {
                Livro auxLivro = new Livro();
                auxLivro.setLivroSplit(jComboBoxLivros.getSelectedItem().toString());

                exemplar = new Exemplar(auxLivro,
                        new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextFieldDataAquisicao.getText()),
                        Float.parseFloat(jFormattedTextFieldPrecoExemplar.getText().replace(",", ".").replace(" ", "")),
                        EnumSituacaoExemplar.valueOf(jComboBoxSituacao.getSelectedItem().toString()),
                        EnumDisponibilidadeExemplar.valueOf(jComboBoxDisponibilidade.getSelectedItem().toString()),
                        jTextFieldMotivoInativacao.getText().toString());

                controleExemplar.incluir(exemplar);
                imprimirDadosDoExemplarNaTabela(controleExemplar.recuperar());
                limpaCampos();
                desabilitaCampos();
                jButtonIncluir.setEnabled(false);
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }

    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonSalvarAlteraracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarAlteraracaoActionPerformed

        if (jFormattedTextFieldDataAquisicao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A data de aquisição do exemplar deve ser informada.\n");
            jFormattedTextFieldDataAquisicao.requestFocus();
        } else if (jFormattedTextFieldPrecoExemplar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O preço do exemplar dese ser informado.\n");
            jFormattedTextFieldPrecoExemplar.requestFocus();
        } else if (jComboBoxLivros.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "O livro deste exemplar deve ser informado.\n");
        } else if (jComboBoxSituacao.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "A situação deste exemplar deve ser informada.\n");
        } else if (jComboBoxDisponibilidade.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "A disponibilidade do exemplar deve ser informada.\n");
        } else if (jTextFieldMotivoInativacao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O estado físico do exemplar deve ser informado.\n");
            jTextFieldMotivoInativacao.requestFocus();
        } else {
            try {
                Livro auxLivro = new Livro();
                auxLivro.setLivroSplit(jComboBoxLivros.getSelectedItem().toString());

                exemplar = new Exemplar(auxLivro,
                        new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextFieldDataAquisicao.getText()),
                        Float.parseFloat(jFormattedTextFieldPrecoExemplar.getText().replace(",", ".").replace(" ", "")),
                        EnumSituacaoExemplar.valueOf(jComboBoxSituacao.getSelectedItem().toString()),
                        EnumDisponibilidadeExemplar.valueOf(jComboBoxDisponibilidade.getSelectedItem().toString()),
                        jTextFieldMotivoInativacao.getText().toString());
                exemplar.setId(exemplarAnterior.getId());
                controleExemplar.alterar(exemplar);
                imprimirDadosDoExemplarNaTabela(controleExemplar.recuperar());
                limpaCampos();
                desabilitaCampos();
                jButtonSalvarAlteraracao.setEnabled(false);
                jButtonEditar.setEnabled(false);
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
                
            }
        }
    }//GEN-LAST:event_jButtonSalvarAlteraracaoActionPerformed

    private void jButtonListagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListagemActionPerformed
        try {
            TelaListaExemplar lista = new TelaListaExemplar();
            lista.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(TelaCadExemplar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonListagemActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // TODO add your handling code here:
        limpaCampos();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTableCadExemplaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadExemplaresMouseClicked
        preencherFormulario();
        jButtonSalvarAlteraracao.setEnabled(true);
        jButtonEditar.setEnabled(true);
        jButtonIncluir.setEnabled(false);
    }//GEN-LAST:event_jTableCadExemplaresMouseClicked

    private void jTableCadExemplaresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCadExemplaresKeyReleased
        preencherFormulario();
    }//GEN-LAST:event_jTableCadExemplaresKeyReleased

    private void jComboBoxSituacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxSituacaoMouseClicked

    }//GEN-LAST:event_jComboBoxSituacaoMouseClicked

    private void jComboBoxSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSituacaoActionPerformed
        if (jComboBoxSituacao.getSelectedIndex() == 1) {
            jTextFieldMotivoInativacao.setText("Livro em bom estado");
        } else if (jComboBoxSituacao.getSelectedIndex() == 2) {
            jComboBoxDisponibilidade.setSelectedIndex(2);
            jTextFieldMotivoInativacao.setText("");
            JOptionPane.showMessageDialog(null, "Informe o motivo da inatividade do livro");
            jTextFieldMotivoInativacao.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxSituacaoActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        habilitaCampos();
        jFormattedTextFieldDataAquisicao.requestFocus();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        habilitaCampos();
        limpaCampos();
        jFormattedTextFieldDataAquisicao.requestFocus();
        jButtonIncluir.setEnabled(true);
         jButtonSalvarAlteraracao.setEnabled(false);
        jButtonEditar.setEnabled(false);
        
    }//GEN-LAST:event_jButtonNovoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Locale.setDefault(Locale.US);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaCadExemplar().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaCadExemplar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonListagem;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvarAlteraracao;
    private javax.swing.JComboBox<String> jComboBoxDisponibilidade;
    private javax.swing.JComboBox<String> jComboBoxLivros;
    private javax.swing.JComboBox<String> jComboBoxSituacao;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataAquisicao;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecoExemplar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelCadExemplar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCadExemplares;
    private javax.swing.JTextField jTextFieldMotivoInativacao;
    // End of variables declaration//GEN-END:variables
}
