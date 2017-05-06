// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hospital.proto

package sr.grpc.gen;

/**
 * Protobuf type {@code ParameterArgument}
 */
public  final class ParameterArgument extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ParameterArgument)
    ParameterArgumentOrBuilder {
  // Use ParameterArgument.newBuilder() to construct.
  private ParameterArgument(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ParameterArgument() {
    parameterName_ = "";
    parameterValue_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ParameterArgument(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            parameterName_ = s;
            break;
          }
          case 17: {

            parameterValue_ = input.readDouble();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return sr.grpc.gen.HospitalProto.internal_static_ParameterArgument_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return sr.grpc.gen.HospitalProto.internal_static_ParameterArgument_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            sr.grpc.gen.ParameterArgument.class, sr.grpc.gen.ParameterArgument.Builder.class);
  }

  public static final int PARAMETERNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object parameterName_;
  /**
   * <code>optional string parameterName = 1;</code>
   */
  public java.lang.String getParameterName() {
    java.lang.Object ref = parameterName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      parameterName_ = s;
      return s;
    }
  }
  /**
   * <code>optional string parameterName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getParameterNameBytes() {
    java.lang.Object ref = parameterName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      parameterName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PARAMETERVALUE_FIELD_NUMBER = 2;
  private double parameterValue_;
  /**
   * <code>optional double parameterValue = 2;</code>
   */
  public double getParameterValue() {
    return parameterValue_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getParameterNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, parameterName_);
    }
    if (parameterValue_ != 0D) {
      output.writeDouble(2, parameterValue_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getParameterNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, parameterName_);
    }
    if (parameterValue_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, parameterValue_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof sr.grpc.gen.ParameterArgument)) {
      return super.equals(obj);
    }
    sr.grpc.gen.ParameterArgument other = (sr.grpc.gen.ParameterArgument) obj;

    boolean result = true;
    result = result && getParameterName()
        .equals(other.getParameterName());
    result = result && (
        java.lang.Double.doubleToLongBits(getParameterValue())
        == java.lang.Double.doubleToLongBits(
            other.getParameterValue()));
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + PARAMETERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getParameterName().hashCode();
    hash = (37 * hash) + PARAMETERVALUE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getParameterValue()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static sr.grpc.gen.ParameterArgument parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.ParameterArgument parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.ParameterArgument parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.ParameterArgument parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.ParameterArgument parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.ParameterArgument parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static sr.grpc.gen.ParameterArgument parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.ParameterArgument parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static sr.grpc.gen.ParameterArgument parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.ParameterArgument parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(sr.grpc.gen.ParameterArgument prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ParameterArgument}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ParameterArgument)
      sr.grpc.gen.ParameterArgumentOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sr.grpc.gen.HospitalProto.internal_static_ParameterArgument_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sr.grpc.gen.HospitalProto.internal_static_ParameterArgument_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sr.grpc.gen.ParameterArgument.class, sr.grpc.gen.ParameterArgument.Builder.class);
    }

    // Construct using sr.grpc.gen.ParameterArgument.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      parameterName_ = "";

      parameterValue_ = 0D;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return sr.grpc.gen.HospitalProto.internal_static_ParameterArgument_descriptor;
    }

    public sr.grpc.gen.ParameterArgument getDefaultInstanceForType() {
      return sr.grpc.gen.ParameterArgument.getDefaultInstance();
    }

    public sr.grpc.gen.ParameterArgument build() {
      sr.grpc.gen.ParameterArgument result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public sr.grpc.gen.ParameterArgument buildPartial() {
      sr.grpc.gen.ParameterArgument result = new sr.grpc.gen.ParameterArgument(this);
      result.parameterName_ = parameterName_;
      result.parameterValue_ = parameterValue_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof sr.grpc.gen.ParameterArgument) {
        return mergeFrom((sr.grpc.gen.ParameterArgument)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(sr.grpc.gen.ParameterArgument other) {
      if (other == sr.grpc.gen.ParameterArgument.getDefaultInstance()) return this;
      if (!other.getParameterName().isEmpty()) {
        parameterName_ = other.parameterName_;
        onChanged();
      }
      if (other.getParameterValue() != 0D) {
        setParameterValue(other.getParameterValue());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      sr.grpc.gen.ParameterArgument parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (sr.grpc.gen.ParameterArgument) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object parameterName_ = "";
    /**
     * <code>optional string parameterName = 1;</code>
     */
    public java.lang.String getParameterName() {
      java.lang.Object ref = parameterName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        parameterName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string parameterName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getParameterNameBytes() {
      java.lang.Object ref = parameterName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        parameterName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string parameterName = 1;</code>
     */
    public Builder setParameterName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      parameterName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string parameterName = 1;</code>
     */
    public Builder clearParameterName() {
      
      parameterName_ = getDefaultInstance().getParameterName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string parameterName = 1;</code>
     */
    public Builder setParameterNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      parameterName_ = value;
      onChanged();
      return this;
    }

    private double parameterValue_ ;
    /**
     * <code>optional double parameterValue = 2;</code>
     */
    public double getParameterValue() {
      return parameterValue_;
    }
    /**
     * <code>optional double parameterValue = 2;</code>
     */
    public Builder setParameterValue(double value) {
      
      parameterValue_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional double parameterValue = 2;</code>
     */
    public Builder clearParameterValue() {
      
      parameterValue_ = 0D;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:ParameterArgument)
  }

  // @@protoc_insertion_point(class_scope:ParameterArgument)
  private static final sr.grpc.gen.ParameterArgument DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new sr.grpc.gen.ParameterArgument();
  }

  public static sr.grpc.gen.ParameterArgument getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ParameterArgument>
      PARSER = new com.google.protobuf.AbstractParser<ParameterArgument>() {
    public ParameterArgument parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ParameterArgument(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ParameterArgument> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ParameterArgument> getParserForType() {
    return PARSER;
  }

  public sr.grpc.gen.ParameterArgument getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

