
package WebService.B21DCCN048;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;


public class PhanTuTanSuat {
    public static void main(String[] args) throws Exception{
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        String studentCode = "B21DCCN048", qCode = "k2CM4gvB";
        List<Integer> a = port.getData(studentCode, qCode);
        System.out.println(a);
        Collections.sort(a);
        int []cnt = new int[1000001];
        for (Integer x : a) {
            cnt[x]++;
        }
        List<String> res = new ArrayList<>();
        for (Integer x : a) {
            if (cnt[x] >= 1) {
                String s = x + ", " + cnt[x];
                res.add(s);
                cnt[x] = 0;
            }
        }
        System.out.println(res);
        port.submitDataStringArray(studentCode, qCode, res);
    }
}
