import org.evidence.craft.TimeCalculator;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeCalculatorTest {

    private final TimeCalculator timeCalculator = new TimeCalculator();

    @Test
    public void testCalculateTimelap_withTwoTimes() {
        List<LocalDateTime> times = Arrays.asList(
                LocalDateTime.of(2024, 10, 1, 10, 0, 0),
                LocalDateTime.of(2024, 10, 1, 12, 30, 15)
        );
        String result = timeCalculator.calculateTimelap(times);
        assertEquals("2 horas y 30 minutos y 15 segundos", result);
    }

    @Test
    public void testCalculateTimelap_withSingleTime() {
        List<LocalDateTime> times = Collections.singletonList(LocalDateTime.now());
        String result = timeCalculator.calculateTimelap(times);
        // Aquí podrías ajustar la aserción según el formato que esperas para un solo LocalDateTime.
        assertEquals(times.get(0).toString(), result);
    }

    @Test
    public void testCalculateTimelap_withEmptyList() {
        List<LocalDateTime> times = Collections.emptyList();
        String result = timeCalculator.calculateTimelap(times);
        assertEquals("No hay tiempos disponibles.", result);
    }

    @Test
    public void testCalculateTimelap_withNullList() {
        List<LocalDateTime> times = null;
        String result = timeCalculator.calculateTimelap(times);
        assertEquals("No hay tiempos disponibles.", result);
    }

    @Test
    public void testCalculateTimelap_withZeroDuration() {
        List<LocalDateTime> times = Arrays.asList(
                LocalDateTime.of(2024, 10, 1, 10, 0, 0),
                LocalDateTime.of(2024, 10, 1, 10, 0, 0)
        );
        String result = timeCalculator.calculateTimelap(times);
        assertEquals("0 segundos", result);
    }

    @Test
    public void testCalculateTimelap_withFourSecondDuration() {
        List<LocalDateTime> times = Arrays.asList(
                LocalDateTime.of(2024, 10, 1, 10, 0, 0),
                LocalDateTime.of(2024, 10, 1, 10, 0, 1),
                LocalDateTime.of(2024, 10, 1, 10, 0, 2),
                LocalDateTime.of(2024, 10, 1, 10, 0, 4)
        );
        String result = timeCalculator.calculateTimelap(times);
        assertEquals("4 segundos", result);
    }
}
