package com.rommelchocho.ms_clientes_personas.repository;

import org.springframework.data.repository.CrudRepository;

import com.rommelchocho.ms_clientes_personas.entity.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long>{

}
