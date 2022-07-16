package com.silly.ecommerce.common.service;

import java.util.List;

/**
 *
 * @param <R> represents RequestDto
 * @param <S> represents ResponseDto
 */
public interface CrudService<R, S> {

    void create(R requestDto);

    void update(R requestDto);

    void delete(Long id);

    List<S> findAll();

    S findById(Long id);
}
