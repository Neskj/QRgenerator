package neskj.QRgenerator.MainController;

import neskj.QRgenerator.Model.Visitor;
import neskj.QRgenerator.QRService.QRReturner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.image.BufferedImage;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MainControllerTest {

    @Mock
    private Model page;

    @Mock
    private QRReturner returner;


    @InjectMocks
    private MainController mainController;

    @Test
    public void sendQrCodeHappyFlow(){

        assertEquals("MainPage.html",mainController.sendQrCode());
    }

    /* пока не вижу варианта как проверить принимаемый base64 и при этом не писать стрингу на 8000+ символов в тесте
    @Test
    public void getDataHappyFlow(){

        String organization="Diksy";
        String surname="Petrova";
        String name="Galina";
        String patronymic="Viktorovna";
        String serial="4892";
        String number="347284";
        String date="20.08.2026";

        Visitor visitor = new Visitor.Builder()
                .addOrganization("Diksy")
                .addSurname("Petrova")
                .addName("Galina")
                .addPatronymic("Viktorovna")
                .addSerial("4892")
                .addNumber("347284")
                .addDate("20.08.2026")
                .build();

        BufferedImage testImage =new BufferedImage(256,256,BufferedImage.TYPE_INT_RGB);
        when(returner.returnQrCode(visitor)).thenReturn(testImage);

        String execute=mainController.getData(organization,surname,name,patronymic,serial,number,date,page);
        assertEquals("MainPage.html",execute);

        verify(returner).returnQrCode(visitor);
    }
*/
}
