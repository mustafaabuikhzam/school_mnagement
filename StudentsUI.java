package school.management.ui;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import school.management.*;

/**
 *
 * @author ahmed
 */
public class StudentsUI extends javax.swing.JFrame {
    public StudentsUI() {
        initComponents();
 
        Header header = new Header(this,jPanel5);
        header.setTitle("Students","icons\\icons8-conference-filled-100.png");
        header.setBackTo(new HomeUI());      
        
        this.setTitle("Students");
       
        ArrayList<Students> students = StudentsController.getAll();
        studentsTable.setModel(getStudentsTable(students));
        studentsTable.setRowSorter(new TableRowSorter<>(studentsTable.getModel()));
        totalStudents.setText(students.size() + "");
        countStudents(students);
    }
    
    private void countStudents(ArrayList<Students> students){
        int maleCount = 0, femaleCount=0;
        for (Students s: students) {
            int check = s.getGender();
            if (check == 1) 
                maleCount++;
            else 
                femaleCount++;
        }
        malesStudents.setText(maleCount +"");
        femalesStudents.setText(femaleCount +"");  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        byID = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delelte = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        totalStudents = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        malesStudents = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        femalesStudents = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        byName = new javax.swing.JTextField();
        print = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        jLabel1 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("select");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Search by ID :");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 30));

        byID.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        byID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                byIDKeyReleased(evt);
            }
        });
        jPanel5.add(byID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 160, 30));

        add.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel5.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 250, 40));

        edit.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel5.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 680, 250, 40));

        delelte.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        delelte.setText("DELETE");
        delelte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delelteActionPerformed(evt);
            }
        });
        jPanel5.add(delelte, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 680, 250, 40));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Total students : ");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, -1, -1));
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 180, 10));

        totalStudents.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        totalStudents.setText("5124");
        jPanel5.add(totalStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 620, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Total males students : ");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 620, -1, -1));
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 650, 210, 10));

        malesStudents.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        malesStudents.setText("5124");
        jPanel5.add(malesStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 620, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Total females students : ");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 620, -1, -1));
        jPanel5.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 650, 210, 10));

        femalesStudents.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        femalesStudents.setText("5124");
        jPanel5.add(femalesStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 620, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Search by name :");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, 30));

        byName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        byName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                byNameKeyReleased(evt);
            }
        });
        jPanel5.add(byName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 160, 30));

        print.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        print.setText("Extract Report");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel5.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 680, 250, 40));

        studentsTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        studentsTable.setRowHeight(30);
        studentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsTableMouseClicked(evt);
            }
        });
        studentsTable.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                studentsTableVetoableChange(evt);
            }
        });
        jScrollPane2.setViewportView(studentsTable);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1200, 370));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmed\\Documents\\NetBeansProjects\\School Management\\icons\\icons8_Refresh_50px.png")); // NOI18N
        jLabel1.setToolTipText("refresh table");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 150, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1224, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        new Add_EditStudentUI().setVisible(true);
    }//GEN-LAST:event_addActionPerformed

    private void byIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_byIDKeyReleased
        studentsTable.setModel(getStudentsTable(StudentsController.searchById(byID.getText())));
        studentsTable.setRowSorter(new TableRowSorter<>(studentsTable.getModel()));
    }//GEN-LAST:event_byIDKeyReleased

    private void delelteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delelteActionPerformed
        try {
            String s_id = studentsTable.getModel().getValueAt(studentsTable.getSelectedRow(), 0).toString();
            StudentsController.delete(s_id);
            ((DefaultTableModel)studentsTable.getModel()).removeRow(studentsTable.getSelectedRow());
        } catch (ArrayIndexOutOfBoundsException ex) {
            Alert.viewWarningMessage("Plase select a row... ");
        } 
    }//GEN-LAST:event_delelteActionPerformed

    private void byNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_byNameKeyReleased
        studentsTable.setModel(getStudentsTable(StudentsController.searchByName(byName.getText())));
        studentsTable.setRowSorter(new TableRowSorter<>(studentsTable.getModel()));
    }//GEN-LAST:event_byNameKeyReleased

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        
        try {
        String s_id = studentsTable.getModel().getValueAt(studentsTable.getSelectedRow(), 0).toString();
            Add_EditStudentUI student = new Add_EditStudentUI();
            student.setVisible(true);
            student.setInputs(StudentsController.getStudentByID(s_id));
        } catch (ArrayIndexOutOfBoundsException ex) {
            Alert.viewWarningMessage("Plase select a row... ");
        }
        
    }//GEN-LAST:event_editActionPerformed

    private void studentsTableVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_studentsTableVetoableChange
       
    }//GEN-LAST:event_studentsTableVetoableChange

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        extractReport();
        
    }//GEN-LAST:event_printActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        ArrayList<Students> students = StudentsController.getAll();
        studentsTable.setModel(getStudentsTable(students));
        studentsTable.setRowSorter(new TableRowSorter<>(studentsTable.getModel()));
        countStudents(students);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void studentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsTableMouseClicked
        if (evt.getClickCount() == 2) {
        try {
            int selectedRow = studentsTable.getSelectedRow();
            if (selectedRow != -1) { // التأكد من أن هناك صف محدد بالفعل
                String s_id = studentsTable.getModel().getValueAt(selectedRow, 0).toString();
                Students student = StudentsController.getStudentByID(s_id);
                if (student != null) {
                    new StudentsProfileUI(student).setVisible(true);
                    this.setVisible(false);
                } else {
                    Alert.viewErrorMessage("Student not found!");
                }
            }
        } catch (Exception ex) { // التقاط أي خطأ محتمل
            Alert.viewErrorMessage("An error occurred while opening student profile:\n" + ex.getMessage());
            // لطباعة الخطأ في الكونسول لتصحيحه لاحقًا
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_studentsTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentsUI().setVisible(true);
            }
        });
    }
    
    private void extractReport(){
    try {
        if (studentsTable.getRowCount() == 0) {
            Alert.viewWarningMessage("لا توجد بيانات طلاب حالياً لإنشاء تقرير.");
            return;
        }

        String[] columnsName = {"ID","Full Name","Gender","Education Stage","Admission Date"};
        new File("reports").mkdirs(); // تأكد من وجود مجلد التقارير

        Document doc = new Document();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        PdfWriter.getInstance(doc, new FileOutputStream("reports/report_" + date + ".pdf"));
        doc.open();

        Paragraph title = new Paragraph("School Manager\n\n\n\n\n", new Font(Font.FontFamily.HELVETICA,16));
        title.setAlignment(Element.ALIGN_CENTER);
        doc.add(title);

        Paragraph context = new Paragraph("This is report for all students : \n\n", new Font(Font.FontFamily.HELVETICA,14));
        doc.add(context);

        PdfPTable pdfTable = new PdfPTable(columnsName.length);
        for (String col : columnsName) {
            PdfPCell cell = new PdfPCell(new Paragraph(col, new Font(Font.FontFamily.HELVETICA, 10)));
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(5);
            pdfTable.addCell(cell);
        }

        for (int row = 0; row < studentsTable.getRowCount(); row++) {
            ArrayList<String> rows = new ArrayList<>();
            rows.add(studentsTable.getModel().getValueAt(row, 0).toString());
            rows.add(studentsTable.getModel().getValueAt(row, 1).toString() 
                + " " + studentsTable.getModel().getValueAt(row, 2).toString() 
                + " " + studentsTable.getModel().getValueAt(row, 3).toString());
            rows.add(studentsTable.getModel().getValueAt(row, 4).toString());
            rows.add(studentsTable.getModel().getValueAt(row, 10).toString());
            rows.add(studentsTable.getModel().getValueAt(row, 6).toString());

            for (int col = 0; col < columnsName.length; col++) {
                PdfPCell cell = new PdfPCell(
                    new Paragraph(rows.get(col), new Font(Font.FontFamily.HELVETICA, 8))
                );
                if (row % 2 != 1) 
                    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPaddingLeft(5);
                cell.setPaddingTop(5);
                cell.setPaddingBottom(5);
                pdfTable.addCell(cell);
            }
        }

        Paragraph total = new Paragraph(
            "\n\n\n\nTotal of all students : " + totalStudents.getText() + "\n"
            + "Total of males students : " + malesStudents.getText() + "\n"
            + "Total of females students : " + femalesStudents.getText(),
            new Font(Font.FontFamily.HELVETICA,10)
        );

        doc.add(pdfTable);
        doc.add(total);
        doc.close();

        Alert.viewSuccessMessage("تم حفظ التقرير بنجاح في مجلد 'reports'.");

    } catch (DocumentException | IOException | NullPointerException | IndexOutOfBoundsException ex) {
        Alert.viewErrorMessage("حدث خطأ أثناء إنشاء التقرير:\n" + ex.toString());
    }
}

    
    private DefaultTableModel getStudentsTable(ArrayList<Students> stds) {
        
        String[] columnNames = {"ID", "First Name","Middle Name","Last Name", "Gender","Birthday", 
            "Admission Date","Parent Name", "Phone Number","Address", "Educational Stage","Notes"};
        DefaultTableModel dtm = new DefaultTableModel(columnNames , 0);
        
        dtm.setColumnCount(12);
        String gender;
        for(Students s : stds) {
            if (s.getGender() == 1) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            dtm.addRow(new Object[] {
                s.getId(),
                s.getFirstName(),
                s.getMiddleName(),
                s.getLastName(),
                gender,
                s.getBirthday(),
                s.getAdmissionDate(),
                s.getGuardianName(),
                s.getPhone(),
                s.getAddress(),
                s.getEducationStage(),
                s.getNotes()
            });
        }
        
        return dtm;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField byID;
    private javax.swing.JTextField byName;
    private javax.swing.JButton delelte;
    private javax.swing.JButton edit;
    private javax.swing.JLabel femalesStudents;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel malesStudents;
    private javax.swing.JButton print;
    private javax.swing.JTable studentsTable;
    private javax.swing.JLabel totalStudents;
    // End of variables declaration//GEN-END:variables
}
