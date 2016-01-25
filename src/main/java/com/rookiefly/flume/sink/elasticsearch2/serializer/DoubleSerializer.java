package com.rookiefly.flume.sink.elasticsearch2.serializer;

import java.io.IOException;

import org.apache.flume.Context;
import org.elasticsearch.common.xcontent.XContentBuilder;

public class DoubleSerializer implements Serializer {
	private String FIELD;

	@Override
	public void initialize(Context context, String field) {
		this.FIELD = field;
	}

	@Override
	public void serializer(XContentBuilder builder, String data) throws IOException {
		builder.field(FIELD, Double.parseDouble(data));
	}

	@Override
	public void configure(Context context) {
	}

}
