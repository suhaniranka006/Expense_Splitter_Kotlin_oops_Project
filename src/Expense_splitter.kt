//EXPENSE TRACKER CONSOLE BASED KOTLIN APPLICATION

//person class every person's name and id
//encapsulation -bundled person data in one class
class Person (val id: String, val name: String)



//expense class -- basic expense
//composition  -- we used Person object here
class Expense (
    val id:String,   //expense id
    val amount:Double,  //amount of expense
    val payer:Person,  //person who payed
    val description:String  //type of expense
)

//expense manager -- store all expense and calculate
class ExpenseManager {
    private val expenses = mutableListOf<Expense>()  //store all expense in a list

    //new expense add
    fun addExpense(expense:Expense) {  //argument of expense type
        expenses.add(expense)  // add to add expense to list
    }


    ////calculate equal split bw all members
    fun calculateSplit(members:List<Person>):  //to calculate split we need list of persons
            Map<Person,Double>{  //share of every person

        //kotlin higher order fun (loops internally
        val total=expenses.sumOf{   //sum of all expenses
            it.amount   //sum of all amounts
        }
        val share = total/members.size   //share of each person

        return members.associateWith {   //keyword that creates a map where original elements are keys, and we generated share(value) for each key
            share  //key=member , value = share
        }
    }
}


//run
fun main(){
    val p1 = Person("1","Amit")  //person 1
    val p2=Person("2","Suhani")  //person 2

    val manager = ExpenseManager()  //which manages expenses

    //add expenses
    manager.addExpense(Expense("e1",200.0,p1,"Dinner"))
    manager.addExpense(Expense("e2",400.0,p2,"Cab"))

    //split calculation
    val splits = manager.calculateSplit(listOf(p1,p2))

    println("Final Settlement: ")
    splits.forEach {   //loop shortcut
        (person,amt) ->  //key values from splits  //destructuring components
        println("${person.name} should pay Rs$amt")
    }

}


//Composition in Kotlin is a design principle where a class is constructed by combining references to other objects (components) rather than inheriting from them. Instead of building an "is-a" relationship (like inheritance), it creates a "has-a" relationship—where one class has or uses another class to achieve functionality. This approach promotes code reusability, flexibility, and maintainability by allowing you to swap or modify behaviors at runtime without being tied to a rigid class hierarchy. By delegating specific tasks to composed objects, each class remains focused on a single responsibility, making the code easier to test, debug, and extend. Essentially, composition helps you build complex systems from simple, interchangeable parts while avoiding the pitfalls of tight coupling and fragile base classes common in deep inheritance trees.