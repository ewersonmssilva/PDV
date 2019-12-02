/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pdv.GUI;

import com.senac.pdv.dao.ProdutoDAO;
import com.senac.pdv.comando.VendaProduto;
import com.senac.pdv.dao.ProdutoDAO;
import com.senac.pdv.desconto.Desconto;
//import com.senac.pdv.desconto.DescontoGamer;
import com.senac.pdv.desconto.DescontoGrandeQuantidade;
import com.senac.pdv.desconto.DescontoProdutoValorAlto;
import com.senac.pdv.desconto.DescontoValorAlto;
import com.senac.pdv.desconto.DescontoVendaCasada;
import com.senac.pdv.desconto.SemDesconto;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


import com.senac.pdv.desconto.*;
import com.senac.pdv.imposto.ICMSSP;
import com.senac.pdv.imposto.IPL;
import com.senac.pdv.modelo.Produto;
import com.senac.pdv.modelo.Venda;
import java.util.ArrayList;

import java.util.regex.Pattern;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;
/**
 *
 * @author ewerson.mssilva
 */
public class pdvUI extends javax.swing.JFrame {

    /**
     * Creates new form pdvUI
     */
    //int row = 0;   
    public pdvUI() {
        initComponents();
        
        //jTextFieldlVendasValor.setText("0.00");
        
                DefaultTableModel modelo = (DefaultTableModel) jTablePesquisar.getModel();
        jTablePesquisar.setRowSorter(new TableRowSorter(modelo));
        


                
                
        
        refresh();
              
            ProdutoDAO DAO = new ProdutoDAO();
            for(Produto prod : DAO.listar()) {                    
                Produto prodGET = (prod);              
                //jComboBoxCodigo.addItem(prodGET.getId());
                jComboBoxVendasNome.addItem(prodGET.getNome());
            } 
        
    }
    
    public void refresh(){ 
        DefaultTableModel modelo = (DefaultTableModel) jTablePesquisar.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();

        for (Produto produto : pdao.read()) {

            modelo.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                produto.getQuantidade(),
                produto.getPreco()
            });

        }
    }

    private void PreparaNovaVenda() {
        //while (jTableVendas.getRowCount() > 0) {
        DefaultTableModel modelo = (DefaultTableModel) jTableVendas.getModel();
        modelo.setNumRows(0);
        //}        
       jTextFieldlVendasValor.setText("0.00");
       jTextFieldlVendasImpostos.setText("0.00");
       jTextFieldlVendasDescontos.setText("0.00");
       jTextFieldlVendasTotal.setText("0.00");
       jTextFieldVendasID.setText("");
       jComboBoxVendasNome.setSelectedIndex(0);
       /*
       ProdutoDAO DAO = new ProdutoDAO();
        for(Produto prod : DAO.listar()) {                    
            Produto prodGET = (prod);
            jComboBoxVendasNome.addItem(prodGET.getNome());
        } */
    }
    
    public void readJTableForDesc(String desc) {
        
        DefaultTableModel modelo = (DefaultTableModel) jTablePesquisar.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();

        for (Produto produto : pdao.readForDesc(desc)) {

            modelo.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                produto.getQuantidade(),
                produto.getPreco()
            });

        }        

    }
    
    public void readJTableForId(Integer id) {
        
        DefaultTableModel modelo = (DefaultTableModel) jTableVendas.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();

        for (Produto produto : pdao.readForId(id)) {

            modelo.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                produto.getQuantidade(),
                produto.getPreco()
            });

        }        

    }    
 
    public void gravaJTablePorIdVendas(Integer id) {
        
        DefaultTableModel modelo = (DefaultTableModel) jTable3.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();

        for (Produto produto : pdao.lerPorIdVendas(id)) {

            modelo.addRow(new Object[]{
                produto.getNome(),
                produto.getQuantidade(),
                produto.getPreco(),
                produto.getData()
            });

        }        

    }    
    public int descontoSelecionado() {
        int selecao=0;        
        if(jRadioButton2.isSelected())
            selecao = 1;
        else if(jRadioButton3.isSelected())
            selecao = 2;
        else if(jRadioButton4.isSelected())
            selecao = 3;
        return selecao;
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelVendas = new javax.swing.JPanel();
        jButtonVendasFinaliza = new javax.swing.JButton();
        jButtonVendasCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendas = new javax.swing.JTable();
        jButtonVendasAdicionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextFieldlVendasValor = new javax.swing.JTextField();
        jTextFieldlVendasImpostos = new javax.swing.JTextField();
        jTextFieldlVendasDescontos = new javax.swing.JTextField();
        jTextFieldlVendasTotal = new javax.swing.JTextField();
        jLabelVendasValor = new javax.swing.JLabel();
        jLabellVendasImpostos = new javax.swing.JLabel();
        jLabellVendasDescontos = new javax.swing.JLabel();
        jLabellVendasTotal = new javax.swing.JLabel();
        jComboBoxVendasNome = new javax.swing.JComboBox<>();
        jTextFieldVendasID = new javax.swing.JTextField();
        jPanelBuscas = new javax.swing.JPanel();
        jButtonBuscasPesquisar = new javax.swing.JButton();
        jTextFieldPesquisarNome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldPesquisarPreco = new javax.swing.JTextField();
        jTextFieldPesquisarQuantidade = new javax.swing.JTextField();
        jButtonPesquisarAtualizar = new javax.swing.JButton();
        jButtonPesquisarCadastrar = new javax.swing.JButton();
        jButtonAtualisarRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePesquisar = new javax.swing.JTable();
        jTextFieldPesquisarPesquisar = new javax.swing.JTextField();
        jPanelControle = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonVendasFinaliza.setText("Finalizar");
        jButtonVendasFinaliza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVendasFinalizaMouseClicked(evt);
            }
        });
        jButtonVendasFinaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendasFinalizaActionPerformed(evt);
            }
        });

        jButtonVendasCancelar.setText("Cancelar");
        jButtonVendasCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendasCancelarActionPerformed(evt);
            }
        });

        jTableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Qtd.", "Preço Unit."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVendas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableVendas);
        if (jTableVendas.getColumnModel().getColumnCount() > 0) {
            jTableVendas.getColumnModel().getColumn(0).setMinWidth(70);
            jTableVendas.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTableVendas.getColumnModel().getColumn(0).setMaxWidth(70);
            jTableVendas.getColumnModel().getColumn(1).setResizable(false);
            jTableVendas.getColumnModel().getColumn(2).setMinWidth(70);
            jTableVendas.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTableVendas.getColumnModel().getColumn(2).setMaxWidth(70);
            jTableVendas.getColumnModel().getColumn(3).setMinWidth(100);
            jTableVendas.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableVendas.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jButtonVendasAdicionar.setText("Adicionar");
        jButtonVendasAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendasAdicionarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText(" Desconto Auto.");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Desconto 2%");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Desconto 5%");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Desconto 10%");

        jTextFieldlVendasValor.setText("0.00");
        jTextFieldlVendasValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldlVendasValorActionPerformed(evt);
            }
        });

        jTextFieldlVendasImpostos.setText("0.00");
        jTextFieldlVendasImpostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldlVendasImpostosActionPerformed(evt);
            }
        });

        jTextFieldlVendasDescontos.setText("0.00");
        jTextFieldlVendasDescontos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldlVendasDescontosActionPerformed(evt);
            }
        });

        jTextFieldlVendasTotal.setText("0.00");

        jLabelVendasValor.setText("Valor:");

        jLabellVendasImpostos.setText("Impostos:");

        jLabellVendasDescontos.setText("Descontos:");

        jLabellVendasTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabellVendasTotal.setText("Total:");

        jComboBoxVendasNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione>" }));
        jComboBoxVendasNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVendasNomeActionPerformed(evt);
            }
        });

        jTextFieldVendasID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVendasIDActionPerformed(evt);
            }
        });
        jTextFieldVendasID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldVendasIDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelVendasLayout = new javax.swing.GroupLayout(jPanelVendas);
        jPanelVendas.setLayout(jPanelVendasLayout);
        jPanelVendasLayout.setHorizontalGroup(
            jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVendasLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVendasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVendasCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonVendasFinaliza))
                            .addGroup(jPanelVendasLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton4)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelVendasValor)
                                        .addComponent(jTextFieldlVendasValor, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldlVendasImpostos, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabellVendasImpostos)
                                        .addComponent(jTextFieldlVendasDescontos, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabellVendasDescontos)
                                        .addComponent(jTextFieldlVendasTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabellVendasTotal)))))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldVendasID, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxVendasNome, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonVendasAdicionar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelVendasLayout.setVerticalGroup(
            jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVendasLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxVendasNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVendasID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVendasAdicionar)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addGap(1, 1, 1)
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabelVendasValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldlVendasValor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabellVendasImpostos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldlVendasImpostos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabellVendasDescontos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldlVendasDescontos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabellVendasTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldlVendasTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                    .addGroup(jPanelVendasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(22, 22, 22)))
                .addGroup(jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVendasFinaliza)
                    .addComponent(jButtonVendasCancelar))
                .addGap(16, 16, 16))
        );

        jTabbedPane2.addTab("Vendas", jPanelVendas);

        jPanelBuscas.setToolTipText("");

        jButtonBuscasPesquisar.setText("Pesquisar");
        jButtonBuscasPesquisar.setPreferredSize(new java.awt.Dimension(80, 23));
        jButtonBuscasPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscasPesquisarActionPerformed(evt);
            }
        });

        jTextFieldPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarNomeActionPerformed(evt);
            }
        });

        jLabel8.setText("Nome:");

        jLabel9.setText("Preço:");

        jLabel10.setText("Qtd:");

        jTextFieldPesquisarPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarPrecoActionPerformed(evt);
            }
        });

        jButtonPesquisarAtualizar.setText("Atualizar");
        jButtonPesquisarAtualizar.setPreferredSize(new java.awt.Dimension(80, 23));
        jButtonPesquisarAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarAtualizarActionPerformed(evt);
            }
        });

        jButtonPesquisarCadastrar.setText("Cadastrar");
        jButtonPesquisarCadastrar.setMaximumSize(new java.awt.Dimension(80, 23));
        jButtonPesquisarCadastrar.setMinimumSize(new java.awt.Dimension(80, 23));
        jButtonPesquisarCadastrar.setPreferredSize(new java.awt.Dimension(80, 23));
        jButtonPesquisarCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarCadastrarActionPerformed(evt);
            }
        });

        jButtonAtualisarRemover.setText("Excluir");
        jButtonAtualisarRemover.setPreferredSize(new java.awt.Dimension(80, 23));
        jButtonAtualisarRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualisarRemoverActionPerformed(evt);
            }
        });

        jTablePesquisar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Descricao", "Qtd", "Preco"
            }
        ));
        jTablePesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePesquisarMouseClicked(evt);
            }
        });
        jTablePesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablePesquisarKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePesquisar);
        if (jTablePesquisar.getColumnModel().getColumnCount() > 0) {
            jTablePesquisar.getColumnModel().getColumn(0).setMinWidth(180);
            jTablePesquisar.getColumnModel().getColumn(0).setPreferredWidth(180);
            jTablePesquisar.getColumnModel().getColumn(0).setMaxWidth(180);
            jTablePesquisar.getColumnModel().getColumn(2).setMinWidth(80);
            jTablePesquisar.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTablePesquisar.getColumnModel().getColumn(2).setMaxWidth(80);
            jTablePesquisar.getColumnModel().getColumn(3).setMinWidth(120);
            jTablePesquisar.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTablePesquisar.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        jTextFieldPesquisarPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscasLayout = new javax.swing.GroupLayout(jPanelBuscas);
        jPanelBuscas.setLayout(jPanelBuscasLayout);
        jPanelBuscasLayout.setHorizontalGroup(
            jPanelBuscasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscasLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelBuscasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscasLayout.createSequentialGroup()
                        .addGroup(jPanelBuscasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBuscasLayout.createSequentialGroup()
                                .addComponent(jButtonPesquisarCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButtonPesquisarAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAtualisarRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(jPanelBuscasLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanelBuscasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBuscasLayout.createSequentialGroup()
                                .addComponent(jTextFieldPesquisarPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPesquisarQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelBuscasLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextFieldPesquisarPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBuscasPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanelBuscasLayout.setVerticalGroup(
            jPanelBuscasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscasLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanelBuscasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPesquisarPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldPesquisarQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelBuscasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisarCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAtualisarRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscasPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPesquisarPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Pesquisar", jPanelBuscas);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descricao", "Qtd", "Preco", "Data"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jTable3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable3KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(1).setMinWidth(80);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable3.getColumnModel().getColumn(2).setMinWidth(120);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable3.getColumnModel().getColumn(3).setMinWidth(180);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(180);
            jTable3.getColumnModel().getColumn(3).setMaxWidth(180);
        }

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Id Venda:");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControleLayout = new javax.swing.GroupLayout(jPanelControle);
        jPanelControle.setLayout(jPanelControleLayout);
        jPanelControleLayout.setHorizontalGroup(
            jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControleLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelControleLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControleLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(542, 542, 542))))
        );
        jPanelControleLayout.setVerticalGroup(
            jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControleLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Controle", jPanelControle);

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        jLabel11.setText("PDV");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("BEC Senac");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPesquisarPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisarPrecoActionPerformed

    private void jButtonBuscasPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscasPesquisarActionPerformed
        readJTableForDesc(jTextFieldPesquisarPesquisar.getText());
    }//GEN-LAST:event_jButtonBuscasPesquisarActionPerformed

    private void jTextFieldPesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarNomeActionPerformed
                Object obj=evt.getSource();
        if(obj == jTextFieldPesquisarNome){
            ProdutoDAO DAO = new ProdutoDAO();
            //String y =(String)jComboBoxPesquisarCodigo.getSelectedItem();
            //int b = Integer.parseInt(y);
            //String applicationNumber = String.valueOf((String)jComboBoxPesquisarCodigo.getSelectedItem());
            //String z = Integer.toString((int) jComboBoxPesquisarCodigo.getSelectedItem());
            String getValue = jTextFieldPesquisarNome.getText();
            Produto prodGET = (Produto) DAO.buscaPorNome(getValue);
            //jTextFieldPesquisarProduto.setText(z); 
    //        jComboBoxPesquisarCodigo.setSelectedItem(prodGET.getId());

                    
        }
    }//GEN-LAST:event_jTextFieldPesquisarNomeActionPerformed

    private void jButtonPesquisarAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarAtualizarActionPerformed
            if (jTablePesquisar.getSelectedRow() != -1) {

            Produto produto = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            produto.setNome(jTextFieldPesquisarNome.getText());
            produto.setQuantidade(Integer.parseInt(jTextFieldPesquisarQuantidade.getText()));
            produto.setPreco(Double.parseDouble(jTextFieldPesquisarPreco.getText()));
            produto.setId((int) jTablePesquisar.getValueAt(jTablePesquisar.getSelectedRow(), 0));
            //dao.update(p);
            dao.atualizar(produto);

            jTextFieldPesquisarNome.setText("");
            jTextFieldPesquisarQuantidade.setText("");
            jTextFieldPesquisarPreco.setText("");

            //readJTable();
            refresh();

        }
    }//GEN-LAST:event_jButtonPesquisarAtualizarActionPerformed

    private void jButtonPesquisarCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarCadastrarActionPerformed
            ProdutoDAO DAO = new ProdutoDAO();
            Produto produto = new Produto();
            //produto = DAO.buscaPorCodigo((int) jComboBoxPesquisarCodigo.getSelectedItem());                       
            produto.setNome(jTextFieldPesquisarNome.getText());
            String getValueValor = jTextFieldPesquisarPreco.getText();
            double valor = Double.parseDouble(getValueValor);
            produto.setPreco(valor);
            String getValueQuantidade = jTextFieldPesquisarQuantidade.getText();
            int quantidade = Integer.parseInt(getValueQuantidade);
            produto.setQuantidade(quantidade); 
            DAO.inserir(produto);
            JOptionPane.showConfirmDialog(null, 
                "Produto Adicionado com sucesso!", "Mensagem", JOptionPane.DEFAULT_OPTION);
            refresh();
    }//GEN-LAST:event_jButtonPesquisarCadastrarActionPerformed

    private void jButtonAtualisarRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualisarRemoverActionPerformed
        if (jTablePesquisar.getSelectedRow() != -1) {

            Produto produto = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            produto.setId((int) jTablePesquisar.getValueAt(jTablePesquisar.getSelectedRow(), 0));
            
            //dao.delete(p);
            dao.remover(produto);

            jTextFieldPesquisarNome.setText("");
            jTextFieldPesquisarQuantidade.setText("");
            jTextFieldPesquisarPreco.setText("");

            //readJTable();
            refresh();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
    }//GEN-LAST:event_jButtonAtualisarRemoverActionPerformed

    private void jTextFieldlVendasDescontosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldlVendasDescontosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldlVendasDescontosActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    @SuppressWarnings("empty-statement")
    private void jButtonVendasAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendasAdicionarActionPerformed
 
        int ADDquantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade"));

        // insere o Produto na tabela        
        String getValueID = jTextFieldVendasID.getText();
        int valorID = Integer.parseInt(getValueID);
        
        double preco = 0;

        DefaultTableModel modelo = (DefaultTableModel) jTableVendas.getModel();
        modelo.setNumRows(jTableVendas.getRowCount());
        ProdutoDAO pdao = new ProdutoDAO();

        for (Produto produto : pdao.readForId(valorID)) {
            preco = produto.getPreco();
            while (ADDquantidade > produto.getQuantidade()){
                ADDquantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade maior que o estoque, Digite a quantidade"));
            };
            modelo.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                ADDquantidade,
                produto.getPreco()
            });

        }
        
        // Calcula os valores de impostos, totais e descontos
                int descontoselect = descontoSelecionado();
                Desconto d1 = new SemDesconto();
                Desconto d2= new SemDesconto();                
                if (descontoselect == 1){                   
                    d1 = new Desconto_2();
                } else if(descontoselect == 2){
                    d1 = new Desconto_5();
                } else if(descontoselect == 3){
                    d1 = new Desconto_10();
                }            
                d1.setProximo(d2);
                
                int id = 10;
                
                String getValueValor = jTextFieldlVendasValor.getText();
                double valor = preco + Double.parseDouble(getValueValor);
                
		Venda venda = new Venda();

		Produto p1 = new Produto();
		p1.setId(id);
		p1.setPreco(valor);
		venda.adicionarProduto(p1);

		venda.setImposto(new ICMSSP());
		//venda.setImposto(new IPL());
		venda.setDesconto(d1);
                               
		String[] ValoresSeparados = venda.toString().split(";");
                
                
               
        // Insere os valores nos campos Valor, Impostos, Descontos e Valor Total 
            Locale.setDefault(Locale.US);
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");            
            decimalFormat.setRoundingMode(RoundingMode.UP);
            jTextFieldlVendasValor.setText(decimalFormat.format(Double. parseDouble(ValoresSeparados[0])));
            jTextFieldlVendasImpostos.setText(decimalFormat.format(Double. parseDouble(ValoresSeparados[1])));
            jTextFieldlVendasDescontos.setText(decimalFormat.format(Double. parseDouble(ValoresSeparados[2])));
            jTextFieldlVendasTotal.setText(decimalFormat.format(Double. parseDouble(ValoresSeparados[3])));
        
    }//GEN-LAST:event_jButtonVendasAdicionarActionPerformed

    private void jButtonVendasFinalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendasFinalizaActionPerformed
        // Verifica Id de Venda        
        ProdutoDAO DAOId = new ProdutoDAO();        
        Produto produtoid = DAOId.idVenda();  
            int IdVenda = produtoid.getId() + 1;
                //System.out.println(IdVenda);        
        
        int row = jTableVendas.getRowCount();
        
        ProdutoDAO DAO = new ProdutoDAO();
        Produto produto = new Produto();
            //produto = DAO.buscaPorCodigo((int) jComboBoxPesquisarCodigo.getSelectedItem());  
            
            for(int i=0;i<row;i++){        
                    produto.setId(IdVenda); // retorna o valor da celula linha X 0
                    produto.setId_Produto((Integer) jTableVendas.getValueAt(i,0)); // retorna o valor da celula linha X 0
                    produto.setNome(jTableVendas.getValueAt(i,1).toString()); // retorna o valor da celula linha X 0
                    produto.setQuantidade((Integer) jTableVendas.getValueAt(i,2)); // retorna o valor da celula linha X 0
                    produto.setPreco((Double) jTableVendas.getValueAt(i,3)); // retorna o valor da celula linha X 0
                    produto.setDesconto(1); // retorna o valor da celula linha X 0
                    DAO.create(produto);
            }        
            
           JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso!");
            row = 0;
            PreparaNovaVenda();
    }//GEN-LAST:event_jButtonVendasFinalizaActionPerformed

    private void jButtonVendasFinalizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVendasFinalizaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVendasFinalizaMouseClicked

    private void jTextFieldPesquisarPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisarPesquisarActionPerformed

    private void jTablePesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablePesquisarKeyReleased
        if (jTablePesquisar.getSelectedRow() != -1) {
            jTextFieldPesquisarNome.setText(jTablePesquisar.getValueAt(jTablePesquisar.getSelectedRow(), 1).toString());
            jTextFieldPesquisarQuantidade.setText(jTablePesquisar.getValueAt(jTablePesquisar.getSelectedRow(), 2).toString());
            jTextFieldPesquisarPreco.setText(jTablePesquisar.getValueAt(jTablePesquisar.getSelectedRow(), 3).toString());

        }
    }//GEN-LAST:event_jTablePesquisarKeyReleased

    private void jTablePesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePesquisarMouseClicked
        if (jTablePesquisar.getSelectedRow() != -1) {
            jTextFieldPesquisarNome.setText(jTablePesquisar.getValueAt(jTablePesquisar.getSelectedRow(), 1).toString());
            jTextFieldPesquisarQuantidade.setText(jTablePesquisar.getValueAt(jTablePesquisar.getSelectedRow(), 2).toString());
            jTextFieldPesquisarPreco.setText(jTablePesquisar.getValueAt(jTablePesquisar.getSelectedRow(), 3).toString());

        }
    }//GEN-LAST:event_jTablePesquisarMouseClicked

    private void jComboBoxVendasNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVendasNomeActionPerformed
        //String value = jComboBoxVendasNome.getSelectedItem().toString();        
        ProdutoDAO DAO = new ProdutoDAO();        
        Produto produto = DAO.buscaPorNom(jComboBoxVendasNome.getSelectedItem().toString());
                if(jComboBoxVendasNome.getSelectedIndex() != 0)
                    jTextFieldVendasID.setText(Integer.toString(produto.getId()));          
    }//GEN-LAST:event_jComboBoxVendasNomeActionPerformed

    private void jTextFieldlVendasImpostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldlVendasImpostosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldlVendasImpostosActionPerformed

    private void jTextFieldVendasIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVendasIDActionPerformed
        ProdutoDAO DAO = new ProdutoDAO();        
        Produto produto = DAO.buscaPorCodigo(Integer.parseInt(jTextFieldVendasID.getText()));  
                jComboBoxVendasNome.setSelectedItem(produto.getNome());
    }//GEN-LAST:event_jTextFieldVendasIDActionPerformed

    private void jTextFieldVendasIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVendasIDKeyReleased
        ProdutoDAO DAO = new ProdutoDAO();        
        Produto produto = DAO.buscaPorCodigo(Integer.parseInt(jTextFieldVendasID.getText()));        
                jComboBoxVendasNome.setSelectedItem(produto.getNome());
    }//GEN-LAST:event_jTextFieldVendasIDKeyReleased

    private void jButtonVendasCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendasCancelarActionPerformed
            int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog (null, "Tem certeza que deseja cancelar a venda?","Atenção",dialogButton);

            if (dialogButton == JOptionPane.YES_OPTION) {
                    PreparaNovaVenda();
            }        
    }//GEN-LAST:event_jButtonVendasCancelarActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3KeyReleased

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        gravaJTablePorIdVendas(Integer.parseInt(jTextField3.getText()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldlVendasValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldlVendasValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldlVendasValorActionPerformed

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
            java.util.logging.Logger.getLogger(pdvUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pdvUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pdvUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pdvUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pdvUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAtualisarRemover;
    private javax.swing.JButton jButtonBuscasPesquisar;
    private javax.swing.JButton jButtonPesquisarAtualizar;
    private javax.swing.JButton jButtonPesquisarCadastrar;
    private javax.swing.JButton jButtonVendasAdicionar;
    private javax.swing.JButton jButtonVendasCancelar;
    private javax.swing.JButton jButtonVendasFinaliza;
    private javax.swing.JComboBox<String> jComboBoxVendasNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelVendasValor;
    private javax.swing.JLabel jLabellVendasDescontos;
    private javax.swing.JLabel jLabellVendasImpostos;
    private javax.swing.JLabel jLabellVendasTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelBuscas;
    private javax.swing.JPanel jPanelControle;
    private javax.swing.JPanel jPanelVendas;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTablePesquisar;
    private javax.swing.JTable jTableVendas;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldPesquisarNome;
    private javax.swing.JTextField jTextFieldPesquisarPesquisar;
    private javax.swing.JTextField jTextFieldPesquisarPreco;
    private javax.swing.JTextField jTextFieldPesquisarQuantidade;
    private javax.swing.JTextField jTextFieldVendasID;
    private javax.swing.JTextField jTextFieldlVendasDescontos;
    private javax.swing.JTextField jTextFieldlVendasImpostos;
    private javax.swing.JTextField jTextFieldlVendasTotal;
    private javax.swing.JTextField jTextFieldlVendasValor;
    // End of variables declaration//GEN-END:variables
}
