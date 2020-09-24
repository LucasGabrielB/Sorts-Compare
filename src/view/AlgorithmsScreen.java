package view;

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

import algorithms.Quicksort;

public class AlgorithmsScreen {
	
	private JFrame frame;
	private final int SCREEN_WIDTH = 720, SCREEN_HEIGHT = 480;
	private BufferedImage backgroundImage, originalValuesButtonImage, sortedValuesButtonImage, comebackButtonImage;
	@SuppressWarnings("rawtypes")
	private List originalList;

	public <T extends Comparable<? super T>> AlgorithmsScreen(List<T> list) {
		JPanelAlgorithmsScreen algorithmsScreenPanel = new JPanelAlgorithmsScreen();
		this.originalList = list;
		
		frame = new JFrame();
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.add(algorithmsScreenPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Comparação dentre algoritmos de ordenação");
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
			JButton sortedValuesButton = new JButton("mostrar dados ordenados");
			JButton comebackButton = new JButton("voltar");
			JButton originalValuesButton = new JButton("mostrar dados originais");
			JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
			JLabel vizualizeValuesLabel = new JLabel("Vizualizar dados:");
			JLabel resultLabel = new JLabel("Resultado:");
			
			// configure screen components
			backgroundLabel.setBounds(0, 0, 720, 480);

			vizualizeValuesLabel.setBounds(40, 320, 200, 40);
			vizualizeValuesLabel.setFont(new Font("Arial", Font.BOLD, 20));
			vizualizeValuesLabel.setForeground(Color.white);
			
			resultLabel.setBounds(40, 40, 200, 40);
			resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
			resultLabel.setForeground(Color.white);
			
			
			sortedValuesButton.setBounds(60, 370, 200, 40);
			sortedValuesButton.setOpaque(false);
			sortedValuesButton.setBorderPainted(false);
			sortedValuesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			comebackButton.setBounds(10, 10, 80, 20);
			comebackButton.setOpaque(false);
			comebackButton.setBorderPainted(false);
			comebackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			originalValuesButton.setBounds(60, 420, 200, 40);
			originalValuesButton.setOpaque(false);
			originalValuesButton.setBorderPainted(false);
			originalValuesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			resultsTableScrollPane.setBounds(50, 100, 618, 143);
			resultsTableScrollPane.setViewportView(resultsTable);
			resultsTable.setModel(new javax.swing.table.DefaultTableModel(
					new Object[][]{
						// TODO
				        {"1°", "Algoritmo nome", "tempo"},
				        {"2°", "Algoritmo nome", "tempo"},
				        {"3°", "Algoritmo nome", "tempo"},
				        {"4°", "Algoritmo nome", "tempo"}
				    },
				    new String[]{
				        "Possição", "Algoritmo", "Tempo gasto"
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
				@SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent e){
					new ShowDataScreen(Quicksort.sort(originalList));
				}
			});
			
			// view sorted values button click
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
		
	}

}
