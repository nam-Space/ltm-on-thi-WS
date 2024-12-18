
package WebService.B21DCCN021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Order;


public class OrderCode {
    public static void main(String[] args)throws Exception{
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        String studentCode = "B21DCCN021", qCode = "CuW1L0ev";
        List<Order> a = port.requestListOrder(studentCode, qCode);
        for (Order x : a) {
            System.out.println(x.getCustomerId() + " - " + x.getAmount() + " - " + x.getStatus());
        }
        Map<String, Float> mp = new HashMap<>();
        for (Order x : a) {
            mp.put(x.getCustomerId(), mp.getOrDefault(x.getCustomerId(), 0f) + x.getAmount());
        }
        String idMax = "";
        float amountMax = 0;
        for (String id : mp.keySet()) {
            float val = mp.get(id);
            if (val > amountMax) {
                amountMax = val;
                idMax = id;
            }
        }
        System.out.println("-----------------");
        List<Order> res = new ArrayList<>();
        for (Order x : a) {
            if (x.getCustomerId().equals(idMax)) {
                res.add(x);
            }
        } 
        for (Order x : res) {
            System.out.println(x.getCustomerId() + " - " + x.getAmount() + " - " + x.getStatus());
        }
        port.submitListOrder(studentCode, qCode, res);
    }
}
