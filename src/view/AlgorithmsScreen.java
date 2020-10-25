package view;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import algorithms.BubbleSort;
import algorithms.InsertionSort;
import algorithms.MergeSort;
import algorithms.Quicksort;
import utils.AlgorithmStatistics;
import utils.AlgorithmsRank;
import utils.WeatherData;

public class AlgorithmsScreen {
	
	private JFrame frame;
	private final int SCREEN_WIDTH = 720, SCREEN_HEIGHT = 480;
	private BufferedImage backgroundImage, originalValuesButtonImage, sortedValuesButtonImage, returnButtonImage;
	@SuppressWarnings("rawtypes")
	private List originalList;

	public <T extends Comparable<? super T>> AlgorithmsScreen(List<T> list) {
		this.originalList = list;
		JPanelAlgorithmsScreen algorithmsScreenPanel = new JPanelAlgorithmsScreen();
		
		frame = new JFrame();
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.add(algorithmsScreenPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Comparação dentre algoritmos de ordenação - Resultados");
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public class JPanelAlgorithmsScreen extends JPanel {
		private static final long serialVersionUID = 1L;
		
		public JPanelAlgorithmsScreen() {
			setFocusable(true);
			setLayout(null);
			setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
			
			// open image files
			try{
		    	backgroundImage = ImageIO.read(this.getClass().getResourceAsStream("/images/mainScreenBackground.jpg"));
		    	sortedValuesButtonImage = ImageIO.read(this.getClass().getResourceAsStream("/images/sortedValuesButton.png"));
		    	returnButtonImage = ImageIO.read(this.getClass().getResourceAsStream("/images/returnButton.png"));
		    	originalValuesButtonImage = ImageIO.read(this.getClass().getResourceAsStream("/images/originalValuesButton.png"));
		    	 
			}
			catch(Exception e){
				
			}

			initComponents();
		}
		
		// initialize, configure and add all screen components
		public void initComponents() {
			// create screen components

			JTable resultsTable = new JTable();
			JScrollPane resultsTableScrollPane = new JScrollPane();
			JButton sortedValuesButton = new JButton(new ImageIcon(sortedValuesButtonImage));
			JButton comebackButton = new JButton(new ImageIcon(returnButtonImage));
			JButton originalValuesButton = new JButton(new ImageIcon(originalValuesButtonImage));
			JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
			JLabel vizualizeValuesLabel = new JLabel("Visualizar dados:");
			JLabel resultLabel = new JLabel("Resultado da ordenação de "+originalList.size()+" dados:");
			
			// configure screen components
			backgroundLabel.setBounds(0, 0, 720, 480);

			vizualizeValuesLabel.setBounds(285, 320, 200, 40);
			vizualizeValuesLabel.setFont(new Font("Arial", Font.BOLD, 20));
			vizualizeValuesLabel.setForeground(Color.white);
			
			resultLabel.setBounds(50, 85, 400, 40);
			resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
			resultLabel.setForeground(Color.white);
			
			
			sortedValuesButton.setBounds(265, 360, 200, 45);
			sortedValuesButton.setOpaque(false);
			sortedValuesButton.setBorderPainted(false);
			sortedValuesButton.setContentAreaFilled(false);
			sortedValuesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			comebackButton.setBounds(7, 7, 145, 50);
			comebackButton.setOpaque(false);
			comebackButton.setContentAreaFilled(false);
			comebackButton.setBorderPainted(false);
			comebackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			originalValuesButton.setBounds(265, 410, 200, 45);
			originalValuesButton.setContentAreaFilled(false);
			originalValuesButton.setOpaque(false);
			originalValuesButton.setBorderPainted(false);
			originalValuesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			resultsTableScrollPane.setBounds(50, 130, 618, 143);
			resultsTableScrollPane.setViewportView(resultsTable);
			
			ArrayList<AlgorithmStatistics> algorithmRank = compareAlgorithms().getRank();
			
			resultsTable.setModel(new javax.swing.table.DefaultTableModel(
					new Object[][]{
						// TODO
				        {"1°", algorithmRank.get(0).getName(), algorithmRank.get(0).getTimeTaken()/ 1e9},
				        {"2°", algorithmRank.get(1).getName(), algorithmRank.get(1).getTimeTaken()/ 1e9},
				        {"3°", algorithmRank.get(2).getName(), algorithmRank.get(2).getTimeTaken()/ 1e9},
				        {"4°", algorithmRank.get(3).getName(), algorithmRank.get(3).getTimeTaken()/ 1e9}
				    },
				    new String[]{
				        "Posição", "Algoritmo", "Tempo gasto (s)"
				    }
			));
			// change table style
			resultsTable.setRowHeight(30);
			TableColumnModel columnModel = resultsTable.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(50);
			columnModel.getColumn(1).setPreferredWidth(250);
			columnModel.getColumn(2).setPreferredWidth(250);
			// align text to center of the cell
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			columnModel.getColumn(0).setCellRenderer(centerRenderer);
			columnModel.getColumn(1).setCellRenderer(centerRenderer);
			columnModel.getColumn(2).setCellRenderer(centerRenderer);
			resultsTable.setEnabled(false);
			resultsTable.setCellSelectionEnabled(false);
			
			// add components to the screen
			add(comebackButton);
			add(vizualizeValuesLabel);
			add(sortedValuesButton);
			add(originalValuesButton);
			add(resultsTableScrollPane);
			add(resultLabel);
			add(backgroundLabel);
			
			// view sorted values button click
			sortedValuesButton.addActionListener(new ActionListener(){  
				@SuppressWarnings({ "unchecked"})
				public void actionPerformed(ActionEvent e){
					List<WeatherData> sortedList = new ArrayList<WeatherData>(originalList);
					Quicksort.sort(sortedList);
					new ShowDataScreen(sortedList); 
				}
			});
			
			// view original values button click
			originalValuesButton.addActionListener(new ActionListener(){  
				@SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent e){
					new ShowDataScreen(originalList);
				}
			});
			
			// come back to main screen button click
			comebackButton.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){
					new MainScreen();
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
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		private AlgorithmsRank compareAlgorithms(){
			AlgorithmsRank algorithmRank = new AlgorithmsRank();
			
			// sort List using Bubble Sort method
			List<Comparable> list = new ArrayList<Comparable>(originalList);
			long timeTaken = System.nanoTime();
			BubbleSort.sort(list);
			AlgorithmStatistics algorithmStatistics = new AlgorithmStatistics("Bubble Sort", System.nanoTime() - timeTaken);
			algorithmRank.addAlgorithm(algorithmStatistics);
			
			// sort List using Insertion Sort method
			list = new ArrayList<Comparable>(originalList);
			timeTaken = System.nanoTime();
			InsertionSort.sort(list);
			algorithmStatistics = new AlgorithmStatistics("Insertion Sort", System.nanoTime()- timeTaken);
			algorithmRank.addAlgorithm(algorithmStatistics);
			
			// sort List using Merge Sort method
			list = new ArrayList<Comparable>(originalList);
			timeTaken = System.nanoTime();
			MergeSort.sort(list);
			algorithmStatistics = new AlgorithmStatistics("Merge Sort", System.nanoTime()- timeTaken);
			algorithmRank.addAlgorithm(algorithmStatistics);
			
			// sort List using Quicksort method
			list = new ArrayList<Comparable>(originalList);
			timeTaken = System.nanoTime();
			Quicksort.sort(list);
			algorithmStatistics = new AlgorithmStatistics("Quicksort", System.nanoTime()- timeTaken);
			algorithmRank.addAlgorithm(algorithmStatistics);
			
			return algorithmRank;
		}
		
	}

}
