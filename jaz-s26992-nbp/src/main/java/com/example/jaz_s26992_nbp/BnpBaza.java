package com.example.jaz_s26992_nbp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="NbpPoprawa")
public class BnpBaza {
    @Schema(description = "ID of currency")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "Zloto")
    @Enumerated(EnumType.STRING)
    private Zloto zloto;
    @Schema(description = "startDate of The CurrencyQuery")
    private LocalDate data_start;
    @Schema(description = "EndDate of The CurrencyQuery")
    private LocalDate data_end;
    @Schema(description = "AvarageCurrency")
    private Double kurs;
    @Schema(description = "data oraz godzina zapytania.")
    private LocalDateTime czas;

    public BnpBaza() {
    }

    public BnpBaza(Long id, Zloto zloto, LocalDate data_start, LocalDate data_end, Double kurs, LocalDateTime czas) {
        this.id = id;
        this.zloto = zloto;
        this.data_start = data_start;
        this.data_end = data_end;
        this.kurs = kurs;
        this.czas = czas;
    }

    public BnpBaza(Zloto zloto, LocalDate data_start, LocalDate data_end, Double kurs, LocalDateTime czas) {
        this.zloto = zloto;
        this.data_start = data_start;
        this.data_end = data_end;
        this.kurs = kurs;
        this.czas = czas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Zloto getZloto() {
        return zloto;
    }

    public void setZloto(Zloto zloto) {
        this.zloto = zloto;
    }

    public LocalDate getData_start() {
        return data_start;
    }

    public void setData_start(LocalDate data_start) {
        this.data_start = data_start;
    }

    public LocalDate getData_end() {
        return data_end;
    }

    public void setData_end(LocalDate data_end) {
        this.data_end = data_end;
    }

    public Double getKurs() {
        return kurs;
    }

    public void setKurs(Double kurs) {
        this.kurs = kurs;
    }

    public LocalDateTime getCzas() {
        return czas;
    }

    public void setCzas(LocalDateTime czas) {
        this.czas = czas;
    }
}
