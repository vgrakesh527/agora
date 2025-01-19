package com.rak.agora.common.service;

import java.util.List;

/***
 *
 * @param <P> payload
 * @param <I> Id
 * @param <R> Response
 */
public interface CrudService<P,I,R> {
  R getById(I id) throws Exception;
  List<R> getAll();
  R create(P payload) throws Exception;
  R update(I id, P payload) throws Exception;
  void delete(I id) throws Exception;
}
