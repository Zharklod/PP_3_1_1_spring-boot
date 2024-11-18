package spring.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.spring_boot.model.User;
import spring.spring_boot.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users/all-users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam(value = "id", defaultValue = "0") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam(value = "id", defaultValue = "0") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @ModelAttribute("headerMessage")
    public String getHeaderMessage() {
        return "Важное сообщение!!!";
    }
}
