package tn.esprit.spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.service.RayonService;

import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "Rayon management")
@RequestMapping("/rayon")
public class RayonRestController {

	@Autowired
	RayonService rayonService;

	// http://localhost:8089/SpringMVC/rayon/get-all-rayons
		@GetMapping("/get-all-rayons")
		@ResponseBody
		@ApiOperation(value = "Récupérer la liste des rayons")
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
		@DeleteMapping("/remove-rayon/{rayon-id}")
		@ResponseBody
		public void removeRayon(@PathVariable("rayon-id") int rayonId) {
		rayonService.deleteRayon(rayonId);
		}
		
		// http://localhost:8089/SpringMVC/rayon/modify-rayon
		@PutMapping("/modify-rayon")
		@ResponseBody
		public Rayon modifyRayon(@RequestBody Rayon rayon) {
		return rayonService.updateRayon(rayon);
		}
		
		// http://localhost:8089/SpringMVC/rayon/patch-rayon
		@PatchMapping("/patch-rayon")
		@ResponseBody
		@ApiOperation(value = "mise à jour partielle-rayon ")
		public Rayon patchRayon(@RequestBody Rayon rayon) {
			return rayonService.patchRayon(rayon);
	}
	
}

