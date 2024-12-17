
package WebService.B21DCCN039;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class ChuyenDoiNhiPhan {
    public static String convert(Integer x) {
        String tmp = "";
        while(x > 0) {
            tmp += x % 2;
            x = x / 2;
        }
        String res = "";
        for (int i = tmp.length() - 1; i >= 0; i--) {
            res += tmp.charAt(i);
        }
        return res;
    }
    
    public static void main(String[] args) throws Exception{
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        String studentCode = "B21DCCN039", qCode = "p6zy0HCO";
        List<Integer> a = port.getData(studentCode, qCode);
        System.out.println(a);
        List<String> res = new ArrayList<>();
        for (Integer x : a) {
            res.add(convert(x));
        }
        System.out.println(res);
        port.submitDataStringArray(studentCode, qCode, res);
    }
}
