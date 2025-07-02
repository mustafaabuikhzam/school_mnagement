package school.management.ui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import school.management.Alert;
import school.management.InputException;
import school.management.Question;
import org.apache.log4j.Logger;
/**
 *
 * @author ahmed
 */
public class ExamsUI extends javax.swing.JFrame {
    private final DefaultListModel questionsModel;
    private DefaultListModel chociesModel; 
    private final ArrayList<Question> questionArray;
    public ExamsUI() {
        initComponents();
        
        this.setTitle("Exams");
        
        Header header = new Header(this,jPanel1);
        header.setTitle("Exams","icons\\icons8_Test_Passed_96px.png");
        header.setBackTo(new HomeUI());
        
        questionsModel = new DefaultListModel();
        questionsList.setModel(questionsModel);
        
        questionArray = new ArrayList<>();
    }
    
    private void clearFields(){
        question.setText("");
        answerA.setText("");
        answerB.setText("");
        answerC.setText("");
        answerD.setText("");
    }
    
    private void checkFieldsForAdding() throws InputException {
        if(question.getText().isEmpty()){
            throw new InputException();
        } else if (answerA.getText().isEmpty() || answerB.getText().isEmpty() ||
                    answerC.getText().isEmpty() || answerD.getText().isEmpty()){
            throw new InputException();
        }
    }
    
    private void checkFieldsToExtract() throws InputException {
        if(!studentsNumber.getText().matches("[0-9]+"))
            throw new InputException();
        else if (!questionsNumber.getText().matches("[0-9]*"))
            throw new InputException();
        else if (topic.getText().isEmpty())
            throw new InputException("Topic");
        else if (questionArray.size() + 1 < Integer.parseInt(questionsNumber.getText())){
            throw new NullPointerException();
        }
    }
    
    private File checkPath(String path){
        File file = new File(path);
            if (!file.exists()) {
                file.mkdir();
            }
        return file;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        question = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionsList = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        topic = new javax.swing.JTextField();
        extract = new javax.swing.JButton();
        byTeacher = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        questionsNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        studentsNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        load = new javax.swing.JButton();
        answerD = new javax.swing.JTextField();
        answerA = new javax.swing.JTextField();
        answerC = new javax.swing.JTextField();
        answerB = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chocies = new javax.swing.JList();
        questionCounter = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        questionCounter1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Choices : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 510, -1, 30));

        question.setBackground(new java.awt.Color(255, 255, 255));
        question.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jPanel1.add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 430, 40));

        questionsList.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        questionsList.setToolTipText("");
        questionsList.setFixedCellHeight(40);
        questionsList.setFocusable(false);
        questionsList.setName(""); // NOI18N
        questionsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionsListMouseClicked(evt);
            }
        });
        questionsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                questionsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(questionsList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 490, 280));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("D : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, 40));

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 130, 40));

        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 130, 40));

        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 130, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Exam topic : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, -1, 40));

        topic.setBackground(new java.awt.Color(255, 255, 255));
        topic.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 390, 40));

        extract.setText("Extract");
        extract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extractActionPerformed(evt);
            }
        });
        jPanel1.add(extract, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 730, 210, 40));

        byTeacher.setBackground(new java.awt.Color(255, 255, 255));
        byTeacher.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(byTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, 390, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("By  : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, 40));

        questionsNumber.setBackground(new java.awt.Color(255, 255, 255));
        questionsNumber.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(questionsNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 100, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Number of questions  : ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, -1, 40));

        studentsNumber.setBackground(new java.awt.Color(255, 255, 255));
        studentsNumber.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(studentsNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 630, 100, 40));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Number of students  : ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 630, -1, 40));

        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 730, 210, 40));

        load.setText("LOAD");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });
        jPanel1.add(load, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 730, 210, 40));

        answerD.setBackground(new java.awt.Color(255, 255, 255));
        answerD.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jPanel1.add(answerD, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 200, 40));

        answerA.setBackground(new java.awt.Color(255, 255, 255));
        answerA.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jPanel1.add(answerA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 200, 40));

        answerC.setBackground(new java.awt.Color(255, 255, 255));
        answerC.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jPanel1.add(answerC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 200, 40));

        answerB.setBackground(new java.awt.Color(255, 255, 255));
        answerB.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jPanel1.add(answerB, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 200, 40));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Question : ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("A : ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("B : ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("C : ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, 40));

        chocies.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        chocies.setToolTipText("");
        chocies.setFixedCellHeight(40);
        chocies.setFocusable(false);
        chocies.setName(""); // NOI18N
        chocies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chociesMouseClicked(evt);
            }
        });
        chocies.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                chociesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(chocies);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, 490, 170));

        questionCounter.setBackground(new java.awt.Color(255, 255, 255));
        questionCounter.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        questionCounter.setText("0");
        jPanel1.add(questionCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, -1, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("All questions : ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, 30));

        questionCounter1.setBackground(new java.awt.Color(255, 255, 255));
        questionCounter1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        questionCounter1.setText("Questions : ");
        jPanel1.add(questionCounter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            checkFieldsForAdding();
            
            Question q = new Question(question.getText());
            q.setA(answerA.getText());
            q.setB(answerB.getText());
            q.setC(answerC.getText());
            q.setD(answerD.getText());
            questionArray.add(q);
            questionsModel.addElement(q.getQuestion());
            clearFields();
        } catch(InputException ex){
            Alert.viewWarningMessage(ex.toString());
        }
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            questionArray.remove(questionsList.getSelectedIndex());
            questionsModel.remove(questionsList.getSelectedIndex());
            chociesModel.removeAllElements();
        } catch (ArrayIndexOutOfBoundsException ex ) {
            Alert.viewWarningMessage("Plase select a question !");
            Logger.getLogger(ExamsUI.class).warn(ex);
        } catch(NullPointerException ex){
            Alert.viewErrorMessage("There's an error...");
            Logger.getLogger(ExamsUI.class).error(ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try {
            checkFieldsForAdding();
            int index = questionsList.getSelectedIndex();
            Question q = questionArray.get(index);
            q.setQuestion(question.getText());
            q.setA(answerA.getText());
            q.setB(answerB.getText());
            q.setC(answerC.getText());
            q.setD(answerD.getText());
            questionsModel.set(index, q.getQuestion());
            clearFields();
            questionsList.clearSelection();
        } catch (InputException ex) {
            Alert.viewWarningMessage(ex.toString());
        } catch (ArrayIndexOutOfBoundsException ex ) {
            Alert.viewWarningMessage("Plase select a question !");
            Logger.getLogger(ExamsUI.class).warn(ex);
        } 
    }//GEN-LAST:event_editActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

    }//GEN-LAST:event_jPanel1MouseClicked

    private void questionsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_questionsListValueChanged
        
    }//GEN-LAST:event_questionsListValueChanged

    private void questionsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionsListMouseClicked
        try {
                if (evt.getClickCount() == 2) {
                Question q = questionArray.get(questionsList.getSelectedIndex());
                question.setText(q.getQuestion());
                answerA.setText(q.getA());
                answerB.setText(q.getB());
                answerC.setText(q.getC());
                answerD.setText(q.getD());
            }
            Question q = questionArray.get(questionsList.getSelectedIndex());
            chociesModel = new DefaultListModel();
            chociesModel.addElement(q.getA());
            chociesModel.addElement(q.getB());
            chociesModel.addElement(q.getC());
            chociesModel.addElement(q.getD());
            chocies.setModel(chociesModel);
        } catch (ArrayIndexOutOfBoundsException ex){
            Alert.viewWarningMessage("The List is empty...");
            Logger.getLogger(ExamsUI.class).warn(ex);
        }
    }//GEN-LAST:event_questionsListMouseClicked

    private void chociesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chociesMouseClicked
        
    }//GEN-LAST:event_chociesMouseClicked

    private void chociesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_chociesValueChanged
        
    }//GEN-LAST:event_chociesValueChanged

    private void extractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extractActionPerformed
        try {
            checkFieldsToExtract();
            Document doc = new Document();
            
            PdfWriter.getInstance(doc, new FileOutputStream(checkPath("Exams/randomization")+"/file.pdf"));
            doc.open();
            int howManyStudent = Integer.parseInt(studentsNumber.getText());
            for (int i=1; i<=howManyStudent; i++){
                Paragraph title = new Paragraph(topic.getText()+"\n\n", new Font(Font.FontFamily.HELVETICA,18));
                title.setAlignment(Element.ALIGN_CENTER);
                doc.add(title);
                Paragraph id_name = new Paragraph("ID:......................."+
                        "             "+"Name:.........................\n\n\n\n",
                        new Font(Font.FontFamily.HELVETICA,14));
                doc.add(id_name);
                int numberOfQuestions = Integer.parseInt(questionsNumber.getText());
                ArrayList<Question> randomQuestions = randomizationQuestions(questionArray,numberOfQuestions);
                for (int counter=0; counter<randomQuestions.size(); counter++){
                    Paragraph multiQuestion = new Paragraph(
                            (counter+1)+" - "+randomQuestions.get(counter).getQuestion() + "?"
                                    + "\nA. " + randomQuestions.get(counter).getA()
                                    + "\nB. " + randomQuestions.get(counter).getB()
                                    + "\nC. " + randomQuestions.get(counter).getC()
                                    + "\nD. " + randomQuestions.get(counter).getD(),
                            new Font(Font.FontFamily.HELVETICA,12)
                    );
                    doc.add(multiQuestion);
                    doc.add(new Paragraph("\n"));
                }
                Paragraph endPage = new Paragraph("END of questions ... \t "+byTeacher.getText(),new Font(Font.FontFamily.HELVETICA,14));
                doc.add(endPage);
                doc.newPage();
            }
            doc.close();
            Alert.viewSuccessMessage("Successfully extraxted file ");
            Logger.getLogger(ExamsUI.class).info("Extraxted file");
        } catch (InputException ex) {
            Alert.viewWarningMessage(ex.toString());
        } catch (FileNotFoundException | DocumentException ex) {
            Alert.viewErrorMessage("There's an error , File not found..");
            Logger.getLogger(ExamsUI.class).error(ex);
        } catch (NullPointerException ex){
            Alert.viewErrorMessage("The size of array smaller then number of questions you insert ");
        }
    }//GEN-LAST:event_extractActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            
            String examName = JOptionPane.showInputDialog("Save the exam as : ");
            int replace = 0;
            if (examName != null) {
                File file = new File(checkPath("Exams") + "\\" + examName + ".e");
                if (file.exists()) {
                    replace = JOptionPane.showConfirmDialog(null,
                            "This file name already exists, Do you want to replace it ?");
                }
                if (replace == 0) {
                    ObjectOutputStream os = new ObjectOutputStream(
                                        new FileOutputStream(checkPath("Exams") + "\\" + examName + ".e"));
                    os.writeInt(questionArray.size());
                    os.writeUTF(topic.getText());
                    for (Question q : questionArray) {
                        os.writeObject(q);
                    }
                    os.close();
                }
            } else {
                throw new InputException();
            }
        } catch (InputException ex) {
            Alert.viewWarningMessage("You should input a name to save the file ");
            Logger.getLogger(ExamsUI.class.getName()).warn(ex);
        } catch (IOException | HeadlessException ex) {
            Alert.viewErrorMessage("There's an error ...");
            Logger.getLogger(ExamsUI.class).error(ex);
        } 
        
    }//GEN-LAST:event_saveActionPerformed

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
        JFileChooser chooser = new JFileChooser("Exams");
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(file));
            questionArray.clear();
            questionsModel.removeAllElements();
            int size = os.readInt();
            topic.setText(os.readUTF());
            for (int i=0;i<size;i++){
                questionArray.add((Question) os.readObject());
            }
            os.close();
        } catch (java.lang.NullPointerException ex ){
            Logger.getLogger(ExamsUI.class).warn(ex);
        }
        catch (IOException | ClassNotFoundException ex) {
            Alert.viewErrorMessage("There's an error");
            Logger.getLogger(ExamsUI.class).error(ex);
        }
        for (Question q : questionArray){
            questionsModel.addElement(q.getQuestion());
        }
    }//GEN-LAST:event_loadActionPerformed

    private ArrayList<Question> randomizationQuestions(ArrayList<Question> questions, int numberOfQuest){
        ArrayList<Question> randomQuestion = new ArrayList<>();
        Random r = new Random();
        int i=0;
        while(i<numberOfQuest){
            Question q = questions.get(r.nextInt(questions.size()));
            if (!randomQuestion.contains(q)){
                String[] c = {q.getA(),q.getB(),q.getC(),q.getD()};
                ArrayList<String> chociesArray = new ArrayList<>(Arrays.asList(c));
                ArrayList<String> randomChocies = new ArrayList<>();
                int j=0;
                while(j<chociesArray.size()){
                    String chocie = chociesArray.get(r.nextInt(chociesArray.size()));
                    if(!randomChocies.contains(chocie)){
                        randomChocies.add(chocie);
                        j++;
                    }
                }
                q.setA(randomChocies.get(0));
                q.setB(randomChocies.get(1));
                q.setC(randomChocies.get(2));
                q.setD(randomChocies.get(3));
                randomQuestion.add(q);
                i++;
            }
        }
        return randomQuestion;
    }
    
    
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
            java.util.logging.Logger.getLogger(ExamsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExamsUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField answerA;
    private javax.swing.JTextField answerB;
    private javax.swing.JTextField answerC;
    private javax.swing.JTextField answerD;
    private javax.swing.JTextField byTeacher;
    private javax.swing.JList chocies;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton extract;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton load;
    private javax.swing.JTextField question;
    private javax.swing.JLabel questionCounter;
    private javax.swing.JLabel questionCounter1;
    private javax.swing.JList questionsList;
    private javax.swing.JTextField questionsNumber;
    private javax.swing.JButton save;
    private javax.swing.JTextField studentsNumber;
    private javax.swing.JTextField topic;
    // End of variables declaration//GEN-END:variables
}
