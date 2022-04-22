/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.controltec;

import com.mycompany.controltec.entidades.Componentes;
import com.mycompany.controltec.entidades.Maquina;
import com.mycompany.controltec.entidades.UsoDeMaquinas;
import com.mycompany.controltec.entidades.Usuario;
import com.mycompany.controltec.jdbc.Conexao;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Lenovo
 */
public class TelaDeLogin extends javax.swing.JFrame {

    Conexao conexao = new Conexao();
    JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());

    /**
     * Creates new form TelaDeLogin
     */
    public TelaDeLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagensFundo = new javax.swing.JLabel();
        lblRA = new javax.swing.JFormattedTextField();
        btnEntrar = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        nameRA = new javax.swing.JLabel();
        nameSENHA = new javax.swing.JLabel();
        labelEmpresa = new javax.swing.JLabel();
        campoEsqueciSenha = new java.awt.Checkbox();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela De Login");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(500, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        lblRA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblRAActionPerformed(evt);
            }
        });
        getContentPane().add(lblRA);
        lblRA.setBounds(200, 90, 120, 20);

        btnEntrar.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrar.setForeground(new java.awt.Color(0, 0, 0));
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(190, 200, 70, 21);

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setForeground(new java.awt.Color(0, 0, 0));
        btnExit.setText("Exit");
        btnExit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(270, 200, 70, 21);

        nameRA.setBackground(new java.awt.Color(255, 255, 255));
        nameRA.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nameRA.setForeground(new java.awt.Color(255, 255, 255));
        nameRA.setText("RA:");
        getContentPane().add(nameRA);
        nameRA.setBounds(200, 70, 30, 16);

        nameSENHA.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nameSENHA.setForeground(new java.awt.Color(255, 255, 255));
        nameSENHA.setText("SENHA:");
        getContentPane().add(nameSENHA);
        nameSENHA.setBounds(200, 120, 60, 16);

        labelEmpresa.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        labelEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        labelEmpresa.setText("Control Tec - Faça seu Login");
        getContentPane().add(labelEmpresa);
        labelEmpresa.setBounds(100, 0, 300, 50);

        campoEsqueciSenha.setBackground(new java.awt.Color(0, 0, 51));
        campoEsqueciSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoEsqueciSenha.setForeground(new java.awt.Color(255, 255, 255));
        campoEsqueciSenha.setLabel("Esqueceu sua senha?");
        campoEsqueciSenha.setState(true);
        getContentPane().add(campoEsqueciSenha);
        campoEsqueciSenha.setBounds(200, 170, 140, 20);

        jPasswordField1.setText("jPasswordField1");
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(200, 140, 120, 19);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:

        String ra = lblRA.getText();
        String senha = lblSenha.getText();
        Maquina maquina = new Maquina();
        //maquina.informacoesMaquina();
        Long idMaquina = 0L;
        Integer contador = 0;

        List<Usuario> listaDeUsuarios = con.query("select * from dbo.Usuario where email = '" + ra + "' "
                + "AND senha = '" + senha + "';",
                new BeanPropertyRowMapper(Usuario.class));

        List<Maquina> listaDeMaquinas = con.query("select * from dbo.Maquina ",
                new BeanPropertyRowMapper(Maquina.class));

        System.out.println(listaDeMaquinas);

        for (Maquina maquinas : listaDeMaquinas) {
            idMaquina = maquinas.getIdMaquina();
        }
        System.out.println(idMaquina);

        List<Componentes> listaDeComponentes = con.query("select * from dbo.Componentes where fkMaquina = '" + idMaquina + "'; ",
                new BeanPropertyRowMapper(Componentes.class));

        listaDeComponentes.forEach(x -> System.out.println(x.getIdComponente()));

        if (listaDeUsuarios.isEmpty()) {
            System.out.println("Erro");
        } else {
            System.out.println("Logado com sucesso");
//            listaDeUsuarios.forEach(usuario -> System.out.println(usuario));
//            listaDeComponentes.forEach(componentes -> System.out.println(componentes));
//            listaDeMaquinas.forEach(maquinas -> System.out.println(maquinas));

            UsoDeMaquinas udm = new UsoDeMaquinas();
            try {
                while (true) {
                    for (Componentes componente : listaDeComponentes) {
                        udm.capturarDados(listaDeUsuarios.get(0), componente);
                        
                    }
                    Thread.sleep(200L);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void lblRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblRAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRAActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnExit;
    private java.awt.Checkbox campoEsqueciSenha;
    private javax.swing.JLabel imagensFundo;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel labelEmpresa;
    private javax.swing.JFormattedTextField lblRA;
    private javax.swing.JLabel nameRA;
    private javax.swing.JLabel nameSENHA;
    // End of variables declaration//GEN-END:variables
}
