
package WebService.B21DCCN509;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class SapXepChuoiTheoDoDaiTangDan {
    
    public static void main(String[] args) throws Exception {
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        String studentCode = "B21DCCN509", qCode = "nYVtCr1q";
        List<String> a = port.requestStringArray(studentCode, qCode);
        System.out.println(a);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(a);
        port.submitCharacterStringArray(studentCode, qCode, a);
    }
}
