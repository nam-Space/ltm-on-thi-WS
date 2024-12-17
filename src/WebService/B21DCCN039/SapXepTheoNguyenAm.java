
package WebService.B21DCCN039;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class SapXepTheoNguyenAm {
    public static int demNguyenAm(String s) {
        int cnt = 0;
        for (char x : s.toCharArray()) {
            if (x == 'u' || x == 'e' || x == 'o' || x == 'a' || x == 'i') cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args) throws Exception {
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        String msv = "B21DCCN039", qCode = "2kbuW7re";
        List<String> a = port.requestStringArray(msv, qCode);
        System.out.println(a);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return demNguyenAm(s1) - demNguyenAm(s2);
            }
        });
        System.out.println(a);
        port.submitCharacterStringArray(msv, qCode, a);
    }
}
