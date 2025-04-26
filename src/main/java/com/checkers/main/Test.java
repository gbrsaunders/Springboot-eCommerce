package com.checkers.main;

import com.checkers.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.checkers.beans.Person;
public class Test {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person1 = context.getBean(Person.class);
        System.out.println(person1);
        System.out.println(person1.getGameStats().getGameStatsServices().getLeague());
        Person person2 = context.getBean(Person.class);
        System.out.println(person2);
        System.out.println(person2.getGameStats().getGameStatsServices().getLeague());
        Person person3 = context.getBean(Person.class);
        System.out.println(person3);
        System.out.println(person3.getGameStats().getGameStatsServices().getLeague());
    }
}
