package slr;

import jade.core.AID;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import utils.*;

class SLRGUI extends JFrame {	
	private SLRAgent myAgent;
	
	private JTextField valueToPredictField;
	
	SLRGUI(SLRAgent a) {
		super(a.getLocalName());
		
		myAgent = a;
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2));
		p.add(new JLabel("Valor a predecir:"));
		valueToPredictField = new JTextField(15);
		p.add(valueToPredictField);
		getContentPane().add(p, BorderLayout.CENTER);
		
		JButton addButton = new JButton("Hacer prediccion");
		addButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String valueToPredict = valueToPredictField.getText().trim();
					myAgent.makePrediction(Double.parseDouble(valueToPredict));
					valueToPredictField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(SLRGUI.this, "Valores invalidos. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
		p = new JPanel();
		p.add(addButton);
		getContentPane().add(p, BorderLayout.SOUTH);
		
		addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myAgent.doDelete();
			}
		} );
		
		setResizable(false);
	}
	
	public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}	
}
