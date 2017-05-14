package libSource;
import  libSource.Attributes.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.Iterator;

/**
 * Created by admin on 07/04/17.
 */
public class mainwindow {
    private JPanel panel1;
    private JButton changeUserButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTable table1;
    private JButton openCardButton;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JRadioButton nameRadioButton;
    private JRadioButton sourceRadioButton;
    private JRadioButton themeRadioButton;
    private JButton отменаПоискаButton;
    private JButton удалитьРесурсButton;
    private JButton добавитьРесурсButton;
    private JButton getbutton;


    public mainwindow() {
        DefaultTableModel model = new DefaultTableModel();

        table1.setAutoCreateRowSorter(true);
        table1.setFillsViewportHeight(true);
        table1.setPreferredScrollableViewportSize(new Dimension(550, 200));
        //model.addColumn("Name");
        //model.addColumn("Description");
        //model.addColumn("Source");
        //model.addColumn("Theme");
        // model.addColumn("Description");
        //model.addColumn("Access Type");

        //table1.setModel(model);
        openCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CardForm();
            }
        });


        changeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new ChangeUser();}
        });

        getbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AttributeList temp = new AttributeList();
                temp.add(new AttributeName());
                temp.add(new AttributeDescription());
                Managerofdata mgr = new Managerofdata;
                List<AttributeList> lst = mgr.getsorces(temp);


                for(int i = 0; i < lst.size; i++)
                {
                    AttributeList temp2;
                    temp2 = lst.get(i);
                    Vector<String> vct =  new Vector<>();
                    for (int j = 0; j < temp2.size(); j++)
                    {
                        BaseAttribute temp3 = temp2.get(j);
                        vct.add(temp3.getAttributeValue());
                    }
                    model.addRow(vct);


                }

                table1.setModel(model);

            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("mainwindow");
        frame.setContentPane(new mainwindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


}
