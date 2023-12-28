package com.korkutkose.couchbasedemo.configuration;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class NativeAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("unknown");
    }

}
