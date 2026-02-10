import kotlin.collections.mutableListOf

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val students = mutableListOf<Student>()
    while(true) {
        println("1)AddStudent 2)ViewStudents 3)SearchStudent 4)Exit".trimIndent())
        when(readln().toIntOrNull()){
            1 -> addStudent(students)
            2-> viewStudents(students)
            3 -> searchStudent(students)
            4 -> return
            else ->println("Invalid choice")
        }
    }
}
fun viewStudents(students: List<Student>){
    if(students.isEmpty()){
        println("No students found")
        return
    }
    for(student in students){
        val a = student.mark?:"N/A"
        println("Name:  "+student.name+", RollNo: "+student.rollno+", Marks: "+a)
    }
}
fun searchStudent(students: List<Student>){
    println("Enter the Rollno of the student:  ")
    val a = readln().toIntOrNull()
    if(a==null){
        println("Invalid RollNo")
        return
    }
    for(student in students){
        if(student.rollno==a){
            println("Name ${student.name}, Rollno: ${student.rollno}, Marks: ${student.mark}")
            return
        }
    }
    println("Student not found")
}
fun addStudent(students: MutableList<Student>){
      println("Enter the name of the student: ")
      val name:String = readln()
      if(name.isBlank()){
          println("Name field should not be empty")
          return
      }
      println("Enter the rollno of the student: ")
      val rollno = readln().toIntOrNull()
      if(rollno == null){
          println("invalid rollno")
          return
      }
      println("Enter the mark of the student:")
      val marks = readln()
      val m = if(marks.isBlank()) null else marks.toIntOrNull()
      if(marks.isNotBlank() && m==null){
          println("Marks field should not be empty")
          return
      }
      val e = Student(name = name, rollno = rollno, mark = m)
      students.add(e)

}