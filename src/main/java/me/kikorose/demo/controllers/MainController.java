package me.kikorose.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    BookRepo bookRepo;


    @GetMapping("/")
    public String defaultRequest(Model model){
        String myMessage = "welcome to Robo Resume";
        model.addAttribute("message", myMessage);
        return "welcome";
    }


    @GetMapping("/addinfo")
    public String addInfo(Model model) {
        model.addAttribute("newInfo", new info());
        return "addinfo";
    }

    @PostMapping("/addinfo")
    public String postBook(@Valid @ModelAttribute("newInfo") Info info, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors()){
            return "addinfo";
        }
        infoRepo.save(info);
        return "result";
    }


    @GetMapping("/addinfo")
    public String initDatabase(){
        Iterable<Info> infolist;
        ArrayList<Info>toadd = new ArrayList<>();

        Info newInfo1 = new Info();
        newInfo1.set( "John J Jingleheimer-Schmidt");

        Info newInfo2 = new Info();
        newInfo2.set("jjjschmidt@gmail.com");

        Info newInfo3 = new Info();
        newInfo3.set("Organization");

        Info newInfo4 = new Info();
        newInfo4.set("StartDate");

        Info newInfo5 = new Info();
        newInfo5.set("EndDate");


        toadd.add(newInfo1);
        toadd.add(newInfo2);
        toadd.add(newInfo3);
        toadd.add(newInfo4);
        toadd.add(newInfo5);

        infolist=toadd;

        infoRepo.save(infolist);

        return "addinfo";

    }


    @GetMapping("/allinfo")
    public String allInfo(Model model){

        Iterable<Info> allinfo = infoRepo.findAll();
        model.addAttribute("AllInfo", allinfo);
        return "allinfo";
        //return "findallbooks";

    }

    @GetMapping("/email"){

        public String email(Model model){
            model.addAttribute("newEmail", new email());
            return "email";

        }

        @GetMapping("/startdate"){

            public String startDate(Model model){
                model.addAttribute("new StartDate", new startdate());
                return "startdate";

            }

            @PostMapping("/startdate"){

                public String startDate(){

               try{
                Date Format formatter = new simpleDate(){
                       Format("dd-mm-yyyy");
                Formatter.setLenient(False);
                date=formatter.parse(05-05-1928);


                }catch(parseException e){
                    e.printStackTrace();
                   }
            }

            @GetMapping("/enddate"){

            }

                public String endDate(Model model){
                    model.addAttribute("new EndDate", new enddate());
                    return "enddate";
            }

            @PostMapping("/enddate"){
                    public String endDate(){

                        try{
                            Date Format formatter = new simpleDate(){
                                Format("dd-mm-yyyy");
                Formatter.setLenient(False);
                                date=formatter.parse(05-05-1928);


                            }catch(parseException e){
                                e.printStackTrace(); }
        }
    }
    }

    }
    }

