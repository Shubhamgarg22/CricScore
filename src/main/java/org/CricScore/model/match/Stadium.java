package org.CricScore.model.match;

import lombok.Getter;
import lombok.Setter;
import org.CricScore.common.Address;

@Getter
@Setter
public class Stadium {
    private String name;
    private Address address;

    public Stadium(String name) {
        this.name = name;
    }
}