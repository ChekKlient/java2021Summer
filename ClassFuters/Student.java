public final class Student{
    final private String name;
    final private Age age;
    private String group;

    public Student(String name, int age, String group){
        this.name = name;
        this.age = new Age(age);
        this.group = group;
    }

    public int hashCode(){
        return ((name == null) ? 0:name.hashCode() * 5 + age.getYear())*5 + group == null ? 0: group.hashCode();
    }
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(hashCode() != obj.hashCode()) return false;
        if(obj instanceof Student){
            Student equalObject = (Student) obj;
            return (this.age.getYear()==equalObject.getAge().getYear())&&(this.name.equals(equalObject.getName()))&&(this.group.equals(equalObject.getGroup()));
        }
        return false;
    }

    private String getGroup() {
        return group;
    }

    private String getName() {
        return name;
    }

    private Age getAge() {
        return new Age(age.getYear());
    }
}