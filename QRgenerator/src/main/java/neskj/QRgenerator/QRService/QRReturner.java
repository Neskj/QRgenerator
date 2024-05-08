package neskj.QRgenerator.QRService;

public interface QRReturner {

    Object returnQrCode(String organization,String name,String patronymic,String surname,String serial,String number,String date);
}
