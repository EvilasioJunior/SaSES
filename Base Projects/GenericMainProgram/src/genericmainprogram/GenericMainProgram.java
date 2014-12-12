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
    public static void main(String[] args) {
        
        //Funcionalidades base 
        Webservice service = new Webservice();
        
        //Funcionalidades base utilizando arquivos
        File Services = new File("Servicos.xml"); //ArquivoComServiçosPrincipais
        File extraServices = new File("OutrosServicos.xml"); //OutrosSeviços (caso seja possível registrar novos serviços que não constam entre as funcionalidade base)
        
        //Weservices funções
        WSFuncs funcs = new WSFuncs();
        
        //Interface Gráfica
        GenericView view = new GenericView();
        
        //variáveis específicas da aplicação
        String stop = ""; //Variável usada para verificar condição de parada do Loop,
                         //pode ter qualquer assinatura e ser utilizada para outras funções
        
        while(!stop.equals("AlgumaCoisa")) // Loop de execução do programa
        {
            /*
             * Primeiro adicione a lógica da interface do programa e  depois utilize um dos 
             * métodos abaixo para acionar as funcionalidades
             */
            
            //Interface gráfica e entrade de dados para a variável que testa a condição de parada
            stop = view.WriteinScreen();
            //stop = view.ReceivedInfoEnvironment();
            
            //testa condição de parada
            if(stop.equals("AlgumaCoisa"))
                continue;
            
            /*
             * Obs.:
             * Caso utilize arquivos, o próprio serviço de planejamento do adaptador irá preencher o arquivo.
             * Caso use socketes, o serviço de planejamento do Adaptador enviará a iformação. 
             * Lembre-se de colcar para executar primeiro o programa principal e só em seguida o adaptador
             */
            
            /*
             * Método 1: Inicializa o serviço por sockets
             */
            
            /*
            try{
            service.initializerBySocket(Integer.parseInt(stop));
            }catch(Exception e){}
            */
             
            /*
             * Método 2: Inicializa o serviço com as inforçãoes de dentro de uma 
             * lista de serviços presente num arquivo
             */ 
            service = funcs.SearchServiceByID(stop,Services);
            
            /*
             * Executando a funcionalidade utilizando método 1 ou 2
             */
            if(service!=null){
                if(service.getarguments().size() > 0)
                    funcs.fService(service, service.getarguments().toArray(new String[service.getarguments().size()]));
                else
                    funcs.fService(service, service.getarguments().toArray(new String[service.getarguments().size()])); 
            }
            else
                System.out.printf("Você tentou executar um serviço inexistente, escolha outro serviço.\n");
            /*
             * Método 3: Executa todos os serviços em um arquivo 
             */
            //funcs.funcAllServicesXML(//"",/*(argumento 1)*/ "", /*(argumento 2)*/ 
            //                      Services.getAbsolutePath());
           
             /*
             * Executar todos os outros serviços que estão informados em um arquivo 
             */
            //funcs.funcAllServicesXML(//"",/*(argumento 1)*/ "", /*(argumento 2)*/ 
            //                      extraServices.getAbsolutePath());
            
        }
    }
}
