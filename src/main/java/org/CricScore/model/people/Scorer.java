package org.CricScore.model.people;

import org.CricScore.exception.InvalidMatch;
import org.CricScore.model.match.Ball;
import org.CricScore.model.match.ScoreCard;

public class Scorer extends Person {
    public Scorer(String name) {
        super(name);
    }

    public void setScore(Ball ball, String match, int innings) throws InvalidMatch {
        ScoreCard scoreCard = ScoreCard.INSTANCE(match, innings);
        scoreCard.setScoreCardForBall(ball);
    }
}