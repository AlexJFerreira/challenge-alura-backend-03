package com.alura.challenge.backend3.mapper;

import org.mapstruct.Mapper;

import com.alura.challenge.backend3.dto.TransacaoDTO;
import com.alura.challenge.backend3.model.Transacao;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {
    TransacaoDTO transacaoEntityToDto(Transacao transacao);
    Transacao transacaoDTOToEntity(TransacaoDTO transacao);
}
