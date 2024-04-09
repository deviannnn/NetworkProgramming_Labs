package Lab7;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class DefaultChatServer extends javax.swing.JFrame {

    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static DataInputStream dataIn;
    private static DataOutputStream dataOut;
    private static boolean isConnected = false;

    public DefaultChatServer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        sendBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatDataArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        msgArea = new javax.swing.JTextArea();
        startBtn = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Default Chat Server");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(600, 352));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        sendBtn.setText("Send");
        sendBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        chatDataArea.setEditable(false);
        chatDataArea.setBackground(new java.awt.Color(255, 255, 255));
        chatDataArea.setColumns(20);
        chatDataArea.setRows(10);
        chatDataArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chatDataArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        chatDataArea.setEnabled(false);
        chatDataArea.setMaximumSize(new java.awt.Dimension(600, 352));
        chatDataArea.setMinimumSize(new java.awt.Dimension(600, 352));
        jScrollPane2.setViewportView(chatDataArea);

        msgArea.setColumns(20);
        msgArea.setRows(5);
        jScrollPane3.setViewportView(msgArea);

        startBtn.setText("Start");
        startBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(startBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sendBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(20, 100, 600, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
        String msgOut = msgArea.getText().trim();

        if (!isConnected || msgOut.equals("")) {
            if (!isConnected) {
                JOptionPane.showMessageDialog(null, "No connection established yet!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            msgArea.setText("");
            return;
        }

        try {
            dataOut.writeUTF("\nServer: " + msgOut);
            chatDataArea.append("\nMe: " + msgOut);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Server Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        msgArea.setText("");
    }//GEN-LAST:event_sendBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error closing server socket: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        // TODO add your handling code here:
        try {
            serverSocket = new ServerSocket(2020);
            Thread serverThread = new Thread(() -> {
                while (true) {
                    try {
                        clientSocket = serverSocket.accept();

                        Thread clientHandlerThread = new Thread(() -> {
                            try {
                                dataIn = new DataInputStream(clientSocket.getInputStream());
                                dataOut = new DataOutputStream(clientSocket.getOutputStream());

                                String msgIn = "";
                                while (!msgIn.equals("exit")) {
                                    msgIn = dataIn.readUTF();
                                    chatDataArea.append(msgIn);
                                }
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "Client connection error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        });

                        clientHandlerThread.start();
                        isConnected = true;
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Server connection error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            });

            serverThread.start();
            chatDataArea.setText("Server was started ...\n");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Sever gap van de ve I/O", "Note", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_startBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatDataArea;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea msgArea;
    private javax.swing.JButton sendBtn;
    private javax.swing.JButton startBtn;
    // End of variables declaration//GEN-END:variables
}
