package neskj.QRgenerator.MainController;

import neskj.QRgenerator.Model.Visitor;
import neskj.QRgenerator.QRService.QRReturner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Logger;

@Controller
public class MainController {

    private final static Logger logger = Logger.getLogger(MainController.class.getName());
    private final QRReturner returner;

    @Autowired
    MainController(@Qualifier("QR") QRReturner returner) {
        this.returner = returner;
    }

    @GetMapping("/getcode")
    public String sendQrCode() {

        return "MainPage.html";
    }

    @PostMapping("/getcode")
    public String getData(@RequestParam(required = false)String organization,
                          @RequestParam(required = false) String surname,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) String patronymic,
                          @RequestParam(required = false) String serial,
                          @RequestParam(required = false) String number,
                          @RequestParam(required = false) String date, Model page){

        Visitor visitor=new Visitor.Builder()
                .addOrganization(organization)
                .addSurname(surname)
                .addName(name)
                .addPatronymic(patronymic)
                .addSerial(serial)
                .addNumber(number)
                .addDate(date)
                .build();

        BufferedImage image=(BufferedImage) returner.returnQrCode(visitor);

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", byteStream);
        } catch (IOException e) {
            logger.info("U have IO exception now...");
        }

        byte[] qrInBytes = byteStream.toByteArray();
        String qrInBase64 = Base64.getEncoder().encodeToString(qrInBytes);
        logger.info("Detected new QR code : " + "\n" + "Going to Base64 -->> " + qrInBase64);

        String message = (qrInBase64 != null) ? "Ваш QR код: " : "Ошибка при создании QR кода. ";
        page.addAttribute("message", message);
        page.addAttribute("qrCode", qrInBase64);

        return "MainPage.html";
    }
}

