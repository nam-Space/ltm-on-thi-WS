
package WebService.B21DCCN015;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.Customer;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;

public class CustomerCode {
    public static void main(String[] args) throws Exception{
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        String studentCode = "B21DCCN015", qCode = "2HqzuZ1J";
        List<Customer> a = port.requestListCustomer(studentCode, qCode);
        for (Customer x : a) {
            System.out.println(x.getCustomerId() + " - " + x.getLocation() + " - " + x.getPurchaseCount() + " - " + x.getTotalSpent());
        }
        List<Customer> res = new ArrayList<>();
        for (Customer x : a) {
            if (x.getTotalSpent() > 5000 && x.getPurchaseCount() >= 5) {
                res.add(x);
            }
        }
        System.out.println("------------------");
        for (Customer x : res) {
            System.out.println(x.getCustomerId() + " - " + x.getLocation() + " - " + x.getPurchaseCount() + " - " + x.getTotalSpent());
        }
        port.submitListCustomer(studentCode, qCode, res);
    }
}
