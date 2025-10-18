package com.jolmos.ticarum.sport.competitions.domain.service;

import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeamService {


    private final TeamRepository teamRepository;

    public Optional<Team> findById(Long teamId) {
        if (teamId == null) {
            return Optional.empty();
        }
        return this.teamRepository.findById(teamId);
    }


    public Set<Team> findByCompetition(Long competitionId) {
        return this.teamRepository.findByCompeticiones(competitionId);
    }
}