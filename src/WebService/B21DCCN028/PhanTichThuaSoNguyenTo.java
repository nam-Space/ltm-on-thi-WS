
package WebService.B21DCCN028;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class PhanTichThuaSoNguyenTo {
    public static String pt(Integer n) {
        String res = "";
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while(n % i == 0) {
                res += i + ", ";
                n /= i;
            }
        }
        if (n > 1) res += n + "";
        else {
            res = res.substring(0, res.length() - 2);
        }
        return res;
    }
    
    public static void main(String[] args) {
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        String studentCode = "B21DCCN028", qCode = "4H6NIBo0";
        List<Integer> a = port.getData(studentCode, qCode);
        System.out.println(a);
        List<String> res = new ArrayList<>();
        for (Integer x : a) {
            System.out.println(pt(x));
            res.add(pt(x));
        }
        port.submitDataStringArray(studentCode, qCode, res);
    }
}
