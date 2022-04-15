package tema1;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JPanel {
    protected JTextField textField;		
    protected JTextField textField2;	
    protected JButton verifyButton;		
    protected static JFrame frame;

    private static int INSETS_10 = 10;

    public Main() {
        super(new GridBagLayout());
        super.setBackground(new Color(153, 153, 153));

        textField = new JTextField(20);
        JLabel Label = new JLabel("Pattern: ");

        textField2 = new JTextField(20);
        JLabel textLabel = new JLabel("String: ");

        verifyButton = new JButton("Verify");
        verifyButton.setForeground(new Color(230,230,250));
        verifyButton.setBackground(new Color(51, 51, 51));
        verifyButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog(frame, "Results", true);
                    d.setLocationRelativeTo(frame);
                boolean isInvalid = false;
                Pattern pattern = null;
                try {
                    pattern = Pattern.compile(textField.getText());
                } catch (Exception x){
                  isInvalid = true;
                }
                if (isInvalid){
                    d.add(new JLabel("Invalid pattern!"));
                } else {
                    if (pattern.matcher(textField2.getText()).find()) {
                        d.add(new JLabel("Match found!"));
                    } else {
                        d.add(new JLabel("No match found."));
                    }
                }
                d.pack();
                d.setVisible(true);
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(INSETS_10, INSETS_10, INSETS_10, INSETS_10);
        c.weightx = 0.5;
        c.weighty = 0.5;

        c.gridx = 0;
        c.gridy = 0;

        add(Label, c);
        c.gridx++;
        add(textField, c);

        c.gridx = 0;
        c.gridy++;
        add(textLabel, c);
        c.gridx++;
        add(textField2, c);

        c.gridx = 0;
        c.gridy++;
        add(verifyButton,c);
    }

    private static void createAndShowGUI() {
        // create and set up the window
        frame = new JFrame("App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // add contents to the window
        frame.add(new Main());

        
        frame.setBounds(200, 200, 550, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

        // display the window
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}