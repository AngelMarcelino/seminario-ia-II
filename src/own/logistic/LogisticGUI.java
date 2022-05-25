package logistic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LogisticGUI extends JFrame {
  private LogisticAgent myAgent;

  private JTextField value1ToPredictField;
  private JTextField value2ToPredictField;
  private JTextField value3ToPredictField;

  LogisticGUI(LogisticAgent a) {
    super(a.getLocalName());

    myAgent = a;

    JPanel p = new JPanel();
    p.setLayout(new GridLayout(3, 2));

    p.add(new JLabel("Valor 1 a predecir:"));
    value1ToPredictField = new JTextField("1", 15);
    p.add(value1ToPredictField);
    p.add(new JLabel("Valor 2 a predecir:"));
    value2ToPredictField = new JTextField("1", 15);
    p.add(value2ToPredictField);
    p.add(new JLabel("Valor 3 a predecir"));
    value3ToPredictField = new JTextField("1", 15);
    p.add(value3ToPredictField);
    getContentPane().add(p, BorderLayout.CENTER);

    JButton addButton = new JButton("Hacer prediccion");
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        try {
          String value1ToPredict = value1ToPredictField.getText().trim();
          String value2ToPredict = value2ToPredictField.getText().trim();
          String value3ToPredict = value3ToPredictField.getText().trim();
          myAgent.makePrediction(Double.parseDouble(value1ToPredict), Double.parseDouble(value2ToPredict),
              Double.parseDouble(value3ToPredict));
          value1ToPredictField.setText("");
          value2ToPredictField.setText("");
          value3ToPredictField.setText("");
        } catch (Exception e) {
          JOptionPane.showMessageDialog(LogisticGUI.this, "Valores invalidos. " + e.getMessage(), "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    p = new JPanel();
    p.add(addButton);
    getContentPane().add(p, BorderLayout.SOUTH);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        myAgent.doDelete();
      }
    });

    setResizable(false);
  }

  public void showGui() {
    pack();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int centerX = (int) screenSize.getWidth() / 2;
    int centerY = (int) screenSize.getHeight() / 2;
    setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
    super.setVisible(true);
  }
}
