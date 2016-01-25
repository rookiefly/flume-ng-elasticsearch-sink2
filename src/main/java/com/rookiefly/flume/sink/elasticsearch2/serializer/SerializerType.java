package com.rookiefly.flume.sink.elasticsearch2.serializer;


public enum SerializerType {

	STRING( com.rookiefly.flume.sink.elasticsearch2.serializer.StringSerializer.class),
	INTEGER( com.rookiefly.flume.sink.elasticsearch2.serializer.IntegerSerializer.class),
	INT( com.rookiefly.flume.sink.elasticsearch2.serializer.IntegerSerializer.class),
	DOUBLE( com.rookiefly.flume.sink.elasticsearch2.serializer.DoubleSerializer.class),
	DATE( com.rookiefly.flume.sink.elasticsearch2.serializer.DateSerializer.class);

	private final Class<? extends Serializer> builderClass;

	private SerializerType(Class<? extends Serializer> builderClass) {
		this.builderClass = builderClass;
	}

	public Class<? extends Serializer> getBuilderClass() {
		return builderClass;
	}
}
