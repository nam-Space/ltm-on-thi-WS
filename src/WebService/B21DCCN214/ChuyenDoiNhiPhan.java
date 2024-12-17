
package WebService.B21DCCN214;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class ChuyenDoiNhiPhan {
    public static String convert(int n) {
        String s = "";
        while (n > 0) {
            s += n % 2;
            n = n / 2;
        }
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            res += s.charAt(i);
        }
        return res;
    }
    
    public static void main(String[] args) throws Exception{
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        String studentCode = "B21DCCN214", qCode = "tDOYrEtU";
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
