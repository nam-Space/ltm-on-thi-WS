
package WebService.B21DCCN011;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class PhanSoToiGian {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) throws Exception {
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        String studentCode = "B21DCCN011", qCode = "ny8Fb8BU";
        double a = port.getDataDouble(studentCode, qCode);
        System.out.println(a);
        a = Math.round(a * 100) / 100.0;
        System.out.println(a);
        int tu, mau = 100;
        tu = (int)(a * 100.0);
        int uc = gcd(tu, mau);
        tu /= uc;
        mau /= uc;
        System.out.println(tu);
        System.out.println(mau);
        List<Integer> res = new ArrayList<>();
        res.add(tu);
        res.add(mau);
        port.submitDataIntArray(studentCode, qCode, res);
    }
}
