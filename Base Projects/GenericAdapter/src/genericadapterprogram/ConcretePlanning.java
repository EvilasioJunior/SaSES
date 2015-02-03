/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genericadapterprogram;

import adapter.Planning;
import webservice.Webservice;

/**
 *
 * @author Evilasio
 */
public class ConcretePlanning extends Planning{
    
    public ConcretePlanning(Webservice wDesigner){
        this.setPlanning(wDesigner);
    }
    
    public ConcretePlanning(){
    }
    
    @Override
    public void plan(){
        //<code of monitoring>
        this.planWebservice();
    }
}
