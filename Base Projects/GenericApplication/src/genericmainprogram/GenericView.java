/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genericmainprogram;

//Importações básicas necessárias
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Evilasio
 */

public class GenericView {
    
    //Webservice wService = new Webservice();
    
    public GenericView(){}
    
    /*public void atualizar(){
        try{ 
         this.wService.initializerBySocket(<Port>); 
        }catch(Exception e){}
    }*/
    
    public String WriteinScreen(){
        String stop = "";
        Scanner in = new Scanner(System.in);
        
        System.out.printf("Print on the screen what you want the customer to see\n");

        stop = in.nextLine();
    
        return stop;
    }
}
