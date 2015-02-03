/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genericmainprogram;
/**
 *
 * @author Evilasio
 */

//Importações mínimas necessaária
import java.io.*;
import webservice.WSFuncs;
import webservice.Webservice;
//Importações específicas da alicação
//Ex.: import java.util.Scanner

public class GenericMainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //Features (Services) 
        Webservice service = new Webservice();
        
        //Base fetures utilizing file
        File Services = new File("Services.xml"); //FilewithMainServices
       
        //Weservices functions
        WSFuncs funcs = new WSFuncs();
        
        //Graphic Interface
        GenericView view = new GenericView();
        
        //Specific variables
        String stop = ""; 
        
        //File used for Stop Criteria of the Adapter
        File sf = new File("StopFile.txt");
        sf.createNewFile();
        try{       
            BufferedWriter out = new BufferedWriter(new FileWriter(sf));
            out.write("");  
            out.flush();
            out.close();
        }catch (IOException e){}
        
        //Executing Adapter
        String[] commands = {"","",""};
        commands[0] = "java";
        commands[1] = "-jar";
        commands[2] = ""; //Path od the GenericAdapterProgram.jar 
        Process p  = Runtime.getRuntime().exec(commands);
        
        while(!stop.equals("something")) // Loop of executing
        {
            
            //Graphic Interface and input for variable that test to stop criteria
            stop = view.WriteinScreen();
            
            if(stop.equals("something"))
                continue;           
            
            /*
             * Method 1: Initialize the service for sockets
             */
            
            /*view.update();*/
             
            /*
             * Method 2: Initialize the service with informations of within a service this list in a file 
             */ 
            service = funcs.SearchServiceByID(stop,Services);
            
            /*
             * Executing the feature utilizing method 1 or 2
             */
            if(service!=null){
                if(service.getarguments().size() > 0)
                    funcs.fService(service, service.getarguments().toArray(new String[service.getarguments().size()]));
                else
                    funcs.fService(service, service.getarguments().toArray(new String[service.getarguments().size()])); 
            }
            else
                System.out.printf("service not exist, choice other service.\n");
            /*
             * Método 3: Execute all the services in a file 
             */
            //funcs.funcAllServicesXML(//"",/*(argumento 1)*/ "", /*(argumento 2)*/ 
            //                      Services.getAbsolutePath());
            
        }
        //Stop Criteria of the Adapter
        try{       
            BufferedWriter out = new BufferedWriter(new FileWriter(sf));
            out.write("stop");  
            out.close();
        }catch (IOException e){}
    }
}
