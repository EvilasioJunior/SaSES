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
    
    public GenericView(){}
    
    // Informações na tela e entrada de dados do teclado
    public String WriteinScreen(){
        String stop = "";
        Scanner entrada = new Scanner(System.in);
        
        //Imprima na tela oq ue você quer que o cliente veja
        System.out.printf("Imprima na tela o que você quer que o cliente veja\n");

        //Recebe dados do teclado que representa um id do serviço (se necessário fazer um tratamento da informação difitada)
        stop = entrada.nextLine();
    
        return stop;
    }
    
    //
    public String ReceivedInfoEnvironment(){
        String stop = "";
        
        //Recebe informação do ambiente
        
        //Faz o tratamento da informação e retorna o id do serviço no arquivo
        //ou a porta a ser usada, caso utilize sockets
        
        
        return stop;
    }
}
