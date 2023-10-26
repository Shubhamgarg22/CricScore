package org.CricScore.model.people;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.CricScore.common.Contact;
import org.CricScore.common.PersonalInfo;

@Getter
@Setter
@ToString
public class Person {
    private String name;
    private PersonalInfo personalInfo;

    public Person(String name) {
        this.name = name;
    }

    private Contact contact;
}