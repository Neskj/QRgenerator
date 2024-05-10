package neskj.QRgenerator.Model;

public class Visitor {

    private String organization;
    private String surname;
    private String name;
    private String patronymic;
    private String serial;
    private String number;
    private String date;

    public static class Builder{

        private  final Visitor visitor;

        public Builder(){
            this.visitor=new Visitor();
        }

        public Builder addOrganization(String organization){
            visitor.organization=organization;
            return this;
        }

        public Builder addSurname(String surname){
            visitor.surname=surname;
            return this;
        }

        public Builder addName(String name){
            visitor.name=name;
            return this;
        }

        public Builder addPatronymic(String patronymic){
            visitor.patronymic=patronymic;
            return this;
        }

        public Builder addSerial(String serial){
            visitor.serial=serial;
            return this;
        }

        public Builder addNumber(String number){
            visitor.number=number;
            return this;
        }

        public Builder addDate(String date){
            visitor.date=date;
            return this;
        }

        public Visitor build(){
            return visitor;
        }
    }

    public String getOrganization() {
        return organization;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() { return name; }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSerial() {
        return serial;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }
}
