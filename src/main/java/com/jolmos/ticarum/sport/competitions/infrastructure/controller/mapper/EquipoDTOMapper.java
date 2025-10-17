package com.jolmos.ticarum.sport.competitions.infrastructure.controller.mapper;

import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto.TeamDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EquipoDTOMapper {

    public TeamDTO map(Team team) {

        return new TeamDTO(team.getId(), team.getNombre(), List.of());

    }

    public Team map(TeamDTO teamDTO) {

        Team team = new Team();
        team.setId(teamDTO.id());
        team.setNombre(teamDTO.nombre());
        return team;

    }


}