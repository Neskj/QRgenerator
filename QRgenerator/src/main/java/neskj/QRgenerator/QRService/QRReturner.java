package neskj.QRgenerator.QRService;


import org.springframework.web.bind.annotation.RequestParam;

public interface QRReturner {

    String returnQrCode(String name, String patronymic,String surname);

}
