package idv.maxy.maxec.biz.search.repository;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseRepository<T,ID> extends Repository<T, ID> {
	  Optional<T> findById(ID id);
	  <S extends T> S save(S entity);
}
