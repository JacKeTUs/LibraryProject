package libSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by dayan on 07.04.2017.
 */
public class CardForm {
    private JFrame frame = new JFrame("CardForm");
    private JPanel CardPanel;
    private JButton editButton;
    private JButton saveButton;
    private JButton discardButton;
    private JTabbedPane tabbedPane1;
    private JTextArea annotationTextArea;
    private JTextArea resourseNameTextArea;
    private JTextArea resoureseOperatorTextArea;
    private JTextArea adressTextArea;
    private JTextArea subjectsTextArea;
    private JTextArea resourseTypeTextArea;
    private JTextArea infoKindTextArea;
    private JTextArea resourseVolumeTextArea;
    private JTextArea languageTextArea;
    private JTextArea timeTextArea;
    private JTextArea archiveInfoTextArea;
    private JPanel generalInfoTab;
    private JPanel subscriptionInfoTab;
    private JPanel subscriptionArchiveTab;
    private JPanel statisticsTab;
    private JPanel additionalInfoTab;
    private JTextArea providerTextArea;
    private JTextArea subscriptionModelTextArea;
    private JTextArea paymentMethonTextArea;
    private JTextArea contractTimeTextArea;
    private JTextArea documentPropsTextArea;
    private JTextArea subscriptionCostTextArea;
    private JTextArea accessModeTextArea;
    private JComboBox testAccessComboBox;
    private JTextField testTimeTextField;
    private JTextArea testAccessConclusionTextArea;
    private JTextArea accessTypeTextArea;
    private JButton showArchiveButton;
    private JLabel catImageLabel;
    private JLabel catInfoLabel;
    private JTextField testAccessTextField;
    private JComboBox accessTypeComboBox;
    private JScrollPane accessTypeScrollPanel;

    private java.util.List<JTextArea> textAreasList = new ArrayList<>();
        // говнокод? :/
    private void fillTextAreasList(){
        textAreasList.add(annotationTextArea);
        textAreasList.add(resourseNameTextArea);
        textAreasList.add(resoureseOperatorTextArea);
        textAreasList.add(subjectsTextArea);
        textAreasList.add(adressTextArea);
        textAreasList.add(resourseTypeTextArea);
        textAreasList.add(infoKindTextArea);
        textAreasList.add(resourseVolumeTextArea);
        textAreasList.add(languageTextArea);
        textAreasList.add(timeTextArea);
        textAreasList.add(archiveInfoTextArea);
        textAreasList.add(providerTextArea);
        textAreasList.add(subscriptionModelTextArea);
        textAreasList.add(paymentMethonTextArea);
        textAreasList.add(contractTimeTextArea);
        textAreasList.add(documentPropsTextArea);
        textAreasList.add(subscriptionCostTextArea);
        textAreasList.add(accessModeTextArea);
        textAreasList.add(testAccessConclusionTextArea);
        textAreasList.add(accessTypeTextArea);

    }


    private void setFieldsUneditable(){
        for (JTextArea area : textAreasList
             ) {
            area.setEditable(false);
            area.setBackground(Color.lightGray);
            testAccessComboBox.setVisible(false);
            testAccessTextField.setVisible(true);
            testTimeTextField.setEditable(false);
            testTimeTextField.setBackground(Color.lightGray);
            accessTypeScrollPanel.setVisible(true);
            accessTypeComboBox.setVisible(false);
        }

    }

    private void setFieldsEditable(){
        for (JTextArea area : textAreasList
                ) {
            area.setEditable(true);
            area.setBackground(Color.white);
            testAccessTextField.setVisible(false);
            testAccessComboBox.setVisible(true);
            testTimeTextField.setEditable(true);
            testTimeTextField.setBackground(Color.white);
            accessTypeScrollPanel.setVisible(false);
            accessTypeComboBox.setVisible(true);
        }
    }

    private boolean fieldsAreCorrect(){

        /*
        HERE TO BE CHECKING
         */
        return true;
    }

    public CardForm() {


        ImageIcon catIcon = new ImageIcon("Docs/cat.png"); // <temporary_shit>
        catImageLabel.setIcon(catIcon);                             //
        catInfoLabel.setVisible(false);                                        //
        catImageLabel.setVisible(false);                                       // </temporary_shit>

        saveButton.setVisible(false);
        discardButton.setVisible(false);
        frame.setSize(650, 550);
       // frame.setResizable(false);
        frame.setContentPane(CardPanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);

        fillTextAreasList();
        setFieldsUneditable();

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFieldsEditable();
                saveButton.setVisible(true);
                discardButton.setVisible(true);
                editButton.setVisible(false);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!fieldsAreCorrect())
                    return;
                setFieldsUneditable();
                editButton.setVisible(true);
                discardButton.setVisible(false);
                saveButton.setVisible(false);
            }
        });

        discardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFieldsUneditable();
                editButton.setVisible(true);
                saveButton.setVisible(false);
                discardButton.setVisible(false);
            }
        });

        showArchiveButton.addActionListener(new ActionListener() {          // this listener to be deleted
            @Override
            public void actionPerformed(ActionEvent e) {
                catInfoLabel.setText("Архива нет, но есть котейка на пицце");
                catImageLabel.setVisible(true);
                catInfoLabel.setVisible(true);
                showArchiveButton.setVisible(false);
            }
        });
    }
}
