//Employee Salary Management System
class CreateEmployee
{
    int id;
    String name;
    float basicSalary;
    int expirence;
    public CreateEmployee(int id,String name,float basicSalary,int expirence){
        this.id=id;
        this.name=name;
        this.basicSalary=basicSalary;
        this.expirence=expirence;
    }
    public float calBonus(){
        if(expirence<=0)
            return 0;
        else if (expirence<=3&&expirence>=1)
            return basicSalary*0.25f;
        else if(expirence>3 && expirence<=6)
            return basicSalary*0.50f;
        else if(expirence>6 && expirence<12)
            return basicSalary*0.75f;
        else 
            return basicSalary;
    }
    public float finalSalary(){
        return calBonus()+basicSalary;
    }
    public void DisplayEmployee(){
        System.out.println("Name : "+name);
        System.out.println("Salary : "+basicSalary);
        System.out.println("Total Salary : "+finalSalary());
        System.out.println("Expirence : "+expirence);
    }
}
public class Employee {
    public static void main(String args[]){
        int id1=1,id2=2,id3=3;
        String name1="Arun",name2="Bob",name3="Charlie";
        int exp1=8,exp2=13,exp3=3;
        float basicSalary1=12000,basicSalary2=19000,basicSalary3=25000;
        CreateEmployee emp1=new CreateEmployee(id1,name1,basicSalary1,exp1);
        CreateEmployee emp2=new CreateEmployee(id2,name2,basicSalary2,exp2);
        CreateEmployee emp3=new CreateEmployee(id3,name3,basicSalary3,exp3);
        System.out.println("Employee1");
        emp1.DisplayEmployee();
        System.out.println("Employee2");
        emp2.DisplayEmployee();
        System.out.println("Employee3");
        emp3.DisplayEmployee();
    }
}
