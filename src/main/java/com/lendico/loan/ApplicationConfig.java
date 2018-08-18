package com.lendico.loan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.lendico.loan.service" })
public class ApplicationConfig {
}
