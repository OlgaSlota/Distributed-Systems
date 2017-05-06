package sr.grpc.gen;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: hospital.proto")
public final class HospitalGrpc {

  private HospitalGrpc() {}

  public static final String SERVICE_NAME = "Hospital";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<sr.grpc.gen.ShowPatientArgument,
      sr.grpc.gen.PatientRecord> METHOD_SHOW_PATIENT_CARD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "Hospital", "ShowPatientCard"),
          io.grpc.protobuf.ProtoUtils.marshaller(sr.grpc.gen.ShowPatientArgument.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(sr.grpc.gen.PatientRecord.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<sr.grpc.gen.PatientRecord,
      sr.grpc.gen.SavePatientResult> METHOD_SAVE_PATIENT_RESULTS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "Hospital", "SavePatientResults"),
          io.grpc.protobuf.ProtoUtils.marshaller(sr.grpc.gen.PatientRecord.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(sr.grpc.gen.SavePatientResult.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<sr.grpc.gen.DateArgument,
      sr.grpc.gen.PatientRecord> METHOD_SHOW_RESULTS_BY_DATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "Hospital", "ShowResultsByDate"),
          io.grpc.protobuf.ProtoUtils.marshaller(sr.grpc.gen.DateArgument.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(sr.grpc.gen.PatientRecord.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<sr.grpc.gen.ParameterArgument,
      sr.grpc.gen.PatientRecord> METHOD_SHOW_RESULTS_BY_PARAM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "Hospital", "ShowResultsByParam"),
          io.grpc.protobuf.ProtoUtils.marshaller(sr.grpc.gen.ParameterArgument.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(sr.grpc.gen.PatientRecord.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HospitalStub newStub(io.grpc.Channel channel) {
    return new HospitalStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HospitalBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HospitalBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static HospitalFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HospitalFutureStub(channel);
  }

  /**
   */
  public static abstract class HospitalImplBase implements io.grpc.BindableService {

    /**
     */
    public void showPatientCard(sr.grpc.gen.ShowPatientArgument request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.PatientRecord> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SHOW_PATIENT_CARD, responseObserver);
    }

    /**
     */
    public void savePatientResults(sr.grpc.gen.PatientRecord request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.SavePatientResult> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAVE_PATIENT_RESULTS, responseObserver);
    }

    /**
     */
    public void showResultsByDate(sr.grpc.gen.DateArgument request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.PatientRecord> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SHOW_RESULTS_BY_DATE, responseObserver);
    }

    /**
     */
    public void showResultsByParam(sr.grpc.gen.ParameterArgument request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.PatientRecord> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SHOW_RESULTS_BY_PARAM, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SHOW_PATIENT_CARD,
            asyncUnaryCall(
              new MethodHandlers<
                sr.grpc.gen.ShowPatientArgument,
                sr.grpc.gen.PatientRecord>(
                  this, METHODID_SHOW_PATIENT_CARD)))
          .addMethod(
            METHOD_SAVE_PATIENT_RESULTS,
            asyncUnaryCall(
              new MethodHandlers<
                sr.grpc.gen.PatientRecord,
                sr.grpc.gen.SavePatientResult>(
                  this, METHODID_SAVE_PATIENT_RESULTS)))
          .addMethod(
            METHOD_SHOW_RESULTS_BY_DATE,
            asyncServerStreamingCall(
              new MethodHandlers<
                sr.grpc.gen.DateArgument,
                sr.grpc.gen.PatientRecord>(
                  this, METHODID_SHOW_RESULTS_BY_DATE)))
          .addMethod(
            METHOD_SHOW_RESULTS_BY_PARAM,
            asyncServerStreamingCall(
              new MethodHandlers<
                sr.grpc.gen.ParameterArgument,
                sr.grpc.gen.PatientRecord>(
                  this, METHODID_SHOW_RESULTS_BY_PARAM)))
          .build();
    }
  }

  /**
   */
  public static final class HospitalStub extends io.grpc.stub.AbstractStub<HospitalStub> {
    private HospitalStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HospitalStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HospitalStub(channel, callOptions);
    }

    /**
     */
    public void showPatientCard(sr.grpc.gen.ShowPatientArgument request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.PatientRecord> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SHOW_PATIENT_CARD, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void savePatientResults(sr.grpc.gen.PatientRecord request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.SavePatientResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAVE_PATIENT_RESULTS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void showResultsByDate(sr.grpc.gen.DateArgument request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.PatientRecord> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_SHOW_RESULTS_BY_DATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void showResultsByParam(sr.grpc.gen.ParameterArgument request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.PatientRecord> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_SHOW_RESULTS_BY_PARAM, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HospitalBlockingStub extends io.grpc.stub.AbstractStub<HospitalBlockingStub> {
    private HospitalBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HospitalBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HospitalBlockingStub(channel, callOptions);
    }

    /**
     */
    public sr.grpc.gen.PatientRecord showPatientCard(sr.grpc.gen.ShowPatientArgument request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SHOW_PATIENT_CARD, getCallOptions(), request);
    }

    /**
     */
    public sr.grpc.gen.SavePatientResult savePatientResults(sr.grpc.gen.PatientRecord request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAVE_PATIENT_RESULTS, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<sr.grpc.gen.PatientRecord> showResultsByDate(
        sr.grpc.gen.DateArgument request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_SHOW_RESULTS_BY_DATE, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<sr.grpc.gen.PatientRecord> showResultsByParam(
        sr.grpc.gen.ParameterArgument request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_SHOW_RESULTS_BY_PARAM, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HospitalFutureStub extends io.grpc.stub.AbstractStub<HospitalFutureStub> {
    private HospitalFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HospitalFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HospitalFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.PatientRecord> showPatientCard(
        sr.grpc.gen.ShowPatientArgument request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SHOW_PATIENT_CARD, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.SavePatientResult> savePatientResults(
        sr.grpc.gen.PatientRecord request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAVE_PATIENT_RESULTS, getCallOptions()), request);
    }
  }

  private static final int METHODID_SHOW_PATIENT_CARD = 0;
  private static final int METHODID_SAVE_PATIENT_RESULTS = 1;
  private static final int METHODID_SHOW_RESULTS_BY_DATE = 2;
  private static final int METHODID_SHOW_RESULTS_BY_PARAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HospitalImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HospitalImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SHOW_PATIENT_CARD:
          serviceImpl.showPatientCard((sr.grpc.gen.ShowPatientArgument) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.PatientRecord>) responseObserver);
          break;
        case METHODID_SAVE_PATIENT_RESULTS:
          serviceImpl.savePatientResults((sr.grpc.gen.PatientRecord) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.SavePatientResult>) responseObserver);
          break;
        case METHODID_SHOW_RESULTS_BY_DATE:
          serviceImpl.showResultsByDate((sr.grpc.gen.DateArgument) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.PatientRecord>) responseObserver);
          break;
        case METHODID_SHOW_RESULTS_BY_PARAM:
          serviceImpl.showResultsByParam((sr.grpc.gen.ParameterArgument) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.PatientRecord>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class HospitalDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sr.grpc.gen.HospitalProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HospitalGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HospitalDescriptorSupplier())
              .addMethod(METHOD_SHOW_PATIENT_CARD)
              .addMethod(METHOD_SAVE_PATIENT_RESULTS)
              .addMethod(METHOD_SHOW_RESULTS_BY_DATE)
              .addMethod(METHOD_SHOW_RESULTS_BY_PARAM)
              .build();
        }
      }
    }
    return result;
  }
}
