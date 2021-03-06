# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: hospital.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
from google.protobuf import descriptor_pb2
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='hospital.proto',
  package='',
  syntax='proto3',
  serialized_pb=_b('\n\x0ehospital.proto\"$\n\x13ShowPatientArgument\x12\r\n\x05pesel\x18\x01 \x01(\t\"\x87\x01\n\rPatientRecord\x12\x0c\n\x04name\x18\x01 \x01(\t\x12\r\n\x05pesel\x18\x02 \x01(\t\x12\x0f\n\x07\x61\x64\x64ress\x18\x03 \x01(\t\x12\x0e\n\x06\x64octor\x18\x04 \x01(\t\x12\x11\n\tparamName\x18\x05 \x03(\t\x12\x12\n\nparamValue\x18\x06 \x03(\x01\x12\x11\n\tparamUnit\x18\x07 \x03(\t\"#\n\x11SavePatientResult\x12\x0e\n\x06status\x18\x01 \x01(\x05\"\x1c\n\x0c\x44\x61teArgument\x12\x0c\n\x04\x64\x61te\x18\x01 \x01(\t\"B\n\x11ParameterArgument\x12\x15\n\rparameterName\x18\x01 \x01(\t\x12\x16\n\x0eparameterValue\x18\x02 \x01(\x01\x32\xf7\x01\n\x08Hospital\x12\x39\n\x0fShowPatientCard\x12\x14.ShowPatientArgument\x1a\x0e.PatientRecord\"\x00\x12:\n\x12SavePatientResults\x12\x0e.PatientRecord\x1a\x12.SavePatientResult\"\x00\x12\x36\n\x11ShowResultsByDate\x12\r.DateArgument\x1a\x0e.PatientRecord\"\x00\x30\x01\x12<\n\x12ShowResultsByParam\x12\x12.ParameterArgument\x1a\x0e.PatientRecord\"\x00\x30\x01\x42$\n\x0bsr.grpc.genB\rHospitalProtoP\x01\xa2\x02\x03HLWb\x06proto3')
)
_sym_db.RegisterFileDescriptor(DESCRIPTOR)




_SHOWPATIENTARGUMENT = _descriptor.Descriptor(
  name='ShowPatientArgument',
  full_name='ShowPatientArgument',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='pesel', full_name='ShowPatientArgument.pesel', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=18,
  serialized_end=54,
)


_PATIENTRECORD = _descriptor.Descriptor(
  name='PatientRecord',
  full_name='PatientRecord',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='name', full_name='PatientRecord.name', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='pesel', full_name='PatientRecord.pesel', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='address', full_name='PatientRecord.address', index=2,
      number=3, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='doctor', full_name='PatientRecord.doctor', index=3,
      number=4, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='paramName', full_name='PatientRecord.paramName', index=4,
      number=5, type=9, cpp_type=9, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='paramValue', full_name='PatientRecord.paramValue', index=5,
      number=6, type=1, cpp_type=5, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='paramUnit', full_name='PatientRecord.paramUnit', index=6,
      number=7, type=9, cpp_type=9, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=57,
  serialized_end=192,
)


_SAVEPATIENTRESULT = _descriptor.Descriptor(
  name='SavePatientResult',
  full_name='SavePatientResult',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='status', full_name='SavePatientResult.status', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=194,
  serialized_end=229,
)


_DATEARGUMENT = _descriptor.Descriptor(
  name='DateArgument',
  full_name='DateArgument',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='date', full_name='DateArgument.date', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=231,
  serialized_end=259,
)


_PARAMETERARGUMENT = _descriptor.Descriptor(
  name='ParameterArgument',
  full_name='ParameterArgument',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='parameterName', full_name='ParameterArgument.parameterName', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='parameterValue', full_name='ParameterArgument.parameterValue', index=1,
      number=2, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=261,
  serialized_end=327,
)

DESCRIPTOR.message_types_by_name['ShowPatientArgument'] = _SHOWPATIENTARGUMENT
DESCRIPTOR.message_types_by_name['PatientRecord'] = _PATIENTRECORD
DESCRIPTOR.message_types_by_name['SavePatientResult'] = _SAVEPATIENTRESULT
DESCRIPTOR.message_types_by_name['DateArgument'] = _DATEARGUMENT
DESCRIPTOR.message_types_by_name['ParameterArgument'] = _PARAMETERARGUMENT

ShowPatientArgument = _reflection.GeneratedProtocolMessageType('ShowPatientArgument', (_message.Message,), dict(
  DESCRIPTOR = _SHOWPATIENTARGUMENT,
  __module__ = 'hospital_pb2'
  # @@protoc_insertion_point(class_scope:ShowPatientArgument)
  ))
_sym_db.RegisterMessage(ShowPatientArgument)

PatientRecord = _reflection.GeneratedProtocolMessageType('PatientRecord', (_message.Message,), dict(
  DESCRIPTOR = _PATIENTRECORD,
  __module__ = 'hospital_pb2'
  # @@protoc_insertion_point(class_scope:PatientRecord)
  ))
_sym_db.RegisterMessage(PatientRecord)

SavePatientResult = _reflection.GeneratedProtocolMessageType('SavePatientResult', (_message.Message,), dict(
  DESCRIPTOR = _SAVEPATIENTRESULT,
  __module__ = 'hospital_pb2'
  # @@protoc_insertion_point(class_scope:SavePatientResult)
  ))
_sym_db.RegisterMessage(SavePatientResult)

DateArgument = _reflection.GeneratedProtocolMessageType('DateArgument', (_message.Message,), dict(
  DESCRIPTOR = _DATEARGUMENT,
  __module__ = 'hospital_pb2'
  # @@protoc_insertion_point(class_scope:DateArgument)
  ))
_sym_db.RegisterMessage(DateArgument)

ParameterArgument = _reflection.GeneratedProtocolMessageType('ParameterArgument', (_message.Message,), dict(
  DESCRIPTOR = _PARAMETERARGUMENT,
  __module__ = 'hospital_pb2'
  # @@protoc_insertion_point(class_scope:ParameterArgument)
  ))
_sym_db.RegisterMessage(ParameterArgument)


DESCRIPTOR.has_options = True
DESCRIPTOR._options = _descriptor._ParseOptions(descriptor_pb2.FileOptions(), _b('\n\013sr.grpc.genB\rHospitalProtoP\001\242\002\003HLW'))
try:
  # THESE ELEMENTS WILL BE DEPRECATED.
  # Please use the generated *_pb2_grpc.py files instead.
  import grpc
  from grpc.beta import implementations as beta_implementations
  from grpc.beta import interfaces as beta_interfaces
  from grpc.framework.common import cardinality
  from grpc.framework.interfaces.face import utilities as face_utilities


  class HospitalStub(object):

    def __init__(self, channel):
      """Constructor.

      Args:
        channel: A grpc.Channel.
      """
      self.ShowPatientCard = channel.unary_unary(
          '/Hospital/ShowPatientCard',
          request_serializer=ShowPatientArgument.SerializeToString,
          response_deserializer=PatientRecord.FromString,
          )
      self.SavePatientResults = channel.unary_unary(
          '/Hospital/SavePatientResults',
          request_serializer=PatientRecord.SerializeToString,
          response_deserializer=SavePatientResult.FromString,
          )
      self.ShowResultsByDate = channel.unary_stream(
          '/Hospital/ShowResultsByDate',
          request_serializer=DateArgument.SerializeToString,
          response_deserializer=PatientRecord.FromString,
          )
      self.ShowResultsByParam = channel.unary_stream(
          '/Hospital/ShowResultsByParam',
          request_serializer=ParameterArgument.SerializeToString,
          response_deserializer=PatientRecord.FromString,
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
            request_deserializer=ShowPatientArgument.FromString,
            response_serializer=PatientRecord.SerializeToString,
        ),
        'SavePatientResults': grpc.unary_unary_rpc_method_handler(
            servicer.SavePatientResults,
            request_deserializer=PatientRecord.FromString,
            response_serializer=SavePatientResult.SerializeToString,
        ),
        'ShowResultsByDate': grpc.unary_stream_rpc_method_handler(
            servicer.ShowResultsByDate,
            request_deserializer=DateArgument.FromString,
            response_serializer=PatientRecord.SerializeToString,
        ),
        'ShowResultsByParam': grpc.unary_stream_rpc_method_handler(
            servicer.ShowResultsByParam,
            request_deserializer=ParameterArgument.FromString,
            response_serializer=PatientRecord.SerializeToString,
        ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
        'Hospital', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


  class BetaHospitalServicer(object):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This class was generated
    only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0."""
    def ShowPatientCard(self, request, context):
      context.code(beta_interfaces.StatusCode.UNIMPLEMENTED)
    def SavePatientResults(self, request, context):
      context.code(beta_interfaces.StatusCode.UNIMPLEMENTED)
    def ShowResultsByDate(self, request, context):
      context.code(beta_interfaces.StatusCode.UNIMPLEMENTED)
    def ShowResultsByParam(self, request, context):
      context.code(beta_interfaces.StatusCode.UNIMPLEMENTED)


  class BetaHospitalStub(object):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This class was generated
    only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0."""
    def ShowPatientCard(self, request, timeout, metadata=None, with_call=False, protocol_options=None):
      raise NotImplementedError()
    ShowPatientCard.future = None
    def SavePatientResults(self, request, timeout, metadata=None, with_call=False, protocol_options=None):
      raise NotImplementedError()
    SavePatientResults.future = None
    def ShowResultsByDate(self, request, timeout, metadata=None, with_call=False, protocol_options=None):
      raise NotImplementedError()
    def ShowResultsByParam(self, request, timeout, metadata=None, with_call=False, protocol_options=None):
      raise NotImplementedError()


  def beta_create_Hospital_server(servicer, pool=None, pool_size=None, default_timeout=None, maximum_timeout=None):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This function was
    generated only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0"""
    request_deserializers = {
      ('Hospital', 'SavePatientResults'): PatientRecord.FromString,
      ('Hospital', 'ShowPatientCard'): ShowPatientArgument.FromString,
      ('Hospital', 'ShowResultsByDate'): DateArgument.FromString,
      ('Hospital', 'ShowResultsByParam'): ParameterArgument.FromString,
    }
    response_serializers = {
      ('Hospital', 'SavePatientResults'): SavePatientResult.SerializeToString,
      ('Hospital', 'ShowPatientCard'): PatientRecord.SerializeToString,
      ('Hospital', 'ShowResultsByDate'): PatientRecord.SerializeToString,
      ('Hospital', 'ShowResultsByParam'): PatientRecord.SerializeToString,
    }
    method_implementations = {
      ('Hospital', 'SavePatientResults'): face_utilities.unary_unary_inline(servicer.SavePatientResults),
      ('Hospital', 'ShowPatientCard'): face_utilities.unary_unary_inline(servicer.ShowPatientCard),
      ('Hospital', 'ShowResultsByDate'): face_utilities.unary_stream_inline(servicer.ShowResultsByDate),
      ('Hospital', 'ShowResultsByParam'): face_utilities.unary_stream_inline(servicer.ShowResultsByParam),
    }
    server_options = beta_implementations.server_options(request_deserializers=request_deserializers, response_serializers=response_serializers, thread_pool=pool, thread_pool_size=pool_size, default_timeout=default_timeout, maximum_timeout=maximum_timeout)
    return beta_implementations.server(method_implementations, options=server_options)


  def beta_create_Hospital_stub(channel, host=None, metadata_transformer=None, pool=None, pool_size=None):
    """The Beta API is deprecated for 0.15.0 and later.

    It is recommended to use the GA API (classes and functions in this
    file not marked beta) for all further purposes. This function was
    generated only to ease transition from grpcio<0.15.0 to grpcio>=0.15.0"""
    request_serializers = {
      ('Hospital', 'SavePatientResults'): PatientRecord.SerializeToString,
      ('Hospital', 'ShowPatientCard'): ShowPatientArgument.SerializeToString,
      ('Hospital', 'ShowResultsByDate'): DateArgument.SerializeToString,
      ('Hospital', 'ShowResultsByParam'): ParameterArgument.SerializeToString,
    }
    response_deserializers = {
      ('Hospital', 'SavePatientResults'): SavePatientResult.FromString,
      ('Hospital', 'ShowPatientCard'): PatientRecord.FromString,
      ('Hospital', 'ShowResultsByDate'): PatientRecord.FromString,
      ('Hospital', 'ShowResultsByParam'): PatientRecord.FromString,
    }
    cardinalities = {
      'SavePatientResults': cardinality.Cardinality.UNARY_UNARY,
      'ShowPatientCard': cardinality.Cardinality.UNARY_UNARY,
      'ShowResultsByDate': cardinality.Cardinality.UNARY_STREAM,
      'ShowResultsByParam': cardinality.Cardinality.UNARY_STREAM,
    }
    stub_options = beta_implementations.stub_options(host=host, metadata_transformer=metadata_transformer, request_serializers=request_serializers, response_deserializers=response_deserializers, thread_pool=pool, thread_pool_size=pool_size)
    return beta_implementations.dynamic_stub(channel, 'Hospital', cardinalities, options=stub_options)
except ImportError:
  pass
# @@protoc_insertion_point(module_scope)
