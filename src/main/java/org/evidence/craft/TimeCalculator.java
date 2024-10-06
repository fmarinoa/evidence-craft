package org.evidence.craft;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class TimeCalculator {

    public String calculateTimelap(List<LocalDateTime> times) {
        if (times == null || times.isEmpty()) {
            return "No hay tiempos disponibles.";
        } else if (times.size() == 1) {
            return times.get(0).toString(); // o un formato específico
        }

        // Calcular la duración entre los dos LocalDateTime
        Duration duration = Duration.between(times.get(0), times.get(times.size() - 1));
        return calculateDuration(duration);
    }

    private String calculateDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        StringBuilder result = new StringBuilder();

        if (hours > 0) {
            result.append(hours).append(" horas");
        }
        if (minutes > 0) {
            if (result.length() > 0) {
                result.append(" y ");
            }
            result.append(minutes).append(" minutos");
        }
        if (seconds > 0) {
            if (result.length() > 0) {
                result.append(" y ");
            }
            result.append(seconds).append(" segundos");
        }

        return result.length() > 0 ? result.toString() : "0 segundos";
    }
}

