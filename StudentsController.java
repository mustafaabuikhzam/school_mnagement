package school.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentsController {
    public static void add(Students s){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = DB.DBconnect();
            String sql = "INSERT INTO students "
                    + "(std_id, first_name, middle_name, last_name, gender, birthday"
                    + ", admission_date, guardian_name, phone, address, "
                    + "education_stage, notes) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, s.getId());
            pstmt.setString(2, s.getFirstName());
            pstmt.setString(3, s.getMiddleName());
            pstmt.setString(4, s.getLastName());
            pstmt.setInt(5, s.getGender());
            pstmt.setString(6, s.getBirthday());
            pstmt.setString(7, s.getAdmissionDate());
            pstmt.setString(8, s.getGuardianName());
            pstmt.setString(9, s.getPhone());
            pstmt.setString(10, s.getAddress());
            pstmt.setInt(11, s.getEducationStage());
            pstmt.setString(12, s.getNotes());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            Alert.viewWarningMessage("Someting Wrong !!" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                Alert.viewWarningMessage("Someting Wrong !!" + e);
            }
        }
     }
    
   public static void update(Students s){
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = DB.DBconnect();
        String sql = "UPDATE students SET  "
                + "first_name = ?, middle_name = ?, last_name = ?, gender = ?, birthday = ?"
                + ", admission_date = ?, guardian_name = ?, phone = ?, address = ?, "
                + "education_stage = ?, notes = ? "
                + " WHERE std_id = ?";
        
        pstmt = conn.prepareStatement(sql);
        
        // طباعة الاستعلام للمراجعة
        System.out.println("Executing SQL: " + sql);
        
        pstmt.setString(1, s.getFirstName());
        pstmt.setString(2, s.getMiddleName());
        pstmt.setString(3, s.getLastName());
        pstmt.setInt(4, s.getGender());
        pstmt.setString(5, s.getBirthday());
        pstmt.setString(6, s.getAdmissionDate());
        pstmt.setString(7, s.getGuardianName());
        pstmt.setString(8, s.getPhone());
        pstmt.setString(9, s.getAddress());
        pstmt.setInt(10, s.getEducationStage());
        pstmt.setString(11, s.getNotes());
        pstmt.setInt(12, s.getId());

        int rowsUpdated = pstmt.executeUpdate();
        
        // التحقق من عدد الصفوف التي تم تعديلها
        if (rowsUpdated > 0) {
            Alert.viewSuccessMessage("تم تعديل البيانات بنجاح.");
        } else {
            Alert.viewWarningMessage("لم يتم العثور على السجل للتعديل.");
        }

    } catch (SQLException e) {
        // طباعة تفاصيل الخطأ
        System.out.println("SQLException: " + e.getMessage());
        Alert.viewWarningMessage("Something went wrong !! " + e.getMessage());
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            Alert.viewWarningMessage("Something went wrong !! " + e);
        }
    }
}


    
    public static void delete(String id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = DB.DBconnect();
            String sql = "DELETE FROM students WHERE std_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            Alert.viewWarningMessage("Someting Wrong !!" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                Alert.viewWarningMessage("Someting Wrong !!" + e);
            }
        }
    }
    
    private static ArrayList<Students> studentSqlStatement(String sql){
        ArrayList<Students> get = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DB.DBconnect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                Students s = new Students();
                s.setId(rs.getInt("std_id"));
                s.setFirstName(rs.getString("first_name"));
                s.setMiddleName(rs.getString("middle_name"));
                s.setLastName(rs.getString("last_name"));
                s.setAddress(rs.getString("address"));
                s.setAdmissionDate(rs.getDate("admission_date").toString());
                s.setBirthday(rs.getDate("birthday").toString());
                s.setEducationStage(rs.getInt("education_stage"));
                s.setGender(rs.getInt("gender"));
                s.setGuardianName(rs.getString("guardian_name"));
                s.setPhone(rs.getString("phone"));
                s.setNotes(rs.getString("notes"));
                get.add(s);
            }
            
            return get;
            
        } catch (SQLException e) {
            Alert.viewWarningMessage("Someting Wrong !!" + e);
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                Alert.viewWarningMessage("Someting Wrong !!" + e);
            }
        }
        return null;
    }
  
    public static ArrayList<Students> getAll(){
        String sql = "SELECT * FROM students ORDER BY std_id ASC";
        return studentSqlStatement(sql);
    }
    
    public static ArrayList<Students> searchById(String id){
        String sql = "SELECT * FROM students WHERE std_id LIKE '%" + id + "%' ORDER BY std_id ASC";
        return studentSqlStatement(sql);
    }
    
    public static ArrayList<Students> searchByName(String name){
        String sql = "SELECT * FROM students WHERE CONCAT(first_name,' ',middle_name,' ',last_name) "
                + "LIKE '%" + name + "%' ORDER BY std_id ASC";
        return studentSqlStatement(sql);
    }
    
    public static Students getStudentByID(String id){
        String sql = "SELECT * FROM students WHERE std_id = " + id;
        ArrayList<Students> students = studentSqlStatement(sql);
        if (!students.isEmpty()) {
            return students.get(0);
        } 
        return null;
    }
    
    public static void setStudentSubjects(int id,int grade){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = DB.DBconnect();
            
            for(int sub=1; sub<=8; sub++){
                for(int sem=1; sem<=2;sem++){
                    String sql = "INSERT INTO student_marks (std_id, sub_id, grade, semester) VALUES (?, ?, ?, ?);";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, id);
                    pstmt.setInt(2, sub);
                    pstmt.setInt(3, grade);
                    pstmt.setInt(4, sem);
                    pstmt.executeUpdate();
                    pstmt.close();
                }
            }
            
            conn.close();
        } catch (SQLException e) {
            Alert.viewWarningMessage("Someting Wrong !!" + e);
        }
    }
    
    public static ArrayList<Subjects> getStudentSubsByID(int id,int grade,int semester){
        ArrayList<Subjects> subs = new ArrayList<>();
        String sql = "SELECT subjects.sub_id,subjects.sub_name,sm.semester,sm.first_month,sm.second_month,sm.third_month,sm.midterm, sm.final FROM student_marks sm INNER JOIN subjects USING(sub_id) INNER JOIN students USING(std_id) WHERE std_id = ? AND grade = ? AND semester = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = DB.DBconnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, grade);
            pstmt.setInt(3, semester);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Subjects sub = new Subjects();
                sub.setSub_int(rs.getInt("sub_id"));
                sub.setSemester(rs.getInt("semester"));
                sub.setSub_name(rs.getString("sub_name"));
                sub.setFirst_month(rs.getInt("first_month"));
                sub.setSecond_month(rs.getInt("second_month"));
                sub.setThird_month(rs.getInt("third_month"));
                sub.setMidterm(rs.getInt("midterm"));
                sub.setFinalExam(rs.getInt("final"));
                subs.add(sub);
            }
            
            return subs;
            
        } catch (SQLException e) {
            Alert.viewWarningMessage("Someting Wrong !!" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                Alert.viewWarningMessage("Someting Wrong !!" + e);
            }
        }
        return null;
    }
    
    public static void studentSubMarksUpdate(int std_id,int grade,int semester,Subjects sub){
        String sql = "UPDATE student_marks SET first_month = ?,second_month = ?,third_month = ?,midterm = ?,final = ? WHERE std_id = ? AND grade = ? AND sub_id = ? AND semester = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = DB.DBconnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sub.getFirst_month());
            pstmt.setInt(2, sub.getSecond_month());
            pstmt.setInt(3, sub.getThird_month());
            pstmt.setInt(4, sub.getMidterm());
            pstmt.setInt(5, sub.getFinalExam());
            pstmt.setInt(6, std_id);
            pstmt.setInt(7, grade);
            pstmt.setInt(8, sub.getSub_int());
            pstmt.setInt(9, sub.getSemester());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            Alert.viewWarningMessage("Someting Wrong !!" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                Alert.viewWarningMessage("Someting Wrong !!" + e);
            }
        }
    }
}
