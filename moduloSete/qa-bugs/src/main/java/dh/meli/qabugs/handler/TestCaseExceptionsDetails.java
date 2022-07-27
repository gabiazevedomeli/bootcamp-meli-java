package dh.meli.qabugs.handler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TestCaseExceptionsDetails {
    private String message;
    private String errorType;
    private Integer statusCode;
    private LocalDateTime timestamp;
}
