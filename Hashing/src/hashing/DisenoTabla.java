/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashing;

import static hashing.Hash.datos;
import static hashing.Hash.valores;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

public class DisenoTabla extends DefaultTableCellRenderer {

    int columna;

    public DisenoTabla(int Colpatron) {
        this.columna = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        table.setForeground(Color.black);
        table.setBackground(Color.WHITE);
        setHorizontalAlignment(CENTER);
        Border b = BorderFactory.createCompoundBorder();
        b = BorderFactory.createCompoundBorder(b, BorderFactory.createMatteBorder(2,2,2,2,Color.BLUE));
        
        table.setBorder(b);
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);

        if (Hash.activado) {
            String elemento = Hash.buscar.getText();

            if (table.getValueAt(row, columna).equals(elemento)) {
                setBackground(Color.green);
            } else {
                setBackground(Color.white);
            }
        }
        return this;
    }

}
