package libSource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 06/05/17.
 */
public class ChangeUser {
    private JFrame frame = new JFrame("ChangeUser");
    private JButton войтиButton;
    private JRadioButton администорRadioButton;
    private JRadioButton читательRadioButton;
    private JPanel Userpanel;


    public ChangeUser() {
        frame.setContentPane(Userpanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }


}
