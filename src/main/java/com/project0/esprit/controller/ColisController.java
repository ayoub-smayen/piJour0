package com.project0.esprit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Colis;
import com.project0.esprit.entity.DiceRoll;
import com.project0.esprit.entity.Etat;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Rollable;
import com.project0.esprit.payload.SmsRequest;
import com.project0.esprit.repository.ColisRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.service.ColisService1;
import com.project0.esprit.service.Service;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class ColisController {
	
	
	
	
	
	
	
	
	@Autowired
	ColisRepository colisrepo;
	
	
	@Autowired
    ColisService1 service;
	
	   @Autowired
	 Service service1;

	   
	   @Autowired
	   private ProductRepository prodrep;
 
   
	   @Autowired
	   private RestTemplate restTemplate;

	   
	   
	   @Autowired
	   private UserRepository userep;
	   
	   @Autowired(required = true)
	    private Rollable greenDice;

	    @Autowired(required = true)
	    private Rollable yellowDice;

	    @Autowired(required = true)
	    private Rollable brownDice;

	    @Autowired(required = true)
	    private Rollable blueDice;

	    @Autowired(required = true)
	    private Rollable greyDice;

	    @Autowired(required = true)
	    private Rollable redDice;

	    @Autowired(required = true)
	    private Rollable blackDice;

	 /*   @GetMapping("/dice/yellow/roll")
	    public @ResponseBody DiceRoll yellowDiceRoll() {
	        return DiceRoll.invoke("Yellow", yellowDice.roll());
	    }

	    @GetMapping("/dice/green/roll")
	    public @ResponseBody DiceRoll greenDiceRoll() {
	        return DiceRoll.invoke("Green", greenDice.roll());
	    }

	    @GetMapping("/dice/brown/roll")
	    public @ResponseBody DiceRoll brownDiceRoll() {
	        return DiceRoll.invoke("Brown", brownDice.roll());
	    }

	    @GetMapping("/dice/blue/roll")
	    public @ResponseBody DiceRoll blueDiceRoll() {
	        return DiceRoll.invoke("Blue", blueDice.roll());
	    }

	    @GetMapping("/dice/grey/roll")
	    public @ResponseBody DiceRoll greyDiceRoll() {
	        return DiceRoll.invoke("Grey", greyDice.roll());
	    }

	    @GetMapping("/dice/red/roll")
	    public @ResponseBody DiceRoll redDiceRoll() {
	        return DiceRoll.invoke("Red", redDice.roll());
	    }

	    @GetMapping("/dice/black/roll")
	    public @ResponseBody DiceRoll blackDiceRoll() {
	        return DiceRoll.invoke("Black", blackDice.roll());
	    }*/
	    
	   
	//   private static int r =0;
	   
	   
	    private String[] slotMachineSymbols = {
	    		"A","B","C"
	    };

	     private  List<String> slotprooduct  =new ArrayList<>() ;
	    
	    
	    
	/*    @RequestMapping("/random")
	    public int getRandomNumber(){
	        return new   Random().nextInt() % 50;
	    }
	    
	    
	    @RequestMapping("/visited")
	    public int  getvisiteder() {
	    	this.r++;
	    	return  r;
	    }
	    
	    @RequestMapping("lvisit")
	    //@HystrixCommand(fallbackMethod = "defaultSpinResult")
	    public String visited(){
	    	 return String.format("%s",getVisitor());
	    	
	    }
 private String getVisitor(){
	    	
	    	
	        int randomNumber = restTemplate.getForObject("http://localhost:8091/api/visited", Integer.class);
	       
	      
	         
	        return    Integer.toString(randomNumber);
	    }*/
 
	    

	    @RequestMapping("/play")
	    //@HystrixCommand(fallbackMethod = "defaultSpinResult")
	    public String spin(Principal us){
	    	
	    	User ui = userep.findByUsernameAndFetchRoles(us.getName());
	    	
	    	
	    	
	    	Long l = 1l;
	    	Product1 p1 = prodrep.findById(l).get();
	    	
	    	String s1 =getSingleSpinResult() ;
	    	String s2 =getSingleSpinResult();
	    	String s3=getSingleSpinResult();
	    	
	    	if(s1.equals(s2) && s2.equals(s3) && s1.equals(s3))
	    		
	    	{
	    		ui.setId(ui.getId());
	    		ui.incrementsCoins();
	    		
	    		// service1.sensStringsms(" you " +  ui.getUsername()  +  " win 🎁   💰💰💰💰     🤑 🤑 🤑 🤑 🤑 🤑 🤑 🤑 🤑 🤑 🤑 🤑  🎁  🎁  🎁   🎁      a  product "  + s1,p1.getProductImg());
	    		ui.setCoins(ui.getCoins()+1);
	    		  userep.save(ui);

	 	        return String.format("  you win 🎁  🤑 🤑 🤑 🤑 🤑 🤑 🤑 🤑 🤑 🤑 🤑 🤑    a  product %s %s %s",s1 , s2, s3);
	 	    	
	    	}
	    	else  return String.format("  you lose  😁  😁  😁  😁   try again    %s %s %s",s1 , s2, s3);
	    }

	    private String getSingleSpinResult(){
	    	
	    	for (Product1   m: prodrep.findAll()) {
	    		slotprooduct.add(m.getProductname());
	    	}
	        int randomNumber = restTemplate.getForObject("http://localhost:8091/api/random", Integer.class);
	       
	         String[] arr =  new String[slotprooduct.size()];
	         slotprooduct.toArray(arr);
	        return    arr[Math.abs(randomNumber%slotprooduct.toArray().length)];
	    }
 
	    
	    
	    private String defaultSpinResult() {
	        return "? ? ?";
	    }


    @PostMapping("/v1/sms")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        service1.sendSms(smsRequest);
    }
    
    
    @PostMapping("/v1/sms2")
    public void sendSms2() {
    	
    	for(Colis b : colisrepo.findAll()) {
    		service1.sendMsg(b);
    	}
        
    }
 
 
    @GetMapping("/pagColis")
    public ResponseEntity<List<Colis>> getAllEmployees(
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "prenom") String sortBy) 
    {
        List<Colis> list = service.getAllEmployees(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Colis>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
	
	
	@PostMapping("/addcolis")
	//@Secured("ROLE_ADMIN")
	private @ResponseBody ResponseEntity<?> savecolis(@RequestBody Colis coli) throws Exception {
		coli.setAffected(true);
		
		coli.setEtatcolis(Etat.EnAttent);
		
		Colis xc =colisrepo.save(coli);
		
		getAllAttentColis();
		
		return ResponseEntity.status(201).body(xc);
		
	}
	
	
	@PutMapping("/putcolis")
	//@Secured("ROLE_ADMIN")@RequestBody Colis coli
	private @ResponseBody ResponseEntity<?> savecolisEtat() throws Exception {
		//coli.setAffected(true);
		
		//coli.setEtatcolis(Etat.EnAttent);
		List<Colis> colismodif = colisrepo.findAll();
		for (Colis xc : colismodif) {
			colisrepo.findById(xc.getColi_id()).map(etr->{
				 etr.setColi_id( etr.getColi_id());
				 if(etr.getEtatcolis()==Etat.EnAttent)
				etr.setEtatcolis(Etat.enCours);
				 
				return colisrepo.save(etr);
			});
		}
		
		colisrepo.saveAll(colismodif);
		
		
		
		
		
		//Colis xc =colisrepo.save(coli);
		
		return ResponseEntity.status(201).body(colismodif);
		
	}
	
	
	@GetMapping("/colis")
	//@Secured("ROLE_ADMIN")
	private List<Colis> getAllColis(){
		return colisrepo.findAll();
	}
	

	 @GetMapping("/colisEnattent")
	 
	 
	 
	 private @ResponseBody ResponseEntity<?> getAllAttentColis(){
		 
		  List<Colis> enatt = new ArrayList<Colis>();
		  
		  
		  for(Colis l : colisrepo.findAll()) {
			  if(l.getEtatcolis().equals(Etat.EnAttent)) {
				  enatt.add(l);
			  }
		  }
		  
		  
		  
		  
		  
		  
		  return  ResponseEntity.status(201).body(enatt);
		 
		 
	 }
	
}
