package com.jolmos.ticarum.sport.competitions.infrastructure.repository.mapper;

import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.infrastructure.repository.model.TeamDBO;
import org.springframework.stereotype.Component;

@Component
public class EquipoDBOMapper {

    public TeamDBO map(Team team) {

        TeamDBO teamDBO = new TeamDBO();
        teamDBO.setId(team.getId());
        teamDBO.setNombre(team.getNombre());

        return teamDBO;

    }

    public Team map(TeamDBO teamDBO) {

        Team team = new Team();
        team.setId(teamDBO.getId());
        team.setNombre(teamDBO.getNombre());

        return team;

    }


}