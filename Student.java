//Student Management System
class CreateStudent{
    int rollno;
    String name;
    int sub1, sub2, sub3;
    public CreateStudent(int rollno,String name,int sub1,int sub2,int sub3){
        this.rollno=rollno;
        this.name=name;
        this.sub1=sub1;
        this.sub2=sub2;
        this.sub3=sub3;
    }
    public int CalculateTotal(){
        return sub1+sub2+sub3;
    }
    public int Average(){
        return CalculateTotal()/3;
    }
    public void DisplayStudent(){
        System.out.println("Name : "+ name);
        System.out.println("RollNo : "+rollno);
        System.out.println("TotalMarks : "+CalculateTotal());
        System.out.println("AverageMarks : "+Average());
    }
}
class Student{
    public static void main(String args[]){
        int s1rollno=1,s2rollno=2,s3rollno=3;
        String name1="Arun",
                name2="Bob",
                name3="Charlie";
        int s1sub1=90,s1sub2=70,s1sub3=80,
            s2sub1=80,s2sub2=90,s2sub3=100,
            s3sub1=60,s3sub2=80,s3sub3=90;
        CreateStudent s1=new CreateStudent(s1rollno,name1,s1sub1,s1sub2,s1sub3);
        CreateStudent s2=new CreateStudent(s2rollno,name2,s2sub1,s2sub2,s2sub3);
        CreateStudent s3=new CreateStudent(s3rollno,name3,s3sub1,s3sub2,s3sub3);

        int maxavg=Math.max(
            s1.Average(),Math.max(s2.Average(),s3.Average()));
            
        System.out.print("HighestAverage : "+ maxavg);
        if(maxavg == s1.Average()) s1.DisplayStudent();
        if(maxavg == s2.Average()) s2.DisplayStudent();
        if(maxavg == s3.Average()) s3.DisplayStudent();

        System.out.println();
        System.out.println("Studetn1");
        s1.DisplayStudent();
        System.out.println("Studetn2");
        s2.DisplayStudent();
        System.out.println("Studetn3");
        s3.DisplayStudent();



    }
}
