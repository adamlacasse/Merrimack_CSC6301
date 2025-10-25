# General
Call instructor "GK"

Going to submit projects in Python and Java
- Java is "easier" because of self-documenting nature
- But can submit in either

Also need to focus on OOP

No set office hours
- Send email to ask questions
- Give three times that work and send a Zoom link to all three
	- He'll pick one and let us know
	- Tries to accommodate the first
# Module 3

## UML (Unified Modeling Language) — Explained for a Software Engineer

### 1. What UML Is (and Isn’t)
- **UML is a standardized visual language** for describing software systems.  
- It’s **not a programming language**, and it doesn’t tell you how to implement something. Instead, it helps people think about, design, and communicate about systems.  
- Think of it as a **blueprint** — similar to how architects draw floor plans before construction.  

---
### 2. Why UML Exists
You’ve probably had these situations as a full-stack dev:
- You’re explaining to a teammate how two services interact, and you end up drawing boxes and arrows on a whiteboard.  
- You’re onboarding to a new project and wish there were a high-level diagram that explained how everything fits together.  

👉 UML takes those **ad hoc sketches** and provides a **shared vocabulary of diagrams and notations** that any developer (or analyst, or architect) can read and understand.  

---
### 3. What UML Covers (the Big Picture)
UML has a lot of diagram types, but they fall into two main categories:  

1. **Structural diagrams** → “What the system *is*”  
   - **Class diagrams**: Show entities (classes, interfaces) and their relationships.  
   - **Component diagrams**: Show how modules or services fit together.  
   - **Deployment diagrams**: Show where code runs (servers, nodes, containers).  

2. **Behavioral diagrams** → “What the system *does*”  
   - **Use case diagrams**: Show how actors (users/systems) interact with the system.  
   - **Sequence diagrams**: Show the order of messages between objects/services.  
   - **Activity diagrams**: Show workflows (like flowcharts).  

👉 You don’t need to memorize all 14+ types of UML diagrams — most real-world use centers around **class, sequence,**

## Law of Demeter (LoD) — Principle of Least Knowledge

### 1. What It Is
The **Law of Demeter** is an object-oriented design guideline that says:

> "An object should only talk to its immediate friends, not strangers."

In practice, a method of an object should only call methods that belong to:
- Itself  
- Its fields (direct member variables)  
- Its method parameters  
- Objects it directly creates  

It should **not** reach deep into object graphs, for example:

```java
a.getB().getC().doSomething();
```

---

### 2. Why It Matters
A common example you may have seen:

```java
order.getCustomer().getAddress().getZipCode();
```

This is sometimes called a **train wreck** (a long chain of calls). Problems:
- If the structure of `Customer` or `Address` changes, this code breaks.  
- The calling code knows **too much** about the internals of `Order`.  
- It is harder to test and maintain.  

A better approach is to let `Order` provide a method:

```java
order.getCustomerZipCode();
```

Now the caller only talks to `Order`, and `Order` handles the details internally.

---

### 3. How It Connects to UML
- In UML class diagrams, the Law of Demeter is about minimizing **coupling** between classes.  
- Instead of a class depending on several layers of relationships, design interfaces so that each class has a **direct, shallow connection** to what it needs.  

---

### 4. Analogy (Real-World)
Think of ordering food at a restaurant:

- **Good design**: You tell the **waiter** what you want. The waiter talks to the chef, who talks to suppliers. You don’t need to know the farmer.  
- **Bad design**: You walk into the kitchen, ask the chef where they get tomatoes, then go to the supplier, then to the farmer. That’s brittle, messy, and not your job.  

---

### 5. Origins of the Name
- The Law of Demeter originated in the **Demeter Project** at Northeastern University (late 1980s).  
- The project focused on **adaptive programming** and reducing dependencies between objects.  
- The name comes from the Greek goddess **Demeter**, who represents **nurturing and growth**. The metaphor: software should be designed to **grow and adapt** gracefully.  

---

### 6. Relation to SOLID Principles
The Law of Demeter is not one of the five SOLID principles, but it complements them:

- **Single Responsibility Principle (SRP):** Classes expose only what’s relevant to themselves.  
- **Interface Segregation Principle (ISP):** Classes expose focused, useful methods instead of forcing clients to dig through structures.  
- **Dependency Inversion Principle (DIP):** Clients depend on higher-level abstractions rather than low-level details.  

All of these encourage:
- Low coupling  
- High cohesion  
- Encapsulation  

---

### TL;DR
The Law of Demeter says: **do not chain through objects; only talk to your direct collaborators.**  

It reduces coupling, makes systems easier to change, and pairs naturally with SOLID principles for cleaner design.


---


Sure thing — here’s a concise, conversational summary you could paste into your group chat:

---

I feel like the Law of Demeter is usually a good thing for code design, but it’s more of a guideline than a hard rule. The big idea is that you shouldn’t chain calls deep into another object’s guts (`a.getB().getC().getD()`), because that makes your code tightly coupled and fragile if the internals change.

That said, applying it too rigidly can just create “middleman” methods that don’t add real value, like just wrapping `getX().getY()` in another method for no reason. The sweet spot is to use LoD whenever it helps hide complexity, keeps objects talking only to their close collaborators, and prevents ripple effects when code changes.

In big evolving use cases, it’s _almost always_ worth it. In smaller or simpler cases, it’s fine to be pragmatic and skip it if the extra indirection doesn’t actually improve clarity or maintainability.

In short: LoD is most beneficial when it actually **protects encapsulation and makes your code less brittle** — not when it just adds boilerplate.

---

Do you want me to also give you a **one-liner version** you can drop when you don’t want the long explanation?


# Module 4
***Naming convention:*** first part of Merrimack email

## Quiz notes
Yes, the `extends` keyword can also be used with interfaces in Java, but in a different way than with classes:
### Interface extending another interface:
An interface can extend another interface using the `extends` keyword:
```Java
interface Animal {
    void eat();
}

interface Mammal extends Animal {
    void breathe();
}

class Dog implements Mammal {
    public void eat() { System.out.println("Dog eats"); }
    public void breathe() { System.out.println("Dog breathes"); }
}
```

### Multiple interface inheritance:
Unlike classes, an interface can extend multiple interfaces:
```Java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

interface Duck extends Flyable, Swimmable {
    void quack();
}
```

### Key differences:
- **Classes**: Use `extends` to inherit from one superclass and `implements` to implement interfaces
- **Interfaces**: Use `extends` to inherit from other interfaces (can be multiple)

So while classes use `implements` to work with interfaces, interfaces themselves use `extends` to create inheritance hierarchies with other interfaces. This still primarily enables **polymorphism** as the fundamental OOP concept, as the extending interface can be used polymorphically wherever its parent interfaces are expected.

---

### public, package-private (no qualifier), protected, private
The `protected` access modifier is more restrictive than `public` but allows visibility to subclasses of a given class.

Here's how the Java access modifiers work in terms of visibility:
1. **public** - Most permissive: Accessible from anywhere
2. **protected** - More restrictive than public: Accessible within the same package AND by subclasses (even if they're in different packages)
3. `<no qualifier>` (package-private) - More restrictive: Accessible only within the same package
4. **private** - Most restrictive: Accessible only within the same class

The `protected` modifier specifically allows:

- Access from within the same package
- Access from subclasses, even if they're in different packages

This makes it the ideal choice when you want to restrict access more than `public` would allow, but still enable subclasses to access the member for inheritance purposes.

Example:
```Java
public class Parent {
    protected int value; // Accessible to subclasses
}

public class Child extends Parent {
    public void method() {
        value = 10; // This works because value is protected
    }
}
```

### Aggregation
One class references objects of another class that exist independently. The referenced objects can exist without the referencing class.
```Java
// Person class exists independently
class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

// Department class aggregates Person objects
class Department {
    private String name;
    private List<Person> employees; // Aggregation - references existing Person objects
    
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    
    public void addEmployee(Person person) {
        employees.add(person); // Adding existing Person objects
    }
    
    public void removeEmployee(Person person) {
        employees.remove(person);
    }
}

// Usage
public class AggregationExample {
    public static void main(String[] args) {
        // Persons exist independently
        Person john = new Person("John");
        Person jane = new Person("Jane");
        
        Department dept = new Department("IT");
        dept.addEmployee(john); // Aggregating existing objects
        dept.addEmployee(jane);
        
        // Even if department is destroyed, persons still exist
    }
}
```

### Composition
One class creates and owns objects of another class as part of its internal structure. The created objects typically cannot exist independently of the creating class.
```Java
// Room class - part of a House
class Room {
    private String type;
    private double area;
    
    public Room(String type, double area) {
        this.type = type;
        this.area = area;
    }
    
    public String getType() {
        return type;
    }
}

// House class composes Room objects
class House {
    private String address;
    private List<Room> rooms; // Composition - House creates and owns rooms
    
    public House(String address) {
        this.address = address;
        this.rooms = new ArrayList<>();
        
        // House creates its own rooms - composition
        rooms.add(new Room("Living Room", 300.0));
        rooms.add(new Room("Bedroom", 200.0));
        rooms.add(new Room("Kitchen", 150.0));
    }
    
    public void addRoom(String type, double area) {
        rooms.add(new Room(type, area)); // Creating new Room objects
    }
    
    public List<Room> getRooms() {
        return rooms;
    }
}

// Usage
public class CompositionExample {
    public static void main(String[] args) {
        House myHouse = new House("123 Main St");
        
        // Rooms are created as part of the House
        // If House is destroyed, rooms are also destroyed
        // Rooms cannot exist without the House
        for (Room room : myHouse.getRooms()) {
			System.out.println("Room Type: " + room.getType());
		}
    }
}
```

### Collections class
The Java `Stack` class extends `Vector` and adds stack-specific functionality through methods like `push()`, `pop()`, and `peek()`. Methods like `add()` and `remove()` are inherited from its parent class `Vector`, not defined specifically for `Stack`.

### Law of Demeter
Q: According to the Law of Demeter, which of the options CANNOT call a method m of a Class C?
A: Methods of a subclass C

#### Why "Methods of a subclass of C" violates the Law of Demeter:

The Law of Demeter states that an object should only call methods on:
1. Itself
2. Objects passed as parameters
3. Objects it creates
4. Its direct component objects (instance variables)

**The violation occurs when:**
- A method in a subclass tries to call method `m` on a **separate instance** of Class C
- This creates inappropriate coupling between the subclass and external instances of its parent class
- The subclass is reaching beyond its immediate "friends" to interact with objects it shouldn't directly know about

#### Example of the violation:
```Java
class C {
    public void m() { /* some method */ }
}

class SubclassOfC extends C {
    public void someMethod() {
        C externalInstance = getInstanceFromSomewhere();
        externalInstance.m(); // This violates Law of Demeter!
    }
}
```
#### Why the other options DON'T violate it:
- **Methods of C**: A class can call its own methods ✓
- **An object held in an instance variable of class C**: Can call methods on its direct components ✓
- **An object created by method m**: Can call methods on objects it creates ✓

#### My Initial Error:
I confused **inheritance** (where subclasses can call inherited methods) with the Law of Demeter violation of **external object interaction**. The Law of Demeter specifically prohibits reaching out to call methods on objects that aren't in your immediate "circle of friends," which includes separate instances of parent classes.

Thank you for the correction - this is a subtle but important distinction in understanding the Law of Demeter!

### Software reuse
Q: Which kind of software reuse is discouraged?
A: 
#### Why "Forked" Reuse is Most Discouraged:

**Forked reuse** means taking existing code and creating a separate, independent copy that evolves on its own path. This creates severe systemic problems:
###### 1. **Maintenance Explosion**
- Each fork requires separate maintenance and bug fixes
- Security vulnerabilities must be patched in every fork independently
- What should be one codebase becomes many diverging codebases
###### 2. **Lost Collaboration Benefits**
- Improvements in one fork don't benefit the others
- Development effort is fragmented instead of consolidated
- The community/team loses the advantages of shared development
###### 3. **Divergence Over Time**
- Forks drift apart, becoming increasingly incompatible
- Eventually becomes impossible to merge improvements back
- Creates "islands" of similar but incompatible solutions
###### 4. **Organizational Inefficiency**
- Multiple teams solve the same problems independently
- Duplicated effort across the organization
- Knowledge and improvements don't propagate

#### Why I Was Wrong About "Opportunistic":

While **opportunistic reuse** (ad-hoc copy-paste) is definitely problematic, it's more of a **tactical issue**:
- Usually involves smaller code snippets
- Can be refactored and cleaned up relatively easily
- Creates technical debt but not structural fragmentation
- The problems are more localized and fixable

### UML follow-up
**UML is semi-formal**

The semi-formal nature of UML is what prevents automatic code generation from UML definitions. Here's why:

**Semi-formal** means that UML combines both formal elements (with precise syntax and semantics) and informal elements (natural language descriptions, ambiguous relationships, and imprecise specifications). For automatic code generation to work reliably, a modeling language needs to be completely formal and unambiguous - every element must have precise, well-defined semantics that can be interpreted by a computer program.

UML's semi-formal characteristics that prevent automatic code generation include:

- Method implementations are not specified (only signatures and interfaces)
- Detailed algorithms and business logic are not captured
- Constraints and business rules may be expressed informally in natural language
- Platform-specific implementation details are deliberately abstracted away
- The same UML model can often be interpreted in multiple valid ways

While the other characteristics (open-source, general purpose, developmental) may add complexity, they don't fundamentally prevent code generation. The semi-formal nature is the core barrier because automated tools cannot reliably resolve the ambiguous or informal parts of UML models.

# Module 5
"If you are using getters and setters, it is probably a bad design" - teacher (GK)

Tomorrow's (Friday) discussion: "not more than ten lines"

"Please name your folders by your Merrimack email address"

# Module 8 / Final

**Software Design Methodology Summary**

Software design methodology is crucial for preventing costly errors that typically occur early in development. A methodology provides underlying principles and rules governing systematic procedures, encompassing four key components: a conceptual model, procedural guidelines, avoidance criteria, and evaluation standards.

The design process involves creative invention and analysis to address recognized needs, whether well-defined or ill-defined. Designers must consider constraints like hardware, implementation languages, and company practices while exploring multiple solutions within the design's degrees of freedom. Design is inherently iterative, requiring thorough analysis to ensure objectives are met without over-engineering.

Software design methodologies are classified into four main approaches:

1. **Level-Oriented Design**: Uses top-down decomposition (stepwise refinement) or bottom-up composition strategies to break complex systems into manageable modules.
2. **Data Flow-Oriented Design**: Emphasizes information processing through data flow diagrams (DFDs), mapping input-output streams using transform or transaction analysis.
3. **Data Structure-Oriented Design**: Focuses on input, internal, and output data structures to drive software development, particularly effective for hierarchical information systems.
4. **Object-Oriented Design**: Utilizes abstraction, information hiding, and modularity through objects containing private data structures and operations, accessed via message interfaces.
    
These approaches aren't mutually exclusive and can be integrated depending on project requirements. Design methodology establishes common communication channels and objectives, particularly important for large, complex projects involving multiple developers.

---

A Software Development Methodology is a framework for structuring and controlling software development processes. Adherence to SDMs like Waterfall, Iterative, or Agile often determines project success or failure.

Many projects fail due to "fly-by-night" approaches where customers skip essential planning phases (concept analyses, requirements gathering, design specifications) in favor of immediate development. This leads to systems delivered late, over budget, and failing to meet expectations.

Proper SDM implementation provides better estimates, stable systems, clear communication, early problem identification, and proactive management. Without SDMs, common issues include poor customer-developer communication, systems that don't meet needs, customer mistrust, and defect-ridden deployments.

Developers also suffer from poor morale due to scope changes and constant fixes when processes are poorly defined. SDMs create roadmaps that manage scope creep and prevent common development problems.

Organizations should begin by conducting "Lessons Learned" meetings to document past project shortcomings and eliminate non-value-adding steps. The key is to START using an SDM—there's no one-size-fits-all solution. Choose what works, stick to it, and continuously adjust the methodology to meet specific project needs and scenarios.

### Types of Software Development Methodologies (SDM)

![[Screenshot 2025-10-23 at 7.27.28 PM.png]]

**12 key software development methodologies**:

**Traditional/Sequential Methods:**
- **Waterfall Model** - Linear, easy to understand but inflexible for changes
- **V Model** - Parallel testing phases, good for small projects but rigid
- **Prototype Methodology** - Creates samples for validation, reduces risks but can increase costs

**Agile/Iterative Methods:**
- **Agile** - Adaptive with continuous improvement, transparent but lacks documentation
- **Scrum** - Team-driven decision making, suitable for changing requirements but needs expert teams
- **Extreme Programming (XP)** - High customer involvement, modern quality methods but depends heavily on people
- **Lean Development** - Low budget/time requirements but team-dependent success

**Hybrid/Specialized Methods:**
- **Spiral Model** - Risk-focused for complex projects but costly and potentially endless
- **Rapid Application Development (RAD)** - Quick results with customer feedback but needs skilled personnel
- **Feature Driven Development** - Good for large teams and continuous updates but not suitable for small projects
- **Joint Application Development** - Collaborative workshops but requires significant time investment
- **Rational Unified Process (RUP)** - Documentation-focused with risk reduction but complex to understand

**Modern Approach:**
- **DevOps** - Integrates development and operations for faster delivery but can be costly and complex

Each methodology suits different project types, team sizes, and organizational needs, with trade-offs between flexibility, documentation, cost, and complexity.

---
### DevOps Summary (TechTarget)

**DevOps** is an organizational approach that bridges the gap between software development and IT operations through a comprehensive umbrella of tools, technologies, and cultural practices. The methodology emphasizes automation, collaboration, and continuous improvement throughout the software development lifecycle.

Key aspects include:

**Core Principles:**

- Breaking down silos between development and operations teams
- Implementing continuous integration/continuous deployment (CI/CD) pipelines
- Automating infrastructure provisioning and management
- Emphasizing security integration (DevSecOps)

**Essential Technologies:**

- Infrastructure as Code (IaC) tools like Terraform
- Container technologies and orchestration platforms
- Configuration management systems
- Monitoring and observability solutions

**Current Evolution:**  
DevOps is adapting to modern challenges including AI integration, platform engineering, and cloud-native architectures. Organizations are incorporating MLOps (Machine Learning Operations) and AIOps (Artificial Intelligence for IT Operations) to handle increasingly complex environments.

**Business Impact:**  
DevOps enables faster software delivery, improved collaboration between teams, reduced deployment failures, and enhanced system reliability. The approach transforms traditional waterfall development into agile, iterative processes that respond quickly to business needs.

The methodology continues evolving with emerging trends like agentic AI, advanced automation, and enhanced security practices integrated throughout the development pipeline.

### Design patterns
Examples include
- Singleton
- Abstract factory
- Factory
- Builder
- Prototype
### Structural patterns
Examples include
- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Proxy
### Behavior patterns
Examples include
- Chain of responsibility
- Command
- Interpreter
- Iterator
- Mediator
- Memento
- Observer
- State
- Visitor


## Final Exam
8 questions
Don't spend move than a half hour on any (four hours total)

Design patterns (from Module 8) won't be on it







