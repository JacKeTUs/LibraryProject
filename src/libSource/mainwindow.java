package libSource;
import  libSource.Attributes.*;
import libSource.Database.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.Iterator;

/**
 * Created by admin on 07/04/17.
 */
public class mainwindow {
    private JPanel panel1;
    private JButton changeUserButton;
    private JTextField searchEdit;
    private JTextField NameEdit;
    private JTextField SourceEdit;
    private JTable table1;
    private JButton openCardButton;
    private JTextField ThemeEdit;
    private JTextField DescriptionEdit;
    private JTextField AccessTypeEdit;
    private JRadioButton nameRadioButton;
    private JRadioButton sourceRadioButton;
    private JRadioButton themeRadioButton;
    private JButton Simplesearch;
    private JButton удалитьРесурсButton;
    private JButton добавитьРесурсButton;
    private JButton getbutton;
    private JButton searchButton;
    private DBFacade facade;
    private BaseAttribute sortattribute;

    public mainwindow() {
        DefaultTableModel model = new DefaultTableModel();
        facade = new DBFacade();
        try {
            facade.connectDB();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        sortattribute = new AttributeName("");
        table1.setAutoCreateRowSorter(true);
        table1.setFillsViewportHeight(true);
        table1.setPreferredScrollableViewportSize(new Dimension(550, 200));


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
                temp.add(new AttributeName(""));
                temp.add(new AttributeDescription(""));
                temp.add(new AttributeAccessType(""));

                //DBFacade facade = new DBFacade();

                try {
                    facade.connectDB();
                    table1.setModel(mybuildTableModel( facade.getSomeResources(temp, sortattribute)));

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

               /* AttributeList temp = new AttributeList();
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

                table1.setModel(model);*/

            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AttributeList lst = new AttributeList();

                    AttributeName           atn = new AttributeName("");
                    AttributeDescription    atd = new AttributeDescription("");
                   // AttributeLink           atl = new AttributeLink("");
                    AttributeTheme          ath = new AttributeTheme("");
                   // AttributeType           atp = new AttributeType("");
                    AttributeAccessType     atat = new AttributeAccessType("");

                    if (!NameEdit.getText().isEmpty()) {
                        atn.setAttributeValue(NameEdit.getText());
                        lst.add(atn);
                    }
                    if (!DescriptionEdit.getText().isEmpty()) {
                        atd.setAttributeValue(DescriptionEdit.getText());
                        lst.add(atd);
                    }
                  /*  if (!LinkEdit.getText().isEmpty()) {
                        atl.setAttributeValue(LinkEdit.getText());
                        lst.add(atl);
                    }*/
                    if (!ThemeEdit.getText().isEmpty()) {
                        ath.setAttributeValue(ThemeEdit.getText());
                        lst.add(ath);
                    }
                    /*
                    if (!TypeEdit.getText().isEmpty()) {
                        atp.setAttributeValue(TypeEdit.getText());
                        lst.add(atp);
                    }*/
                    if (!AccessTypeEdit.getText().isEmpty()) {
                        atat.setAttributeValue(AccessTypeEdit.getText());
                        lst.add(atat);
                    }

                    AttributeList lstOut = new AttributeList();

                    AttributeName           atnO = new AttributeName("");
                    AttributeDescription    atdO = new AttributeDescription("");
                    AttributeLink           atlO = new AttributeLink("");
                    AttributeTheme          athO = new AttributeTheme("");
                    AttributeType           atpO = new AttributeType("");
                    AttributeAccessType     atatO = new AttributeAccessType("");


                    lstOut.add(atn);
                    lstOut.add(atd);
                    //  lstOut.add(atl);
                    //  lstOut.add(ath);
                    //lstOut.add(atp);
                    lstOut.add(atat);

                    if (lst.size() > 0)
                        table1.setModel(mybuildTableModel(facade.extendedSearch(lstOut, lst)));

                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
                    System.exit(-1);
                }
            }
        });

        Simplesearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table1.setModel(mybuildTableModel(facade.simpleSearch(searchEdit.getText())));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
                    System.exit(-1);
                }
            }
        });
        sourceRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortattribute = new AttributeAccessType("");
            }
        });
        themeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortattribute = new AttributeTheme("");
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

    public static TableModel mybuildTableModel(final ResultSet resultSet) throws SQLException {
        int columnCount = resultSet.getMetaData().getColumnCount();

        // Column names.
        Vector<String> columnNames = new Vector<>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            columnNames.add(resultSet.getMetaData().getColumnName(columnIndex));
        }

        // Data of the table.
        Vector<Vector<Object>> dataVector = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> rowVector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                rowVector.add(resultSet.getObject(columnIndex));
            }
            dataVector.add(rowVector);
        }

        return new DefaultTableModel(dataVector, columnNames);
    }


}
