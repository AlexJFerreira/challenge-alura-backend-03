package com.alura.challenge.backend3.service;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alura.challenge.backend3.dto.TransacaoDTO;
import com.alura.challenge.backend3.exception.EmptyFileException;
import com.alura.challenge.backend3.exception.ProcessedDateException;
import com.alura.challenge.backend3.mapper.CsvMapper;
import com.alura.challenge.backend3.mapper.TransacaoMapper;
import com.alura.challenge.backend3.model.Transacao;
import com.alura.challenge.backend3.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository repository;

	@Autowired
	private TransacaoMapper mapper;

	private static final DecimalFormat DF = new DecimalFormat("0.000");
	private static final long MEGABYTE = 1024L * 1024L;

	public List<Transacao> recuperaTransacoes(MultipartFile file) throws IOException, EmptyFileException, ProcessedDateException {

		printUploadedFileInfo(file);

		List<TransacaoDTO> transacaoDtoList = CsvMapper.toTransacaoDtoList(file);

		if (isEmpty(transacaoDtoList)) {
			throw new EmptyFileException("Arquivo vazio");
		}

		final LocalDate dataTransacaoInicial = transacaoDtoList.get(0).getDataHoraTransacao().toLocalDate();

		final List<Transacao> transacoesDeHoje = repository.findByDataHoraTransacaoBetween(
				dataTransacaoInicial.atStartOfDay(),
				dataTransacaoInicial.atTime(LocalTime.MAX));

		if (isEmpty(transacoesDeHoje)) {
			
			List<Transacao> transacaoList = transacaoDtoList.stream()
					.filter(transacao -> transacao.getDataHoraTransacao().toLocalDate().equals(dataTransacaoInicial))
					.map(mapper::transacaoDTOToEntity).toList();
			
			return transacaoList;
		} else {
			System.out.println("As de hoje ja foram, chefe!");
			throw new ProcessedDateException("Arquivo do dia já foi processado");
		}

	}

	private void printUploadedFileInfo(MultipartFile file) throws IOException {
		final String fileSizeInMB = DF.format((double) file.getSize() / MEGABYTE);

		System.out.println("Nome do Arquivo: " + file.getOriginalFilename() + " Tamanho: " + fileSizeInMB + "MB");

		System.out.println("Arquivo: " + CsvMapper.toTransacaoDtoList(file));
	}

}
