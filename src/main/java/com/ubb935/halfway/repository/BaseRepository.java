package com.ubb935.halfway.repository;

import com.ubb935.halfway.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
@Transactional
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, String> {
}
