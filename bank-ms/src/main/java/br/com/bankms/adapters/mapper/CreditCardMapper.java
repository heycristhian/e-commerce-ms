package br.com.bankms.adapters.mapper;

import br.com.bankms.adapters.inbound.dto.request.CreditCardRequest;
import br.com.bankms.application.entity.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditCardMapper {
    CreditCardMapper INSTANCE = Mappers.getMapper(CreditCardMapper.class);

    CreditCard toEntity(CreditCardRequest request);
}
