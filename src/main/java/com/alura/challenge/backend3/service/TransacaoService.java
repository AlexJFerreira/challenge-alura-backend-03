package com.alura.challenge.backend3.service;

import java.io.IOException;
import java.text.DecimalFormat;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alura.challenge.backend3.mapper.CsvMapper;

@Service
public class TransacaoService {
	
	private static final DecimalFormat DF = new DecimalFormat("0.000");
	private static final long MEGABYTE = 1024L * 1024L;
	
	public void processaTransacao(MultipartFile file) throws IOException {

		final String fileSizeInMB = DF.format((double) file.getSize() / MEGABYTE);
		  
		System.out.println("Nome do Arquivo: " + file.getOriginalFilename() + " Tamanho: " + fileSizeInMB + "MB");

		System.out.println("Arquivo: " + CsvMapper.toTransacaoDtoList(file));
	}
	


}
