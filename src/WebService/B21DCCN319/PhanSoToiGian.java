
package WebService.B21DCCN319;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class PhanSoToiGian {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        String studentCode = "B21DCCN319", qCode = "OmQ1nmL4";
        double a = port.getDataDouble(studentCode, qCode);
        System.out.println(a);
        a = Math.round(a * 100) / 100.0;
        int tu = (int) (a * 100.0);
        int mau = 100;
        int uc = gcd(tu, mau);
        tu /= uc;
        mau /= uc;
        List<Integer> res = new ArrayList<>();
        res.add(tu);
        res.add(mau);
        System.out.println(res);
        port.submitDataIntArray(studentCode, qCode, res);
    }
}
