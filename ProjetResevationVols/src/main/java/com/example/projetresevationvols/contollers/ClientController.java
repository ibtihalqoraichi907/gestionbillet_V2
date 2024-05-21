package com.example.projetresevationvols.contollers;

import com.example.projetresevationvols.entities.Client;
import com.example.projetresevationvols.entities.Reservation;
import com.example.projetresevationvols.services.ClientService;
import com.example.projetresevationvols.services.ReservationService;
import com.example.projetresevationvols.services.VolService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@AllArgsConstructor
public class ClientController {
    
    private ClientService clientService;
    private ReservationService reservationService;
    private VolService volService;

    @RequestMapping("/inscription")
    public String inscription(){

        return "inscription";
    }
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("clientvue") Client client){
        Client saveClient = clientService.saveClient(client);
        return "Land";
    }
    @GetMapping("/logins")
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("logins");
        mav.addObject("client", new Client());
        request.getSession().setAttribute("savedClient", new Client());
        return mav;
    }

    @PostMapping("/logins")
    public String connexion(@ModelAttribute("login") Client client,HttpServletRequest request){
        Client client1 = clientService.login(client.getMail(),client.getPassword());

        if(Objects.nonNull(client1)){
            request.getSession().setAttribute("savedClient", client1);
            return "index";
        }

        return "connexionech";
    }
    @GetMapping("/modclient")
    public ModelAndView editClient(HttpServletRequest request) {
        Client savedClient = (Client) request.getSession().getAttribute("savedClient");
        if(savedClient == null) {
            return new ModelAndView("redirect:/connexion");
        }
        ModelAndView mav = new ModelAndView("modclient");
        mav.addObject("client", savedClient);
        return mav;
    }
    @GetMapping("/deconnexion")
    public String deconnexion(){
        return "deconnexion";
    }
    @PostMapping("/modclient")
    public String saveEditedClient(@ModelAttribute("client") Client editedClient, HttpServletRequest request) {
        Client savedClient = (Client) request.getSession().getAttribute("savedClient");
        savedClient.setNom(editedClient.getNom());
        savedClient.setPrenom(editedClient.getPrenom());
        savedClient.setMail(editedClient.getMail());
        savedClient.setPassword(editedClient.getPassword());
        savedClient.setAdresse(editedClient.getAdresse());
        savedClient.setTel(editedClient.getTel());
        clientService.updateClient(savedClient);
        return "index";
    }
    @GetMapping("/reservation")
    public String reservation(HttpServletRequest request, ModelMap modelMap) {
        Client client1 = (Client) request.getSession().getAttribute("savedClient");
        modelMap.addAttribute("client", client1);
        return "reservation";
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request, ModelMap modelMap) {
        Client client1 = (Client) request.getSession().getAttribute("savedClient");
        modelMap.addAttribute("client", client1);
        return "index";
    }

    @GetMapping("/reservlist")
    public String reservlist(HttpServletRequest request, ModelMap modelMap) {
        Client client1 = (Client) request.getSession().getAttribute("savedClient");
        List<Reservation> reservations = reservationService.getAllByRel(client1.getId());
        modelMap.addAttribute("client", client1);
        modelMap.addAttribute("reservation",reservations );
        return "reservlist";
    }
}
