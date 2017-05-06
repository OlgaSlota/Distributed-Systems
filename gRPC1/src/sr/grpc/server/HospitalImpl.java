package sr.grpc.server;

import io.grpc.stub.StreamObserver;
import sr.grpc.gen.*;
import sr.grpc.model.Parameter;
import sr.grpc.model.Patient;
import sr.grpc.model.Result;

import java.time.LocalDate;
import java.util.*;

import static java.lang.Thread.sleep;

/**
 * Created by Suota on 2017-05-03.
 */
public class HospitalImpl extends HospitalGrpc.HospitalImplBase {
    private Map<String,Patient> patients = new HashMap<>();

    @Override
    public void showPatientCard(ShowPatientArgument request, StreamObserver<PatientRecord> responseObserver) {
        System.out.println("View Patient Card Request " + request.getPesel());
        PatientRecord.Builder patientRecordBuilder = PatientRecord.newBuilder();
        PatientRecord result;
        Patient patient = patients.get(request.getPesel());
        if ( patient== null ){
            System.out.println("No patient found");
            result = patientRecordBuilder.build();
        } else {
            List<Result> results = patient.getResultList();
            for (int i=0; i<results.size(); i++){
                List<Parameter> params = results.get(i).getParameters();
                for(int j=0;j<params.size();j++){
                    patientRecordBuilder = patientRecordBuilder.addParamName(params.get(j).getName())
                            .addParamValue(params.get(j).getValue()).addParamUnit(params.get(j).getUnit());
                }
            }
            result = patientRecordBuilder.setName(patient.getName()).setPesel(patient.getPesel())
                    .setAddress(patient.getAddress()).build();
        }
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void savePatientResults(PatientRecord request, StreamObserver<SavePatientResult> responseObserver) {
        System.out.println("add Patient Results Request " + request.getName() + request.getPesel());
        Result patientResult = new Result(LocalDate.now().toString(),request.getDoctor(), new ArrayList<>());

        for (int i=0; i< request.getParamNameCount() ; i++){
            System.out.println(request.getParamName(i)+ " _ "+request.getParamValue(i)+ " _ "+request.getParamUnit(i));
            patientResult.getParameters().add(new Parameter(request.getParamName(i), request.getParamValue(i), request.getParamUnit(i)));
        }
        Patient newPatient = patients.get(request.getPesel());
        if(newPatient == null){
            newPatient = new Patient(request.getName(),request.getPesel(),request.getAddress(), new ArrayList<>());
            patients.put(request.getPesel(), newPatient);
        }
        newPatient.getResultList().add(patientResult);

        SavePatientResult result = SavePatientResult.newBuilder().setStatus(0).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void showResultsByDate(DateArgument request, StreamObserver<PatientRecord> responseObserver) {
        System.out.println("View Results by date request: " + request.getDate());

        for(Patient patient : patients.values()){
            for (Result res : patient.getResultList()){
                PatientRecord.Builder patientRecordBuilder = PatientRecord.newBuilder();
                try { sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                if (res.getDate().equals(request.getDate())){
                    for (Parameter param : res.getParameters()){
                        patientRecordBuilder = patientRecordBuilder.addParamName(param.getName())
                                .addParamValue(param.getValue()).addParamUnit(param.getUnit());
                }
                PatientRecord result = patientRecordBuilder.setName(patient.getName()).setDoctor(res.getDoctor()).build();
                responseObserver.onNext(result);
                }
            }
        }
        responseObserver.onCompleted();
    }

    @Override
    public void showResultsByParam(ParameterArgument request, StreamObserver<PatientRecord> responseObserver) {
        System.out.println("View Results by parameter request: " + request.getParameterName());

        for(Patient patient : patients.values()){
            for (Result res : patient.getResultList()){
                PatientRecord.Builder patientRecordBuilder = PatientRecord.newBuilder();
                for (Parameter param : res.getParameters()){
                        try { sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                        if(param.getName().equals(request.getParameterName())
                                && param.getValue()>request.getParameterValue()-0.5
                                && param.getValue()<request.getParameterValue()+0.5)
                        {
                            patientRecordBuilder = patientRecordBuilder.addParamName(param.getName())
                                    .addParamValue(param.getValue()).addParamUnit(param.getUnit());
                        }
                      }
                    PatientRecord result = patientRecordBuilder.setName(patient.getName()).setDoctor(res.getDoctor()).build();
                    responseObserver.onNext(result);
                }
        }
        responseObserver.onCompleted();
    }
}
