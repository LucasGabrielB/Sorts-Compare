package view;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import utils.WeatherData;


public class ShowDataScreen {
	private JFrame frame;
	private final int SCREEN_WIDTH = 720, SCREEN_HEIGHT = 480;
	private List<WeatherData> list;
	
	public ShowDataScreen(List<WeatherData> list){
		this.list = list;
		JPanelShowDataScreen menuScreen = new JPanelShowDataScreen();

		frame = new JFrame();
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.add(menuScreen);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Comparação dentre algoritmos de ordenação - Vizualição dos dados");
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

			// change table style
			resultsTable.setEnabled(false);
			resultsTable.setCellSelectionEnabled(false);
			
			DefaultTableModel tableModel = new DefaultTableModel();
			
			tableModel.setColumnIdentifiers(new String[]{
			    	"Data Hora", "Temp. Ins. (C)",
			    	"Temp. Max. (C)", "Temp. Min. (C)",
			    	"Umi. Ins. (%)", "Umi. Max. (%)",
			    	"Umi. Min. (%)","Pto Orvalho Ins. (C)",
			    	"Pto Orvalho Max. (C)", "Pto Orvalho Min. (C)",
			    	"Pressao Ins. (hPa)", "Pressao Max. (hPa)",
			    	"Pressao Min. (hPa)", "Vel. Vento (m/s)",
			    	"Dir. Vento (m/s)", "Raj. Vento (m/s)",
			    	"Radiacao (KJ/m²)", "Chuva (mm)"

			    });
			
			for(int i = 0, size = list.size(); i < size; i++ ){
				tableModel.addRow(new Object[]{
						list.get(i).getDate(),
						list.get(i).getTemperatureInst(),
						list.get(i).getTemperatureMax(),
						list.get(i).getTemperatureMin(),
						list.get(i).getAirHumidityInst(),
						list.get(i).getAirHumidityMax(),
						list.get(i).getAirHumidityMin(),
						list.get(i).getDewPointInst(),
						list.get(i).getDewPointMax(),
						list.get(i).getDewPointMin(),
						list.get(i).getPressureInst(),
						list.get(i).getPressureMax(),
						list.get(i).getPressureMin(),
						list.get(i).getWindVelocity(),
						list.get(i).getWindDirection(),
						list.get(i).getWindGust(),
						list.get(i).getRadiation(),
						list.get(i).getRain()
					});
				
			}
			resultsTable.setModel(tableModel);
			
			add(resultsTableScrollPane);
		}
	}

}
