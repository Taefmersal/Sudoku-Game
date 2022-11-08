
package sugokugame;

//this is a Tamplate structural design pattern 
//Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure


public abstract class CalculatePoint  {

    abstract void AddPoint();
    abstract void SubPoint();
    
    public final void point(){
        
        AddPoint();
        SubPoint();
    }
}
        

    


