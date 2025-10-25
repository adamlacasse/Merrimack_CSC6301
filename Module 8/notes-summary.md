# Notes Summary — CSC 6301 Software Design & Documentation

## General / Admin
- Instructor: GK. Address as "GK".
- Submissions: Python or Java (Java favored for self-documentation). Emphasis on OOP.
- Office hours by email: propose three times and include Zoom links; GK picks one.
- Naming: Use Merrimack email prefix for folder names.

## UML (Unified Modeling Language)
- Purpose: Standard visual language for describing systems; not executable code.
- Value: Shared vocabulary for diagrams beyond ad hoc whiteboard sketches.
- Common diagrams:
  - Structural: Class, Component, Deployment
  - Behavioral: Use Case, Sequence, Activity (most commonly used)
- Semi-formal nature prevents reliable automatic code generation (algorithms, constraints, and platform details aren’t fully specified, allowing multiple interpretations).

## Law of Demeter (LoD)
- Principle: "Only talk to your immediate friends" (self, fields, parameters, objects you create). Avoid deep chains like `a.getB().getC().doX()`.
- Benefits: Lower coupling, better encapsulation, easier change/testing; complements SRP, ISP, DIP.
- Pragmatism: Avoid creating pointless "middleman" methods; apply when it reduces brittleness and hides complexity.
- Clarification: LoD restricts calling methods on unrelated/external instances—even in subclasses—beyond immediate collaborators. Don’t confuse inheritance with permission to reach into separate instances of a parent.

## Java Focus Points
- Interfaces: Interfaces extend other interfaces (multiple allowed). Classes extend one class and implement interfaces.
- Access modifiers (broad → narrow): public → protected → package-private → private; protected visible to package peers and subclasses (even cross-package).
- Aggregation vs Composition:
  - Aggregation: Has-a reference to independent objects (can outlive the aggregator).
  - Composition: Owns/creates parts that don’t exist independently of the whole.
- Collections: `Stack` extends `Vector`; `push/pop/peek` are stack-specific; `add/remove` inherited.

## Software Reuse
- Discouraged: Forked reuse (independent copies that diverge). Causes maintenance explosion, lost collaboration, incompatibility, and organizational inefficiency.
- Opportunistic copy/paste is problematic but typically localized and easier to refactor than forked divergence.

## Software Design Methodology (SDM)
- Why: Prevent early, costly errors; enforce communication, planning, evaluation, and scope control.
- Four design approaches:
  1) Level-Oriented (top-down/bottom-up)
  2) Data Flow-Oriented (DFDs; transform/transaction)
  3) Data Structure-Oriented (input/internal/output structures)
  4) Object-Oriented (abstraction, information hiding, modularity)
- Process guidance: Start using an SDM; iterate and tailor it. Do lessons-learned and remove non-value steps.

### Types of SDM (high-level)
- Traditional/Sequential: Waterfall, V-Model, Prototyping
- Agile/Iterative: Agile, Scrum, XP, Lean
- Hybrid/Specialized: Spiral, RAD, FDD, JAD, RUP
- Modern: DevOps (integrates Dev + Ops; CI/CD, automation, observability, security/DevSecOps; evolving with MLOps/AIOps/platform engineering)

## Design Patterns (high-level catalog)
- Creational: Singleton, Abstract Factory, Factory, Builder, Prototype
- Structural: Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy
- Behavioral: Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Visitor

## Final Exam Notes
- 8 questions; budget ~30 minutes each (~4 hours total).
- Module 8 design patterns are not on the exam (per note).
