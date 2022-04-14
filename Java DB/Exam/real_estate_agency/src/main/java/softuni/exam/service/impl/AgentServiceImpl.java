package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportAgentDTO;
import softuni.exam.models.dto.ImportTownDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.FileUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

@Service
public class AgentServiceImpl implements AgentService {
    private final Path path = Path.of("src", "main", "resources", "files", "json", "agents.json");
    private final FileUtil fileUtil;
    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public AgentServiceImpl(FileUtil fileUtil, AgentRepository agentRepository, TownRepository townRepository, Gson gson, Validator validator, ModelMapper modelMapper) {
        this.fileUtil = fileUtil;
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return fileUtil.readFile(path);
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder result = new StringBuilder();

        String json = readAgentsFromFile();

        ImportAgentDTO[] agentDTOS = this.gson.fromJson(json, ImportAgentDTO[].class);

        Arrays.stream(agentDTOS)
                .map(this::importAgent)
                .forEach(r -> result.append(r).append(System.lineSeparator()));

        return result.toString().trim();
    }

    private String importAgent(ImportAgentDTO importAgentDTO) {

        Set<ConstraintViolation<ImportAgentDTO>> constraintViolations = this.validator.validate(importAgentDTO);

        if (constraintViolations.isEmpty()) {
            Optional<Agent> optionalAgent = this.agentRepository.findByFirstName(importAgentDTO.getFirstName());
            Optional<Town> optionalTown = this.townRepository.findByTownName(importAgentDTO.getTown());
            if (optionalAgent.isEmpty() && optionalTown.isPresent()) {

                Agent agent = this.modelMapper.map(importAgentDTO, Agent.class);
                agent.setTown(optionalTown.get());

                this.agentRepository.save(agent);
                return String.format("Successfully imported agent - %s %s", agent.getFirstName(), agent.getLastName());
            } else {
                return "Invalid agent";
            }
        } else {
            return "Invalid agent";
        }

    }

}
