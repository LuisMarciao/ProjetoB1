package model;

import java.time.LocalDateTime;

public class Atendimento {
    public Paciente paciente;
    public LocalDateTime horario;

    public Atendimento(Paciente paciente) {
        this.paciente = paciente;
        this.horario = LocalDateTime.now();
    }

    public String toString() {
        return paciente.nome + " atendido em " + horario;
    }
}