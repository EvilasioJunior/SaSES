/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genericadapterprogram;

import adapter.Analysis;
import webservice.Webservice;

/**
 *
 * @author Evilasio
 */
public class ConcreteAnalysis extends Analysis{

    public ConcreteAnalysis(Webservice wAnalyzer){
        this.setAnalysis(wAnalyzer);
    }
    
    public ConcreteAnalysis(){
    }

    @Override
    public void analyze(){
        //<code of alaysis>
        this.analyzeWebservice();
        this.Notify();
    }
     
}
