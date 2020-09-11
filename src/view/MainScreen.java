package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainScreen {
	
	private JFrame frame;
	private final int SCREEN_WIDTH = 720, SCREEN_HEIGHT = 480;
	
	public static void main(String args[]){
		new MainScreen();
		
	}

	public MainScreen() {
		JPanelMainScreen menuScreen = new JPanelMainScreen();

		frame = new JFrame();
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.add(menuScreen);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Comparação dentre algoritmos de ordenação");
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public class JPanelMainScreen extends JPanel {
		private static final long serialVersionUID = 1L;
		
		public JPanelMainScreen() {
			setFocusable(true);
			setLayout(null);
			setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

			initComponents();
		}
		
		// initialize, configure and add all screen components
		public void initComponents() {
			// create screen components
			JButton randomValuesButton = new JButton("Valores Aleatorios");
			JButton choseFileButton = new JButton("Abrir Arquivo");
			
			// configure screen components
			randomValuesButton.setBounds(270, 300, 200, 40);
			choseFileButton.setBounds(270, 350, 200, 40);
			
			// add components to the screen
			add(randomValuesButton);
			add(choseFileButton);
			
			// random values button click
			randomValuesButton.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){
					
					// read values amount size
					String sizeString = JOptionPane.showInputDialog(null, 
						"Digite a quantidade de dados que deseja ordenar.",
					    100);
					
					// click cancel button
					if(sizeString == null){
						return;
					}	
					// no value
					else if(sizeString.trim().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "Digite um valor valido.");
					}
					else{
						try{
							int listSize = Integer.parseInt(sizeString);
						
							if (listSize <= 0) {
								JOptionPane.showMessageDialog(null, "Digite um valor valido.");
						    } 
						    else {
						    	// crates a list with random integer values 
						    	ArrayList<Integer> valuesList = new ArrayList<Integer>();
						    	
						    	Random random = new Random();
						    	for(int i = 0; i < listSize; i++){
						    		valuesList.add(Math.abs(random.nextInt()));
						    	}
						    	
						    	new AlgorithmsScreen(valuesList);
						    
						    }
						
						}
						catch(Exception ex){
							return;
						
						}
					
					}
				
				}
			});
			
			// chose file button click
			choseFileButton.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){
					ArrayList<Integer> valuesList = new ArrayList<Integer>();
					new AlgorithmsScreen(valuesList); // TODO
				}
			});
		
		}
	
	}

}
