package com.viper.ckframework.keymanager.mapper;

import com.viper.ckframework.keymanager.entity.ApiTokenEntity;
import com.viper.ckframework.keymanager.model.ApiTokenDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TokenMapper {

    @Mapping(source = "apiToken", target = "apiToken")
    ApiTokenDto toDto(ApiTokenEntity entity);

    @Mapping(source = "apiToken", target = "apiToken")
    ApiTokenEntity toEntity(ApiTokenDto dto);

    List<ApiTokenDto> toListDto(List<ApiTokenEntity> entities);
}
