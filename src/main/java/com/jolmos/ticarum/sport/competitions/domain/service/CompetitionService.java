package com.jolmos.ticarum.sport.competitions.domain.service;

import com.jolmos.ticarum.sport.competitions.domain.model.Competicion;
import com.jolmos.ticarum.sport.competitions.domain.repository.CompetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompetitionService {


    private final CompetitionRepository competitionRepository;

    public Competicion registrar(Competicion competicion) {
        return this.competitionRepository.save(competicion);
    }


}


