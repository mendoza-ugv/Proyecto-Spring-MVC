package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Ciudadano;

public interface ICiudadanoRepo extends JpaRepository<Ciudadano, Integer>{

}
