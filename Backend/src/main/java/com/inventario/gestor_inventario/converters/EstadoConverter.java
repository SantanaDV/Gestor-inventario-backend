//package com.inventario.gestor_inventario.converters;
//
//import com.inventario.gestor_inventario.entities.Tarea;
//
//import jakarta.persistence.AttributeConverter;
//import jakarta.persistence.Converter;
//
//import java.util.Arrays;
//
//@Converter(autoApply = true)
//public class EstadoConverter implements AttributeConverter<Tarea.Estado, String> {
//
//    @Override
//    public String convertToDatabaseColumn(Tarea.Estado estado) {
//        return estado != null ? estado.getTexto() : null;
//    }
//
//
//
//    @Override
//    public Tarea.Estado convertToEntityAttribute(String dbData) {
//        return Arrays.stream(Tarea.Estado.values())
//                .filter(e -> e.getTexto().equals(dbData))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Estado desconocido: " + dbData));
//    }
//}
//
