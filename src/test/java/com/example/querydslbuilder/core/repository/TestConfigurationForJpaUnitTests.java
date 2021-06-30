package com.example.querydslbuilder.core.repository;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@AutoConfigurationPackage
@ComponentScan(basePackages = "com.example.querydslbuilder.core.repository")
@EntityScan(basePackages = "com.example.querydslbuilder.core.entity")
public class TestConfigurationForJpaUnitTests {
}
