package com.knet.template.mvc.freemarker.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 한승룡
 * @since 2019-11-06
 */
@Configuration
public class JacksonConfig {

	@Bean
	public Module jsonMapperJava8DateTimeModule() {
		SimpleModule module = new SimpleModule();

		// LocalDate
		module.addSerializer(LocalDate.class, new JsonSerializer<LocalDate>() {
			@Override
			public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
				gen.writeString(value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			}
		});
		module.addDeserializer(LocalDate.class, new JsonDeserializer<LocalDate>() {
			@Override
			public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
				return LocalDate.parse(jsonParser.getValueAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
		});

		// LocalTime
		module.addSerializer(LocalTime.class, new JsonSerializer<LocalTime>() {
			@Override
			public void serialize(LocalTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
				gen.writeString(value.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
			}
		});
		module.addDeserializer(LocalTime.class, new JsonDeserializer<LocalTime>() {
			@Override
			public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
				String value = jsonParser.getValueAsString();
				if (value.length() == 5) {
					value += ":00.000";
				} else  if (value.length() == 8) {
					value += ".000";
				}
				return LocalTime.parse(value, DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
			}
		});

		// LocalDateTime
		module.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
			@Override
			public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
				gen.writeString(value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
			}
		});
		module.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
			@Override
			public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
				String value = jsonParser.getValueAsString();
				if (value.length() == 10) {
					value += " 00:00:00.000";
				} else if (value.length() == 16) {
					value += ":00.000";
				} else if (value.length() == 19) {
					value += ".000";
				}

				return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
			}
		});

		return module;
	}
}
