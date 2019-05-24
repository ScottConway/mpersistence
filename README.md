# mpersistence

Inspired by a Numberphile video about multiplicative persistence.  
The purpose was to find the combinations of numbers
that could be put together to test the multiplicative persistence of a number.  

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
 whould have been 133 digits.  
 
To me this makes sense as when your as your exponents get bigger and bigger the chances of 
having a 0 or 5 in the result become 100%.  But because this problem apparently 
has been tested with up to a three hundred digits makes me feel like I am missing
something.  

So feel free to look over my code and let me know if there is a flaw in 
my approach to this problem.    

# What's new

**3/26/2019** - Realized a bug in my logic in that when I got the powers of the a
digit I had already done the first iteration of multiplicative persistence.   
Changed program to take that into account and I did come up with more digits (133 vs 56)
but that is well short of the 300 that has been performed so still feel like 
I am missing something.

**3/30/2019** - Made one more change that really speeded up the program.  I 
realized that for the 2, 3, and 4 I only need a single digit because beyond that
it is a combination of existing numbers (4^2 is the same as 2\*4, 4^3 is the 
same as 2\*4\*8, 4^4 is the same as 4\*8\*8, etc.)  This gave fewer combinations 
to put together to test yielding a seven fold speed increase on my mac mini.

**4/30/2019** - The idea that this could be so simple has bugged me for a while 
so I wrote a unit test that proved myself wrong.  I collected the smallest value 
for each persistence level and compared them with the known list from [wikipedia](https://en.wikipedia.org/wiki/Persistence_of_a_number) 
and found the discrepancies.   First was at persistence of 7 the smallest value is 68889
but I got 246889.   Doing the math I found that 8^3 = 512 so my theory about 5 being
a bad digit was okay but not as a digit in a building block because when I 
multiplied that by the rest of the digits I got 27648 - which is a good number.

The same went for 0 because after removing the check for 5 the next discrepancy was the persistence level 10 where 
the smallest number is 3778888999 and I got 24666778899.  Here again doing the math I 
saw that 8^4 = 4096 so I threw out that building block but multiplying all the digits 
together removed the zero.    

So I removed the check and now consider all numbers in the building blocks (still only 
taking a single 2, 3, 4 though) and while it is considerably slower, 34 seconds to compute 
a max of 30 digits in a building block,  I still see a limit where I stop finding 
persistent numbers because at a certain level a zero becomes inevitble when multiplying out.    