package com.arrow.lives.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.arrow.lives.model.Live;

public interface LiveRepository extends JpaRepository<Live, Long> {

	Page<Live> findByDataLiveAfterOrderByDataLiveAsc(LocalDateTime date, Pageable pageable);

	Page<Live> findByDataLiveBeforeOrderByDataLiveDesc(LocalDateTime date, Pageable pageable);

}
