package controller;

import java.util.List;
import java.util.stream.Collectors;

import dao.AnimalDAO;
import dao.ConsultDAO;
import entity.Animal;
import entity.AnimalType;
import entity.Consult;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.AnimalClinicService;

@Path("clinic")
public class AnimalClinicController {

    private final AnimalClinicService service;

    public AnimalClinicController() {
        AnimalDAO animalDAO = new AnimalDAO();
        ConsultDAO consultDAO = new ConsultDAO();

        this.service = new AnimalClinicService(consultDAO, animalDAO);
    }

    @POST
    @Path("animal")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewAnimal(AnimalDTO dto) {
        if (dto.getName() != null && dto.getType() != null && dto.getOwner() != null) {
            AnimalType type = AnimalType.valueOf(dto.getType());
            boolean added = service.addAnimal(dto.getName(), type, dto.getOwner());
            if(added) {
                return Response.ok().build();
            } else {
                return Response.status(Response.Status.CONFLICT).build();
            }
        }
        return Response.status(Response.Status.PRECONDITION_FAILED).build();
    }

    @GET
    @Path("animal")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllAnimalsForOwner(@QueryParam("owner") String owner) {
        List<Animal> animals = service.findAllAnimalsForOwner(owner);
        List<AnimalDTO> dtos = animals.stream().map(this::assemble).collect(Collectors.toList());
        return Response.ok(dtos).build();
    }

    @GET
    @Path("animal/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAnimal(@PathParam("id") int id) {
        Animal animal = service.findAnimal(id);
        return Response.ok(assemble(animal)).build();
    }

    @POST
    @Path("consult")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createConsult(ConsultDTO dto) {
        boolean added = service.addConsult(dto.getAnimalId(), dto.getDate(), dto.getReason());
        if(added) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @GET
    @Path("consult")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllConsultsForAnimal(@QueryParam("animalid") int animalId) {
        List<Consult> consults = service.findAllConsultsForAnimal(animalId);
        List<ConsultDTO> dtos = consults.stream().map(this::assemble).collect(Collectors.toList());
        return Response.ok(dtos).build();
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
