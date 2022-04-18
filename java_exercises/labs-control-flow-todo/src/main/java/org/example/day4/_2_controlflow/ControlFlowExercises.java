package org.example.day4._2_controlflow;

public class ControlFlowExercises {
    /*
        TODO 3
        Children ride bicycles when the temperature outside is between 15 and 30 degrees (inclusive).
        Unless it is winter, then the lower limit is 10 instead of 15. Given an int temp and a boolean isWinter,
        return true if children ride bikes and false otherwise.

        kidsRide(30, false) -> true
        kidsRide(13, true)  -> true
        kidsRide(12, false) -> false
        kidsRide(5, false)  -> false
        kidsRide(31, true)  -> false
     */
    boolean kidsRide(int temp, boolean isWinter) {
        if ( temp >= 15 && temp <= 30 && isWinter == false || temp >= 10 && temp <= 30 && isWinter == true) {
            return true;
        }
        return false;
    }

    /*
        TODO 4

        Given two int values, a and b, return true if either one is 8. Or if their sum, difference or product is 6.
        The function Math.abs(num) computes the absolute value of a number.

        find8(8, 8)  -> true
        find8(8, -5) -> true
        find8(7, 15) -> true
        find8(4, 2)  -> true
        find8(6, 2)  -> true
        find8(-8, 1) -> false
        find8(12, 0) -> false
     */
    boolean find8(int a, int b) {

        if ( a == 8 || b == 8 ) {
            return true;
        }

        return ( Math.abs(a - b) == 8 || a + b == 8 || a * b == 8);
    }
/*   used Math.abs only where it needed where it returns the absolute value of a given argument,
        in this case we needed to make a - b absolute
*/

    /*
        TODO 5

        Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values,
        it should only count once towards the sum.

        sum(2, 3, 4) -> 9
        sum(2, 2, 4) -> 6
        sum(5, 3, 3) -> 8
        sum(1, 1, 1) -> 1
        sum(4, 2, 4) -> 6
        sum(5, 7, 3) -> 15
     */
    int sum(int a, int b, int c) {

//  part 1, if a = b and a = c, return the values of a, but if only a = b, return a + c

        if (a == b) {
            if (a == c) {
                return a;
            }
            return a + c;
        }
//  part 2, where a = c, only return a + b

        if (a == c) {
            return a + b;
        }

//  part 3, where b = c, only return a + b

        if ( b == c) {
            return a + b;
        }

//  part 4, if no value is equal to each other, return the sum of them all

    return ( a + b + c);

    }

    /*
        TODO 6

        You are invited out to dinner. Return true if you should go. Normally you go, except on Sundays you only
        go with your mom. In all cases, if it is past 20, you do not go.

        goOut(false, false, false) → true
        goOut(true, true, false)   → true
        goOut(true, true, true)    → false
        goOut(false, false, true)  → false
        goOut(true, false, false)  → false
     */
    boolean goOut(boolean isSunday, boolean isMom, boolean isPast20) {
//        first if ispast20 is true, then return false as regardless of anything else, you do not go

    if (isPast20) {
        return false;
    }
// if mom is true, you still go
    if (isMom) {
        return true;
    }
//    ! means not equal to so this means return true if it's not sunday?

    return (!isSunday);

    }

    /*
        TODO 7

        You want to hang paintings in a line, next to one another, on a gallery wall. The wall is 'length' meters long.
        You have a number of small paintings (1 m each) and big paintings (5 m each). Return true if it is possible
        to fill the entire wall by choosing from the given paintings. There are no gaps between paintings.

        hangPaintings(4, 1, 9)   -> true
        hangPaintings(3, 2, 10)  -> true
        hangPaintings(6, 1, 11)  -> true
        hangPaintings(3, 2, 9)   -> false
        hangPaintings(1, 4, 12)  -> false
        hangPaintings(20, 0, 21) -> false
     */
    boolean hangPaintings(int small, int big, int length) {
//need to go over reasoning and understand this section!!!
        int maxBig = length/5;
        if (maxBig <= big) {
            length -= maxBig * 5;
        } else {
            length -= big * 5;
        }
        return length <= small;

    }

    /*
        TODO 8

        Given a day of the week encoded as 1=Mon, 2=Tue, 3=Wed, ...7=Sun, and a boolean indicating if we are on vacation,
        return a String saying whether you should party or not. Mon-Thu and Sun, the String should be "Don't party"
        and on Fri and Sat, it should be "Party till midnight". Unless you are on vacation, then on Mon-Thu and Sun
        it should be "Party till midnight", and Fri and Sat it should be "Party all night".

        canParty(1, false) -> "Don't party"
        canParty(6, false) -> "Party till midnight"
        canParty(3, true)  -> "Party till midnight"
        canParty(5, true)  -> "Party all night"
     */
    String canParty(int day, boolean vacation) {

        /*  if vacation is true AND its day 5 or 6, then return party all night
        * we open a { so that we can make multiple statement for if vacation is true */
        if (vacation) {
            if (day == 5 || day == 6) {
                return "Party all night";
            }
//            if vacation is true, but its not day 5 0r 6, then return party till midnight
            return "Party till midnight";
//            end of } of initial statement,so now it is for if vacation is false
        } else if ( day == 5 ||day == 6) {
            return "Party till midnight";
        }
        return "Don't party";
    }
}
