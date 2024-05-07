package neskj.QRgenerator.QRService;


import org.springframework.web.bind.annotation.RequestParam;

public interface QRReturner {

    Object returnQrCode(String name, String patronymic,String surname);

}
