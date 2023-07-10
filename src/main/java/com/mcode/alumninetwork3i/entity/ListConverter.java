package com.mcode.alumninetwork3i.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.util.StringUtils;

import java.util.List;

@Converter
public class ListConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return StringUtils.collectionToCommaDelimitedString(attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return StringUtils.commaDelimitedListToSet(dbData).stream().toList();
    }
}
