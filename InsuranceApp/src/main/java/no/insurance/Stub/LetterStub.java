package no.insurance.Stub;

import no.insurance.domain.Letter;
import no.insurance.helper.Insurance;
import no.insurance.helper.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by p on 29/10/2016.
 */
public class LetterStub {
    private static Map<Long, Letter> letterMap = new HashMap<Long, Letter>();
    private static Long idIndex = 3L;

    private static Long userId1 = 1L;
    private static Long userId2 = 2L;
    private static Long userId3 = 3L;

    static {
        Letter letter = new Letter(1L, userId1, Insurance.CAR.getValue(), "product got for my car", State.SEND.getValue(), 3450.5);
        letterMap.put(1L, letter);

        letter = new Letter(2L, userId2, Insurance.HOME.getValue(), "product got for my home", State.PAY.getValue(), 3450.5);
        letterMap.put(2L, letter);

        letter = new Letter(3L, userId3, Insurance.BOAT.getValue(), "product got for my boat", State.ACTIVE.getValue(), 3450.5);
        letterMap.put(3L, letter);

        /*
            Long Id;
            Integer userId;
            Integer type;
            String product;
            Integer state;
            Double price;
         */

    }

    public static List<Letter> list() {

        return new ArrayList<Letter>(letterMap.values());

    }

    public static Letter create(Letter letter) {

        idIndex += 1;
        letter.setId(idIndex);
        letterMap.put(idIndex, letter);
        return letter;
    }

    public static Letter get(Long id) {

        return letterMap.get(id);
    }

    public static Letter update(Long id, Letter letter) {

        letterMap.put(id, letter);
        return letter;

    }

    public static Letter delete(Long id) {

        return letterMap.remove(id);
    }

}
