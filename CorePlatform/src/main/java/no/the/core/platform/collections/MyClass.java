package no.the.core.platform.collections;

public class MyClass implements Comparable<MyClass>{

    String label, value;

    public MyClass(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MyClass myClass = (MyClass) o;

        if (!label.equals(myClass.label))
            return false;

        return value.equalsIgnoreCase(myClass.value);
    }

    @Override
    public int hashCode() {
        int result = label.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public int compareTo(MyClass other) {
        return value.compareToIgnoreCase(other.value);
    }
}
