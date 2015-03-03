import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GraphicInterface extends JFrame {
	
	private JButton startButton = new JButton("Start");
	private JButton stopButton = new JButton("Stop");
	private JTextField searchFile = new JTextField();
	private JLabel displayText = new JLabel("Alpha Beta Gamma SUPER delta");
	
	public GraphicInterface(){
		
	    this.setTitle("CS371-Assignement 1");
	    this.setSize(400, 400);
	    this.setLocationRelativeTo(null); // Window's position 
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    this.setResizable(false);	
		
	    //Button
	    startButton.setBounds(210, 10, 50, 50);
	    this.getContentPane().add(startButton);
	    
	    stopButton.setBounds(10,95,50,50);
	    this.getContentPane().add(stopButton);
	    
	    //Text file for searching the file that we want to display
	    
	    searchFile.setBounds(10,10,200,50);
	    this.getContentPane().add(searchFile);
	    
	    //Label for displaying the text file
	    Border border = BorderFactory.createLineBorder(Color.BLACK, 1); // Create a border for the Jlabel
	    displayText.setBorder(border);
	    
	    displayText.setFont(new java.awt.Font(Font.SANS_SERIF, Font.BOLD, 14));
	    displayText.setForeground(Color.BLACK);
	    displayText.setBounds(10, 80, 200, 15);
	    this.getContentPane().add(displayText);
    	    
	}

}
