package cn.xzit.recar.Jpa.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
@NoRepositoryBean
public interface BaseJpa<T> extends JpaRepository<T, Serializable>, JpaSpecificationExecutor<T>{

}
