import javax.swing.*;
import java.util.ArrayList;

public class Ordenamiento {

    public void mostrarPlatos(ArrayList<Plato> platos, JTextArea textAMostrar){
        textAMostrar.setText("");
        for (Plato plato : platos) {
            textAMostrar.append(plato.toString() + "\n");
        }
    }
    public void ordenarPorNombre(ArrayList<Plato> platos){
        for (int i = 0; i < platos.size() - 1; i++) {
            for (int j = 0; j < platos.size() - i - 1; j++) {
                if (platos.get(j + 1).getNombre().compareTo(platos.get(j).getNombre()) < 0) {
                    Plato aux = platos.get(j + 1);
                    platos.set(j + 1, platos.get(j));
                    platos.set(j, aux);
                }
            }
        }
    }
    public void ordenarPorPrecio(ArrayList<Plato> platos){
        for (int i = 0; i < platos.size() - 1; i++) {
            for (int j = 0; j < platos.size() - i - 1; j++) {
                if (platos.get(j + 1).getPrecio() < platos.get(j).getPrecio()) {
                    Plato aux = platos.get(j + 1);
                    platos.set(j + 1, platos.get(j));
                    platos.set(j, aux);
                }
            }
        }
    }
    public void ordenarPorCalorias(ArrayList<Plato> platos){
        for (int i = 1; i < platos.size(); i++) {
            Plato aux = platos.get(i);
            int j = i - 1;
            while (j >= 0 && platos.get(j).getCalorias() > aux.getCalorias()) {
                platos.set(j + 1, platos.get(j));
                j--;
            }
            platos.set(j + 1, aux);
        }
    }
    public void ordenarPorTiempoPreparacion(ArrayList<Plato> platos){
        for (int i = 1; i < platos.size(); i++) {
            Plato aux = platos.get(i);
            int j = i - 1;
            while (j >= 0 && platos.get(j).getTiempoPreparacion() > aux.getTiempoPreparacion()) {
                platos.set(j + 1, platos.get(j));
                j--;
            }
            platos.set(j + 1, aux);
        }
    }

}
