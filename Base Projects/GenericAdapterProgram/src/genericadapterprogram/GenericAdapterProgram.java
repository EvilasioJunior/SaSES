package genericadapterprogram;

//Importações mínimas necessárias
import adapter.Monitoring;
import adapter.Analysis;
import adapter.Adapter;
import adapter.Planning;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import webservice.Webservice;

public class GenericAdapterProgram {

    public static void main(String[] args) {
        //Serviços
        Webservice wMonitoramento;
        Webservice wAnalise;
        Webservice wPlanejamento;

        //---Declarando serviços----//
        wMonitoramento = new Webservice("targetName","Name","url", "Port");
        wAnalise = new Webservice("targetName","Name","url", "Port");
        wPlanejamento = new Webservice("targetName","Name","url", "Port");

        //Setando Monitoring, Analysis e Planning
        Monitoring monitor = new Monitoring(wMonitoramento);    
        Analysis analisador = new Analysis(wAnalise);
        Planning planejador = new Planning(wPlanejamento);

        //Configurando monitores
        monitor.setValuesMonitor("ValoresMonitor.xml"); 
        monitor.setTime(0/*tempo até a execução do próximo monitor*/);

        //Configurar analisadores
        analisador.setValuesAnalysis("ValoresAnalise.xml"); 
        analisador.setObserver(monitor);           

        //Configurando planejadores
        planejador.setObserver(analisador);

        //Criar listas de Monitoring, Analysis, Planning
        List<Monitoring> monitores = new ArrayList();
        List<Analysis> analisadores = new ArrayList();
        List<Planning> planejadores = new ArrayList();

        //Adicionar monitores, analisadores e planejadores as listas
        monitores.add(monitor);
        analisadores.add(analisador);
        planejadores.add(planejador);

        //Setando Adapter
        Adapter adaptador = new Adapter(monitores, analisadores, 
                                              planejadores); 
        adaptador.setMonitoring(monitor);
        adaptador.setAnalysis(analisador);
        adaptador.setPlanning(planejador);

        //Setando adaptador para quando usar arquivos
        Adapter adaptador2 = new Adapter();
        //outros
        File SumarioPlanos = new File("");
        File SumarioMonitor = new File("");
        File SumarioAnalise = new File("");

        //Setando Funções Específicas dessa adaptação, 
        //como o critério de parada do adaptador
        //A execução dessas funções são disparadas pelo adaptador
        SpecificFunction sf = new SpecificFunction();
        sf.setObserver(adaptador);

        adaptador.run();
        //adaptador.run2();
        adaptador2.runlist(SumarioMonitor, SumarioAnalise, SumarioPlanos, 0);

    }
}
