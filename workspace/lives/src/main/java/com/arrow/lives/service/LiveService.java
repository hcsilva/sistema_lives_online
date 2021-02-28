package com.arrow.lives.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.arrow.lives.model.Live;
import com.arrow.lives.repository.LiveRepository;

@Service
public class LiveService {

	@Autowired
	private LiveRepository liveRepository;

	public Page<Live> findAll(Pageable pageable, String flag) {
		if (flag != null && pageable.equals("next")) {
			return liveRepository.findByDataLiveAfterOrderByDataLiveAsc(LocalDateTime.now(), pageable);
		} else if (flag != null && flag.equals("previous")) {
			return liveRepository.findByDataLiveBeforeOrderByDataLiveDesc(LocalDateTime.now(), pageable);
		} else {
			return liveRepository.findAll(pageable);
		}
	}

	public Optional<Live> findById(Long id) {
		return liveRepository.findById(id);
	}

	public Live save(Live live) {
		return liveRepository.save(live);
	}

	public void delete(Live live) {
		liveRepository.delete(live);
	}

}
