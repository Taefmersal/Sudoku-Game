
package sugokugame;

//this is a State structural design pattern 
//Allow an object to change its state based on its internal state 
//when the user press Exit  the State of the game will be (Stop)
//when the user press Start the State of the game will be (Start)

public interface State {
    
	public void doAction(Context context);
}
