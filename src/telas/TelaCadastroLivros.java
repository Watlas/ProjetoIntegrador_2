/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controle.LivroControle;
import java.util.logging.Level;
import java.util.logging.Logger;
import classes.*;
import controle.AreaControle;
import controle.AutorControle;
import controle.EditoraControle;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roger
 */
public class TelaCadastroLivros extends javax.swing.JFrame {

    LivroControle livroControle = null;
    Livro livro = null;
    Livro livroAnterior = null;
    AutorControle autorControle = null;
    EditoraControle editoraControle = null;
    AreaControle areaControle = null;

    /**
     * Creates new form TelaCadastroLivros
     *
     * @throws java.lang.Exception
     */
    public TelaCadastroLivros() throws Exception {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        jFormattedTextFieldISBN.setEnabled(false);
        jTextFieldTitulo.setEnabled(false);
        jTextField1SubTitulo.setEnabled(false);
        jComboBoxAutor.setEnabled(false);
        jComboBoxEditora.setEnabled(false);
        jComboBoxAreaDoLivro.setEnabled(false);
        jTextFieldEdicao.setEnabled(false);
        jTextFieldAnoPublic.setEnabled(false);
        jButtonIncluirLivro.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonSalvarAlteracao.setEnabled(false);

        try {
            livroControle = new LivroControle("livro.txt");
            livroAnterior = new Livro();
            livro = new Livro();

            autorControle = new AutorControle("Autores.txt");
            ArrayList<Autor> listaDeAutores = autorControle.recuperar();
            for (int pos = 0; pos < listaDeAutores.size(); pos++) {
                Autor aux = listaDeAutores.get(pos);
                jComboBoxAutor.addItem(aux.getId() + "-" + aux.getNomeAutor().toUpperCase());
            }
            editoraControle = new EditoraControle("Editoras.txt");
            ArrayList<Editora> listaDeEditoras = editoraControle.recuperar();
            for (int pos = 0; pos < listaDeEditoras.size(); pos++) {
                Editora aux = listaDeEditoras.get(pos);

                jComboBoxEditora.addItem(aux.getId() + "-" + aux.getDescricaoEditora().toUpperCase());
            }
            areaControle = new AreaControle("Areas.txt");
            ArrayList<AreaDoLivro> listaDeArea = areaControle.recuperar();
            for (int pos = 0; pos < listaDeArea.size(); pos++) {
                AreaDoLivro aux = listaDeArea.get(pos);

                jComboBoxAreaDoLivro.addItem(aux.getId() + "-" + aux.getCdd() + "-" + aux.getDescricaoDaArea().toUpperCase());
            }
            imprimirDadosDoLivroGrid(livroControle.recuperar());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na inicialização de algum componente\n" + erro);
        }

    }
    
    public void habilitaCampos(){
        jFormattedTextFieldISBN.setEnabled(true);
        jTextFieldTitulo.setEnabled(true);
        jTextField1SubTitulo.setEnabled(true);
        jComboBoxAutor.setEnabled(true);
        jComboBoxEditora.setEnabled(true);
        jComboBoxAreaDoLivro.setEnabled(true);
        jTextFieldEdicao.setEnabled(true);
        jTextFieldAnoPublic.setEnabled(true);
    }
    
    public void desabilitaCampos(){
         jFormattedTextFieldISBN.setEnabled(false);
        jTextFieldTitulo.setEnabled(false);
        jTextField1SubTitulo.setEnabled(false);
        jComboBoxAutor.setEnabled(false);
        jComboBoxEditora.setEnabled(false);
        jComboBoxAreaDoLivro.setEnabled(false);
        jTextFieldEdicao.setEnabled(false);
        jTextFieldAnoPublic.setEnabled(false);
    }

    private void imprimirDadosDoLivroGrid(ArrayList<Livro> lista) throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTableCadastroDeLivros.getModel();
        model.setNumRows(0);
        for (int pos = 0; pos < lista.size(); pos++) {
            String[] linha = new String[9];
            Livro aux = lista.get(pos);
            linha[0] = "" + aux.getId();
            linha[1] = aux.getIsbn();
            linha[2] = aux.getTituloLivro().toUpperCase();
            linha[3] = aux.getSubTituloLivro().toUpperCase();
            linha[4] = aux.getAutor().getId() + "-" + aux.getAutor().getNomeAutor().toUpperCase();
            linha[5] = aux.getEdicao();
            linha[6] = "" + aux.getAnoDePublicacao();
            linha[7] = aux.getEditora().getId() + "-" + aux.getEditora().getDescricaoEditora().toUpperCase();
            linha[8] = aux.getArea().getId() + "-" + aux.getArea().getCdd() + "-" + aux.getArea().getDescricaoDaArea().toString().toUpperCase();
            model.addRow(linha);
        }
    }

    public void preencherCamposFormulario() {

        int linha = jTableCadastroDeLivros.getSelectedRow();
        if (linha >= 0) {

            String campoID = jTableCadastroDeLivros.getValueAt(linha, 0).toString();
            String campoISBN = jTableCadastroDeLivros.getValueAt(linha, 1).toString();
            String campoTitulo = jTableCadastroDeLivros.getValueAt(linha, 2).toString();
            String campoSubTitulo = jTableCadastroDeLivros.getValueAt(linha, 3).toString();
            String campoAutor = jTableCadastroDeLivros.getValueAt(linha, 4).toString();
            String campoEdicao = jTableCadastroDeLivros.getValueAt(linha, 5).toString();
            String campoAnoPublic = jTableCadastroDeLivros.getValueAt(linha, 6).toString();
            String campoEditora = jTableCadastroDeLivros.getValueAt(linha, 7).toString();
            String campoArea = jTableCadastroDeLivros.getValueAt(linha, 8).toString();

            jFormattedTextFieldISBN.setText(campoISBN);
            jTextFieldTitulo.setText(campoTitulo);
            jTextField1SubTitulo.setText(campoSubTitulo);
            jComboBoxAutor.setSelectedItem(campoAutor);
            jTextFieldEdicao.setText(campoEdicao);
            jTextFieldAnoPublic.setText(campoAnoPublic);
            jComboBoxEditora.setSelectedItem(campoEditora);
            jComboBoxAreaDoLivro.setSelectedItem(campoArea);

            livroAnterior.setId(Integer.parseInt(campoID));
            livroAnterior.setTituloLivro(campoTitulo);
        }
    }

    public void limparCampos() {
        
        jFormattedTextFieldISBN.setText("");
        jTextFieldTitulo.setText("");
        jTextField1SubTitulo.setText("");
        jTextFieldEdicao.setText("");
        jTextFieldAnoPublic.setText("");
        jComboBoxAutor.setSelectedIndex(0);
        jComboBoxEditora.setSelectedIndex(0);
        jComboBoxAreaDoLivro.setSelectedIndex(0);

    }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanelCadastroLivros = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1SubTitulo = new javax.swing.JTextField();
        jButtonIncluirLivro = new javax.swing.JButton();
        jButtonListagem = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCadastroDeLivros = new javax.swing.JTable();
        jButtonLimpar = new javax.swing.JButton();
        jButtonSalvarAlteracao = new javax.swing.JButton();
        jComboBoxAutor = new javax.swing.JComboBox<>();
        jComboBoxEditora = new javax.swing.JComboBox<>();
        jComboBoxAreaDoLivro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldEdicao = new javax.swing.JTextField();
        jButtonIncluirNovoAutor = new javax.swing.JButton();
        jButtonIncluirNovaEditora = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAnoPublic = new javax.swing.JTextField();
        jFormattedTextFieldISBN = new javax.swing.JFormattedTextField();
        jButtonEditar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonAtualizarCdd = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA CONTROLE DE BIBLIOTECA");
        setResizable(false);

        jLabel2.setText("Código ISBN");

        jLabel4.setText("TÍTULO");

        jLabel5.setText("CADASTRO DE LIVROS");

        jLabel6.setText("SUB-TÍTULO");

        jLabel7.setText("AUTOR");

        jLabel8.setText("EDITORA");

        jLabel9.setText("ÁREA");

        jButtonIncluirLivro.setText("INCLUIR");
        jButtonIncluirLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirLivroActionPerformed(evt);
            }
        });

        jButtonListagem.setText("LISTAGEM");
        jButtonListagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListagemActionPerformed(evt);
            }
        });

        jButtonFechar.setText("FECHAR");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jTableCadastroDeLivros.setAutoCreateRowSorter(true);
        jTableCadastroDeLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ISBN", "TÍTULO", "SUB-TÍTULO", "AUTOR", "EDIÇÃO", "ANO PUBLIC.", "Editora", "Área do livro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadastroDeLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadastroDeLivrosMouseClicked(evt);
            }
        });
        jTableCadastroDeLivros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCadastroDeLivrosKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCadastroDeLivros);
        if (jTableCadastroDeLivros.getColumnModel().getColumnCount() > 0) {
            jTableCadastroDeLivros.getColumnModel().getColumn(0).setMinWidth(40);
            jTableCadastroDeLivros.getColumnModel().getColumn(0).setMaxWidth(40);
            jTableCadastroDeLivros.getColumnModel().getColumn(1).setMinWidth(120);
            jTableCadastroDeLivros.getColumnModel().getColumn(1).setMaxWidth(120);
            jTableCadastroDeLivros.getColumnModel().getColumn(6).setMinWidth(60);
            jTableCadastroDeLivros.getColumnModel().getColumn(6).setMaxWidth(60);
            jTableCadastroDeLivros.getColumnModel().getColumn(7).setMinWidth(0);
            jTableCadastroDeLivros.getColumnModel().getColumn(7).setMaxWidth(0);
            jTableCadastroDeLivros.getColumnModel().getColumn(8).setMinWidth(0);
            jTableCadastroDeLivros.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        jButtonLimpar.setText("LIMPAR");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonSalvarAlteracao.setText("SALVAR ALTERAÇÃO");
        jButtonSalvarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarAlteracaoActionPerformed(evt);
            }
        });

        jComboBoxAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< Selecione o autor >" }));
        jComboBoxAutor.setBorder(null);
        jComboBoxAutor.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxAutorPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBoxAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxAutorMouseClicked(evt);
            }
        });

        jComboBoxEditora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<  Selecione a Editora  >" }));
        jComboBoxEditora.setBorder(null);
        jComboBoxEditora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxEditoraMouseClicked(evt);
            }
        });

        jComboBoxAreaDoLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<  Selecione a Área do Livro  >" }));
        jComboBoxAreaDoLivro.setBorder(null);
        jComboBoxAreaDoLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxAreaDoLivroMouseClicked(evt);
            }
        });

        jLabel1.setText("EDIÇÃO");

        jButtonIncluirNovoAutor.setText("NOVO");
        jButtonIncluirNovoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirNovoAutorActionPerformed(evt);
            }
        });

        jButtonIncluirNovaEditora.setText("NOVO");
        jButtonIncluirNovaEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirNovaEditoraActionPerformed(evt);
            }
        });

        jLabel3.setText("ANO PUB.");

        jTextFieldAnoPublic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAnoPublicKeyReleased(evt);
            }
        });

        try {
            jFormattedTextFieldISBN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-##-###-####-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButtonEditar.setText("EDITAR");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonNovo.setText("NOVO");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonAtualizarCdd.setText("ATUALIZAR CDD");

        javax.swing.GroupLayout jPanelCadastroLivrosLayout = new javax.swing.GroupLayout(jPanelCadastroLivros);
        jPanelCadastroLivros.setLayout(jPanelCadastroLivrosLayout);
        jPanelCadastroLivrosLayout.setHorizontalGroup(
            jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldTitulo)
                                            .addComponent(jTextField1SubTitulo)))
                                    .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jFormattedTextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                                .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                                        .addComponent(jComboBoxAreaDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAtualizarCdd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonNovo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonIncluirLivro))
                                    .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                                        .addComponent(jComboBoxAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonIncluirNovoAutor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                                        .addComponent(jComboBoxEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonIncluirNovaEditora)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldAnoPublic, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(83, 83, 83))))
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLivrosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSalvarAlteracao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonListagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFechar)))
                        .addContainerGap())))
            .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelCadastroLivrosLayout.setVerticalGroup(
            jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLivrosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1SubTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIncluirNovoAutor)
                    .addComponent(jTextFieldEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIncluirNovaEditora)
                    .addComponent(jTextFieldAnoPublic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19)
                .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxAreaDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAtualizarCdd)
                    .addComponent(jButtonIncluirLivro)
                    .addComponent(jButtonNovo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFechar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonListagem)
                    .addComponent(jButtonSalvarAlteracao)
                    .addComponent(jButtonEditar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadastroLivros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadastroLivros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        try {
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroLivros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jComboBoxAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxAutorMouseClicked
        try {
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroLivros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBoxAutorMouseClicked

    private void jButtonIncluirNovoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirNovoAutorActionPerformed
        try {
            TelaCadAutor tela = new TelaCadAutor();
            tela.setVisible(true);
            this.dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButtonIncluirNovoAutorActionPerformed

    private void jButtonIncluirNovaEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirNovaEditoraActionPerformed
        try {
            TelaCadEditora tela = new TelaCadEditora();
            tela.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroLivros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonIncluirNovaEditoraActionPerformed

    private void jButtonIncluirLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirLivroActionPerformed

        if (jFormattedTextFieldISBN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o ISBN do livro!");
            jFormattedTextFieldISBN.requestFocus();
        } else if (jTextFieldTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o Título do livro!");
            jTextFieldTitulo.requestFocus();
        } else if (jTextField1SubTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o Sub-Título do livro!");
            jTextField1SubTitulo.requestFocus();
        } else if (jComboBoxAutor.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "O autor do livro deve ser informado.\n");
        } else if (jComboBoxEditora.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "A editora do livro deve ser informada.\n");
        } else if (jComboBoxAreaDoLivro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "A área do livro deve ser informada.\n");
        } else if (jTextFieldEdicao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a Edição do livro!");
            jTextFieldEdicao.requestFocus();
        } else if (jTextFieldAnoPublic.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o Ano de Publicação do livro!");
            jTextFieldAnoPublic.requestFocus();
        } else {
            try {
                livro.setIsbn(jFormattedTextFieldISBN.getText());
                livro.setTituloLivro(jTextFieldTitulo.getText());
                livro.setSubTituloLivro(jTextField1SubTitulo.getText());
                livro.setEdicao(jTextFieldEdicao.getText());
                livro.setAnoDePublicacao(Integer.parseInt(jTextFieldAnoPublic.getText()));

                Autor auxAutor = new Autor();
                auxAutor.setAutorSplit(jComboBoxAutor.getSelectedItem().toString());
                livro.setAutor(auxAutor);

                Editora auxEditora = new Editora();
                auxEditora.setEditoraSplit(jComboBoxEditora.getSelectedItem().toString());
                livro.setEditora(auxEditora);

                AreaDoLivro auxArea = new AreaDoLivro();
                auxArea.setAreaSplit(jComboBoxAreaDoLivro.getSelectedItem().toString());
                livro.setArea(auxArea);

                livroControle.incluir(livro);
                imprimirDadosDoLivroGrid(livroControle.recuperar());
                limparCampos();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }

        jFormattedTextFieldISBN.requestFocus();
    }//GEN-LAST:event_jButtonIncluirLivroActionPerformed

    private void jComboBoxEditoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxEditoraMouseClicked


    }//GEN-LAST:event_jComboBoxEditoraMouseClicked

    private void jComboBoxAreaDoLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxAreaDoLivroMouseClicked


    }//GEN-LAST:event_jComboBoxAreaDoLivroMouseClicked

    private void jComboBoxAutorPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxAutorPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_jComboBoxAutorPopupMenuWillBecomeInvisible

    private void jTableCadastroDeLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroDeLivrosMouseClicked
        try {
            preencherCamposFormulario();
            jButtonIncluirLivro.setEnabled(false);
            jButtonEditar.setEnabled(true);
            jButtonSalvarAlteracao.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jTableCadastroDeLivrosMouseClicked

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparCampos();
        desabilitaCampos();
        jFormattedTextFieldISBN.requestFocus();
        jButtonIncluirLivro.setEnabled(true);

    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jTableCadastroDeLivrosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCadastroDeLivrosKeyReleased
        preencherCamposFormulario();
    }//GEN-LAST:event_jTableCadastroDeLivrosKeyReleased

    private void jButtonListagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListagemActionPerformed
        try {
            TelaListaLivros listaDeLivros = new TelaListaLivros();
            listaDeLivros.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroLivros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonListagemActionPerformed

    private void jButtonSalvarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarAlteracaoActionPerformed
        try {
            livro.setId(livroAnterior.getId());

            livro.setIsbn(jFormattedTextFieldISBN.getText());
            livro.setTituloLivro(jTextFieldTitulo.getText());
            livro.setSubTituloLivro(jTextField1SubTitulo.getText());
            livro.setEdicao(jTextFieldEdicao.getText());
            livro.setAnoDePublicacao(Integer.parseInt(jTextFieldAnoPublic.getText()));

            Autor auxAutor = new Autor();
            auxAutor.setAutorSplit(jComboBoxAutor.getSelectedItem().toString());
            livro.setAutor(auxAutor);

            Editora auxEditora = new Editora();
            auxEditora.setEditoraSplit(jComboBoxEditora.getSelectedItem().toString());
            livro.setEditora(auxEditora);

            AreaDoLivro auxArea = new AreaDoLivro();
            auxArea.setAreaSplit(jComboBoxAreaDoLivro.getSelectedItem().toString());
            livro.setArea(auxArea);

            int opcao = JOptionPane.showConfirmDialog(null, "Deseja alterar "
                    + livroAnterior.getTituloLivro() + "?");
            // Este if verifica a minha opção de escolha dentro da caixa de diálogo do jPane
            if (opcao == 0) {

                livroControle.alterarDadosDoLivro(livro);
                imprimirDadosDoLivroGrid(livroControle.recuperar());
            limparCampos();
            jButtonEditar.setEnabled(false);
            jButtonSalvarAlteracao.setEnabled(false);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na alteração deste item\n" + erro + "\n");
        }
    }//GEN-LAST:event_jButtonSalvarAlteracaoActionPerformed

    private void jTextFieldAnoPublicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAnoPublicKeyReleased
        jTextFieldAnoPublic.setText(jTextFieldAnoPublic.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_jTextFieldAnoPublicKeyReleased

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        habilitaCampos();
        jFormattedTextFieldISBN.requestFocus();
        jButtonIncluirLivro.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonSalvarAlteracao.setEnabled(false);
        limparCampos();

    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        habilitaCampos();
        jFormattedTextFieldISBN.requestFocus();
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
            java.util.logging.Logger.getLogger(TelaCadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaCadastroLivros().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaCadastroLivros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAtualizarCdd;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonIncluirLivro;
    private javax.swing.JButton jButtonIncluirNovaEditora;
    private javax.swing.JButton jButtonIncluirNovoAutor;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonListagem;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvarAlteracao;
    private javax.swing.JComboBox<String> jComboBoxAreaDoLivro;
    private javax.swing.JComboBox<String> jComboBoxAutor;
    private javax.swing.JComboBox<String> jComboBoxEditora;
    private javax.swing.JFormattedTextField jFormattedTextFieldISBN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelCadastroLivros;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableCadastroDeLivros;
    private javax.swing.JTextField jTextField1SubTitulo;
    private javax.swing.JTextField jTextFieldAnoPublic;
    private javax.swing.JTextField jTextFieldEdicao;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables

}
