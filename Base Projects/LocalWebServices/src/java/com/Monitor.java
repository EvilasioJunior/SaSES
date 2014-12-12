/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

//Importações necesárias
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Evilasio
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Monitor {
   @WebMethod
    public String funcService(String arquivoalanilse){      
       /*
        * Declare as variáveis específicas de seu monitor
        */
       
       /*
        * Adicione a lógica específica de seu monitor
        */
        
        return "";
    }
}
