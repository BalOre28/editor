/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package text;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Principal extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> cb_font;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane tp_texto;
    private StyledDocument doc;
    private Style estilo;

    public Principal() {
        initComponents();
        doc = tp_texto.getStyledDocument();
        estilo = tp_texto.addStyle("miEstilo", null);

        DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) cb_font.getModel();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            modelo.addElement(fontName);
        }
        cb_font.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tp_texto = new javax.swing.JTextPane();
        cb_font = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(tp_texto);

        cb_font.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_fontActionPerformed(evt);
            }
        });

        jButton1.setText("Cambiar Color de Texto");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Negrita");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Itálica");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Subrayar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setText("Cambiar Color de Fondo");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setText("Guardar");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jButton7.setText("Abrir");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(cb_font, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        pack();
    }

    private void cb_fontActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedFont = (String) cb_font.getSelectedItem();
        StyleConstants.setFontFamily(estilo, selectedFont);
        doc.setCharacterAttributes(0, doc.getLength(), estilo, false);
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        try {
            StyleConstants.setForeground(estilo,
                    JColorChooser.showDialog(this, "Seleccione Color", Color.red)
            );
            doc.setCharacterAttributes(tp_texto.getSelectionStart(),
                    tp_texto.getSelectionEnd() - tp_texto.getSelectionStart(),
                    tp_texto.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        try {
            StyleConstants.setBold(estilo, true);
            doc.setCharacterAttributes(tp_texto.getSelectionStart(),
                    tp_texto.getSelectionEnd() - tp_texto.getSelectionStart(),
                    tp_texto.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        try {
            StyleConstants.setItalic(estilo, true);
            doc.setCharacterAttributes(tp_texto.getSelectionStart(),
                    tp_texto.getSelectionEnd() - tp_texto.getSelectionStart(),
                    tp_texto.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {
        try {
            StyleConstants.setUnderline(estilo, true);
            doc.setCharacterAttributes(tp_texto.getSelectionStart(),
                    tp_texto.getSelectionEnd() - tp_texto.getSelectionStart(),
                    tp_texto.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {
        try {
            StyleConstants.setBackground(estilo,
                    JColorChooser.showDialog(this, "Seleccione Color", Color.yellow)
            );
            doc.setCharacterAttributes(tp_texto.getSelectionStart(),
                    tp_texto.getSelectionEnd() - tp_texto.getSelectionStart(),
                    tp_texto.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("El Inge Docs", "omf");
        jfc.setFileFilter(filtro);
        int seleccion = jfc.showSaveDialog(this);

        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                File fichero = null;
                if (jfc.getFileFilter().getDescription().equals("El Inge Docs")) {
                    fichero = new File(jfc.getSelectedFile().getPath() + ".omf");
                } else {
                    fichero = jfc.getSelectedFile();
                }

                fw = new FileOutputStream(fichero);
                bw = new ObjectOutputStream(fw);
                Documento d = new Documento(tp_texto, doc, estilo);
                bw.writeObject(d);
                bw.flush();

                JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bw != null) bw.close();
                    if (fw != null) fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {
        File fichero = null;
        FileInputStream entrada = null;
        ObjectInputStream objeto = null;
        try {
            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("El Inge Docs", "omf");
            jfc.setFileFilter(filtro);
            int seleccion = jfc.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fichero = jfc.getSelectedFile();
                entrada = new FileInputStream(fichero);
                objeto = new ObjectInputStream(entrada);
                tp_texto.setText("");
                Documento temp = (Documento) objeto.readObject();
                tp_texto.setText(temp.getPanel().getText());
                tp_texto.setDocument(temp.getDoc());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (objeto != null) {
                    objeto.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
}//fin del main
