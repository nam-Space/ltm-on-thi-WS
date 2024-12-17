
package WebService.B21DCCN564;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class NhomTheoSoLuongNguyenAm {
    public static int demNguyenAm(String s) {
        int cnt = 0;
        String tmp = "ueoaiUEOAI";
        for (char x : s.toCharArray()) {
            if (tmp.contains(x+"")) cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args) throws Exception{
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        String studentCode = "B21DCCN564", qCode = "ptdU1his";
        List<String> a = port.requestStringArray(studentCode, qCode);
        System.out.println(a);
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (!mp.containsKey(a.get(i))) {
                List<String> tmp = new ArrayList<>();
                tmp.add(a.get(i));
                mp.put(a.get(i), demNguyenAm(a.get(i)));
                for (int j = i + 1; j < a.size(); j++) {
                    if (demNguyenAm(a.get(i)) == demNguyenAm(a.get(j)) && !mp.containsKey(a.get(j))) {
                        tmp.add(a.get(j));
                        mp.put(a.get(j), demNguyenAm(a.get(j)));
                    }
                }
                res.add(tmp);
            }
        }
        System.out.println(res);

        List<String> ans = new ArrayList<>();
        for (List<String> s : res) {
            Collections.sort(s);
            String tmp = "";
            for (String x : s) {
                tmp += x + ", ";
            }
            tmp = tmp.substring(0, tmp.length() - 2);
            ans.add(tmp);
        }
        System.out.println(ans);
        port.submitCharacterStringArray(studentCode, qCode, ans);
    }
}
