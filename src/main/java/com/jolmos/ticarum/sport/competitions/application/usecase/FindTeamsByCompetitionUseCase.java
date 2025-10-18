package com.jolmos.ticarum.sport.competitions.application.usecase;

import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.domain.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class FindTeamsByCompetitionUseCase {

   private final TeamService teamService;

    public Set<Team> execute(Long competitionId){
        return this.teamService.findByCompetition(competitionId);
    }
}
