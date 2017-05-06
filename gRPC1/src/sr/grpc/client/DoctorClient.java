package sr.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import sr.grpc.gen.*;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class DoctorClient {

	private final ManagedChannel channel;
	private final HospitalGrpc.HospitalBlockingStub hospitalBlockingStub;

	public DoctorClient(String host, int port)
	{
		channel = ManagedChannelBuilder.forAddress(host, port)
				.usePlaintext(true)
				.build();
		
		hospitalBlockingStub = HospitalGrpc.newBlockingStub(channel);
	}

	public static void main(String[] args) throws Exception 
	{
		DoctorClient client = new DoctorClient("localhost", 50051);
		client.test();
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}


	public void test() throws InterruptedException
	{
		try {
			String line = null;
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in)); 
			do{
				try {
					System.out.print("==> ");
					System.out.flush();
					line = in.readLine();
					if (line == null)
						break;
					if(line.startsWith("show by PESEL"))	{
						ShowPatientArgument request = ShowPatientArgument.newBuilder().setPesel(line.split(" ")[3]).build();
						try{
							PatientRecord result = hospitalBlockingStub.showPatientCard(request);
							System.out.println(result.getName());
							System.out.println(result.getPesel());
							for(int i =0 ; i< result.getParamNameList().size() ; i++){
								System.out.println(result.getParamName(i)+" _ " +
										result.getParamValue(i)+" _ " + result.getParamUnit(i)+" _ " );
							}
						} catch (Exception e) {
							System.out.println("Connection to server failed");
						}

					} else if (line.startsWith("show by date")){
						try {
							DateArgument request = DateArgument.newBuilder().setDate(line.split(" ")[3]).build();

                        Iterator<PatientRecord> patientRecordIterator;
                        try {
                            patientRecordIterator = hospitalBlockingStub.showResultsByDate(request);
                            while(patientRecordIterator.hasNext())
                            {
                                PatientRecord result = patientRecordIterator.next();
								if(result.getParamNameList().size()>0) {
									System.out.println("Patient: " + result.getName());
									System.out.println("From doctor: " + result.getDoctor());
								}
                                for(int i =0 ; i< result.getParamNameList().size() ; i++){
                                    System.out.println(result.getParamName(i)+" _ " +
                                            result.getParamValue(i)+" _ " + result.getParamUnit(i)+" _ " );
                                }
                            }
                        } catch (StatusRuntimeException ex) {
                            System.out.println("Streaming results by date failed");
                            return;
                        }
						} catch (ArrayIndexOutOfBoundsException e ){
							System.out.println("Invalid input");
						}

                    } else if (line.startsWith("show by param")){
						try {
							ParameterArgument request = ParameterArgument.newBuilder().setParameterName(line.split(" ")[3])
                                .setParameterValue(Double.parseDouble(line.split(" ")[4])).build();

                    	    Iterator<PatientRecord> patientRecordIterator;

						try {
							patientRecordIterator = hospitalBlockingStub.showResultsByParam(request);
                            while(patientRecordIterator.hasNext())
                            {
                                PatientRecord result = patientRecordIterator.next();
								if(result.getParamNameList().size()>0){
									System.out.println("Patient: " + result.getName());
									System.out.println("From doctor: " + result.getDoctor());
								}
                                for(int i =0 ; i< result.getParamNameList().size() ; i++){
                                    System.out.println(result.getParamName(i)+" _ " +
                                            result.getParamValue(i)+" _ " + result.getParamUnit(i)+" _ " );
                                }
                            }
                        } catch (StatusRuntimeException ex) {
                            System.out.println("Streaming results by parameter failed");
                            return;
                        }
						} catch (ArrayIndexOutOfBoundsException e ){
							System.out.println("Invalid input");
						}
                    }
				} catch (java.io.IOException ex) {
					System.out.println("IO Exception while reading input");
				}
			} while (!line.equals("x"));
		} finally {
			shutdown();
		}
	}
}
