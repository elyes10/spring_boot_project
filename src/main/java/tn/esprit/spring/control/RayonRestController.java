package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Rayon;

import tn.esprit.spring.services.RayonService;

@RestController
@Api(tags = "Rayon management")
@RequestMapping("/rayon")
public class RayonRestController {

	@Autowired
	RayonService rayonService;

	// http://localhost:8089/SpringMVC/rayon/get-all-rayons
		@GetMapping("/get-all-rayons")
		@ResponseBody
		@ApiOperation(value = "Récupérer la liste des stocks")
		public List<Rayon> getRayons() {
		List<Rayon> listRayons = rayonService.getsAllRayons();
		return listRayons;
		}
		
		
		// http://localhost:8089/SpringMVC/rayon/add-rayon
		@PostMapping("/add-rayon")
		@ResponseBody
		public Rayon addRayon(@RequestBody Rayon r)
		{
		Rayon rayon = rayonService.addRayon(r);
		return rayon;
		}
		
		
		// http://localhost:8089/SpringMVC/rayon/remove-rayon/{rayon-id}
		@DeleteMapping("/remove-stock/{stock-id}")
		@ResponseBody
		public void removeRayon(@PathVariable("rayon-id") Long rayonId) {
		rayonService.deleteRayon(rayonId);
		}
		
		// http://localhost:8089/SpringMVC/rayon/modify-rayon
		@PutMapping("/modify-rayon")
		@ResponseBody
		public Rayon modifyRayon(@RequestBody Rayon rayon) {
		return rayonService.updateRayon(rayon);
		}
		
	}

