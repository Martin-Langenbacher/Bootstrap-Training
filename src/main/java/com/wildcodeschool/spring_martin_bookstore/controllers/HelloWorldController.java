package com.wildcodeschool.spring_martin_bookstore.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {
	
	@GetMapping("/")
    public String hello() {
		return "index";
    }
	

    
	
	/*
	
	@GetMapping("/")
    public String hello() {
		return "Hello Martin & World!!!";
    }
	
	
	@GetMapping("/index")
	public String getIndexPage() {

		return "redirect:/index";
	}
	*/
	
	
/*	
	
	// read one...
    @GetMapping("/school")
    public String getSchool(Model model,
                            @RequestParam(required = false) Long id) {

        // TODO : find one school by id
    	School school = new School();
    	if (id != null) {
    		Optional<School> optionalSchool = repository.findById(id);
    		if (optionalSchool.isPresent()) {
    			school = optionalSchool.get();
    		}
    	}
    	model.addAttribute("school", school);

        return "school";
    }
	
	
	*/
	
	
}






/*


@Controller
public class UserController {

	private final UserService userService;
	private final SkillService skillService;
	private final UserSkillService userSkillService;

	@Autowired
	public UserController(UserService userService, SkillService skillService, UserSkillService userSkillService) {
		super();
		this.userService = userService;
		this.skillService = skillService;
		this.userSkillService = userSkillService;
	}

	@GetMapping("/users/search")
	public String getUsersBySkillId(Model model, @RequestParam(name = "id", required = true) Long skillId) {
		model.addAttribute("users", userService.getUsersBySkillId(skillId));

		Skill skill = skillService.getSingleSkill(skillId);
		model.addAttribute("skill", skill);

		return "users/get_by_skill";
	}

	// Show administrator page
	@GetMapping("/admin")
	public String getAll(Model model) {

		model.addAttribute("users", userService.getUsers());

		return "users/get_all";
	}

	// Show edit user form
	@GetMapping("/user/edit")
	public String showEditUserForm(UserForm userForm, @RequestParam(name = "id", required = false) Long userId) {

		User user = new User();

		if (userId != null) {
			Optional<User> optionalUser = userService.getSingleUser(userId);
			if (optionalUser.isPresent()) {
				user = optionalUser.get();
			}
		}

		userForm.setUser(user);

		Set<UserSkill> userSkills = user.getUserSkills();
		List<Skill> skills = skillService.getSkills();

		UserSkillLevel userSkillLevel;

		for (Skill skill : skills) {
			userSkillLevel = new UserSkillLevel(skill.getId(), skill.getName(), false, skill.getImageURL());
			for (UserSkill userSkill : userSkills) {
				if (skill.getId() == userSkill.getId().getSkillId()) {
					userSkillLevel.setChecked(true);
				}
			}
			userForm.getUserSkillLevels().add(userSkillLevel);
		}

		return "user/edit";
	}

	// Create a new user
	@GetMapping("/user/new")
	public String getUser2(Model model) {

		User user = new User();
		model.addAttribute("user", user);

		return "user/edit";
	}

	// Update or insert a user
	@PostMapping("/user/upsert")
	public String postUser(@ModelAttribute UserForm userForm,
			@RequestParam(name = "id", required = false) Long userId, Principal principal) {
		boolean isNewUser = userId == null;

		User user = new User();

		if (!isNewUser) {
			Optional<User> optionalUser = userService.getSingleUser(userId);
			if (optionalUser.isPresent()) {
				user = optionalUser.get();
			}
		}

		Set<Long> userSkillIds = user.getUserSkillIds();
		List<UserSkillLevel> userSkillLevels = userForm.getUserSkillLevels();

		// Durchlaufen der UserSkillLevel-Liste - geht über alle skills
		for (UserSkillLevel userSkillLevel : userSkillLevels) {

			if (userSkillLevel.isChecked()) {
				Skill skill;

				skill = skillService.getSingleSkill(userSkillLevel.getId());

				if (!(userSkillIds.contains(userSkillLevel.getId()))) {
					userSkillService.addNewUserSkill(user, skill);
				}
			} else {
				Skill skill = null;

				skill = skillService.getSingleSkill(userSkillLevel.getId());

				if (userSkillIds.contains(userSkillLevel.getId())) {
					userSkillService.removeUserSkill(user, skill);
				}
			}
		}

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		user.setId(userForm.getId());
		user.setFirstName(userForm.getFirstName());
		user.setLastName(userForm.getLastName());
		user.setZipCode(userForm.getZipCode());
		user.setCity(userForm.getCity());
		user.setDateOfBirth(userForm.getDateOfBirth());
		user.setEmail(userForm.getEmail());
		// user.setPassword(userForm.getPassword());
		user.setPassword(passwordEncoder.encode(userForm.getPassword()));

		user.setDescription(userForm.getDescription());
		user.setImageURL(userForm.getImageURL());

		if (isNewUser) {
			userService.createNewUser(user);
		} else {
			userService.updateUser(user);
		}
		
		if ("admin".equals(principal.getName())) {
			return "redirect:/admin";
		}
		return "redirect:/user/profile";

	}

	// View a user
	@GetMapping("/user/view")
	public String viewUser(Model model, @RequestParam(name = "id", required = false) Long userId) {

		User user = new User();

		if (userId != null) {
			Optional<User> optionalUser = userService.getSingleUser(userId);
			if (optionalUser.isPresent()) {
				user = optionalUser.get();
			}
		}

		model.addAttribute("user", user);

		return "user/view";
	}

	// View user profile
	@GetMapping("/user/profile")
	public String viewProfile(Model model) {
		User user = new User();

		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long userId = user.getId();

		if (userId != null) {
			Optional<User> optionalUser = userService.getSingleUser(userId);
			if (optionalUser.isPresent()) {
				user = optionalUser.get();
			}
		}

		model.addAttribute("user", user);

		return "user/profile";
	}

	// Delete a user
	@GetMapping("/user/delete")
	public String deleteUser(@RequestParam Long id) {

		userService.deleteUser(id);

		return "redirect:/user/deleted";
	}

	// Delete a user
	@GetMapping("/user/deleted")
	public String deletedUser() {

		return "/user/deleted";
	}

}

*/
