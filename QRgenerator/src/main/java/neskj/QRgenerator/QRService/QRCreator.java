package neskj.QRgenerator.QRService;

import org.springframework.stereotype.Component;

@Component
public class QRCreator implements QRReturner {

    public String returnQrCode(String name, String patronymic,String surname){

        StringBuilder qr=new StringBuilder()
                .append(name)
                .append(patronymic)
                .append(surname);

        return "Тут будет qr код для строки : "+qr.toString();

    }
}
