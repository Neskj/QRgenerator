package neskj.QRgenerator.QRService;

import org.springframework.stereotype.Component;

//тестовая реализация для проверки контроллера
@Deprecated
@Component
public class QRCreator implements QRReturner {


    public String returnQrCode(String organization,String name,String patronymic,String surname,String serial,String number,String date){

        return "Тут будет qr код для строки --->>"+" Имя : "+name+" ; Отчество : "+patronymic+ " ; Фамилия : "+surname+" .";
    }
}
