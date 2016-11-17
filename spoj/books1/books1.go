package main

import "fmt"

/*

- Best-case scenario is that you can divide the books into k parts with equal sums
    - This can happen if all the books have the same value
    - Can also happen with e.g. k = 2, p = 100 100 / 200
- At most 500 books and 200 cases -> 100,000 books total
- Minimize the work assigned to the first scriber, then second, etc. -> for loop
- Each person has to have at least one book

m = 9, k = 3
1 2 3 4 5 6 7 8 9

initially first group is / 1 / -> now, with k = 2 and m = 8, trying to find
k = 2 equal groups inside 2 3 4 5 6 7 8 9 -> this can't happen
BUT why are you even trying to find equal groups? that's not the win condition.
condition is that you must minimize the MAX sum.

brute-force try all solutions:
1 / 2 / 3 ... 9
- Need to place two (k - 1) divisions inside m slots... (m choose k - 1) could get very big
- can avoid duplicated work by only continuing with solutions that have the
minimum for the first group as being less than the maximum minimum
- to avoid re-computing sums, can change the list into a sum as you go
- this explains why this is a binary search problem despite the page amounts
not being in sorted order

1 2 3 4 5 6 7 8 9
becomes
1 3 6 10 15 21 28 36 45

1 1 1 1 1
becomes
1 2 3 4 5

- once you place a division after p_i, you can subtract Sum(p_i) from each Sum(p_{j > i})
e.g., placing a division after 1 in the first case makes the sum list
0 / 2 5 9 14 20 27 35 44

trivially in this case with k = 2, you only need to place one division.

- what does binary search do? well, in a sorted list of length n, it takes log(n)
time to say whether or not that element exists in the list
- it can be modified to return the largest element smaller than a given element
- knowing that the sum for the first scribe is 1, you could see if there is
another series with sum 1... but would this produce the optimal solution?

- maybe work backwards so that the smallest workload is assigned to the first scribe
- how would you re-update the list then? say you have

1 2 3 4 5 6 7 / 8 9

then the sum list would be

28 27 25 22 18 13 7 / 17

- if you take the largest (by sum) sequence whose sum is *still* less than 17,
then you don't increase the maximum
    - e.g. in this case you can take up 6 and 7. the new sum list is then:
      15 14 12 9 5 / 13 / 17
- you can try this with all m choices for the back-end division
    - except each scribe has to get at least one book, so that means the back-end division
        can't go through the first k - 1 spots because each of the other k - 1
        scribes must receive at least one book

- pessimistically, if you try each position for the backend, you have O(m) iterations
of an inner loop. an inner loop does a binary search on a list of at most length m.
    - the inner loop also has to update the the sum list k - 1 times, one for each scribe.
        this costs (k - 1)(m) = O(M^2)

200 * 500^3 = 200 * (125 * 1000000) = 250 * 00000000 = 25,000,000,000

- but, you can avoid testing all placements for the first division by only
testing those divisions with their first sum <= the previous smallest max sum.
choosing a division whose first sum, and hence max sum, would be greater than
the max would be wasteful

- represent a division as a series of sums
- function to determine if one sum should replace another
    - compare max sums. no decision -> compare first sum, second sum, etc. note
        that all possible divisions will have the same number of sums so this
        comparison is relatively easy
*/

func main() {
	var n int
	fmt.Scanln(&n)
	for tc := 0; tc < n; tc++ {
		var m int
		var k int
		fmt.Scan(&m, &k)
		pages := make([]int64, m)
		for i := 0; i < m; i++ {
			var temp int64
			fmt.Scan(&temp)
			pages[i] = temp
		}
	}
}
