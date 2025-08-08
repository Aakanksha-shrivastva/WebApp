package com.bmt.webapp.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bmt.webapp.models.Client;
import com.bmt.webapp.models.ClientDto;
import com.bmt.webapp.repositorys.ClientRepository;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientRepository clientRepo;

    @GetMapping({"", "/"})
    public String getClients(Model model) {
        var clients = clientRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("clients", clients);
        return "clients/index";
    }

    @GetMapping("/create")
    public String createClient(Model model) {
        model.addAttribute("clientDto", new ClientDto());
        return "clients/create";
    }

    @PostMapping("/create")
    public String createClient(
            @Valid @ModelAttribute("clientDto") ClientDto clientDto,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "clients/create";
        }

        Client client = new Client();
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setGender(clientDto.getGender());
        client.setPassword(clientDto.getPassword());
        client.setRole(clientDto.getRole());
        client.setPhone(clientDto.getPhone());
        client.setCreatedAt(new Date());

        clientRepo.save(client);

        return "redirect:/clients";
    }

    // EDIT FORM (GET)
    @GetMapping("/edit")
    public String editClient(Model model, @RequestParam("id") int id) {
        Client client = clientRepo.findById(id).orElse(null);
        if (client == null) {
            return "redirect:/clients";
        }

        // Map entity to DTO
        ClientDto clientDto = new ClientDto();
        clientDto.setName(client.getName());
        clientDto.setEmail(client.getEmail());
        clientDto.setGender(client.getGender());
        clientDto.setPassword(client.getPassword());
        clientDto.setRole(client.getRole());
        clientDto.setPhone(client.getPhone());

        model.addAttribute("client", client); // Optional: for display
        model.addAttribute("clientDto", clientDto);

        return "clients/edit";
    }

    // EDIT SAVE (POST)
    @PostMapping("/edit")
    public String updateClient(
            @RequestParam("id") int id,
            @Valid @ModelAttribute("clientDto") ClientDto clientDto,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "clients/edit";
        }

        Client client = clientRepo.findById(id).orElse(null);
        if (client == null) {
            return "redirect:/clients";
        }

        // Update fields
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setGender(clientDto.getGender());
        client.setPassword(clientDto.getPassword());
        client.setRole(clientDto.getRole());
        client.setPhone(clientDto.getPhone());

        clientRepo.save(client);

        return "redirect:/clients";
    }
}
