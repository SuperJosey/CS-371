import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class SearchingFile extends Thread {
	
	private String file;
	private JPanel panelErr;

	public SearchingFile(String fileToFind){
		
		this.file = fileToFind;
		this.panelErr = new JPanel();
	}
	
	public void run(){
		
		Reader reader = null;
		String testOut = null;
		
		try{
		//We first try to open the resource	
		reader = new FileReader(file);
		BufferedReader In = new BufferedReader(reader);
		
			try {
				//Then we are trying to put the file into a String
				//System.out.println("Fichier trouver");
				testOut = In.readLine();
				MyFile.setMyFileText(testOut);
				
		    
			}finally{
				//In every case we are closing the resources used
				In.close();
				Closeable resource = reader;
				
				if(resource != null){
					resource.close();
				}
			}
		//If an error happen then we informing the user by an alert message	
		}catch (FileNotFoundException e1) {
			
			JOptionPane.showMessageDialog(panelErr, "Error: File '"+GraphicInterface.textArea1.getText()+"' not found", 
					"Warning",JOptionPane.WARNING_MESSAGE);

		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(panelErr, "Error: File with the file: "+GraphicInterface.textArea1.getText()+" not found", 
					"Warning",JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		

	}
}
