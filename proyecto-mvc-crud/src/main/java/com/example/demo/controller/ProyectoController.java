package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Ciudadano;
import com.example.demo.model.Domicilio;
import com.example.demo.repository.ICiudadanoRepo;
import com.example.demo.repository.IDomicilioRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProyectoController {
	
	@Autowired
	private ICiudadanoRepo ciudadanoRepo;
	
	@Autowired
	private IDomicilioRepo domicilioRepo;
	
	@GetMapping("/")
	public String home(Model modelCiu, Model modelDom){
		
		List<Ciudadano> listCiudadano;
		listCiudadano = ciudadanoRepo.findAll();
		modelCiu.addAttribute("all_ciudadano", listCiudadano);
		
		List<Domicilio> listDomicilio;
		listDomicilio = domicilioRepo.findAll();
		modelDom.addAttribute("all_domicilio", listDomicilio);
		
		return "index";
	}
	
	@GetMapping("/add_ciudadano")
	public String addCiudadano(){
		return "addCiudadano";
	}
	
	@GetMapping("/add_domicilio")
	public String addDomicilio(){
		return "addDomicilio";
	}
	
	@GetMapping("/edit_ciudadano/{IdCiudadano}")
	public String editCiudadano(@PathVariable(value = "IdCiudadano") int IdCiudadano, Model m){
		Optional<Ciudadano> ciudadano = ciudadanoRepo.findById(IdCiudadano);
		Ciudadano ciu=ciudadano.get();
		m.addAttribute("ciudadano", ciu);
		return "editCiudadano";
	}
	
	@GetMapping("/edit_domicilio/{IdDomicilio}")
	public String editDomicilio(@PathVariable(value = "IdDomicilio") int IdDomicilio, Model m){
		Optional<Domicilio> domicilio = domicilioRepo.findById(IdDomicilio);
		Domicilio dom=domicilio.get();
		m.addAttribute("domicilio", dom);
		return "editDomicilio";
	}
	
	@GetMapping("/delete_ciudadano")
	public String deleteCiudadano(){
		return "deleteCiudadano";
	}
	
	@GetMapping("/delete_domicilio")
	public String deleteDomicilio(){
		return "deleteDomicilio";
	}

	@PostMapping("/save_ciudadano")
	public String saveCiudadano(@ModelAttribute Ciudadano ciudadano, HttpSession session) {
		ciudadanoRepo.save(ciudadano);
		session.setAttribute("msg", "Ciudadano agregado con exito!");
		return "redirect:/";
	}

	@PostMapping("/save_domicilio")
	public String saveDomicilio(@ModelAttribute Domicilio domicilio, HttpSession session) {
		domicilioRepo.save(domicilio);
		session.setAttribute("msg", "Domicilio agregado con exito!");
		return "redirect:/";
	}

	@PostMapping("/update_ciudadano")
	public String updateCiudadano(@ModelAttribute Ciudadano ciudadano, HttpSession session) {
		ciudadanoRepo.save(ciudadano);
		session.setAttribute("msg", "Ciudadano actualizado con exito!");
		return "redirect:/";
	}

	@PostMapping("/update_domicilio")
	public String updateDomicilio(@ModelAttribute Domicilio domicilio, HttpSession session) {
		domicilioRepo.save(domicilio);
		session.setAttribute("msg", "Domicilio actualizado con exito!");
		return "redirect:/";
	}
	
	@GetMapping("/delete_ciudadano/{IdCiudadano}")
	public String deleteCiudadano(@PathVariable(value = "IdCiudadano") int IdCiudadano, HttpSession session) {
		ciudadanoRepo.deleteById(IdCiudadano);
		session.setAttribute("msg", "Ciudadano eliminado con exito!");
		return "redirect:/";
	}
	
	@GetMapping("/delete_domicilio/{IdDomicilio}")
	public String deleteDomicilio(@PathVariable(value = "IdDomicilio") int IdDomicilio, HttpSession session) {
		domicilioRepo.deleteById(IdDomicilio);
		session.setAttribute("msg", "Domicilio eliminado con exito!");
		return "redirect:/";
	}
	
}
