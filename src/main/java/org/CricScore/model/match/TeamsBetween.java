package org.CricScore.model.match;
import lombok.Getter;
import lombok.Setter;
import org.CricScore.model.people.PlayingMembers;
import org.CricScore.model.people.Team;

@Getter
@Setter
public class TeamsBetween {
    Team team1;
    Team team2;
    PlayingMembers t1PlayingMembers;
    PlayingMembers t2PlayingMembers;

    public TeamsBetween(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
}