# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

import hospital_pb2 as hospital__pb2


class HospitalStub(object):

  def __init__(self, channel):
    """Constructor.

    Args:
      channel: A grpc.Channel.
    """
    self.ShowPatientCard = channel.unary_unary(
        '/Hospital/ShowPatientCard',
        request_serializer=hospital__pb2.ShowPatientArgument.SerializeToString,
        response_deserializer=hospital__pb2.PatientRecord.FromString,
        )
    self.SavePatientResults = channel.unary_unary(
        '/Hospital/SavePatientResults',
        request_serializer=hospital__pb2.PatientRecord.SerializeToString,
        response_deserializer=hospital__pb2.SavePatientResult.FromString,
        )
    self.ShowResultsByDate = channel.unary_stream(
        '/Hospital/ShowResultsByDate',
        request_serializer=hospital__pb2.DateArgument.SerializeToString,
        response_deserializer=hospital__pb2.PatientRecord.FromString,
        )
    self.ShowResultsByParam = channel.unary_stream(
        '/Hospital/ShowResultsByParam',
        request_serializer=hospital__pb2.ParameterArgument.SerializeToString,
        response_deserializer=hospital__pb2.PatientRecord.FromString,
        )


class HospitalServicer(object):

  def ShowPatientCard(self, request, context):
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def SavePatientResults(self, request, context):
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def ShowResultsByDate(self, request, context):
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def ShowResultsByParam(self, request, context):
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')


def add_HospitalServicer_to_server(servicer, server):
  rpc_method_handlers = {
      'ShowPatientCard': grpc.unary_unary_rpc_method_handler(
          servicer.ShowPatientCard,
          request_deserializer=hospital__pb2.ShowPatientArgument.FromString,
          response_serializer=hospital__pb2.PatientRecord.SerializeToString,
      ),
      'SavePatientResults': grpc.unary_unary_rpc_method_handler(
          servicer.SavePatientResults,
          request_deserializer=hospital__pb2.PatientRecord.FromString,
          response_serializer=hospital__pb2.SavePatientResult.SerializeToString,
      ),
      'ShowResultsByDate': grpc.unary_stream_rpc_method_handler(
          servicer.ShowResultsByDate,
          request_deserializer=hospital__pb2.DateArgument.FromString,
          response_serializer=hospital__pb2.PatientRecord.SerializeToString,
      ),
      'ShowResultsByParam': grpc.unary_stream_rpc_method_handler(
          servicer.ShowResultsByParam,
          request_deserializer=hospital__pb2.ParameterArgument.FromString,
          response_serializer=hospital__pb2.PatientRecord.SerializeToString,
      ),
  }
  generic_handler = grpc.method_handlers_generic_handler(
      'Hospital', rpc_method_handlers)
  server.add_generic_rpc_handlers((generic_handler,))