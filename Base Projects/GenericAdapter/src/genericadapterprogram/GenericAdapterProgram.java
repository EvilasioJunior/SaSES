package genericadapterprogram;

//Importações mínimas necessárias
import adapter.*;
import java.util.ArrayList;
import java.util.List;
import webservice.Webservice;

public class GenericAdapterProgram {

    public static void main(String[] args) {         

        Webservice wMonitoring; Webservice wAnalysis; Webservice wPlanning;
        
        //---Declare Services----//
        wMonitoring = new Webservice("targetName","Name","url", "Port");
        wAnalysis = new Webservice("targetName","Name","url", "Port");
        wPlanning = new Webservice("targetName","Name","url", "Port");
        
        //Set Specific Functions this adaptation, 
        AdapterObserver sf = new AdapterObserver(); 
        
        //Set Monitoring, Analysis and Planning
        Monitoring monitor = new ConcreteMonitoring(wMonitoring);    
        Analysis analyzer = new ConcreteAnalysis(wAnalysis);
        Planning planner = new ConcretePlanning(wPlanning);

        //Configure monitor
        monitor.setValuesMonitor("ValuesMonitor.xml"); 
        monitor.setTime(0);

        //Configure analyzer
        analyzer.setValuesAnalysis("ValuesAnalysis.xml"); 
        analyzer.setObserver(monitor);           

        //Configure designer
        planner.setObserver(analyzer);
        
        //Set List of Monitoring, Analysis and Planning
        List<Monitoring> monitors = new ArrayList<Monitoring>();    
        List<Analysis> analyzers = new ArrayList<Analysis>();
        List<Planning> planners = new ArrayList<Planning>();
        monitors.add(monitor); 
        analyzers.add(analyzer);
        planners.add(planner);
        

        //Set Adapter
        Adapter adapter = new Adapter(monitors, analyzers, planners); 
        
        //Set observers for Specific Funtions
        sf.setObserver(adapter);
       
        //Method Run of the Adapter
        adapter.run();

    }
}
