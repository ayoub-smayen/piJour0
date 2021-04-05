package com.project0.esprit;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.project0.esprit.datentity.Option;
import com.project0.esprit.datentity.Poll;
import com.project0.esprit.datentity.Role;
import com.project0.esprit.datentity.RoleEnum;
import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Colis;
import com.project0.esprit.entity.Etat;
import com.project0.esprit.repository.ColisRepository;
import com.project0.esprit.repository.OptionRepository;
import com.project0.esprit.repository.PollRepository;
import com.project0.esprit.repository.RoleRepository;
import com.project0.esprit.repository.UserRepository;
import java.util.Date;
import java.util.List;
@Component
public class DummyDataCmdLineRunner implements CommandLineRunner {
	

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private OptionRepository optionRepository;
    
    /*@Autowired
    private ColisRepository  colisRepository;
*/
    @SuppressWarnings("deprecation")
	@Override
    public void run(String... strings) throws Exception {
    	
    	/* Role userRole = new Role(RoleEnum.DELIVERY_MAN.toString());
         roleRepository.save(userRole);
        

         String password = bcryptEncoder.encode("password1");
    	
    	 User u1 = new User("deliv", password);
    	 u1.setEmail("delivery@gmail.com");
         u1.setRoles(Arrays.asList(userRole));
         userRepository.save(u1);
    	
    	Role userRole1 = new Role(RoleEnum.DELIVERY_MAN.toString());
        roleRepository.save(userRole1);
       

        String password1 = bcryptEncoder.encode("password1");
   	
   	 User u11 = new User("yessmine2", password1);
   	 u11.setEmail("yesminenjim@gmail.com");
        u11.setRoles(Arrays.asList(userRole1));
        userRepository.save(u11);*/
    /*

    	Date d = new Date();
    	
    	
    	Colis v;
    	
    	List<Colis> lv  = colisRepository.findAll();
 
    	System.out.println(lv);
    	 for (Colis k : lv) {
    		 
    		 
    		 if(k.getCreatedAt().getMinutes() - d.getMinutes() == 1 ) {
    			 if(k.getAffected()==true) {
    				 Colis tmp = colisRepository.findById(k.getColis_id());
    				 k.setEtatcolis(Etat.enCours);
    				 
    				 
    				 System.out.println(k.getCreatedAt().getMinutes() - d.getMinutes());
    				 System.out.println(k.getEtatcolis());
    			 }
    		 }
    		 
    		 colisRepository.saveAll(lv);
    		 
    		 
    		 
    	 }
    	
    	
    	*/
    	
    

    	/*
     Role userRole2 = new Role(RoleEnum.ROLE_USER.toString());
        roleRepository.save(userRole2);
        Role adminRole = new Role(RoleEnum.ROLE_ADMIN.toString());
        roleRepository.save(adminRole);

        String password2 = bcryptEncoder.encode("password");

        //insert normal test user
        User u2 = new User("user", password);
        u2.setRoles(Arrays.asList(userRole2));
        userRepository.save(u2);

        //insert admin test user
        User u3 = new User("admin", password);
        u3.setRoles(Arrays.asList(adminRole, userRole2));
        userRepository.save(u3);
        Poll poll = new Poll("What do you preffer to code backend in?");
        poll.setVisible(Boolean.TRUE);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        poll.setEndDate(Date.from(tomorrow.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        poll.setIpAdresses(Arrays.asList("192.168.1.42"));
        poll.setUser(u1);
        pollRepository.save(poll);

        Option option1 = new Option("Java");
        Option option2 = new Option("Node");
        option1.setPoll(poll);
        option2.setPoll(poll);
        optionRepository.save(option1);
        optionRepository.save(option2);

        Poll poll2 = new Poll("What frontend framework do you preffer?");
        poll2.setVisible(Boolean.TRUE);
        poll2.setEndDate(new Date());
        poll2.setIpAdresses(Arrays.asList("192.1.2.164"));
        poll2.setUser(u1);

        option1 = new Option("Angular");
        option2 = new Option("React");
        option1.setPoll(poll2);
        option2.setPoll(poll2);
        pollRepository.save(poll2);
        optionRepository.save(option1);
        optionRepository.save(option2);
*/
    }

}
