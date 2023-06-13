import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame {
    int contador = 0;

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textIngresoNombre;
    private JButton ingresarPlatoButton;
    private JTextArea textAIngresoPlatos;
    private JButton QuemarDatosButton;
    private JTextField textIngresoPrecio;
    private JTextField textIngresoCalorias;
    private JTextField textIngresoPreparacion;
    private JButton buscarModifButton;
    private JButton modificarModifButton;
    private JTextField textoModifNombre;
    private JTextField textoModifPrecio;
    private JTextField textoModifCalorias;
    private JTextField textoModifPreparacion;
    private JTextArea textAModif;
    private JButton ButtonBuscarEliminar;
    private JTextField textNombreEliminar;
    private JTextArea textAEliminar;
    private JButton eliminarButton;
    private JComboBox comboBoxOrder;
    private JButton mostrarButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
    private JTextField textBuscarPlatoOrden;

    public mainForm() {

        Menu menu = new Menu();
        Ordenamiento ordenamiento = new Ordenamiento();
        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plato plato = new Plato(textIngresoNombre.getText(), Integer.parseInt(textIngresoPrecio.getText()),
                        Integer.parseInt(textIngresoCalorias.getText()), Integer.parseInt(textIngresoPreparacion.getText()));
                if(plato.getNombre().equals("") || plato.getPrecio() == 0 || plato.getCalorias() == 0 || plato.getTiempoPreparacion() == 0){
                    JOptionPane.showMessageDialog(null, "No se puede ingresar un plato con campos vacios");
                }else{
                    menu.agregarPlato(plato);
                    JOptionPane.showMessageDialog(null, "Plato ingresado correctamente");
                    menu.imprimirMenu(textAIngresoPlatos);
                }
            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.datosPredefinidos();
                menu.imprimirMenu(textAIngresoPlatos);
            }
        });
        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textoModifNombre.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "No se puede buscar un plato con el campo vacio");
                }else{
                    if(menu.buscarPlato(textoModifNombre.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "No se encontro el plato");
                    }else{
                        textoModifNombre.setText(menu.buscarPlato(textoModifNombre.getText()).getNombre());
                        textoModifPrecio.setText(String.valueOf(menu.buscarPlato(textoModifNombre.getText()).getPrecio()));
                        textoModifPreparacion.setText(String.valueOf(menu.buscarPlato(textoModifNombre.getText()).getTiempoPreparacion()));
                        textoModifCalorias.setText(String.valueOf(menu.buscarPlato(textoModifNombre.getText()).getCalorias()));
                        textoModifPrecio.setEditable(true);
                        textoModifPreparacion.setEditable(true);
                        textoModifCalorias.setEditable(true);
                    }
                }
            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //modificar plato
                if(textoModifNombre.getText().equals("") || textoModifPrecio.getText().equals("") ||
                        textoModifPreparacion.getText().equals("") || textoModifCalorias.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "No se puede modificar un plato con campos vacios");
                }else{
                    menu.modificarPlato(menu.buscarPlato(textoModifNombre.getText()), textoModifNombre.getText(),
                            Integer.parseInt(textoModifPrecio.getText()), Integer.parseInt(textoModifCalorias.getText()),
                            Integer.parseInt(textoModifPreparacion.getText()));
                    JOptionPane.showMessageDialog(null, "Plato modificado correctamente");
                }
            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textNombreEliminar.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "No se puede buscar un plato con el campo vacio");
                }else{
                    if(menu.buscarPlato(textNombreEliminar.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "No se encontro el plato");
                    }else{
                        textNombreEliminar.setText(menu.buscarPlato(textNombreEliminar.getText()).getNombre());
                        textAEliminar.setText(String.valueOf(menu.buscarPlato(textNombreEliminar.getText()).getPrecio()));
                    }
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textNombreEliminar.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar un plato con el campo vacio");
                }else{
                    menu.eliminarPlato(menu.buscarPlato(textNombreEliminar.getText()));
                    JOptionPane.showMessageDialog(null, "Plato eliminado correctamente");
                }
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                if(comboBoxOrder.getSelectedItem().equals("Nombre")){
                    ordenamiento.ordenarPorNombre(menu.getMenu());
                    ordenamiento.mostrarPlatos(menu.getMenu(), textAMostrar);
                }else if(comboBoxOrder.getSelectedItem().equals("Precio")){
                    ordenamiento.ordenarPorPrecio(menu.getMenu());
                    ordenamiento.mostrarPlatos(menu.getMenu(), textAMostrar);
                }else if(comboBoxOrder.getSelectedItem().equals("Calorias")){
                    ordenamiento.ordenarPorCalorias(menu.getMenu());
                    ordenamiento.mostrarPlatos(menu.getMenu(), textAMostrar);
                }else if(comboBoxOrder.getSelectedItem().equals("Tiempo de preparacion")){
                    ordenamiento.ordenarPorTiempoPreparacion(menu.getMenu());
                    ordenamiento.mostrarPlatos(menu.getMenu(), textAMostrar);
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contador !=0 && !textBuscarPlatoOrden.getText().equals("")){
                    menu.buscarPlato(textBuscarPlatoOrden.getText());
                    JOptionPane.showMessageDialog(null, "Plato encontrado");
                    textAMostrar.setText(menu.buscarPlato(textBuscarPlatoOrden.getText()).toString());
                }else if(contador == 0){
                    JOptionPane.showMessageDialog(null, "No se puede buscar un plato sin haber ordenado primero");
                }else{
                    JOptionPane.showMessageDialog(null, "No se puede buscar un plato con el campo vacio");
                }
            }
        });

    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
