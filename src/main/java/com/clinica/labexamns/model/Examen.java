package com.clinica.labexamns.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

// Creación del modelo exámen para nuestra base de datos en MongoDB
@Data
@Document(collection = "examenes")
public class Examen {
    @Id
    private String id;

    private String pacienteId;
    private String medicoId;
    private String tipoExamen;
    private LocalDateTime fecha;
    private String estado; // pendiente, completado, cancelado
    private Map<String, Object> resultado;
    private String comentarios;
}
