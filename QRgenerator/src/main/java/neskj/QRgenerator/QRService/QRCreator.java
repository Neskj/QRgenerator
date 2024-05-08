package neskj.QRgenerator.QRService;

import neskj.QRgenerator.Model.Visitor;
import org.springframework.stereotype.Component;

//тестовая реализация для проверки контроллера, больше не используется
@Deprecated
@Component
public class QRCreator implements QRReturner {

    public String returnQrCode(Visitor visitor){

        return "Тут будет qr код для строки --->>"+" Имя : "+visitor.getName()+" ; Отчество : "+visitor.getPatronymic()+ " ; Фамилия : "+visitor.getSurname()+" .";
    }
}
