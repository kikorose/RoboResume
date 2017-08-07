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
        String myMessage = "welcome to the Book Database";
        model.addAttribute("message", myMessage);
        return "welcome";
    }


    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("newBook", new Book());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String postBook(@Valid @ModelAttribute("newBook") Book book, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors()){
            return "addbook";
        }
        bookRepo.save(book);
        return "result";
    }


    @GetMapping("/add6books")
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

        return "allinfo";

    }


    @GetMapping("/showallbooks")
    public String showAllBooks(Model model){

        Iterable<Book> allbook = bookRepo.findAll();
        model.addAttribute("allBook", allbook);
        return "showallbooks";
        //return "findallbooks";

    }
}

}
}

