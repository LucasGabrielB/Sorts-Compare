package view;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ShowDataScreen {
	private JFrame frame;
	private final int SCREEN_WIDTH = 720, SCREEN_HEIGHT = 480;
	private List list;
	
	public <T extends Comparable<? super T>> ShowDataScreen(List<T> list){
		this.list = list;
		JPanelShowDataScreen menuScreen = new JPanelShowDataScreen();

		frame = new JFrame();
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.add(menuScreen);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Comparação dentre algoritmos de ordenação");
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public class JPanelShowDataScreen extends JPanel{
		private static final long serialVersionUID = 1L;
		
		public JPanelShowDataScreen(){
			setFocusable(true);
			setLayout(null);
			setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
			
			initComponents();
		}
		
		public void initComponents(){
			JTable resultsTable = new JTable();
			JScrollPane resultsTableScrollPane = new JScrollPane();
			
			resultsTableScrollPane.setBounds(5, 5, 710, 470);
			resultsTableScrollPane.setViewportView(resultsTable);
			
			resultsTable.setModel(new javax.swing.table.DefaultTableModel(
					new Object[][]{
						// TODO, add rows to table
				        
				    },
				    new String[]{
				    	"Data Hora", "Temp. Ins. (C)",
				    	"Temp. Max. (C)", "Temp. Min. (C)",
				    	"Umi. Ins. (%)", "Umi. Max. (%)",
				    	"Umi. Min. (%)","Pto Orvalho Ins. (C)",
				    	"Pto Orvalho Max. (C)", "Pto Orvalho Min. (C)",
				    	"Pressao Ins. (hPa)", "Pressao Max. (hPa)",
				    	"Pressao Min. (hPa)", "Vel. Vento (m/s)",
				    	"Dir. Vento (m/s)", "Raj. Vento (m/s)",
				    	"Radiacao (KJ/m²)", "Chuva (mm)"

				    }
			));
			// change table style
			resultsTable.setEnabled(false);
			resultsTable.setCellSelectionEnabled(false);
			
			add(resultsTableScrollPane);
		}
	}

}
