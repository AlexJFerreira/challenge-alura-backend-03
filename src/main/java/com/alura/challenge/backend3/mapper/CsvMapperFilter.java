package com.alura.challenge.backend3.mapper;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alura.challenge.backend3.dto.TransacaoDTO;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.MappingStrategy;

public class CsvMapperFilter implements CsvToBeanFilter {

	private final MappingStrategy<TransacaoDTO> strategy;

	public CsvMapperFilter(MappingStrategy<TransacaoDTO> strategy) {
		this.strategy = strategy;
	}

	public boolean allowLine(String[] line) {
		final List<String> lineFields = Arrays.asList(line);
		boolean invalidLine = lineFields.stream().anyMatch(StringUtils::isBlank);
		return !invalidLine;
	}

}