package domains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fixtures.PlayerFixture;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
class PlayerTest {

  @Test
  @Timeout(100)
  void shouldThrowWithNullStrategy() {
    assertThrows(Exception.class, () -> PlayerFixture.of("name", null));
  }

  @ParameterizedTest
  @NullAndEmptySource
  void shouldThrowWithNullName(String name) {
    assertThrows(Exception.class, () -> PlayerFixture.of(name, StrategyType.S));
  }

  @Test
  @Timeout(100)
  void equals() {

    String name = "name";
    Player expected = PlayerFixture.of(name, StrategyType.S);
    assertEquals(expected, expected);
    assertEquals(31 * name.hashCode() + StrategyType.S.hashCode(), expected.hashCode());
    assertEquals(expected.hashCode(), expected.hashCode());
    assertEquals(expected, PlayerFixture.of(name, StrategyType.S));
    assertEquals(expected.hashCode(), PlayerFixture.of(name, StrategyType.S).hashCode());
    assertNotEquals(null, expected);
    assertNotEquals(expected, PlayerFixture.of("notequals", StrategyType.S));
    assertNotEquals(expected.hashCode(), PlayerFixture.of("notequals", StrategyType.S).hashCode());
    assertNotEquals(expected, PlayerFixture.of(name, StrategyType.P));
    assertNotEquals(expected.hashCode(), PlayerFixture.of(name, StrategyType.P).hashCode());
    assertNotEquals(expected, PlayerFixture.of("notequals", StrategyType.P));
    assertNotEquals(expected.hashCode(), PlayerFixture.of("notequals", StrategyType.P).hashCode());
  }

  @Test
  @Timeout(100)
  void toStringEquals() {
    Player expected = PlayerFixture.of("name", StrategyType.S);
    String toString = "Player{hashCode=" + expected.hashCode() + ", name='name', strategy=S}";
    assertEquals(toString, expected.toString());
  }
}
