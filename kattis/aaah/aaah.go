package main

import "fmt"

func main() {
	var able string
	var required string
	fmt.Scanln(&able)
	fmt.Scanln(&required)
	if len(able) >= len(required) {
		fmt.Println("go")
	} else {
		fmt.Println("no")
	}
}
