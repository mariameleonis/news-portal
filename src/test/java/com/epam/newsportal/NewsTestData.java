package com.epam.newsportal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewsTestData {
	public static final String TEST_TEXT = "Lorem ipsum dolor sit amet";
    public static final String TEST_STRING_DATE = "2022-04-12";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd");
    public static final LocalDate TEST_DATE = LocalDate.parse(TEST_STRING_DATE, FORMATTER);
    public static final long NEWS_ID_1 = 1L;
    public static final long NEWS_ID_2 = 2L;
}
