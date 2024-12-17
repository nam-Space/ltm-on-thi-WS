
package WebService.B21DCCN509;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Project;

public class ProjectCode {
    public static void main(String[] args) throws Exception{
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        String studentCode = "B21DCCN509", qCode = "4ETHYv5f";
        List<Project> a = port.requestListProject(studentCode, qCode);
        for (Project x : a) {
            System.out.println(x.getProjectId() + " - " + x.getProjectName() + " - " + x.getCompletionPercentage() + " - " + x.getDueDate());
        }
        List<Project> res = new ArrayList<>();
        for (Project x : a) {
            Calendar start = Calendar.getInstance(), end = Calendar.getInstance();
            start.setTime(new Date());
            end.setTime(x.getDueDate().toGregorianCalendar().getTime());
            int days = 0;
            while(!start.after(end)) {
                days++;
                start.add(Calendar.DAY_OF_MONTH, 1);
            }
            System.out.println(days);
            if (days <= 15 && x.getCompletionPercentage() >= 80) {
                res.add(x);
            }
        }
        for (Project x : res) {
            System.out.println(x.getProjectId() + " - " + x.getProjectName() + " - " + x.getCompletionPercentage() + " - " + x.getDueDate());
        }
        port.submitListProject(studentCode, qCode, res);
    }
}
