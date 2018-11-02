package Modelo;
import Controlador.ControlProceso;
import Vista.VistaPrincipal;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TablaResultado {

    DefaultTableModel modelo2 = new DefaultTableModel();
    ControlProceso d = new ControlProceso();
    Queue<Proceso> cola = new LinkedList<>();
    
    
    public TablaResultado() {

    }

    public void fCFS() {
        
       
        cola = d.getColaProceso();

        if (cola.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor registre procesos", null, 2);

        } else {

            //Al no haber un metodo get en Queue lo pasamos a un Arreglo[]
            Proceso[] cola2 = this.queueToArray(cola);

            // Organizamos en el orden de llegada usando el metodo burbuja
            cola2 = this.sortLlegada(cola2);

            // y lo volvemos a pasar a la Cola ya organizados en el orden requerido
            cola = arrayToQueue(cola2);

            //Calculamos la sumatoria de tiempos
            int limite = this.calculateLimit(cola2);
            
            VistaPrincipal.refreshTR();
            String cabecera[] = new String[limite];

            for (int i = 0; i < limite; i++) {
                cabecera[i] = String.valueOf("       " + i);
            }
            modelo2.setColumnIdentifiers(cabecera);

            String fila[] = new String[limite];

            int n = 0;
            while (n < limite) {

                Proceso element = cola.poll();

                for (int k = 0; k < element.getProceso(); k++) {

                    fila[n] = "       " + element.getNombre();

                    n++;
                }

            }
            modelo2.addRow(fila);
        }
    }
    
    
    public void sRTF() {

        cola = d.getColaProceso();

        if (cola.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor registre procesos", null, 2);

        } else {

            //Al no haber un metodo get en Queue lo pasamos a un Arreglo[]
            Proceso[] cola2 = this.queueToArray(cola);

            // Organizamos en el orden de Proceso/Llegada usando el metodo burbuja           
            cola2 = this.sortLlegada(cola2);

            // Llenamos la cola con los procesos ordenados
            cola = arrayToQueue(cola2);

            //Calculamos la sumatoria de tiempos
            int limite = this.calculateLimit(cola2);

            VistaPrincipal.refreshTR();
            String cabecera[] = new String[limite];

            for (int i = 0; i < limite; i++) {
                cabecera[i] = String.valueOf("       " + i);
            }
            modelo2.setColumnIdentifiers(cabecera);

            String fila2[] = new String[limite];
            int n = 0;
            Proceso element = cola.poll();
            Proceso temp = new Proceso();
            boolean estado = false;

            while (n < limite) {

                if (cola.isEmpty() & element.getProceso() <= 0) {

                    break;

                } else {

                    element.setProceso(element.getProceso() - 1);
                    fila2[n] = "       " + element.getNombre();
                    n++;

                    //Rotamos buscando un proceso igual a n
                    if (element.getProceso() != 0) {
                        int y = 0;
                        while (y < cola.size()) {
                            temp = cola.poll();
                            if (temp.getLlegada() == n) {
                                if (temp.getProceso() < element.getProceso()) {
                                    cola.offer(element);
                                    element = temp;
                                    estado = true;
                                } else {
                                  cola.offer(temp);
                                }                                
                            } 
                                else {
                              cola.offer(temp);
                            }
                            y++;
                            }

                        // Si no consigue llegadas y el proceso de element ==0 entonces Buscamos el mas rapido
                        if (estado == false & element.getProceso() == 0) {

                            element = getElMasRapido(cola);

                        } // SINO BUSCAMOS EL MAS RAPIDO Y SI NO SE CONSIGUE QUE CONTINUE CON EL PROCESO

                                    } else {
                               element = getElMasRapido(cola);
                            }

                        }
                       cola = deleteZeros(cola);
                       estado = false;
                    }

                        modelo2.addRow(fila2);

                }

}

    
    public void roundRobin() {

        int quantum = 0;
        boolean status = false;

        if (d.getColaProceso().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Registre procesos por favor", null, 2);
        } else {

            while (status == false) {
                try {
                    String q = JOptionPane.showInputDialog(null, "Digite el Quantum");
                    quantum = Integer.parseInt(q);
                    status = true;
                    if (quantum <= 0) {
                        quantum = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el Quantum"));
                        status = false;
                        break;
                    }

                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(null, "Digite Numero/Llene la casilla");
                    status = false;
                }

            }
            if (status == true) {

                cola = d.getColaProceso();

                //Al no haber un metodo get en Queue lo pasamos a un Arreglo[]
                Proceso[] cola2 = this.queueToArray(cola);

                // Organizamos en el orden de Proceso/Llegada usando el metodo burbuja           
                cola2 = this.sortLlegada(cola2);

                // Llenamos la cola con los procesos ordenados
                cola = arrayToQueue(cola2);

                //Calculamos la sumatoria de tiempos
                int limite = this.calculateLimit(cola2);

                VistaPrincipal.refreshTR();
                String cabecera[] = new String[limite];

                for (int i = 0; i < limite; i++) {
                    cabecera[i] = String.valueOf("       " + i);
                }

                modelo2.setColumnIdentifiers(cabecera);
                String fila2[] = new String[limite];
                int time = 0;
                Proceso element = cola.poll();

                while (time < limite) {
                    int u = 0;
                    while (u < quantum) {
                        deleteZeros(cola);
                        element.setProceso(element.getProceso() - 1);
                        fila2[time] = String.valueOf("       " + element.getNombre());
                        time++;
                        if (element.getProceso() <= 0) {
                            deleteZeros(cola);
                            break;
                        }
                        u++;
                    }
                    cola.offer(element);
                    element = cola.poll();
                }
                modelo2.addRow(fila2);
            }

        }
    }
    
      
    public void sJF(){
    
      cola = d.getColaProceso();

        if (cola.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor registre procesos", null, 2);

        } else {

            //Al no haber un metodo get en Queue lo pasamos a un Arreglo[]
            Proceso[] cola2 = this.queueToArray(cola);

            // Organizamos en el orden de llegada usando el metodo burbuja
            cola2 = this.sortProceso(cola2);

            // y lo volvemos a pasar a la Cola ya organizados en el orden requerido
            cola = arrayToQueue(cola2);

            //Calculamos la sumatoria de tiempos
            int limite = this.calculateLimit(cola2);
            
            VistaPrincipal.refreshTR();
            String cabecera[] = new String[limite];

            for (int i = 0; i < limite; i++) {
                cabecera[i] = String.valueOf("       " + i);
            }
            modelo2.setColumnIdentifiers(cabecera);

            String fila[] = new String[limite];

            int n = 0;
            while (n < limite) {

                Proceso element = cola.poll();

                for (int k = 0; k < element.getProceso(); k++) {

                    fila[n] = "       " + element.getNombre();

                    n++;
                }

            }
            modelo2.addRow(fila);
        }
    
    }
    
    
   public void prioridad(){
   
     cola = d.getColaProceso();

        if (cola.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor registre procesos", null, 2);

        } else {

         
            Proceso[] cola2 = this.queueToArray(cola);

            cola2 = this.sortPrioridad(cola2);

            cola = arrayToQueue(cola2);        

            //Calculamos la sumatoria de tiempos
            int limite = this.calculateLimit(cola2);
            
            VistaPrincipal.refreshTR();
            String cabecera[] = new String[limite];

            for (int i = 0; i < limite; i++) {
                cabecera[i] = String.valueOf("       " + i);
            }
            modelo2.setColumnIdentifiers(cabecera);

            String fila[] = new String[limite];

            int n = 0;
            while (n < limite) {

                Proceso element = cola.poll();

                for (int k = 0; k < element.getProceso(); k++) {

                    fila[n] = "       " + element.getNombre();

                    n++;
                }

            }
            modelo2.addRow(fila);
        }
   
   
   
   }
    
    
    
    private Proceso[] queueToArray(Queue<Proceso> Queue) {
        
        int tamaño = Queue.size();
        Proceso[] array = new Proceso[tamaño];
        
        for (int i = 0; i < tamaño; i++) {
            
            array[i] = Queue.poll();
            
        }
        
        return array;
    }
    
    
    
    private Proceso[] sortLlegada(Proceso[] obj) {

        for (int i = 0; i < obj.length; i++) {

            for (int j = 0; j < obj.length; j++) {

                if (obj[i].getLlegada() < obj[j].getLlegada()) {

                    Proceso temp = obj[i];
                    obj[i] = obj[j];
                    obj[j] = temp;

                }

            }

        }
        return obj;
    }
    
      private Proceso[] sortPrioridad(Proceso[] obj) {

        for (int i = 0; i < obj.length; i++) {

            for (int j = 0; j < obj.length; j++) {

                if (obj[i].getPrioridad() < obj[j].getPrioridad()) {

                    Proceso temp = obj[i];
                    obj[i] = obj[j];
                    obj[j] = temp;

                }

            }

        }
        return obj;
    }
  
      
      private Proceso[] sortProceso(Proceso[] obj) {

        for (int i = 0; i < obj.length; i++) {

            for (int j = 0; j < obj.length; j++) {

                if (obj[i].getProceso() < obj[j].getProceso()) {

                    Proceso temp = obj[i];
                    obj[i] = obj[j];
                    obj[j] = temp;

                }

            }

        }
        return obj;
    }    

    private int calculateLimit(Proceso[] obj) {
        
        int limite = 0;
        
        for (int i = 0; i < obj.length; i++) {
            limite += obj[i].getProceso();
        }
        return limite;
    }
    
    private Queue<Proceso> deleteZeros(Queue<Proceso> Queue) {
        Proceso element;
        int n = 0;
        while (n < Queue.size()) {

            element = cola.poll();
            if (element.getProceso() <= 0) {

                cola.remove(element);

            } else {

                cola.offer(element);

            }

            n++;
        }

        return Queue;
    }


    
    private Queue<Proceso> arrayToQueue(Proceso [] array){
    
        Queue<Proceso> cola = new LinkedList<>();
        
        for (Proceso proceso : array) {
            
            cola.offer(proceso);
        }
    
    
    return cola;
    }
    
    
    
    
    
    public Proceso getElMasRapido(Queue<Proceso> cola) {

        Proceso element = new Proceso();
        Proceso temp = new Proceso();

        cola = deleteZeros(cola);

        int k = 0;
        element = cola.poll();
        if (!(cola.isEmpty())) {
            while (k < cola.size()) {
                temp = cola.poll();
                if (!(element.getProceso() == temp.getProceso())) {
                    if (element.getProceso() > temp.getProceso()) {
                        cola.offer(element);
                        element = temp;
                    } else {
                        cola.offer(temp);
                    }

                } else {
                    if (element.getLlegada() < temp.getLlegada()) {

                        cola.offer(temp);

                    } else {

                        cola.offer(element);
                        element = temp;

                    }
                }
                k++;
            }
        }

        return element;
    }
    
    
    
    
    
    public DefaultTableModel getModel() {
        return modelo2;
    }

}
