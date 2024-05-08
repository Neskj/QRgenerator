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

@Component
@Qualifier("QR")
public class QRGenerator implements QRReturner{

    BufferedImage image;

    @Override
    public Object returnQrCode(Visitor visitor) {

        String text="New visitor: "+"\n"+"Organization : "+visitor.getOrganization()+"\n"+"Full name: "
                +visitor.getSurname()+" "+visitor.getName()+ " "+visitor.getPatronymic()+"\n"+
                "Passport: "+visitor.getSerial()+" "+visitor.getNumber()+"\n"+"Date of visit: "+visitor.getDate();
        System.out.println(text);
        int width=256;
        int height=256;

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
            image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            for(int i=0;i<height;i++) {
                for (int j = 0; j < width; j++){
                    image.setRGB(j,i, bitMatrix.get(j,i)? Color.BLACK.getRGB():Color.WHITE.getRGB());
                }
            }
        }catch (WriterException e){
            System.out.println("U has a Writer exception rhight now.");
        }
        try {
            ImageIO.write(image, "png", new File("qr_code.png"));
        }catch (IOException e){
            System.out.println("Attention !!! IO Exception!!");
        }

        return image;
    }
}
