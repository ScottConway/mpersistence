# mpersistence
Inspired by a Numberphile video about multiplicative persistence.  
The purpose was to find the combinations of numbers
that could be put together to test the multipliative persistence of a number.  

You can find out more about multiplicative persistence either from the 
[Numberphile youtube video](https://www.youtube.com/watch?v=Wim9WJeDTHQ&t=603s) 
or the [Wikipedia article](https://en.wikipedia.org/wiki/Persistence_of_a_number).

My idea was to take each of the digits to build a number with the possibility 
of a high persistence (2,3,4,6,7,8,9) and find all the powers of that number up
to a given limit, currently 500, and for each of those go through and multiply all the digits 
once (first iteration of multiplicative persistence) and as long as that number
did not have a 0 or 5 (which would cause the persistence to short circuit quickly) 
I kept as a possibility.  

The thought was I would then take that map and go through all the combinations, 
append them together in a string and test each to see if it has a high persistence.
That way I would have fewer numbers to test and would be much quicker than brute force. 
But what I found though was that I had very few combinations - 28 to be precise with 
the largest number I could make by combining the largest for each number
 whould have been 56 digits.  
 
To me this makes sense as when your as your exponents get bigger and bigger the chances of 
having a 0 or 5 in the result become 100%.  But because this problem apparently 
has been tested with up to a three hundred digits makes me feel like I am missing
something.  

So feel free to look over my code and let me know if there is a flaw in 
my approach to this problem.    
