package Modelo;

import Controlador.ControlProceso;
import java.util.ArrayList;
import java.util.Queue;
import javax.swing.table.DefaultTableModel;

public class TablaProceso {

    DefaultTableModel modelo1 = new DefaultTableModel();
    ControlProceso a = new ControlProceso();
    
    public TablaProceso(){
    
       setColumns();
    
    
    }
    
    

   private void setColumns() {

        String cabecera[] = {"Nombre", "Llegada", "Proceso", "Prioridad"};
        modelo1.setColumnIdentifiers(cabecera);
    }

    public  void setData() {

        Queue<Proceso> colaProcess = a.getColaProceso();

        ArrayList<Object[]> objecto = new ArrayList<>();

        for (Proceso proc : colaProcess) {

            objecto.add(new Object[]{proc.getNombre(), proc.getLlegada(), proc.getProceso(), proc.getPrioridad()});

        }

        for (Object[] obj : objecto) {

            modelo1.addRow(obj);

        }

    }

    public DefaultTableModel getModel() {
        return modelo1;
    }

}
