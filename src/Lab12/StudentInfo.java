package Lab12;

import javax.swing.JOptionPane;

public class StudentInfo extends javax.swing.JFrame {

    /**
     * Creates new form CreateStudent
     *
     * @param isCreate
     */
    public StudentInfo(boolean isCreate) {
        initComponents();

        if (isCreate) {
            showBtn.setEnabled(!isCreate);
            numTf.setEnabled(!isCreate);
            numTf.setText(ManagePerson.getNextNumber() + "");
        } else {
            mainLb.setText("Student Info");
            createBtn.setEnabled(isCreate);
            numTf.setEnabled(isCreate);
            nameTf.setEnabled(isCreate);
            birthdayTf.setEnabled(isCreate);
            scoreTf.setEnabled(isCreate);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mainLb = new javax.swing.JLabel();
        numTf = new javax.swing.JTextField();
        codeTf = new javax.swing.JTextField();
        nameTf = new javax.swing.JTextField();
        birthdayTf = new javax.swing.JTextField();
        scoreTf = new javax.swing.JTextField();
        createBtn = new javax.swing.JButton();
        showBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("Number:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Student Code:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("Full Name:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("Birthday:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("Score:");

        mainLb.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        mainLb.setText("Enter Student Info");

        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        showBtn.setText("Show");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(mainLb))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(birthdayTf)
                            .addComponent(scoreTf)
                            .addComponent(numTf, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeTf)
                            .addComponent(nameTf))))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createBtn)
                .addGap(37, 37, 37)
                .addComponent(showBtn)
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainLb)
                    .addComponent(backBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(birthdayTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(scoreTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(showBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        // TODO add your handling code here:
        String code = codeTf.getText().trim();
        String name = nameTf.getText().trim();
        String birthday = birthdayTf.getText().trim();
        String score = scoreTf.getText().trim();

        if (ManagePerson.codeValidator(code) && ManagePerson.nameValidator(name)
                && ManagePerson.birthdayValidator(birthday) && ManagePerson.scoreValidator(score)) {

            int numberI = Integer.parseInt(numTf.getText());
            double scoreD = Double.parseDouble(score);
            ManagePerson.appendStudent(new Student(numberI, name, code, birthday, scoreD));

            JOptionPane.showMessageDialog(null, "Student added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            new StudentInfo(true).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_createBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtnActionPerformed
        // TODO add your handling code here:
        String code = codeTf.getText().trim();

        Person p = ManagePerson.findByCode(code);

        if (p != null && p instanceof Student student) {
            fillInfo(student);
        } else {
            JOptionPane.showMessageDialog(null, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
            cleanInfo();
        }
    }//GEN-LAST:event_showBtnActionPerformed

    private void cleanInfo() {
        numTf.setText("");
        nameTf.setText("");
        birthdayTf.setText("");
        scoreTf.setText("");
    }

    private void fillInfo(Student student) {
        numTf.setText(student.getNumber() + "");
        codeTf.setText(student.getCode());
        nameTf.setText(student.getName());
        birthdayTf.setText(student.getBirthday());
        scoreTf.setText(student.getScore() + "");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField birthdayTf;
    private javax.swing.JTextField codeTf;
    private javax.swing.JButton createBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel mainLb;
    private javax.swing.JTextField nameTf;
    private javax.swing.JTextField numTf;
    private javax.swing.JTextField scoreTf;
    private javax.swing.JButton showBtn;
    // End of variables declaration//GEN-END:variables
}