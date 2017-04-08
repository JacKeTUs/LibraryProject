import java.sql.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import java.util.Vector;
import javax.swing.table.*;

/**
 * Created by JacKeTUs on 06.04.2017.
 */
public class myGui {
    private JTable table1;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private DBFacade dbFacade;
    Statement stmt = null;

    public myGui() {
        dbFacade = new DBFacade();
        try {
            dbFacade.connectDB();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.exit(-1);
        }

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1_clicked();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2_clicked();
            }
        });
    }


    private void button1_clicked() {
        try {
            table1.setModel(buildTableModel(dbFacade.getAllResources()));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.exit(-1);
        }
    }
    private void button2_clicked() {
        try {
            table1.setModel(buildTableModel(dbFacade.simpleSearch(textField1.getText())));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.exit(-1);
        }
    }


    public static void main(String[] args) {

        myGui Window = new myGui();

        JFrame frame = new JFrame("App");
        frame.setContentPane(Window.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static TableModel buildTableModel(final ResultSet resultSet) throws SQLException {
        int columnCount = resultSet.getMetaData().getColumnCount();
        System.out.println("Колонок:"+ columnCount);


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


