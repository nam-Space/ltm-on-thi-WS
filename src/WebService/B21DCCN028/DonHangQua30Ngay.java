
package WebService.B21DCCN028;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.OrderY;

public class DonHangQua30Ngay {
    public static void main(String[] args) throws Exception {
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        
        String studentCode = "B21DCCN028", qCode = "uHG5y8rs";
        List<OrderY> a = port.requestListOrderY(studentCode, qCode);
        for (OrderY x : a) {
            System.out.println(x.getOrderId() + " " + x.getOrderDate() + " " + x.getStatus() + " " + x.getCustomerId());
        }
        List<OrderY> res = new ArrayList<>();
        for (OrderY x : a) {
            Calendar start = Calendar.getInstance(), end = Calendar.getInstance();
            start.setTime(x.getOrderDate().toGregorianCalendar().getTime());
            end.setTime(new Date());
            int period = 0;
            while(!start.after(end)) {
                period++;
                start.add(Calendar.DAY_OF_MONTH, 1);
            }
            System.out.println(period);
            if (period > 30 && (x.getStatus().equals("pending") || x.getStatus().equals("processing"))) {
                res.add(x);
            }
        }
        for (OrderY x : res) {
            System.out.println(x.getOrderId() + " " + x.getOrderDate() + " " + x.getStatus() + " " + x.getCustomerId());
        }
        port.submitListOrderY(studentCode, qCode, res);
    }
}
