
package WebService.B21DCCN029;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class PhanTichUocSo {
    public static void main(String[] args) throws Exception{
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        String studentCode = "B21DCCN029", qCode = "4FkqTa3I";
        double a = port.getDataDouble(studentCode, qCode);
        System.out.println(a);
        int n = (int)a;
        System.out.println(n);
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
            }
        }
        System.out.println(res);
        res.add(0, res.size());
        System.out.println(res);
        port.submitDataIntArray(studentCode, qCode, res);
    }
}
