package neskj.QRgenerator.MainController;

import neskj.QRgenerator.QRService.QRReturner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final QRReturner returner;

    @Autowired
    MainController(QRReturner returner){
        this.returner=returner;
    }

    @GetMapping("/getcode")
    public String sendQrCode(){

        return "MainPage.html";


    }

    @PostMapping("/getcode")
    public String getData(@RequestParam(required = false) String name, @RequestParam(required = false) String patronymic, @RequestParam(required = false) String surname, Model page){

       String text ="Example";
        System.out.println(text);
        page.addAttribute("x",text);

       return "MainPage.html";

    }
}