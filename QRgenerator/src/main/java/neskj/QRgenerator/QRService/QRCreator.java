package neskj.QRgenerator.QRService;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Component;

@Component
public class QRCreator implements QRReturner {


    public String returnQrCode(String name, String patronymic, String surname){

        return "Тут будет qr код для строки --->>"+" Имя : "+name+" ; Отчество : "+patronymic+ " ; Фамилия : "+surname+" .";


    }
}
