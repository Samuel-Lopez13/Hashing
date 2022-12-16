/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hashing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import hashing.MyButton;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Hash extends javax.swing.JFrame {

    //la posicion de la flecha en y
    private int y = 260;

    //es el tiempo que se le dara a las animaciones
    private int tiempo = 200;

    //para colorear la tabla
    private DisenoTabla dt = new DisenoTabla(1);

    //arreglo 1 es el llenado por el usuario
    public static ArrayList<String> datos = new ArrayList<String>();
    //arreglo 2 es llenado con -1
    public static ArrayList<String> valores = new ArrayList<String>();

    public static DefaultTableModel modeloTabla;

    public Hash() {
        setUndecorated(true);
        initComponents();
        setSize(600, 700);
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        modeloTabla = new DefaultTableModel();
        modeloTabla = (DefaultTableModel) tabla.getModel();
        tabla.setDefaultRenderer(Object.class, dt);

        //para diseñar la cabecera de la tabla
        JTableHeader th;
        th = tabla.getTableHeader();
        Font fuente = new Font("Arial", Font.BOLD, 20);
        th.setFont(fuente);
        th.setForeground(Color.WHITE);
        th.setBackground(new Color(8, 78, 199));
        th.setPreferredSize(new Dimension(getWidth(), 60));

        //los componentes deben iniciarse invisibles
        flecha.setVisible(false);
        son.setVisible(false);
    }

    public void LlenadoValores() {
        //se llena el arreglo de valores con -1
        for (int i = 0; i < datos.size(); i++) {
            valores.add("-1");
        }
    }

    //aqui inicia la funcion Hash
    public void funcion() {
        Thread hilo = new Thread() {
            @Override
            public void run() {
                //recorrera un bucle dependiendo del tamano del arreglo
                for (int i = 0; i < datos.size(); i++) {
                    //obtine el elemento
                    String elemento = datos.get(i);
                    //y se le saca el modulo
                    int indiceArreglo = Integer.parseInt(elemento) % datos.size();
                    try {
                        operacion1.setText(elemento + " % " + datos.size());
                        sleep(tiempo);
                        resultado.setText(indiceArreglo + "");
                        sleep(tiempo);
                        //para esto se usa el llenado de otro arreglo
                        //por si no tiene otra cosa que no sea -1 quiere decir que
                        //Esta ocupado
                        while (valores.get(indiceArreglo) != "-1") {
                            for (int j = 0; j < indiceArreglo; j++) {
                                y += 40;
                            }
                            flecha.setLocation(flecha.getX(), y);
                            flecha.setVisible(true);
                            son.setIcon(new ImageIcon("src/img/x.png"));
                            son.setVisible(true);
                            sleep(tiempo);
                            son.setVisible(false);
                            flecha.setVisible(false);
                            //entrara y se sumara uno al indice
                            indiceArreglo++;
                            //este es para si llega al limite del tamano el indice
                            //regrese a 0
                            indiceArreglo %= datos.size();
                            resultado.setText(indiceArreglo + "");
                            sleep(tiempo);
                            y = 260;
                        }
                        //si encuentra uno vacio se guardara en el arreglo
                        //llenado con -1
                        valores.set(indiceArreglo, elemento);
                        for (int j = 0; j < indiceArreglo; j++) {
                            y += 40;
                        }
                        flecha.setLocation(flecha.getX(), y);
                        flecha.setVisible(true);
                        son.setIcon(new ImageIcon("src/img/s.png"));
                        son.setVisible(true);
                        sleep(tiempo);
                        modeloTabla.setValueAt(indiceArreglo, indiceArreglo, 0);
                        modeloTabla.setValueAt(elemento, indiceArreglo, 1);
                        repaint();
                        resultado.setText("");
                        operacion1.setText("");
                        flecha.setVisible(false);
                        son.setVisible(false);
                        y = 260;
                        sleep(tiempo);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        hilo.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        agregar = new javax.swing.JTextField();
        cadena = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        flecha = new javax.swing.JLabel();
        operacion1 = new javax.swing.JLabel();
        resultado = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        aceptar = new hashing.MyButton();
        btnBuscar = new hashing.MyButton();
        ejecutar = new hashing.MyButton();
        son = new javax.swing.JLabel();
        reset = new hashing.MyButton();
        panelNuevo1 = new hashing.panelNuevo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(13, 9, 117));
        jPanel1.setLayout(null);

        agregar.setBackground(new java.awt.Color(226, 224, 209));
        agregar.setForeground(new java.awt.Color(102, 102, 102));
        agregar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        agregar.setText("Ingresar Valor");
        agregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                agregarMousePressed(evt);
            }
        });
        agregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                agregarKeyPressed(evt);
            }
        });
        jPanel1.add(agregar);
        agregar.setBounds(125, 50, 160, 35);

        cadena.setBackground(new java.awt.Color(255, 244, 153));
        cadena.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cadena.setForeground(new java.awt.Color(13, 9, 117));
        cadena.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cadena.setOpaque(true);
        jPanel1.add(cadena);
        cadena.setBounds(30, 130, 270, 40);

        tabla.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Indice", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setFocusable(false);
        tabla.setRowHeight(40);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 200, 270, 480);

        flecha.setBackground(new java.awt.Color(255, 255, 0));
        flecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha.png"))); // NOI18N
        flecha.setOpaque(true);
        jPanel1.add(flecha);
        flecha.setBounds(300, 260, 80, 40);

        operacion1.setBackground(new java.awt.Color(13, 9, 117));
        operacion1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        operacion1.setForeground(new java.awt.Color(255, 255, 255));
        operacion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        operacion1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        operacion1.setOpaque(true);
        jPanel1.add(operacion1);
        operacion1.setBounds(390, 240, 136, 73);

        resultado.setBackground(new java.awt.Color(13, 9, 117));
        resultado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        resultado.setForeground(new java.awt.Color(255, 255, 255));
        resultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        resultado.setOpaque(true);
        jPanel1.add(resultado);
        resultado.setBounds(390, 330, 136, 73);

        buscar.setBackground(new java.awt.Color(226, 224, 209));
        buscar.setForeground(new java.awt.Color(102, 102, 102));
        buscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscar.setText("Ingresar Valor");
        buscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buscarMousePressed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
            }
        });
        jPanel1.add(buscar);
        buscar.setBounds(310, 50, 160, 35);

        aceptar.setBackground(new java.awt.Color(253, 254, 97));
        aceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        aceptar.setForeground(new java.awt.Color(8, 78, 199));
        aceptar.setText("Aceptar");
        aceptar.setBorderPainted(false);
        aceptar.setFocusable(false);
        aceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        aceptar.setRadius(30);
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        jPanel1.add(aceptar);
        aceptar.setBounds(25, 25, 80, 80);

        btnBuscar.setBackground(new java.awt.Color(253, 254, 97));
        btnBuscar.setForeground(new java.awt.Color(8, 78, 199));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorderPainted(false);
        btnBuscar.setFocusable(false);
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setRadius(30);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(490, 25, 80, 80);
        btnBuscar.getAccessibleContext().setAccessibleDescription("");

        ejecutar.setBackground(new java.awt.Color(253, 254, 97));
        ejecutar.setForeground(new java.awt.Color(8, 78, 199));
        ejecutar.setText("Ejecutar");
        ejecutar.setBorderPainted(false);
        ejecutar.setFocusable(false);
        ejecutar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ejecutar.setRadius(30);
        ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarActionPerformed(evt);
            }
        });
        jPanel1.add(ejecutar);
        ejecutar.setBounds(360, 110, 200, 80);

        son.setBackground(new java.awt.Color(255, 204, 102));
        son.setOpaque(true);
        jPanel1.add(son);
        son.setBounds(430, 420, 60, 60);

        reset.setBackground(new java.awt.Color(253, 254, 97));
        reset.setForeground(new java.awt.Color(8, 78, 199));
        reset.setText("Reset");
        reset.setToolTipText("");
        reset.setBorderPainted(false);
        reset.setFocusPainted(false);
        reset.setFocusable(false);
        reset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reset.setRadius(30);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset);
        reset.setBounds(480, 650, 100, 40);

        javax.swing.GroupLayout panelNuevo1Layout = new javax.swing.GroupLayout(panelNuevo1);
        panelNuevo1.setLayout(panelNuevo1Layout);
        panelNuevo1Layout.setHorizontalGroup(
            panelNuevo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        panelNuevo1Layout.setVerticalGroup(
            panelNuevo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        jPanel1.add(panelNuevo1);
        panelNuevo1.setBounds(0, 0, 750, 800);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static boolean activado = false;

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        datos.add(agregar.getText());
        String arregloC = "";
        for (String dato : datos) {
            arregloC += dato + " ";
        }
        cadena.setText(arregloC);
    }//GEN-LAST:event_aceptarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Thread hilo = new Thread() {
            @Override
            public void run() {
                int limite = datos.size();
                int contador = 0;
                boolean bandera = true;
                //el elemento buscado
                String elemento = buscar.getText();
                //Se le sacara su modulo
                int indiceArreglo = Integer.parseInt(elemento) % datos.size();
                try {
                    operacion1.setText(elemento + " % " + datos.size());
                    sleep(tiempo);
                    resultado.setText(indiceArreglo + "");
                    sleep(tiempo);
                    //si el elemento no es el del indice pasara al siguiente
                    while (!elemento.equals(tabla.getValueAt(indiceArreglo, 1).toString())) {
                        for (int j = 0; j < indiceArreglo; j++) {
                            y += 40;
                        }
                        flecha.setLocation(flecha.getX(), y);
                        flecha.setVisible(true);
                        son.setIcon(new ImageIcon("src/img/x.png"));
                        son.setVisible(true);
                        sleep(tiempo);
                        son.setVisible(false);
                        flecha.setVisible(false);
                        sleep(tiempo);
                        //se sumara´+1 al indice
                        indiceArreglo++;
                        //si se pasa regresara a 0
                        indiceArreglo %= datos.size();
                        resultado.setText(indiceArreglo + "");
                        sleep(tiempo);
                        y = 260;
                        contador++;
                        //Si supera el limite de datos, quiere decir que no existe
                        if (contador == limite) {
                            bandera = false;
                            JOptionPane.showMessageDialog(null, "No se encontro");
                            break;
                        }
                    }
                    if (bandera) {
                        for (int j = 0; j < indiceArreglo; j++) {
                            y += 40;
                        }
                        flecha.setLocation(flecha.getX(), y);
                        flecha.setVisible(true);
                        son.setIcon(new ImageIcon("src/img/s.png"));
                        son.setVisible(true);
                        sleep(tiempo);
                        activado = true;
                        repaint();
                        flecha.setVisible(false);
                        son.setVisible(false);
                        y = 260;
                        sleep(tiempo);
                    }
                } catch (InterruptedException ex) {
                }
            }
        };
        hilo.start();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarActionPerformed
        LlenadoValores();
        String[] valorFalso = {null, null};
        System.out.println(datos.size());
        for (int i = 0; i < datos.size(); i++) {
            modeloTabla.addRow(valorFalso);
        }
        aceptar.setColorClick(new Color(253, 254, 97));
        aceptar.setEnabled(false);
        agregar.setEnabled(false);
        funcion();
        ejecutar.setColorClick(new Color(253, 254, 97));
        ejecutar.setEnabled(false);
    }//GEN-LAST:event_ejecutarActionPerformed

    private void agregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMousePressed
        buscar.setText("Ingresar Valor");
        buscar.setForeground(new Color(102, 102, 102));
        agregar.setText("");
        agregar.setForeground(Color.BLACK);
    }//GEN-LAST:event_agregarMousePressed

    private void buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMousePressed
        activado = false;
        modeloTabla.fireTableDataChanged();
        agregar.setText("Ingresar Valor");
        agregar.setForeground(new Color(102, 102, 102));
        buscar.setText("");
        buscar.setForeground(Color.BLACK);
    }//GEN-LAST:event_buscarMousePressed

    private void agregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_agregarKeyPressed
        if (evt.getKeyCode() == VK_ENTER) {
            datos.add(agregar.getText());
            String arregloC = "";
            for (String dato : datos) {
                arregloC += dato + " ";
            }
            cadena.setText(arregloC);
            agregar.setText("");
        }
    }//GEN-LAST:event_agregarKeyPressed

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        
    }//GEN-LAST:event_buscarKeyPressed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        agregar.setText("Ingresar Valor");
        buscar.setText("Ingresar Valor");
        cadena.setText("");
        operacion1.setText("");
        resultado.setText("");
        aceptar.setColorClick(new Color(255, 255, 0));
        aceptar.setEnabled(true);
        agregar.setEnabled(true);
        ejecutar.setColorClick(new Color(255, 255, 0));
        ejecutar.setEnabled(true);
        clearTable();
        datos = new ArrayList<String>();
        valores = new ArrayList<String>();
    }//GEN-LAST:event_resetActionPerformed

    private void clearTable() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i -= 1;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hashing.MyButton aceptar;
    private javax.swing.JTextField agregar;
    private hashing.MyButton btnBuscar;
    public static javax.swing.JTextField buscar;
    private javax.swing.JLabel cadena;
    private hashing.MyButton ejecutar;
    private javax.swing.JLabel flecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel operacion1;
    private hashing.panelNuevo panelNuevo1;
    private hashing.MyButton reset;
    private javax.swing.JLabel resultado;
    private javax.swing.JLabel son;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
