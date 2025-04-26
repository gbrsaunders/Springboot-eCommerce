package com.checkers.config;

import com.checkers.beans.GameStats;
import com.checkers.beans.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = {"com.checkers.implementation","com.checkers.services"})
@ComponentScan(basePackageClasses = {com.checkers.beans.GameStats.class,com.checkers.beans.Person.class})
    public class ProjectConfig {

    }
