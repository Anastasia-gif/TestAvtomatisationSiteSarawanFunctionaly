import java.util.HashMap;
import java.util.Map;

public class TestData {
    String validUserTel = "9999999999";
    String validUserCode = "8520";
    Map<String,String> invalidDateForEnterPersonArea = new HashMap<>();
    {
        {
            invalidDateForEnterPersonArea.put("","Необходимо ввести номер");
            invalidDateForEnterPersonArea.put("8","Неправильно введен номер");
            invalidDateForEnterPersonArea.put("88","Неправильно введен номер");
            invalidDateForEnterPersonArea.put("88888","Неправильно введен номер");

        }
    }

}
