package oracle.certified.associate.SE81Z0808.test.predicate;

import java.util.function.Predicate;

/**
 * Created by p on 16/02/2017.
 */
public class MyCheckEmployee implements CheckEmployee {
    @Override
    public boolean check(Employee e) {
        return e.getSalary() > 1_00_000;
    }
}
