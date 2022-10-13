package main.java;

import java.util.List;
import main.java.exceptions.WrongNumberOfPlayersError;

public class Match {

  private static final int PLAYER_ONE = 0;
  private static final int PLAYER_TWO = 1;
  private static final int NUMBER_OF_PLAYERS = 2;

  private Match() {}

  public static Player winner(List<Player> players) throws WrongNumberOfPlayersError {

    if (players == null || players.size() != NUMBER_OF_PLAYERS)
      throw new WrongNumberOfPlayersError();

    Player playerOne = players.get(PLAYER_ONE);
    Player playerTwo = players.get(PLAYER_TWO);

    if (playerTwo.strategy.beats(playerOne.strategy)) return playerTwo;

    return playerOne;
  }
}
