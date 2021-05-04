package guru.springframework.controllers;//package guru.springframework.controllers;

//import guru.springframework.domain.Admin;
//import guru.springframework.domain.Product;
//import guru.springframework.services.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//public class AdminController {
//    private AdminService adminService;
//        @Autowired
//      public void setAdminService(AdminService adminService){
//        this.adminService=adminService;
//
//        }
//        @RequestMapping(("/admin"))
//           public String editAdmin(Model model){
//            model.addAttribute("admin",new Product());
//            return "admin";
//
//            }

import guru.springframework.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//        }
@Controller
public class AdminController {

        @RequestMapping(("/administrator"))
           public String editAdmin(Model model){
            model.addAttribute("admin",new Product());
            return "administrator";

            }

        }

