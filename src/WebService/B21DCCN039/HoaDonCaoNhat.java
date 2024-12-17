
package WebService.B21DCCN039;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Order;

public class HoaDonCaoNhat {
    public static void main(String[] args) throws Exception{
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        String studentCode = "B21DCCN039", qCode = "yDvKOPOR";
        List<Order> a = port.requestListOrder(studentCode, qCode);
        for (Order x : a) {
            System.out.println(x.getCustomerId() + " " + x.getAmount() + " " + x.getStatus());
        }
        Map<String, Float> mp = new HashMap<>();
        for (Order x : a) {
            mp.put(x.getCustomerId(), mp.getOrDefault(x.getCustomerId(), 0f) + x.getAmount()); 
        }
        String makhMax = "";
        float amountMax = 0;
        for (String makh : mp.keySet()) {
            float amount = mp.get(makh);
            if (amount > amountMax) {
                amountMax = amount;
                makhMax = makh;
            }
        }
        System.out.println("---------------------------------------------------");
        List<Order> res = new ArrayList<>();
        for (Order x : a) {
            if (x.getCustomerId().equals(makhMax)) {
                res.add(x);
            }
        }
        for (Order x : res) {
            System.out.println(x.getCustomerId() + " " + x.getAmount() + " " + x.getStatus());
        }
        port.submitListOrder(studentCode, qCode, res);
    }
}
