/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

//Importações necesárias
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author Evilasio
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Planejador {
   @WebMethod
    public String funcService(String arquivoalanilse){
       //declarações base 
       String sDestino = "Path\\Servicos.txt"; //endreço do arquivo Servicos.txt do Programa Principal (Ver GenericMainProgram)
              
       /*
        * Declare as variáveis específicas de seu planejador
        */
       
       /*
        * Adicione a lógica específica de seu planejador
        */
        
       //Informar webservice(s) que a aplicação deve utilizar
        try{
        //Com arquivo
        BufferedWriter out = new BufferedWriter(new FileWriter(sDestino));
        out.write("TargetNamespace"); out.newLine();
        out.write("Name"); out.newLine();
        out.write("url"); out.newLine();
        out.write("Port"); out.newLine();
        out.write("Argumentos"); out.newLine(); //caso opite por gravar os argumentos do serviço no arquivo
        out.close();
            
        //via socket
        //Socket cliente = new Socket("", 12345/*Tem de ser a mesma porta usada no GenericMai Program*/);
        //PrintStream saida = new PrintStream(cliente1.getOutputStream());
        //saida.println("targetName;Name;url;Port");
        //saida.close();
        //cliente.close();
        }catch(IOException e){
        
        }
        return "";
    }
}