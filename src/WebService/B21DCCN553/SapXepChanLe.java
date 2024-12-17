
package WebService.B21DCCN553;

import java.io.*;
import java.util.*;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class SapXepChanLe {
    public static void main(String[] args) throws Exception{
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        
        String msv = "B21DCCN553", qCode = "DGYEn2Q9";
        List<Integer> a = port.getData(msv, qCode);
        System.err.println(a);
        List<Integer> chan = new ArrayList<>();
        List<Integer> le = new ArrayList<>();
        for (Integer x : a) {
            if (x % 2 == 0) chan.add(x);
            else le.add(x);
        }
        List<Integer> res = new ArrayList<>();
        int max_len = chan.size() < le.size() ? chan.size() : le.size();
        int cnt = 0;
        for (int i = 0; i < max_len; i++) {
            res.add(chan.get(i));
            res.add(le.get(i));
            cnt++;
        }
        while(cnt < chan.size()) {
            res.add(chan.get(cnt));
            cnt++;
        }
        while(cnt < le.size()) {
            res.add(le.get(cnt));
            cnt++;
        }
        port.submitDataIntArray(msv, qCode, res);
        System.out.println(res);
    }
}
