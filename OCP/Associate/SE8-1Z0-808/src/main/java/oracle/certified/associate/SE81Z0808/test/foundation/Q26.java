package oracle.certified.associate.SE81Z0808.test.foundation;

import oracle.certified.associate.SE81Z0808.test.predicate.CheckEmployee;
import oracle.certified.associate.SE81Z0808.test.predicate.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Created by p on 16/02/2017.
 */
public class Q26  {

    public void filterEmployees(ArrayList<Employee> dataList, CheckEmployee p) {
        Iterator<Employee> i = dataList.iterator();
        while (i.hasNext()) {
            if(p.check(i.next())) {
                i.remove();
            }
        }
    }

    public void filterEmployees(ArrayList<Employee> dataList, Predicate<Employee> p) {
        Iterator<Employee> i = dataList.iterator();
        while (i.hasNext()) {
            if(p.test(i.next())) {
                i.remove();
            }
        }
    }


    public static void main(String... args) {

        Predicate<Employee> p = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 1_000_000;
            }
        };

        ArrayList<Employee> employeeList = new ArrayList<>();

        Q26 q26 = new Q26();
        q26.filterEmployees(employeeList, p);

        //q26.filterEmployees(employeeList, e -> e.getSalary() > 1_000_000);

        q26.filterEmployees(employeeList, new CheckEmployee() {
            @Override
            public boolean check(Employee e) {
                return false;
            }
        });
    }







}
