
package WebService.B21DCCN048;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Student;

public class StudentCode {
    public static void main(String[] args) throws Exception{
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        String studentCode = "B21DCCN048", qCode = "QgdMPsyr";
        List<Student> a = port.requestListStudent(studentCode, qCode);
        for (Student x : a) {
            System.out.println(x.getName() + " - " + x.getScore());
        }
        System.out.println("---------------");
        List<Student> res = new ArrayList<>();
        for (Student x : a) {
            if (x.getScore() >= 8.0 || x.getScore() < 5.0) {
                res.add(x);
            }
        } 
        port.submitListStudent(studentCode, qCode, res);
    }
}
