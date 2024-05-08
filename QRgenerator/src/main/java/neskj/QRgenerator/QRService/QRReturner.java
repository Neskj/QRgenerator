package neskj.QRgenerator.QRService;

import neskj.QRgenerator.Model.Visitor;

public interface QRReturner {

    Object returnQrCode(Visitor visitor);
}
