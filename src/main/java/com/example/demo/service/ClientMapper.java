package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientDTO map(Client entity) {
        ClientDTO MappClientTodto = new ClientDTO();
        MappClientTodto.setId(entity.getId());
        MappClientTodto.setNom(entity.getNom());
        MappClientTodto.setPrenom(entity.getPrenom());
        MappClientTodto.setEmail(entity.getEmail());
        MappClientTodto.setNumero(entity.getNumero());
        MappClientTodto.setAdresse(entity.getAdresse());
        return MappClientTodto;
    }
}
