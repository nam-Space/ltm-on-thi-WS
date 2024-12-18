
package WebService.B21DCCN015;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;


public class SoLonNhatDuocTaoTuMang {
    public static void main(String[] args) throws Exception{
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        String studentCode = "B21DCCN015", qCode = "fCtJeDin";
        List<Integer> a = port.getData(studentCode, qCode);
        System.out.println(a);
        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "", s2 = o2 + "";
                return s2.compareTo(s1);
            }
        });
        System.out.println(a);
        String res = "";
        for (Integer x : a) {
            res += x;
        }
        System.out.println(res);
        port.submitDataString(studentCode, qCode, res);
    }
}
