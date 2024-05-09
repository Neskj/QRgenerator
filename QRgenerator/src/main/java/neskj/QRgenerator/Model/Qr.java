package neskj.QRgenerator.Model;

public enum Qr {
    VISITOR("Новый посетитель : "),
    ORGANIZATION("Организация : "),
    FULLNAME("Полное имя : "),
    PASPORT("Паспорт : "),
    DATE("Дата посещения : ");

    private final String text;

    Qr(String text){
        this.text=text;
    }

    public String getText(){
        return text;
    }
}
