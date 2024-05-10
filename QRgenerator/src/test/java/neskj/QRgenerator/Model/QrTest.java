package neskj.QRgenerator.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QrTest {

    @Test
    public void tryQrParametresHappyFlow() {

        assertEquals("Новый посетитель : ", Qr.VISITOR.getText());
        assertEquals("Организация : ", Qr.ORGANIZATION.getText());
        assertEquals("Полное имя : ", Qr.FULLNAME.getText());
        assertEquals("Паспорт : ", Qr.PASPORT.getText());
        assertEquals("Дата посещения : ", Qr.DATE.getText());
    }
}
