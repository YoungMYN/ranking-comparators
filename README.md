[![en](https://img.shields.io/badge/lang-en-green.svg)]()
[![ru](https://img.shields.io/badge/lang-ru-blue.svg)]()
# ranking-comparators
A few templates for compiling rating lists of objects, with different parameters storage structures

### non-nested-params-comparator
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
> The ideal application of this algorithm can be called the algorithm for compiling a rating table of football teams in a group:  
  If the number of points scored is the same for several teams, then we look at the difference in goals scored if the number of goals scored by several of these teams is the same,
  then we look at the number of goals conceded and so on.

**Note 1**:In this abstract, it is not possible to safely use the Unit class at the compilation level, so object initializations occur using Raw Types.  
If you want to avoid this, you need to be more specific.   
I have researched this issue, you can find my discussion on [Stack Overflow](https://stackoverflow.com/questions/78711032)
