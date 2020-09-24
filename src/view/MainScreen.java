package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainScreen {
	
	private JFrame frame;
	private final int SCREEN_WIDTH = 720, SCREEN_HEIGHT = 480;
	private BufferedImage backgroundImage, openFileButtonImage, randomValuesButtonImage;
	
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
			
			// open image files
			try{
		    	backgroundImage = ImageIO.read(this.getClass().getResourceAsStream("/images/mainScreenBackground.jpg"));
		    	openFileButtonImage = ImageIO.read(this.getClass().getResourceAsStream("/images/openFileButton.png"));
		    	randomValuesButtonImage = ImageIO.read(this.getClass().getResourceAsStream("/images/randomValuesButton.png"));
			}
			catch(Exception e){
				
			}

			initComponents();
		}
		
		// initialize, configure and add all screen components
		public void initComponents() {
			// create screen components
			JButton randomValuesButton = new JButton(new ImageIcon(randomValuesButtonImage));
			JButton openFileButton = new JButton(new ImageIcon(openFileButtonImage));
			JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
			
			// configure screen components
			randomValuesButton.setBounds(270, 300, 200, 40);
			openFileButton.setBounds(300, 350, 140, 40);
			backgroundLabel.setBounds(0, 0, 720, 480);
			openFileButton.setOpaque(false);
			openFileButton.setContentAreaFilled(false);
			openFileButton.setBorderPainted(false);
			openFileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			randomValuesButton.setOpaque(false);
			randomValuesButton.setContentAreaFilled(false);
			randomValuesButton.setBorderPainted(false);
			randomValuesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			// add components to the screen
			add(randomValuesButton);
			add(openFileButton);
			add(backgroundLabel);
			
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
						    	for(int i = listSize; i > 0; i--){
						    		valuesList.add(Math.abs(random.nextInt()));
						    	}
						    	
						    	new AlgorithmsScreen(valuesList);
						    	dispose();
						    }
						
						}
						catch(Exception ex){
							return;
						
						}
					
					}
				
				}
			});
			
			// chose file button click
			openFileButton.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){
					ArrayList<Integer> valuesList = new ArrayList<Integer>();
					new AlgorithmsScreen(valuesList); // TODO
				}
			});
		
		}
		
		// method to dispose this JPanel
		public void dispose() {
		    JFrame parent = (JFrame) this.getTopLevelAncestor();
		    parent.dispose();
		    removeAll();
		   
		}
	
	}

}
