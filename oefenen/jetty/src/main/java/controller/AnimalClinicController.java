package controller;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import entity.Animal;
import entity.AnimalType;
import entity.Consult;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.AnimalClinicService;

public class AnimalClinicController {

    private final AnimalClinicService service;

    public AnimalClinicController(AnimalClinicService service) {
        this.service = service;
    }

    @POST
    @Path("/newanimal")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createNewAnimal(AnimalDTO dto) {
        if (dto.getName() != null && dto.getType() != null && dto.getOwner() != null) {
            AnimalType type = AnimalType.valueOf(dto.getType());
            return service.addAnimal(dto.getName(), type, dto.getOwner());
        }
        return false;
    }

    @GET
    @Path("/findanimals/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalDTO> findAllAnimalsForOwner(@PathParam("id") String owner) {
        List<Animal> animals = service.findAllAnimalsForOwner(owner);
        return animals.stream().map(this::assemble).collect(Collectors.toList());
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AnimalDTO findAnimal(@PathParam("id") int id) {
        Animal animal = service.findAnimal(id);
        return assemble(animal);
    }

    @POST
    @Path("/newconsult")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createConsult(ConsultDTO dto) {
        return service.addConsult(dto.getAnimalId(), dto.getDate(), dto.getReason());
    }

    @GET
    @Path("/findconsults/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConsultDTO> findAllConsultsForAnimal(@PathParam("id") int animalId) {
        List<Consult> consults = service.findAllConsultsForAnimal(animalId);
        return consults.stream().map(this::assemble).collect(Collectors.toList());
    }

    private AnimalDTO assemble(Animal animal) {
        AnimalDTO dto = new AnimalDTO();
        dto.setId(animal.getId());
        dto.setName(animal.getName());
        dto.setType(animal.getType().toString());
        dto.setOwner(animal.getOwner());
        return dto;
    }

    private ConsultDTO assemble(Consult consult) {
        ConsultDTO dto = new ConsultDTO();
        dto.setId(consult.getId());
        dto.setAnimalId(consult.getAnimal().getId());
        dto.setDate(consult.getDate());
        dto.setReason(consult.getReason());
        return dto;
    }
}
