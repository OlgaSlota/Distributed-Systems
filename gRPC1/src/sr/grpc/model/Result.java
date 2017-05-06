package sr.grpc.model;

import java.util.List;

/**
 * Created by Suota on 2017-05-03.
 */
public class Result {
    private String date;
    private String doctor;
    private List<Parameter> parameters;

    public Result(String date, String doctor, List<Parameter> parameters) {
        this.date = date;
        this.doctor = doctor;
        this.parameters = parameters;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

}
