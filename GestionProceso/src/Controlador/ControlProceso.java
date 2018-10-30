
package Controlador;

import Modelo.Proceso;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.Queue;




public class ControlProceso {    
    
    private static Queue<Proceso> colaProceso = new LinkedList<Proceso>();    

    public Queue<Proceso> getColaProceso() {
        return colaProceso;
    }

    public void setColaProceso(Queue<Proceso> colaProceso) {
        ControlProceso.colaProceso = colaProceso;
    }
   
    
      public void llenar(){

        try{            
         FileInputStream filein = new FileInputStream("data1.txt"); 
   
         
            try{                
                 ObjectInputStream objin = new ObjectInputStream(filein); 
                 
                try{                    
                  
                      colaProceso = (Queue<Proceso>) objin.readObject();
                }catch(ClassNotFoundException e){}
            }catch(IOException e){}
        }catch(FileNotFoundException e){}
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
