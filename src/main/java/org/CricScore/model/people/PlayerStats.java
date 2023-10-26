package org.CricScore.model.people;

import lombok.Getter;
import lombok.Setter;
import org.CricScore.model.match.MatchType;

import java.util.Map;

@Getter
@Setter
public class PlayerStats {
    private Map<MatchType, Stats> playerStatistics;

    @Getter
    @Setter
    private static class Stats {
        private int matchesPlayed;
        private float oversBowled;
        private float runsScored;
        private int wicketsTaken;
        private int catchesTaken;
        private int stumping;
        private float econ;
        private float avg;
    }
}