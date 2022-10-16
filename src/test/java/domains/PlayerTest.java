package domains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fixtures.PlayerFixture;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import strategys.StrategyType;

@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
class PlayerTest {

  @ParameterizedTest
  @MethodSource("fixtures.PlayerMethodSource#equals")
  void equals(Player one, Player two, boolean expected) {
    assertEquals(expected, one.equals(two));
    assertEquals(expected, two != null && one.hashCode() == two.hashCode());
  }

  @Test
  void shouldThrowWithNullStrategy() {
    assertThrows(Exception.class, () -> PlayerFixture.of("name", null));
  }

  @ParameterizedTest
  @NullAndEmptySource
  void shouldThrowWithNullName(String name) {
    assertThrows(Exception.class, () -> PlayerFixture.of(name, StrategyType.S));
  }
}
