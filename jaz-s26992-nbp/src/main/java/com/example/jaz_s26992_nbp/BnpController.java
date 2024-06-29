package com.example.jaz_s26992_nbp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/nbp")
public class BnpController {

    private final BnpService bnpService;

    public BnpController(BnpService bnpService) {
        this.bnpService = bnpService;
    }

    @Operation(summary = "Get And Put Into Database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Currency Founded :)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BnpBaza.class)) }),
            @ApiResponse(responseCode = "400", description = "Nieprawidłowo Sformułowane Zapytanie",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "TIMEOUT",
                    content = @Content) })
    @GetMapping("/rate/zloto")
    public ResponseEntity<ZlotoSrednia> getCurrency(@RequestParam(defaultValue = "1") Long days) throws BnpExceptionHandlers{
        ZlotoSrednia ZlotoSrednia = bnpService.kurs(days);
        return ResponseEntity.ok(ZlotoSrednia);
    }
}
