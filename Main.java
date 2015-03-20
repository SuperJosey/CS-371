import javax.swing.SwingUtilities;

class Main{

    public static void main(String[] args) {
    	
		//We using invoke later because we acceding to a Swing component thus  
		//we need to make all our action in the EDT thread
        SwingUtilities.invokeLater(new Runnable(){
        	
            public void run(){
            	
              new GraphicInterface();
            	
            }
          });
    	
    }
}