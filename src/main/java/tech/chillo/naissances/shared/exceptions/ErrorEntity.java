package tech.chillo.naissances.shared.exceptions;

import java.time.LocalDateTime;

public record ErrorEntity(
        LocalDateTime time,
        int status,
        String code,
        String message
) {
}
