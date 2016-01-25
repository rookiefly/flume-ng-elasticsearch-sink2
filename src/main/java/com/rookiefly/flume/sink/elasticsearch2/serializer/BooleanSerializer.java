package com.rookiefly.flume.sink.elasticsearch2.serializer;

import java.io.IOException;

import org.apache.flume.Context;
import org.elasticsearch.common.xcontent.XContentBuilder;

public class BooleanSerializer implements Serializer {
	private String FIELD;

	@Override
	public void initialize(Context context, String field) {
		this.FIELD = field;
	}

	@Override
	public void serializer(XContentBuilder builder, String data) throws IOException {
		builder.field(
				FIELD,
				!((data == null) || "false".equalsIgnoreCase(data) || "off".equalsIgnoreCase(data)
						|| "no".equalsIgnoreCase(data) || "0".equalsIgnoreCase(data) || "".equalsIgnoreCase(data)));
	}

	@Override
	public void configure(Context context) {
	}
}
