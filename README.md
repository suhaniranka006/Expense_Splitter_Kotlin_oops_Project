# 🎯Project: Smart Expense Splitter


## 🔥Overview
This is a **console-based Kotlin project** that helps split group expenses equally among members.

It demonstrates **Object-Oriented Programming (OOPs**) concepts in a real-world scenario like **trips, parties, or events**.



## 🔥OOP Concepts Used

1.**Encapsulation**
   
Example:

class Person (val id: String, val name: String)

//All data related to a person (id, name) is encapsulated/bundled inside the Person class.

2.**Composition**

Example:

class Expense (val id:String, val amount:Double, val payer:Person, val description:String)

//Expense contains a Person object (payer). This shows **“has-a” relationship** → Expense has a Person.



3.**Abstraction (via Manager class)**

Example:

class ExpenseManager { ... }

//Users don’t worry about how expenses are stored or calculated; they just call addExpense() and calculateSplit().


4.**Higher-Order Functions**

Example:

val total = expenses.sumOf { it.amount }

//Kotlin’s functional style replaces manual loops with clean expressions.


5.**Destructuring & Map usage**

Example:

splits.forEach { (person, amt) -> println("${person.name} should pay Rs$amt") }

//forEach directly unpacks Map entries into person and amt.


## 🔥UML Class Diagram

classDiagram

    class Person {
        - id: String
        - name: String
    }

    class Expense {
        - id: String
        - amount: Double
        - payer: Person
        - description: String
    }

    class ExpenseManager {
        - expenses: MutableList<Expense>
        + addExpense(expense: Expense): Unit
        + calculateSplit(members: List<Person>): Map<Person, Double>
    }

    Person "1" <-- "1" Expense : payer
    ExpenseManager "1" --> "*" Expense : manages



## 🔥How the Program Works (Flow)

1.Create Person objects → members of the group.

2.Add Expense objects → store who paid how much for what.

3.Store everything in ExpenseManager.

4.Call calculateSplit() → divides total equally among all members.

5.Print results in a friendly format.


## 🔥Sample Run (Output)

Final Settlement:

Amit should pay Rs300.0

Suhani should pay Rs300.0


## 🔥Future Enhancements

Add different expense types (FoodExpense, TravelExpense using inheritance).

Add support for unequal splitting (e.g., weights based on who used more).

Store expenses in a file or database.

Create a simple Android app UI on top of this logic.

