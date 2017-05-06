package sr.grpc.model;

/**
 * Created by Suota on 2017-05-03.
 */
public class Parameter {
    String name;
    double value;
    String unit;
    Group group;

    public Parameter(String name, double value, String unit) {
        this.name = name;
        this.value = value;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
