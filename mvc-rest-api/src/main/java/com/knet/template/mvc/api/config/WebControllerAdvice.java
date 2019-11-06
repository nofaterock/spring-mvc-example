package com.knet.template.mvc.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 한승룡
 * @since 2019-11-06
 */
@Slf4j
@ControllerAdvice
public class WebControllerAdvice {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.initDirectFieldAccess();

		// LocalDate
		binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			}
		});

		// LocalTime
		binder.registerCustomEditor(LocalTime.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (text.length() == 5) {
					text += ":00.000";
				} else if (text.length() == 8) {
					text += ".000";
				}
				setValue(LocalTime.parse(text, DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
			}
		});

		// LocalDateTime
		binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (text.length() == 10) {
					text += " 00:00:00.000";
				} else if (text.length() == 16) {
					text += ":00.000";
				} else if (text.length() == 19) {
					text += ".000";
				}
				setValue(LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
			}
		});
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity handleGlobalException(HttpServletRequest request, Exception e) {
		log.error("Controller Exception !!", e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

}
