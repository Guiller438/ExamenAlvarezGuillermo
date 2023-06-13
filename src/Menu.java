import javax.swing.*;
import java.util.ArrayList;

public class Menu {

    ArrayList<Plato> menu = new ArrayList<>();
    public void datosPredefinidos(){
        menu.add(new Plato("Milanesa", 500, 1000, 30));
        menu.add(new Plato("Pizza", 400, 800, 20));
        menu.add(new Plato("Hamburguesa", 300, 600, 15));
        menu.add(new Plato("Ensalada", 200, 400, 10));
        menu.add(new Plato("Sopa", 100, 200, 5));
    }

    public void agregarPlato(Plato plato){
        if (buscarPlato(plato.getNombre()) == null) {
            menu.add(plato);
        }
    }

    public void eliminarPlato(Plato plato){
        for(Plato plato1 : menu){
            if(plato1.getNombre().equals(plato.getNombre())){
                menu.remove(plato1);
            }
        }
    }
    public Plato buscarPlato(String nombre){
        for (Plato plato : menu) {
            if (plato.getNombre().equals(nombre)) {
                return plato;
            }
        }
        return null;
    }
    public void modificarPlato(Plato plato, String nombre, int precio, int calorias, int tiempoPreparacion){
        plato.setNombre(nombre);
        plato.setPrecio(precio);
        plato.setCalorias(calorias);
        plato.setTiempoPreparacion(tiempoPreparacion);
    }
    public ArrayList<Plato> getMenu() {
        return menu;
    }

    public void imprimirMenu(JTextArea textArea){
        textArea.setText("");
        for (Plato plato : menu) {
            textArea.append(plato.toString() + "\n");
        }
    }
    @Override
    public String toString() {
        return "Menu{" +
                "menu=" + menu +
                '}';
    }
}
