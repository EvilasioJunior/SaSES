/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genericadapterprogram;

import adapter.Monitoring;
import webservice.Webservice;

/**
 *
 * @author Evilasio
 */
public class ConcreteMonitoring extends Monitoring{
    
    public ConcreteMonitoring(Webservice wMonitor){
        this.setMonitoring(wMonitor);
    }
    
    public ConcreteMonitoring(){
    }
    
    @Override
    public void monitoring(){
         //<code of monitoring>
        this.monitoringWebservice();
        //Alert Observers
        this.Notify();
        
        //Time until next read
        try {  
           Thread.sleep(getTime()*1000);  //each getTime() seconds
        } catch (Exception e) {  
        }
    }     
    
}
