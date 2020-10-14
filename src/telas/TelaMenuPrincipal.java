package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import telas.*;

public class TelaMenuPrincipal extends javax.swing.JFrame {

    TelaCadEditora telaEditora = null;
    TelaCadAutor telaAutor = null;
    TelaCadArea telaArea = null;
    TelaCadUsuarios telaUsuario = null;
    TelaCadExemplar telaExemplar = null;
    TelaCadastroLivros telaLivro = null;
    TelaListaEditora listaEditoras = null;
    TelaListaDeAutores listaAutores = null;
    TelaListaDeAreas listaAreas = null;
    TelaListaDeUsuarios listaUsuarios = null;
    TelaListaExemplar listaExemplares = null;
    TelaListaLivros listaLivros = null;

    /**
     *
     * Creates new form TelaMenuPrincipal
     */
    public TelaMenuPrincipal() {
        initComponents();
        jMenuCadastros.setEnabled(false);
        jMenuDevolucao.setEnabled(false);
        jMenuEmprestimo.setEnabled(false);
        jMenuPesquisar.setEnabled(false);
        jMenuRelatorios.setEnabled(false);
        jMenuReserva.setEnabled(false);
        jMenuSugestoes.setEnabled(false);
        setExtendedState(MAXIMIZED_BOTH);

    }

    public void habilitaMenus() {
        jMenuCadastros.setEnabled(true);
        jMenuDevolucao.setEnabled(true);
        jMenuEmprestimo.setEnabled(true);
        jMenuPesquisar.setEnabled(true);
        jMenuRelatorios.setEnabled(true);
        jMenuReserva.setEnabled(true);
        jMenuSugestoes.setEnabled(true);
    }

    public void abrirFormulario(JInternalFrame janela) {
        int lDesk = jDesktopPaneMenuPrincipal.getWidth();
        int aDesk = jDesktopPaneMenuPrincipal.getHeight();
        int lIFrame = janela.getWidth();
        int aIFrame = janela.getHeight();
        janela.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        jDesktopPaneMenuPrincipal.add(janela);
        janela.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanelMenuPrincipalBiblioteca = new javax.swing.JPanel();
        jDesktopPaneMenuPrincipal = new javax.swing.JDesktopPane();
        jButtonLoginAoSistemaBiblioteca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemArea = new javax.swing.JMenuItem();
        jMenuItemAutor = new javax.swing.JMenuItem();
        jMenuItemEditora = new javax.swing.JMenuItem();
        jMenuItemExemplar = new javax.swing.JMenuItem();
        jMenuItemLivro = new javax.swing.JMenuItem();
        jMenuItemUsuario = new javax.swing.JMenuItem();
        jMenuEmprestimo = new javax.swing.JMenu();
        jMenuItemEmprestimo = new javax.swing.JMenuItem();
        jMenuDevolucao = new javax.swing.JMenu();
        jMenuItemDevolucao = new javax.swing.JMenuItem();
        jMenuReserva = new javax.swing.JMenu();
        jMenuItemReserva = new javax.swing.JMenuItem();
        jMenuPesquisar = new javax.swing.JMenu();
        jMenuItemPesquisarArea = new javax.swing.JMenuItem();
        jMenuItemPesquisarAutor = new javax.swing.JMenuItem();
        jMenuItemPesquisarEditora = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItemPesquisarLivro = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItemPesquisarUsuario = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuItemRelatorioAreas = new javax.swing.JMenuItem();
        jMenuItemRelatorioAutores = new javax.swing.JMenuItem();
        jMenuItemRelatorioEditoras = new javax.swing.JMenuItem();
        jMenuItemExemplares = new javax.swing.JMenuItem();
        jMenuItemRelatorioLivros = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuSugestoes = new javax.swing.JMenu();
        jMenuItemSugestoes = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Controle de Biblioteca");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelMenuPrincipalBiblioteca.setBackground(new java.awt.Color(0, 0, 0));
        jPanelMenuPrincipalBiblioteca.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButtonLoginAoSistemaBiblioteca.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonLoginAoSistemaBiblioteca.setText("LOGIN AO SISTEMA");
        jButtonLoginAoSistemaBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginAoSistemaBibliotecaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WRRL - Software e Soluções");

        jLabelData.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelData.setForeground(new java.awt.Color(255, 255, 255));
        jLabelData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelData.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelHora.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelHora.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHora.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jDesktopPaneMenuPrincipal.setLayer(jButtonLoginAoSistemaBiblioteca, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneMenuPrincipal.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneMenuPrincipal.setLayer(jLabelData, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneMenuPrincipal.setLayer(jLabelHora, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneMenuPrincipalLayout = new javax.swing.GroupLayout(jDesktopPaneMenuPrincipal);
        jDesktopPaneMenuPrincipal.setLayout(jDesktopPaneMenuPrincipalLayout);
        jDesktopPaneMenuPrincipalLayout.setHorizontalGroup(
            jDesktopPaneMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneMenuPrincipalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneMenuPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLoginAoSistemaBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPaneMenuPrincipalLayout.setVerticalGroup(
            jDesktopPaneMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneMenuPrincipalLayout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addGroup(jDesktopPaneMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPaneMenuPrincipalLayout.createSequentialGroup()
                        .addComponent(jButtonLoginAoSistemaBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jDesktopPaneMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDesktopPaneMenuPrincipalLayout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(jLabel2))
                            .addGroup(jDesktopPaneMenuPrincipalLayout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jLabelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanelMenuPrincipalBibliotecaLayout = new javax.swing.GroupLayout(jPanelMenuPrincipalBiblioteca);
        jPanelMenuPrincipalBiblioteca.setLayout(jPanelMenuPrincipalBibliotecaLayout);
        jPanelMenuPrincipalBibliotecaLayout.setHorizontalGroup(
            jPanelMenuPrincipalBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuPrincipalBibliotecaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPaneMenuPrincipal)
                .addContainerGap())
        );
        jPanelMenuPrincipalBibliotecaLayout.setVerticalGroup(
            jPanelMenuPrincipalBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuPrincipalBibliotecaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPaneMenuPrincipal)
                .addContainerGap())
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenuCadastros.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuCadastros.setText("CADASTROS");
        jMenuCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastrosActionPerformed(evt);
            }
        });

        jMenuItemArea.setText("Área");
        jMenuItemArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAreaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemArea);

        jMenuItemAutor.setText("Autor");
        jMenuItemAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAutorActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemAutor);

        jMenuItemEditora.setText("Editora");
        jMenuItemEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditoraActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemEditora);

        jMenuItemExemplar.setText("Exemplar");
        jMenuItemExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExemplarActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemExemplar);

        jMenuItemLivro.setText("Livro");
        jMenuItemLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLivroActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemLivro);

        jMenuItemUsuario.setText("Usuário");
        jMenuItemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuarioActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemUsuario);

        jMenuBar1.add(jMenuCadastros);

        jMenuEmprestimo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuEmprestimo.setText("EMPRÉSTIMO");
        jMenuEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEmprestimoActionPerformed(evt);
            }
        });

        jMenuItemEmprestimo.setText("Exemplar");
        jMenuItemEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEmprestimoActionPerformed(evt);
            }
        });
        jMenuEmprestimo.add(jMenuItemEmprestimo);

        jMenuBar1.add(jMenuEmprestimo);

        jMenuDevolucao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuDevolucao.setText("DEVOLUÇÃO");
        jMenuDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDevolucaoActionPerformed(evt);
            }
        });

        jMenuItemDevolucao.setText("Exemplar");
        jMenuItemDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDevolucaoActionPerformed(evt);
            }
        });
        jMenuDevolucao.add(jMenuItemDevolucao);

        jMenuBar1.add(jMenuDevolucao);

        jMenuReserva.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuReserva.setText("RESERVA");

        jMenuItemReserva.setText("Reserva");
        jMenuItemReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReservaActionPerformed(evt);
            }
        });
        jMenuReserva.add(jMenuItemReserva);

        jMenuBar1.add(jMenuReserva);

        jMenuPesquisar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuPesquisar.setText("PESQUISAR");

        jMenuItemPesquisarArea.setText("Área");
        jMenuItemPesquisarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisarAreaActionPerformed(evt);
            }
        });
        jMenuPesquisar.add(jMenuItemPesquisarArea);

        jMenuItemPesquisarAutor.setText("Autor");
        jMenuItemPesquisarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisarAutorActionPerformed(evt);
            }
        });
        jMenuPesquisar.add(jMenuItemPesquisarAutor);

        jMenuItemPesquisarEditora.setText("Editora");
        jMenuItemPesquisarEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisarEditoraActionPerformed(evt);
            }
        });
        jMenuPesquisar.add(jMenuItemPesquisarEditora);

        jMenuItem4.setText("Exemplar");
        jMenuPesquisar.add(jMenuItem4);

        jMenuItemPesquisarLivro.setText("Livro");
        jMenuItemPesquisarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisarLivroActionPerformed(evt);
            }
        });
        jMenuPesquisar.add(jMenuItemPesquisarLivro);

        jMenuItem2.setText("Sugestão");
        jMenuPesquisar.add(jMenuItem2);

        jMenuItemPesquisarUsuario.setText("Usuário");
        jMenuPesquisar.add(jMenuItemPesquisarUsuario);

        jMenuBar1.add(jMenuPesquisar);

        jMenuRelatorios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuRelatorios.setText("RELATÓRIOS");
        jMenuRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatoriosActionPerformed(evt);
            }
        });

        jMenuItemRelatorioAreas.setText("Áreas");
        jMenuItemRelatorioAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioAreasActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemRelatorioAreas);

        jMenuItemRelatorioAutores.setText("Autores");
        jMenuItemRelatorioAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioAutoresActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemRelatorioAutores);

        jMenuItemRelatorioEditoras.setText("Editoras");
        jMenuItemRelatorioEditoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioEditorasActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemRelatorioEditoras);

        jMenuItemExemplares.setText("Exemplares");
        jMenuItemExemplares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExemplaresActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemExemplares);

        jMenuItemRelatorioLivros.setText("Livros");
        jMenuItemRelatorioLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioLivrosActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemRelatorioLivros);

        jMenuItem3.setText("Sugestões");
        jMenuRelatorios.add(jMenuItem3);

        jMenuItemUsuarios.setText("Usuarios");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemUsuarios);

        jMenuBar1.add(jMenuRelatorios);

        jMenuSugestoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuSugestoes.setText("SUGESTÕES");

        jMenuItemSugestoes.setText("Adicionar sugestões de novas aquisições");
        jMenuItemSugestoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSugestoesActionPerformed(evt);
            }
        });
        jMenuSugestoes.add(jMenuItemSugestoes);

        jMenuBar1.add(jMenuSugestoes);

        jMenuSair.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuSair.setText("SAIR");

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuItemSair);

        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMenuPrincipalBiblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMenuPrincipalBiblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastrosActionPerformed

    }//GEN-LAST:event_jMenuCadastrosActionPerformed

    private void jMenuItemEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditoraActionPerformed
        try {
           
            if (telaEditora == null) {
                telaEditora = new TelaCadEditora();
                telaEditora.setLocationRelativeTo(null);
            }
            telaEditora.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemEditoraActionPerformed

    private void jMenuItemAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAutorActionPerformed
        try {
            if (telaAutor == null) {
                telaAutor = new TelaCadAutor();
            }
            telaAutor.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_jMenuItemAutorActionPerformed

    private void jMenuItemLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLivroActionPerformed
        try {
            if (telaLivro == null) {
                telaLivro = new TelaCadastroLivros();
            }
            telaLivro.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItemLivroActionPerformed

    private void jMenuItemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuarioActionPerformed
        try {
            if (telaUsuario == null) {
                telaUsuario = new TelaCadUsuarios();
            }
            telaUsuario.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItemUsuarioActionPerformed

    private void jMenuItemAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAreaActionPerformed
        try {
            if (telaArea == null) {
                telaArea = new TelaCadArea();
            }
            telaArea.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemAreaActionPerformed

    private void jMenuEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEmprestimoActionPerformed


    }//GEN-LAST:event_jMenuEmprestimoActionPerformed

    private void jMenuDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDevolucaoActionPerformed

    }//GEN-LAST:event_jMenuDevolucaoActionPerformed

    private void jMenuItemEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEmprestimoActionPerformed
        TelaEmprestimo telaEmprestimo = new TelaEmprestimo();
        telaEmprestimo.setVisible(true);

    }//GEN-LAST:event_jMenuItemEmprestimoActionPerformed

    private void jMenuItemDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDevolucaoActionPerformed
        TelaDevolucao telaDevolucao = new TelaDevolucao();
        telaDevolucao.setVisible(true);

    }//GEN-LAST:event_jMenuItemDevolucaoActionPerformed

    private void jMenuItemReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReservaActionPerformed
        TelaReservaLivros telaReserva = new TelaReservaLivros();
        telaReserva.setVisible(true);

    }//GEN-LAST:event_jMenuItemReservaActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        int saida = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema ? ");
        if (saida == 0) {
            System.exit(0);
        }


    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemSugestoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSugestoesActionPerformed
        try {
            TelaCadSugestao telaSugestao = new TelaCadSugestao();
            telaSugestao.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItemSugestoesActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setExtendedState(MAXIMIZED_BOTH);

        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        jLabelData.setText(formato.format(dataSistema));

        Timer timer = new Timer(1000, new hora());
        timer.start();

    }//GEN-LAST:event_formWindowOpened

    private void jMenuRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatoriosActionPerformed

    }//GEN-LAST:event_jMenuRelatoriosActionPerformed

    private void jMenuItemRelatorioAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioAreasActionPerformed
        try {
            if (listaAreas == null) {
                listaAreas = new TelaListaDeAreas();
            }
            listaAreas.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemRelatorioAreasActionPerformed

    private void jMenuItemRelatorioEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioEditorasActionPerformed
        try {
            if (listaEditoras == null) {
                listaEditoras = new TelaListaEditora();
            }
            listaEditoras.setVisible(true);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }//GEN-LAST:event_jMenuItemRelatorioEditorasActionPerformed

    private void jMenuItemPesquisarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisarAreaActionPerformed
        try {
            TelaListaDeAreas tela = new TelaListaDeAreas();
            tela.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItemPesquisarAreaActionPerformed

    private void jMenuItemPesquisarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisarAutorActionPerformed
        TelaListaDeAutores tela = new TelaListaDeAutores();
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemPesquisarAutorActionPerformed

    private void jMenuItemPesquisarEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisarEditoraActionPerformed
        try {
            TelaListaEditora tela = new TelaListaEditora();
            tela.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemPesquisarEditoraActionPerformed

    private void jMenuItemPesquisarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisarLivroActionPerformed
        try {
            TelaListaLivros tela = new TelaListaLivros();
            tela.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemPesquisarLivroActionPerformed

    private void jButtonLoginAoSistemaBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginAoSistemaBibliotecaActionPerformed
        try {
            TelaLoginAoSistemaBiblioteca tls = new TelaLoginAoSistemaBiblioteca(this, true);
            jButtonLoginAoSistemaBiblioteca.setVisible(false);
            tls.setVisible(true);
            habilitaMenus();
        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonLoginAoSistemaBibliotecaActionPerformed

    private void jMenuItemExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExemplarActionPerformed
        try {
            if (telaExemplar == null) {
                telaExemplar = new TelaCadExemplar();
            }
            telaExemplar.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItemExemplarActionPerformed

    private void jMenuItemRelatorioAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioAutoresActionPerformed
        try {
            if (listaAutores == null) {
                listaAutores = new TelaListaDeAutores();
            }
            listaAutores.setVisible(true);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao exibir a tela " + erro);
        }
    }//GEN-LAST:event_jMenuItemRelatorioAutoresActionPerformed

    private void jMenuItemExemplaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExemplaresActionPerformed
        try {
            if (listaExemplares == null) {
                listaExemplares = new TelaListaExemplar();
            }
            listaExemplares.setVisible(true);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao exibir a tela " + erro);

        }
    }//GEN-LAST:event_jMenuItemExemplaresActionPerformed

    private void jMenuItemRelatorioLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioLivrosActionPerformed
        try {
            if (listaLivros == null) {
                listaLivros = new TelaListaLivros();
            }
            listaLivros.setVisible(true);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao exibir a tela " + erro);

        }

    }//GEN-LAST:event_jMenuItemRelatorioLivrosActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        try {
            if (listaUsuarios == null) {
                listaUsuarios = new TelaListaDeUsuarios();
            }
            listaUsuarios.setVisible(true);
        } catch (Exception erro) {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao exibir a tela " + erro);

        }
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLoginAoSistemaBiblioteca;
    private javax.swing.JDesktopPane jDesktopPaneMenuPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenu jMenuDevolucao;
    private javax.swing.JMenu jMenuEmprestimo;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemArea;
    private javax.swing.JMenuItem jMenuItemAutor;
    private javax.swing.JMenuItem jMenuItemDevolucao;
    private javax.swing.JMenuItem jMenuItemEditora;
    private javax.swing.JMenuItem jMenuItemEmprestimo;
    private javax.swing.JMenuItem jMenuItemExemplar;
    private javax.swing.JMenuItem jMenuItemExemplares;
    private javax.swing.JMenuItem jMenuItemLivro;
    private javax.swing.JMenuItem jMenuItemPesquisarArea;
    private javax.swing.JMenuItem jMenuItemPesquisarAutor;
    private javax.swing.JMenuItem jMenuItemPesquisarEditora;
    private javax.swing.JMenuItem jMenuItemPesquisarLivro;
    private javax.swing.JMenuItem jMenuItemPesquisarUsuario;
    private javax.swing.JMenuItem jMenuItemRelatorioAreas;
    private javax.swing.JMenuItem jMenuItemRelatorioAutores;
    private javax.swing.JMenuItem jMenuItemRelatorioEditoras;
    private javax.swing.JMenuItem jMenuItemRelatorioLivros;
    private javax.swing.JMenuItem jMenuItemReserva;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemSugestoes;
    private javax.swing.JMenuItem jMenuItemUsuario;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenu jMenuPesquisar;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuReserva;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenu jMenuSugestoes;
    private javax.swing.JPanel jPanelMenuPrincipalBiblioteca;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            jLabelHora.setText(String.format("%1$tH:%1$tH:%1$tS", now));
        }
    }

} // Fim da classe principal
