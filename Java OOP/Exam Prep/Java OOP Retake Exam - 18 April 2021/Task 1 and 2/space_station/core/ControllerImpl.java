package space_station.core;

import space_station.common.ConstantMessages;
import space_station.common.ExceptionMessages;
import space_station.models.astronauts.Astronaut;
import space_station.models.astronauts.Biologist;
import space_station.models.astronauts.Geodesist;
import space_station.models.astronauts.Meteorologist;
import space_station.models.mission.Mission;
import space_station.models.mission.MissionImpl;
import space_station.models.planets.Planet;
import space_station.models.planets.PlanetImpl;
import space_station.repositories.AstronautRepository;
import space_station.repositories.PlanetRepository;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private AstronautRepository astronautRepository = new AstronautRepository();
    private PlanetRepository planetRepository = new PlanetRepository();
    private Mission mission = new MissionImpl();
    private int exploredPlanetsCount = 0;

    @Override
    public String addAstronaut(String type, String astronautName) {

        Astronaut astronaut;

        switch (type){
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        astronautRepository.add(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {

        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(List.of(items));
        planetRepository.add(planet);

        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if (astronaut == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> suitableAstronauts = astronautRepository.getModels().stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if (suitableAstronauts.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Planet planet = planetRepository.findByName(planetName);
        mission.explore(planet, suitableAstronauts);
        this.exploredPlanetsCount ++;
        long deadAstronautsCount = suitableAstronauts.stream().filter(a-> a.getOxygen() == 0).count();

        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronautsCount);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanetsCount))
                .append(System.lineSeparator())
                .append(ConstantMessages.REPORT_ASTRONAUT_INFO);
        for (Astronaut astronaut : astronautRepository.getModels()){
            sb.append(System.lineSeparator())
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, astronaut.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()))
                    .append(System.lineSeparator());
            if (astronaut.getBag().getItems().isEmpty()){
                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"));
            } else {
                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,
                        String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems())));
            }
        }
        return sb.toString();
    }
}
