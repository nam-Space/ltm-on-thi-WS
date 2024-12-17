
package WebService.B21DCCN553;

import java.util.*;
import vn.medianews.*;

public class XoayVongPhai {
    public static void main(String[] args) throws Exception {
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        List<Integer> a = port.requestCharacter("B21DCCN553", "fHIhbY4V");
        System.out.println(a);
        List<Character> b = new ArrayList<>();
        for (Integer x : a) {
            b.add((char) (int) x);
        }
        System.out.println(b);
        int xoay = a.get(0) % a.size();
        System.out.println(a.get(0));
        System.out.println(xoay);
        Collections.rotate(a, xoay);
        Collections.rotate(b, xoay);
        System.out.println(a);
        System.out.println(b);
        port.submitCharacterCharArray("B21DCCN553", "fHIhbY4V", a);
    }
}
