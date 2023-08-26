package Listeci;
import javax.swing.*;

import Listeci.LinkedListCustom.Node;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LinkedListSwingApp extends JFrame {
    private LinkedListCustom linkedList;

    private JButton addFirstButton;
    private JButton addAtIndexButton;
    private JButton addLastButton;
    private JButton deleteButton;
    private JButton displayDataAndNextButton;
    private JButton displayPointerAndDataButton;

    private JTextField inputDataField;
    private JTextField indexField;
    private JTextArea outputArea;

    public LinkedListSwingApp() {
        linkedList = new LinkedListCustom();
        createRandomLinkedList();

        setTitle("Linked List Swing Application");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        addFirstButton = new JButton("Add at the Beginning");
        addAtIndexButton = new JButton("Add at Index");
        addLastButton = new JButton("Add at the End");
        deleteButton = new JButton("Delete Element");
        displayDataAndNextButton = new JButton("Display Data and Next");
        displayPointerAndDataButton = new JButton("Display Pointer and Data");

        inputDataField = new JTextField();
        indexField = new JTextField();
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(addFirstButton);
        add(inputDataField);
        add(addAtIndexButton);
        add(indexField);
        add(addLastButton);
        add(new JLabel()); // Placeholder for formatting
        add(deleteButton);
        add(new JLabel()); // Placeholder for formatting
        add(displayDataAndNextButton);
        add(displayPointerAndDataButton);
        add(new JLabel()); // Placeholder for formatting
        add(new JScrollPane(outputArea));

        addFirstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int data = Integer.parseInt(inputDataField.getText());
                    linkedList.addFirst(data);
                    updateOutput();
                    inputDataField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(LinkedListSwingApp.this, "Invalid input! Please enter an integer.");
                }
            }
        });

        addAtIndexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int data = Integer.parseInt(inputDataField.getText());
                    int index = Integer.parseInt(indexField.getText());
                    linkedList.addAtIndex(data, index);
                    updateOutput();
                    inputDataField.setText("");
                    indexField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(LinkedListSwingApp.this, "Invalid input! Please enter an integer.");
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(LinkedListSwingApp.this, "Index out of range! Please enter a valid index.");
                }
            }
        });

        addLastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int data = Integer.parseInt(inputDataField.getText());
                    linkedList.addLast(data);
                    updateOutput();
                    inputDataField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(LinkedListSwingApp.this, "Invalid input! Please enter an integer.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int data = Integer.parseInt(inputDataField.getText());
                    linkedList.deleteElement(data);
                    updateOutput();
                    inputDataField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(LinkedListSwingApp.this, "Invalid input! Please enter an integer.");
                }
            }
        });

        displayDataAndNextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOutput();
            }
        });

        displayPointerAndDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                Node currentNode = linkedList.head; // Access head directly
                while (currentNode != null) {
                    sb.append("Pointer: ").append(currentNode).append(", Data: ").append(currentNode.data).append("\n");
                    currentNode = currentNode.next;
                }
                outputArea.setText(sb.toString());
            }
        });
    }

    private void createRandomLinkedList() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int data = random.nextInt(100); // Generating random integers between 0 and 100
            linkedList.addLast(data);
        }
    }

    private void updateOutput() {
        outputArea.setText(linkedList.getListAsString());
    }
}

