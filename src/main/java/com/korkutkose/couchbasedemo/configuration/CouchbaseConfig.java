package com.korkutkose.couchbasedemo.configuration;


import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;
import org.springframework.data.couchbase.repository.auditing.EnableCouchbaseAuditing;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Slf4j
@Configuration
@EnableCouchbaseRepositories(basePackages = "com.korkutkose.couchbasedemo.persistence")
//@EnableCouchbaseAuditing
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final String DOCUMENTS_BASE_PACKAGE = "com.korkutkose.couchbasedemo.persistence";

    @Value("${couchbase.bootstrap-hosts}")
    private String hostName;

    @Value("${couchbase.bucket.user}")
    private String username;

    @Value("${couchbase.bucket.password}")
    private String password;

    @Value("${couchbase.bucket.name}")
    private String bucketName;

    @Override
    protected String getMappingBasePackage() {
        return DOCUMENTS_BASE_PACKAGE;
    }

    @Override
    public String getConnectionString() {
        return hostName;
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }

    @Bean
    public NativeAuditorAware auditorAware() {
        return new NativeAuditorAware();
    }

    @Override
    public String typeKey() {
        return MappingCouchbaseConverter.TYPEKEY_SYNCGATEWAY_COMPATIBLE;
    }

    @Override
    public CouchbaseCustomConversions customConversions() {
        return new CouchbaseCustomConversions(
                Arrays.asList(
                        LocalDateTimeToStringConverter.INSTANCE,
                        StringToLocalDateTimeConverter.INSTANCE,
                        LocalDateToStringConverter.INSTANCE,
                        StringToLocalDateConverter.INSTANCE)
        );
    }

    @WritingConverter
    private enum LocalDateTimeToStringConverter implements Converter<LocalDateTime, String> {
        INSTANCE;

        public String convert(LocalDateTime source) {
            return source.format(DATE_TIME_FORMATTER);
        }
    }

    @ReadingConverter
    private enum StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
        INSTANCE;

        public LocalDateTime convert(@Nonnull String source) {
            return LocalDateTime.parse(source, DATE_TIME_FORMATTER);
        }
    }


    @WritingConverter
    private enum LocalDateToStringConverter implements Converter<LocalDate, String> {
        INSTANCE;

        public String convert(LocalDate source) {
            return source.format(DATE_FORMATTER);
        }
    }

    @ReadingConverter
    private enum StringToLocalDateConverter implements Converter<String, LocalDate> {
        INSTANCE;

        public LocalDate convert(@Nonnull String source) {
            return LocalDate.parse(source, DATE_FORMATTER);
        }
    }
}
