
package WebService.B21DCCN015;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class PascalCamelSnakeCase {
    public static void main(String[] args) throws Exception{
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        String studentCode = "B21DCCN015", qCode = "cvN0ZWnm";
        String s = port.requestString(studentCode, qCode);
        System.out.println(s);
        s = s.replace("_", " ");
        String []arrStr = s.split("\\s+");
        List<String> res = new ArrayList<>();
        String PascalCase = "", camelCase = "", snake_case = "";
        for (int i = 0; i < arrStr.length; i++) {
            PascalCase += arrStr[i].substring(0, 1).toUpperCase() + arrStr[i].substring(1).toLowerCase();
            if (i != 0) {
                camelCase += arrStr[i].substring(0, 1).toUpperCase() + arrStr[i].substring(1).toLowerCase();
            }
            else {
                camelCase += arrStr[i].toLowerCase();
            }
            snake_case += arrStr[i].toLowerCase() + "_";
        }
        snake_case = snake_case.substring(0, snake_case.length() - 1);
        System.out.println(PascalCase);
        System.out.println(camelCase);
        System.out.println(snake_case);
        res.add(PascalCase);
        res.add(camelCase);
        res.add(snake_case);
        port.submitCharacterStringArray(studentCode, qCode, res);
    }
}
