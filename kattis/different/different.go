package main

import (
	"bufio"
	"fmt"
	"math/big"
	"os"
)

func main() {
	s := bufio.NewScanner(os.Stdin)
	for s.Scan() {
		a := new(big.Int)
		b := new(big.Int)
		fmt.Sscanf(s.Text(), "%s %s", a, b)
		c := new(big.Int).Sub(a, b)
		fmt.Println(new(big.Int).Abs(c))
	}
}
