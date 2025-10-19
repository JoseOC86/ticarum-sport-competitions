package com.jolmos.ticarum.sport.competitions.domain.service;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;
import com.jolmos.ticarum.sport.competitions.domain.model.Team;
import com.jolmos.ticarum.sport.competitions.domain.model.exception.CompetitionNotFoundException;
import com.jolmos.ticarum.sport.competitions.domain.model.exception.TeamAlreadyExistException;
import com.jolmos.ticarum.sport.competitions.domain.repository.CompetitionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CompetitionServiceTest {


    @Mock
    private CompetitionRepository competitionRepository;
    @Mock
    private TeamService teamService;
    @InjectMocks
    private CompetitionService competitionService;
    private final static Long ID_COMPETICION = 1L;
    private final static Long ID_TEAM = 2L;
    private static final String NOMBRE_TEAM = "Jose Team";

    @Test
    void executeRegistrarEquipo_withNoExistenCompetition_throwsCompetitionNotFoundException() {
        Team team = new Team();
        Mockito.when(this.competitionRepository.findById(ID_COMPETICION)).thenReturn(Optional.empty());

        Assertions.assertThrows(CompetitionNotFoundException.class, () -> this.competitionService.registrarEquipo(ID_COMPETICION, team) );
    }

    @Test
    void executeRegistrarEquipo_withTeamAlreadyRegistered_throwsTeamAlreadyRegisteredException() {
        Team team = new Team();
        team.setId(ID_TEAM);
        team.setNombre(NOMBRE_TEAM);
        Competition competition = new Competition();
        competition.addEquipo(team);
        Mockito.when(this.competitionRepository.findById(ID_COMPETICION)).thenReturn(Optional.of(competition));
        Mockito.when(this.teamService.findById(ID_TEAM)).thenReturn(Optional.of(team));

        Assertions.assertThrows(TeamAlreadyExistException.class, () -> this.competitionService.registrarEquipo(ID_COMPETICION, team) );
    }

    @Test
    void executeRegistrarEquipo_withRequestOk_RegisterSuccessfully() {
        Team team = new Team();
        team.setId(ID_TEAM);
        team.setNombre(NOMBRE_TEAM);
        Competition competition = new Competition();
        Competition competitionStored = new Competition();
        competitionStored.addEquipo(team);
        Mockito.when(this.competitionRepository.findById(ID_COMPETICION)).thenReturn(Optional.of(competition));
        Mockito.when(this.teamService.findById(ID_TEAM)).thenReturn(Optional.empty());
        Mockito.when(this.competitionRepository.save(competition)).thenReturn(competitionStored);
        Team registered = this.competitionService.registrarEquipo(ID_COMPETICION, team);

        Assertions.assertNotNull(registered);
        Assertions.assertEquals(ID_TEAM, registered.getId());
        Assertions.assertEquals(NOMBRE_TEAM, registered.getNombre());

    }
}
