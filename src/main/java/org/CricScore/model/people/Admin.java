package org.CricScore.model.people;
import org.CricScore.exception.InvalidMatch;
import org.CricScore.exception.InvalidTeamException;
import org.CricScore.exception.InvalidTournamentException;
import org.CricScore.model.match.Fixture;
import org.CricScore.model.match.Match;
import org.CricScore.model.match.Stadium;
import org.CricScore.model.match.Tournament;
import org.CricScore.repository.DataSink;

import java.util.ArrayList;

public class Admin extends Person {
    public Admin(String name) {
        super(name);
    }

    public void addTournament(Tournament tournament) {
        DataSink.tournamentMap.putIfAbsent(tournament.getName(), tournament);
    }

    public void addMatch(Match match) throws InvalidTournamentException {
        if (DataSink.tournamentMap.get(match.getTournament().getName()) == null) {
            throw new InvalidTournamentException("Invalid tournament");
        }
        DataSink.tournamentMap.get(match.getTournament().getName())
                .getMatches().add(match);
        DataSink.matchMap.putIfAbsent(match.getMatchId(), match);
    }

    public void addTeam(Team team) throws InvalidTournamentException {
        if (DataSink.tournamentMap.get(team.getTourName()) == null) {
            throw new InvalidTournamentException("Invalid tournament");
        }
        DataSink.tournamentMap.get(team.getTourName()).getTeams().add(team);
        DataSink.teamMap.putIfAbsent(team.getName(), team);
    }

    public void addPlayer(Player player, String team, String tour) throws InvalidTeamException, InvalidTournamentException {
        if (DataSink.tournamentMap.get(tour) == null)
            throw new InvalidTournamentException("Invalid tournament");
        if (DataSink.teamMap.get(team) == null)
            throw new InvalidTeamException("Invalid team");
        DataSink.playerMap.putIfAbsent(player.getName(), player);

    }

    public void addUmpire(Umpire umpire, String match) throws InvalidMatch {
        if (DataSink.matchMap.get(match) == null)
            throw new InvalidMatch("Invalid match");
        DataSink.matchMap.get(match).getUmpires().add(umpire);
    }

    public void addCommentator(Commentator commentator, String match) throws InvalidMatch {
        if (DataSink.matchMap.get(match) == null)
            throw new InvalidMatch("Invalid match");
        DataSink.matchMap.get(match).getCommentators().add(commentator);
        DataSink.commentators.putIfAbsent(commentator.getName(), commentator);
    }

    public void addScorer(Scorer scorer, String match) throws InvalidMatch {
        if (DataSink.matchMap.get(match) == null)
            throw new InvalidMatch("Invalid match");
        DataSink.matchMap.get(match).getScorers().add(scorer);
        DataSink.scorerMap.putIfAbsent(scorer.getName(), scorer);
    }

    public void addStadium(Stadium stadium) {
        DataSink.stadiumMap.putIfAbsent(stadium.getName(), stadium);
    }

    public void addFixture(Fixture fixture) throws InvalidTournamentException {
        if (DataSink.tournamentMap.get(fixture.getTournament()) == null)
            throw new InvalidTournamentException("Invalid tournament");
        if (DataSink.fixtureMap.get(fixture.getTournament()) == null)
            DataSink.fixtureMap.put(fixture.getTournament(), new ArrayList<>());
        DataSink.fixtureMap.get(fixture.getTournament()).add(fixture);
    }
}