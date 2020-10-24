package view;

import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utils.WeatherData;

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
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e){
					
					// read values amount size
					String sizeString = JOptionPane.showInputDialog(null, 
						"Digite a quantidade de dados que deseja ordenar.",
					    10000);
					
					// click cancel button
					if(sizeString == null){
						return;
					}	
					// no value
					else if(sizeString.trim().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "Digite um valor valido.");
						return;
					}
					else{
						int listSize;
						try{
							listSize = Integer.parseInt(sizeString);
						
							if (listSize <= 0) {
								JOptionPane.showMessageDialog(null, "Digite um valor valido.");
								return;
						    }
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(null, "Digite um valor valido.");
							return;						
						}
						    
				    	// crates a list with random WeatherData values
						ArrayList<WeatherData> valuesList = new ArrayList<WeatherData>();
				    	
				    	Random r = new Random();
				    	for(int i = listSize; i > 0; i--){
				    		WeatherData weatherData = new WeatherData();
				    		
				    		// generate random data
			            	Date date = new Date();
			            	date.setYear(r.nextInt(2020));
			            	date.setMonth(r.nextInt(13));
			            	date.setDate(r.nextInt(29));
			            	date.setHours(r.nextInt(25));
			            	weatherData.setDate(date);
			            	weatherData.setTemperatureInst(r.nextDouble() + r.nextInt(50));
			            	weatherData.setTemperatureMin(r.nextDouble() + r.nextInt(50));
			            	weatherData.setTemperatureMax(r.nextDouble() + r.nextInt(50));
			            	weatherData.setAirHumidityInst(r.nextDouble() + r.nextInt(100));
			            	weatherData.setAirHumidityMax(r.nextDouble() + r.nextInt(100));
			            	weatherData.setAirHumidityMin(r.nextDouble() + r.nextInt(100));
			            	weatherData.setDewPointInst(r.nextDouble() + r.nextInt(25));
			            	weatherData.setDewPointMax(r.nextDouble() + r.nextInt(25));
			            	weatherData.setDewPointMin(r.nextDouble() + r.nextInt(25));
			            	weatherData.setPressureInst(r.nextDouble() + r.nextInt(1100));
			            	weatherData.setPressureMax(r.nextDouble() + r.nextInt(1100));
			            	weatherData.setPressureMin(r.nextDouble() + r.nextInt(1100));
			            	weatherData.setWindVelocity(r.nextDouble() + r.nextInt(50));
			            	weatherData.setWindDirection(r.nextDouble() + r.nextInt(10));
			            	weatherData.setWindGust(r.nextDouble() + r.nextInt(361));
			            	weatherData.setRadiation(r.nextDouble() + r.nextInt(5000));
			            	weatherData.setRain(r.nextDouble() + r.nextInt(100));
			            	
			            	valuesList.add(weatherData);
				    	
				    	}
				    	
				    	new AlgorithmsScreen(valuesList);
				    	dispose();
					
					}
				
				}
			});
			
			// chose file button click TODO
			openFileButton.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){
					
					// request the user for a .csv file
					FileDialog dialog = new FileDialog((Dialog)null, "Selecione o arquivo .CSV");
				    dialog.setMode(FileDialog.LOAD);
				    dialog.setFile("*.csv;*.CSV");
				    dialog.setVisible(true);
				    String filePath = dialog.getDirectory() + dialog.getFile();
				    
					ArrayList<WeatherData> valuesList = new ArrayList<WeatherData>();

			        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			        	String line = "";
			        	
			        	// skip header..
			        	br.readLine(); br.readLine();br.readLine();
			            
			        	while ((line = br.readLine()) != null) {
			        		try{
				            	String[] lineData = line.split(";");
				            	WeatherData weatherData = new WeatherData();
				            	
				            	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HHHH");		
				            	
				            	Date date = simpleDateFormat.parse(lineData[0] + " " + lineData[1]);
				            	weatherData.setDate(date);
				            	weatherData.setTemperatureInst(Double.parseDouble((lineData[2].length() == 0)? "0" : lineData[2].replaceAll(",",".")));
				            	weatherData.setTemperatureMin(Double.parseDouble((lineData[4].length() == 0)? "0" : lineData[4].replaceAll(",",".")));
				            	weatherData.setTemperatureMax(Double.parseDouble((lineData[3].length() == 0)? "0" :lineData[3].replaceAll(",",".")));
				            	weatherData.setAirHumidityInst(Double.parseDouble((lineData[5].length() == 0)? "0" :lineData[5].replaceAll(",",".")));
				            	weatherData.setAirHumidityMax(Double.parseDouble((lineData[6].length() == 0)? "0" :lineData[6].replaceAll(",",".")));
				            	weatherData.setAirHumidityMin(Double.parseDouble((lineData[7].length() == 0)? "0" :lineData[7].replaceAll(",",".")));
				            	weatherData.setDewPointInst(Double.parseDouble((lineData[8].length() == 0)? "0" :lineData[8].replaceAll(",",".")));
				            	weatherData.setDewPointMax(Double.parseDouble((lineData[9].length() == 0)? "0" :lineData[9].replaceAll(",",".")));
				            	weatherData.setDewPointMin(Double.parseDouble((lineData[10].length() == 0)? "0" :lineData[10].replaceAll(",",".")));
				            	weatherData.setPressureInst(Double.parseDouble((lineData[11].length() == 0)? "0" :lineData[11].replaceAll(",",".")));
				            	weatherData.setPressureMax(Double.parseDouble((lineData[12].length() == 0)? "0" :lineData[12].replaceAll(",",".")));
				            	weatherData.setPressureMin(Double.parseDouble((lineData[13].length() == 0)? "0" :lineData[13].replaceAll(",",".")));
				            	weatherData.setWindVelocity(Double.parseDouble((lineData[14].length() == 0)? "0" :lineData[14].replaceAll(",",".")));
				            	weatherData.setWindDirection(Double.parseDouble((lineData[15].length() == 0)? "0" :lineData[15].replaceAll(",",".")));
				            	weatherData.setWindGust(Double.parseDouble((lineData[16].length() == 0)? "0" :lineData[16].replaceAll(",",".")));
				            	weatherData.setRadiation(Double.parseDouble((lineData[17].length() == 0)? "0" :lineData[17].replaceAll(",",".")));
				            	weatherData.setRain(Double.parseDouble((lineData[18].length() == 0)? "0" :lineData[18].replaceAll(",",".")));
				            	
				            	valuesList.add(weatherData);
			        		}
			        		catch (ArrayIndexOutOfBoundsException ex){} // ignoring rows with missing data
			            }
			        
			        } 
			        catch (IOException ex) {
			            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			            return;
			        
			        }
			        catch (NumberFormatException | ParseException ex) {
			            JOptionPane.showMessageDialog(null, "Erro ao processar o arquivo.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
					
					new AlgorithmsScreen(valuesList); // TODO
					dispose();
				
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
