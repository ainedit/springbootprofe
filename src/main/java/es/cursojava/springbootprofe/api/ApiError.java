package es.cursojava.springbootprofe.api;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Formato estándar de error de la API")
public class ApiError {

    @Schema(example = "404")
    private int status;

    @Schema(example = "NOT_FOUND")
    private String error;

    @Schema(example = "No existe el alumno con id=99")
    private String message;

    public ApiError() {}

    public ApiError(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public int getStatus() { return status; }
    public String getError() { return error; }
    public String getMessage() { return message; }
}
