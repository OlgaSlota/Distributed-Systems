package sr.grpc.model;

import java.util.List;

/**
 * Created by Suota on 2017-05-03.
 */
public class Patient {

    private String name;
    private String pesel;
    private String address;
    private List<Result> resultList;

    public Patient(String name, String pesel, String address, List<Result> resultList){
        this.name = name;
        this.pesel = pesel;
        this.address = address;
        this.resultList = resultList;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
