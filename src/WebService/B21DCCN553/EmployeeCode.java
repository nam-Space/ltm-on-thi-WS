
package WebService.B21DCCN553;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import vn.medianews.Employee;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;

public class EmployeeCode {
    public static void main(String[] args) throws Exception {
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        String studentCode = "B21DCCN553", qCode = "YqLALT1k";
        Employee employee = port.requestEmployee(studentCode, qCode);
        System.out.println(employee);
        System.out.println(employee.getStartDate());
        System.out.println(employee.getEndDate());
        System.out.println(employee.getWorkingDays());
        Calendar start = Calendar.getInstance(), end = Calendar.getInstance();
        start.setTime(employee.getStartDate().toGregorianCalendar().getTime());
        end.setTime(employee.getEndDate().toGregorianCalendar().getTime());
        int workingDays = 0;
        while(!start.after(end)) {
            int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) workingDays++;
            start.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println(workingDays);
        employee.setWorkingDays(workingDays);
        System.out.println(employee);
        port.submitEmployee(studentCode, qCode, employee);
    }
}
