package Browser;

public class Person {
    String firstName;
    String lastName;
    String due;

    public Person(String firstName, String lastName, String due){
        this.firstName = firstName;
        this.lastName = lastName;
        this.due = due;
    }
    public double getDue(){
        return Double.parseDouble(due.replace("$",""));
    }
    public String getFullname(){
        return String.format("%S %S", firstName, lastName);
    }


}
