package com.rookiefly.flume.sink.elasticsearch2.serializer;

import java.io.IOException;

import org.apache.flume.Context;
import org.elasticsearch.common.xcontent.XContentBuilder;

public class StringSerializer implements Serializer {
	private String KEY;

	@Override
	public void initialize(Context context, String key) {
		this.KEY = key;
	}

	@Override
	public void serializer(XContentBuilder builder, String data) throws IOException {
		builder.field(KEY, data);
	}

	@Override
	public void configure(Context context) {
	}

}
