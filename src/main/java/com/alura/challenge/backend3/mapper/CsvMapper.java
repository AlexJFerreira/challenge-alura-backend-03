package com.alura.challenge.backend3.mapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.alura.challenge.backend3.dto.TransacaoDTO;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvMapper {

	public static List<TransacaoDTO> toTransacaoDtoList(MultipartFile file) throws IOException {
		final Reader reader = new InputStreamReader(file.getInputStream());

		final ColumnPositionMappingStrategy<TransacaoDTO> ms = new ColumnPositionMappingStrategy<>();
		ms.setType(TransacaoDTO.class);

		final CsvToBean<TransacaoDTO> cb = new CsvToBeanBuilder<TransacaoDTO>(reader)
				.withType(TransacaoDTO.class)
				.withFilter(new CsvMapperFilter(ms))
				.withMappingStrategy(ms).build();

		return cb.parse();
	}

}
