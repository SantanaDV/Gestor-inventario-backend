package com.inventario.gestor_inventario.utilities;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.inventario.gestor_inventario.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

public class ProductoIdSerializer extends JsonSerializer<Producto> {
    @Override
    public void serialize(Producto producto, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", producto.getId_producto());
        gen.writeEndObject();
    }
}
