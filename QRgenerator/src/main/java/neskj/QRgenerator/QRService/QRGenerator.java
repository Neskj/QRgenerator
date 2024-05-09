package neskj.QRgenerator.QRService;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import neskj.QRgenerator.Model.Visitor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

@Component
@Qualifier("QR")
public class QRGenerator implements QRReturner {

    private final static Logger logger = Logger.getLogger(QRGenerator.class.getName());
    private BufferedImage image;

    @Override
    public Object returnQrCode(Visitor visitor) {

        String inputText = "New visitor: " + "\n" + "Organization : " + visitor.getOrganization() + "\n" + "Full name: "
                + visitor.getSurname() + " " + visitor.getName() + " " + visitor.getPatronymic() + "\n" +
                "Passport: " + visitor.getSerial() + " " + visitor.getNumber() + "\n" + "Date of visit: " + visitor.getDate();
        logger.info("A line has been accepted to generate a QR code: " + "\n" + inputText);

        byte[] encodeBytes = inputText.getBytes(StandardCharsets.UTF_8);
        String encodeText = new String(encodeBytes,StandardCharsets.ISO_8859_1);
        try {
            int width = 256;
            int height = 256;
            BitMatrix bitMatrix = new MultiFormatWriter().encode(encodeText, BarcodeFormat.QR_CODE, width, height);
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    image.setRGB(j, i, bitMatrix.get(j, i) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
                }
            }
        } catch (WriterException e) {
            logger.info("U have a Writer exception rhight now. ");
        }
        try {
            ImageIO.write(image, "png", new File("qr_code.png"));
        } catch (IOException e) {
            logger.info("Attention !!! IO Exception!!");
        }
        return image;
    }
}
