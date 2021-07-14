public class Worker{
    private String name;
    private int age;
    private int grade;

    public Worker(String name, int age, int grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName(){return name;}
    public int getAge(){return age;}
    public int getGrade(){return grade;}
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }

    public int hashCode(){
        return (11*name.hashCode() + age)*11 + grade;
    }

    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj instanceof Worker){
            Worker objCurrentClass = (Worker)obj;
            return name.equals(objCurrentClass.getName()) && age == objCurrentClass.getAge() && grade == objCurrentClass.getGrade();
        }
        return false;
    }

}