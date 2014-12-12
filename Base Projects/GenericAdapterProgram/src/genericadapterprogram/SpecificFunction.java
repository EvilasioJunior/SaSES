/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genericadapterprogram;

import adapter.Specific;
import adapter.Adapter;

/**
 *
 * @author Evilasio
 */
public class SpecificFunction implements Specific{
   //Atributos para Observer Observador
    private Adapter adaptadorObservado; 
    
    public SpecificFunction(){}
    
    //Setar novo objeto observado
    public void setObserver(Adapter a){
        this.adaptadorObservado = a;
	adaptadorObservado.addSpecificFunction(this);
    }
    
    //Métodos para Observer Observador   
    @Override
    public void update(Adapter a) {
		if(a == adaptadorObservado){
                    adaptadorObservado.setStop(verificaEstadoPaciente());
		}
    }
  
    public Boolean verificaEstadoPaciente(){
        Boolean baux = true;       
        return baux;
    } 
}
