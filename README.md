[![en](https://img.shields.io/badge/lang-en-green.svg)](README.md)  
[![ru](https://img.shields.io/badge/lang-ru-blue.svg)](README.ru.md)
# ranking-comparators
A few templates for compiling rating lists of objects, with different parameters storage structures

### non-nested-params-comparator  
___
— this is a fairly abstract implementation of the system
that makes up the ranked lists of incoming objects represented by the Unit class.

The Unit class stores a Map of the parameters, the enum of which you set yourself in the class
Params Name.

The type of the stored parameter is not defined, the main condition is
the implementation of the interface Comparable .

In the Priority class, you set the priority of each parameter, I
have it implemented by a number (Integer). However, the numerical evaluation is quite subjective, so I recommend that you register your own enumeration class, and link it in the Priority class.
(Since an Enum storing ONE, TWO, THREE... will guarantee that any parameter will be evaluated on this scale,
however, this is not so important for rating, so I let this point go.)

The rating class compares our Units with each other, according to parameters based on their priority.

The comparison is based on the following principle: The comparator goes from the highest priority parameters to the least priority ones.  
The comparison process is lazy: if there are discrepancies in the highest priority parameter, then he will not even look at the other parameters.

*In one of the latest updates, a flag for data consistency was added to the comparator.
If this flag is set, validation will be performed before comparing the elements, verifying that each object contains the same set of fields.
If this flag is not set, the comparator will compare objects based on the available set of parameters.*

> The ideal application of this algorithm can be called the algorithm for compiling a rating table of football teams in a group:  
  If the number of points scored is the same for several teams, then we look at the difference in goals scored if the number of goals scored by several of these teams is the same,
  then we look at the number of goals conceded and so on.

**Note 1**:In this abstract, it is not possible to safely use the Unit class at the compilation level, so object initializations occur using Raw Types.  
If you want to avoid this, you need to be more specific.   
I have researched this issue, you can find my discussion on [Stack Overflow](https://stackoverflow.com/questions/78711032)


### tree-nested-params-comparator  
___  
— prototype of a system that compares objects with a high degree of tree nesting.

Each Person object in this project, contains a field with its own parameters, represented by an object of class Params.

Each class also has N number of children of the Person class, each with its own parameters (and children, and parameters, and so on ad infinitum).

Let's assume that we don't know anything about the degree of nesting of the incoming object, and we want to compare it with another object, by some parameter (in my case, the assumption of the system is that the comparison can take place only by fields inherited from the Number class, i.e. numbers. You can change this logic for your tasks). The list of parameters that can be compared is represented by the enum CalculatingParam inside the Params class. This enum stores the names of those variables by which we can compare one Person with another.

The class enumeration CalculatingStrategy provides some strategies by which it is possible to perform a calculation on any of the parameters whose name is listed in CalculatingParam.

>For example, CalculatingParam MAX combined with CalculatingParam.AGE, when comparing two Persons, ranks higher the one that has the Person with the higher maximum age in its inheritance tree than the object it is being compared to.



You can compare by average age in the tree, by total height among all children, by number of children, etc. The options are many and are limited only by your imagination.

_*Important note*_, it is recommended to represent leaves on a tree inheritance structure (objects that are not the parent node for any other object) by objects of the LastDescendant class, because it implements the necessary behavior, when invoking invalid operations with a tree leaf, for example, when trying to assign references to “children” to such a node, an UnsupportedOperationException will be thrown.

Also, such a class is convenient because you can implement tree leaf-specific behavior in it, and seamlessly manipulate the behavior of the object via polymorphism.

>Each of my implementations of the Runker classes implements a generic Runker interface with a single method List<String> printAndReturnRank(List<T>); If you want, you can use this interface (as well as the AbstractRanker class with an implemented helper method for console output) for your own implementation.



###### *The source code of this project is written using the AI technology of [SBER]( http://www.sberbank.ru/) – developer assistant [GigaCode]( https://gigacode.ru/)*