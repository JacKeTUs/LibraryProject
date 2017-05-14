package libSource.oldInterface;

import libSource.*;
import libSource.Database.*;
import libSource.Attributes.*;

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;
import sun.security.krb5.internal.crypto.Des;

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
    private JTextField searchEdit;
    private JButton button3;
    private JTextField NameEdit;
    private JTextField DescrEdit;
    private JTextField LinkEdit;
    private JTextField ThemeEdit;
    private JTextField TypeEdit;
    private JTextField AccessTypeEdit;
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

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3_clicked();
            }
        });
    }


    // Выборка всего
    private void button1_clicked() {
        try {
           // table1.setModel(buildTableModel(dbFacade.getAllResources()));
            AttributeList lst = new AttributeList();

            AttributeName           atn = new AttributeName("");
            AttributeDescription    atd = new AttributeDescription("");
            AttributeLink           atl = new AttributeLink("");
            AttributeTheme          ath = new AttributeTheme("");
            AttributeType           atp = new AttributeType("");
            AttributeAccessType     atat = new AttributeAccessType("");
            AttributeKind           atk  = new AttributeKind("");

            lst.add(atn);
            lst.add(atd);
            lst.add(atl);
            lst.add(ath);
            lst.add(atp);
            lst.add(atat);
            lst.add(atk);


            table1.setModel(buildTableModel(dbFacade.getSomeResources(lst, atn)));

        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.exit(-1);
        }
    }
    // Кнопка, демонстрирующая простой поиск
    private void button2_clicked() {
        try {
            table1.setModel(buildTableModel(dbFacade.simpleSearch(searchEdit.getText())));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.exit(-1);
        }
    }

    // Кнопка, демонстрирующая расш.поиск
    private void button3_clicked() {
        try {
            AttributeList lst = new AttributeList();
            
            AttributeName           atn = new AttributeName("");
            AttributeDescription    atd = new AttributeDescription("");
            AttributeLink           atl = new AttributeLink("");
            AttributeTheme          ath = new AttributeTheme("");
            AttributeType           atp = new AttributeType("");
            AttributeAccessType     atat = new AttributeAccessType("");

            if (!NameEdit.getText().isEmpty()) {
                atn.setAttributeValue(NameEdit.getText());
                lst.add(atn);
            }
            if (!DescrEdit.getText().isEmpty()) {
                atd.setAttributeValue(DescrEdit.getText());
                lst.add(atd);
            }
            if (!LinkEdit.getText().isEmpty()) {
                atl.setAttributeValue(LinkEdit.getText());
                lst.add(atl);
            }
            if (!ThemeEdit.getText().isEmpty()) {
                ath.setAttributeValue(ThemeEdit.getText());
                lst.add(ath);
            }
            if (!TypeEdit.getText().isEmpty()) {
                atp.setAttributeValue(TypeEdit.getText());
                lst.add(atp);
            }
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
            lstOut.add(atp);
            lstOut.add(atat);

            if (lst.size() > 0)
                table1.setModel(buildTableModel(dbFacade.extendedSearch(lstOut, lst)));

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


