package com.rookiefly.flume.sink.elasticsearch2.serializer;

import java.io.IOException;

import org.apache.flume.Context;
import org.apache.flume.conf.Configurable;
import org.elasticsearch.common.xcontent.XContentBuilder;

public interface Serializer extends Configurable {
	void initialize(Context context, String field);

	void serializer(XContentBuilder builder, String data) throws IOException;
}
