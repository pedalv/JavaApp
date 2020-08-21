package no.agitec.fagaften.mellom.oppdrag.repository;

import no.agitec.fagaften.mellom.oppdrag.domain.Person;
import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
    @Trace
    Person findByName(String name);

    @Trace
    Iterable<Person> findByAgeGreaterThan(int age);

    @Trace
    Iterable<Person> findByAgeLessThan(int age);

    @Trace
    Iterable<Person> findByAgeGreaterThanAndAgeLessThan(int greaterThanAge, int lessThanAge);
}

/**
 * An Iterable is a simple representation of a series of elements that can be iterated over.
 * It does not have any iteration state such as a "current element".
 * Instead, it has one method that produces an Iterator.
 *
 * public interface Iterable <T> {
 *     java.util.Iterator<T> iterator();
 *
 *     default void forEach(java.util.function.Consumer<? super T> action) {  }
 *
 *     default java.util.Spliterator<T> spliterator(){  }
 * }
 *
 *
 * An Iterator is the object with iteration state.
 * It lets you check if it has more elements using hasNext() and move to the next element (if any) using next().
 *
 * public interface Iterator <E> {
 *     boolean hasNext();
 *
 *     E next();
 *
 *     default void remove() {  }
 *
 *     default void forEachRemaining(java.util.function.Consumer<? super E>action){  }
 * }
 *
 * Iterator Vs. Collection
 * - Iterator can only move to next() element or remove() an element.
 * - However Collection can add(), iterate, remove() or clear() the elements of the collection.
 * - Iterator provides a better speed than Collections, as the Iterator interface has limited number of operations.
 * - java.sql.SQLException extends Iterable. Hence it allows the caller to safely iterate over causes of SQLException.
 * Using a collection, in this case, would be expensive because, in a chain of n exceptions, use of a collection
 * in the SQLException interface would potentially require the construction of O(n^2) elements.
 * However, use of Iterable provides O(n) access to the exception chain.
 *
 *
 * https://www.baeldung.com/java-iterable-to-collection
 *
 * public interface List <E> extends java.util.Collection<E> {
 *     int size();
 *
 *     boolean isEmpty();
 *
 *     boolean contains(java.lang.Object o);
 *
 *     java.util.Iterator<E> iterator();
 *
 *     java.lang.Object[] toArray();
 *
 *     <T> T[] toArray(T[] ts);
 *
 *     boolean add(E e);
 *
 *     boolean remove(java.lang.Object o);
 *
 *     boolean containsAll(java.util.Collection<?> collection);
 *
 *     boolean addAll(java.util.Collection<? extends E> collection);
 *
 *     boolean addAll(int i, java.util.Collection<? extends E> collection);
 *
 *     boolean removeAll(java.util.Collection<?> collection);
 *
 *     boolean retainAll(java.util.Collection<?> collection);
 *
 *     default void replaceAll(java.util.function.UnaryOperator<E> operator) {  }
 *
 *     default void sort(java.util.Comparator<? super E>c){  }
 *
 *     void clear();
 *
 *     boolean equals(java.lang.Object o);
 *
 *     int hashCode();
 *
 *     E get(int i);
 *
 *     E set(int i,E e);
 *
 *     void add(int i,E e);
 *
 *     E remove(int i);
 *
 *     int indexOf(java.lang.Object o);
 *
 *     int lastIndexOf(java.lang.Object o);
 *
 *     java.util.ListIterator<E> listIterator();
 *
 *     java.util.ListIterator<E> listIterator(int i);
 *
 *     java.util.List<E> subList(int i,int i1);
 *
 *     default java.util.Spliterator<E> spliterator(){  }
 *
 *     static<E> java.util.List<E> of(){  }
 *
 *     static<E> java.util.List<E> of(E e1){  }
 *
 *     static<E> java.util.List<E> of(E e1,E e2){  }
 *
 *     static<E> java.util.List<E> of(E e1,E e2,E e3){  }
 *
 *     static<E> java.util.List<E> of(E e1,E e2,E e3,E e4){  }
 *
 *     static<E> java.util.List<E> of(E e1,E e2,E e3,E e4,E e5){  }
 *
 *     static<E> java.util.List<E> of(E e1,E e2,E e3,E e4,E e5,E e6){  }
 *
 *     static<E> java.util.List<E> of(E e1,E e2,E e3,E e4,E e5,E e6,E e7){  }
 *
 *     static<E> java.util.List<E> of(E e1,E e2,E e3,E e4,E e5,E e6,E e7,E e8){  }
 *
 *     static<E> java.util.List<E> of(E e1,E e2,E e3,E e4,E e5,E e6,E e7,E e8,E e9){  }
 *
 *     static<E> java.util.List<E> of(E e1,E e2,E e3,E e4,E e5,E e6,E e7,E e8,E e9,E e10){  }
 *
 *     @java.lang.SafeVarargs
 *     static<E> java.util.List<E> of(E...elements){  }
 *
 *     static<E> java.util.List<E> copyOf(java.util.Collection<?extends E> coll){  }
 * }
 *
 */