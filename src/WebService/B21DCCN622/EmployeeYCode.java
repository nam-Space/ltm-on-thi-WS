
package WebService.B21DCCN622;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import vn.medianews.EmployeeY;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;

public class EmployeeYCode {
    public static int ngay(EmployeeY x) {
        Calendar start = Calendar.getInstance(), end = Calendar.getInstance();
        start.setTime(x.getStartDate().toGregorianCalendar().getTime());
        end.setTime(new Date());
        int cntDate = 0;
        while (!start.after(end)) {
            cntDate++;
            start.add(Calendar.DAY_OF_YEAR, 1);
        }
        return cntDate;
    }
    
    public static void main(String[] args) throws Exception{
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        String studentCode = "B21DCCN622", qCode = "tPAn7486";
        List<EmployeeY> a = port.requestListEmployeeY(studentCode, qCode);
        for (EmployeeY x : a) {
            System.out.println(x.getName() + ": " + x.getStartDate());
        }
        Collections.sort(a, new Comparator<EmployeeY>() {
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                return ngay(o2) - ngay(o1);
            }
        });
        System.out.println("----------------------------");
        for (EmployeeY x : a) {
            System.out.println(x.getName() + ": " + x.getStartDate());
        }
        port.submitListEmployeeY(studentCode, qCode, a);
    }
}
