
package WebService.B21DCCN214;

import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class LamSachVaDaoNguocChuoi {
    public static void main(String[] args) throws Exception{
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        String studentCode = "B21DCCN214", qCode = "IKrW3J8J";
        String s = port.requestString(studentCode, qCode);
        System.out.println(s);
        String res = "";
        for (char x : s.toCharArray()) {
            if (Character.isAlphabetic(x)) {
                res += x;
            }
        }
        String ans = "";
        for (int i = res.length() - 1; i >= 0; i--) {
            ans += res.charAt(i);
        }
        System.out.println(ans);
        port.submitCharacterString(studentCode, qCode, ans);
    }
}
