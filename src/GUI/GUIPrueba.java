package GUI;

import Logica.GuerreroStarWars;
import Logica.ListaSimple;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPrueba {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField codigo;
    private JTextField nombre;
    private JComboBox comboBox1;
    private JTextField planetaOrigen;
    private JTextField nivelFuerza;
    private JPanel GUIPrueba;
    private JButton agregarButton;
    private JButton limpiarCamposButton;
    private JTable table1;
    private JButton generarListaButton;
    private JComboBox comboBox2;
    private JButton filtrarButton;
    private JTable table2;
    private JButton ordenarButton;
    private ListaSimple listaSimple = new ListaSimple();
    private ListaSimple listaFiltrada = new ListaSimple();
    private GuerreroStarWars guerreroStarWars = null;

    public GUIPrueba() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(listaSimple.buscarLineal(Integer.parseInt(codigo.getText())) != -1) {

                    JOptionPane.showMessageDialog(null, "Ya existe ese pana");
                }else{

                    guerreroStarWars = new GuerreroStarWars(Integer.parseInt(codigo.getText()), nombre.getText(), comboBox1.getSelectedItem().toString(), planetaOrigen.getText(), Integer.parseInt(nivelFuerza.getText()));
                    listaSimple.addElement(guerreroStarWars);
                    JOptionPane.showMessageDialog(null, "Guerrero agregado con exito");
                }

            }
        });

        limpiarCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                codigo.setText("");
                nombre.setText("");
                planetaOrigen.setText("");
                nivelFuerza.setText("");
            }

        });
        generarListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listaSimple.mostrarElementos(table1);
            }
        });

        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listaFiltrada = listaSimple.filtrarLista(comboBox2.getSelectedItem().toString());
                listaFiltrada.mostrarElementos(table2);
            }
        });

        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listaFiltrada.ordenar();
                listaFiltrada.mostrarElementos(table2);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIPrueba");
        frame.setContentPane(new GUIPrueba().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
