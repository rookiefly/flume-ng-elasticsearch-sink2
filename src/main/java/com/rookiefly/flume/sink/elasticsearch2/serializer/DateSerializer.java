package com.rookiefly.flume.sink.elasticsearch2.serializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.flume.Context;
import org.elasticsearch.common.xcontent.XContentBuilder;

import com.google.common.base.Throwables;

public class DateSerializer implements Serializer {
	private String FIELD;
	private DateFormat FORMAT;

	@Override
	public void initialize(Context context, String field) {
		this.FIELD = field;
		configure(context);
	}

	@Override
	public void serializer(XContentBuilder builder, String data) throws IOException {
		try {
			builder.field(FIELD, FORMAT.parse(data));
		} catch (ParseException e) {
			Throwables.propagate(e);
		}
	}

	@Override
	public void configure(Context context) {
		String format = context.getString("format");
		String locale = context.getString("locale");
		if(format == null) {
			FORMAT = new SimpleDateFormat();
		} else if(locale == null){
			FORMAT = new SimpleDateFormat(format);
		} else {
			FORMAT = new SimpleDateFormat(format, new Locale(locale));
		}
	}

}
