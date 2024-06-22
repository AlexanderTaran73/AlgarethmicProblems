package Solutions.Leetcode_649

import java.util.*
/*
In the world of Dota2, there are two parties: the Radiant and the Dire.

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:

Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".
*/

class Solution {
    fun predictPartyVictory(senate: String): String {
        var q1: Queue<Int> = LinkedList()
        var q2: Queue<Int> = LinkedList()
        val n = senate.length
        for (i in 0..n-1){
            if (senate[i] == 'R') q1.add(i)
            else q2.add(i)
        }

        while (!q1.isEmpty() && !q2.isEmpty()){

            if (q1.first() > q2.first()) q2.add(q2.first() + n)
            else q1.add(q2.first() + n)

            q1.remove()
            q2.remove()
        }
        if (q1.isEmpty()) return "Dire"
        else return "Radiant"
    }
}