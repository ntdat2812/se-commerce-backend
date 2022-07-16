package com.silly.ecommerce.common.mapper;

/**
 * @param <E> represents Entity
 * @param <D> represents Dto
 */
public interface BaseMapper<E, D> {
    D entityToDto(E entity);
    E dtoToEntity(D dto);
}
