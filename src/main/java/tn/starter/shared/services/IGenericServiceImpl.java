package tn.starter.shared.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.starter.shared.repositories.BaseRepository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
@Slf4j
public class IGenericServiceImpl<DTO,T,ID> implements IGenericService<DTO,T,ID> {

	@Autowired
	JpaRepository<T,ID> repository;

	private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	private final Class<DTO> dtoClass = (Class<DTO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	@Override
	public DTO add(DTO dto) {
		T entity = BeanUtils.instantiateClass(entityClass);
		BeanUtils.copyProperties(dto, entity);
		repository.save(entity);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public DTO update(DTO dto) {
		T entity = BeanUtils.instantiateClass(entityClass);
		BeanUtils.copyProperties(dto, entity);
		repository.save(entity);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public DTO retrieveById(ID id) {
		T entity = repository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Object not found"));
		DTO dto = BeanUtils.instantiateClass(dtoClass);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DTO> retrieveAll() {

		return null;
	}

	@Override
	public void delete(ID id) {
		repository.deleteById(id);
	}
}
