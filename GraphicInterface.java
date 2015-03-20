import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GraphicInterface extends JFrame implements ActionListener {
    
	private JPanel panel1;
    public static JTextArea textArea1 = new JTextArea();
    public static JTextArea textArea2 = new JTextArea();
    private JButton buttonStart = new JButton();
    private JButton buttonStop = new JButton();
    
    public GraphicInterface() {
        super("CS371");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        // Button
        buttonStart.setText("Start");
        buttonStart.addActionListener(this);
        buttonStop.setText("Stop");
        buttonStop.addActionListener(this);

        // TextArea1: User input
        textArea1.setColumns(20);
        textArea1.setRows(5);
        textArea1.setEditable(true);
        textArea1.setText("Enter your file.txt here");
        
        //TextArea2: Displaying the file
        textArea2.setColumns(20);
        textArea2.setRows(5);
        textArea2.setEditable(false);
        textArea2.setText("The file will be displayed in this area");
        //textArea2.setLineWrap(true);

        // Add Components
        panel1.add(textArea1);
        panel1.add(textArea2);
        panel1.add(buttonStart);
        panel1.add(buttonStop);

        // Add to Frame
        this.getContentPane().add(panel1);

        // Setting size and set Visible
        this.setSize(700, 300);
        this.setVisible(true);

    }

	@Override
	public void actionPerformed(ActionEvent src) {

		Object source = src.getSource();
		
		if(source.equals(buttonStart))
		{
			System.out.println("La on start");

			//We creating a first thread which searching and then loading the file asked
			Thread searchFileThread;
			searchFileThread = new SearchingFile(textArea1.getText());
			searchFileThread.run();
			
			//Then if the file is correctly loaded we can start a new thread to scroll the text:
			
			new Thread(new Runnable() {	
			
				public void run(){
					
					while(MyFile.isScrolling == true){ //While stop haven't been pressed we scrolling the text
						
						//Scrolling action:
						char c = MyFile.MyFileText.charAt(0);
						String rest = MyFile.MyFileText.substring(1);
						MyFile.MyFileText = rest + c;
						textArea2.setText(MyFile.MyFileText);
						
						try{
							
							Thread.sleep(150);	//Using thread sleep to "controling" the scroll speed
							
						}catch(InterruptedException e){ 
							
							JOptionPane.showMessageDialog(panel1, "Error during thread execution",
									"Warning",JOptionPane.WARNING_MESSAGE);
						}
						
					}
				}
			
			}).start();			
			
		}
		else{
			//When the stop button is pressed isScrolling become false 
			//then it's stop executing the thread used for scrolling the text
			MyFile.isScrolling = false;
		}	
	}
	
	
}