package main

import (
	"encoding/csv"
	"fmt"
	"os"
	"strconv"
)

type LA struct {
	name        string
	hours       int
	workedHours int
}

func (la *LA) getName() string {
	return la.name
}

func (la *LA) getTotalHours() int {
	return la.hours
}

func (la *LA) getWorkedHours() int {
	return la.workedHours
}

func (la *LA) setHoursLeft() {
	la.workedHours -= 1
}

func main() {
	csvFile := "responses1.csv"
	file, err := os.Open(csvFile)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	defer file.Close()

	reader := csv.NewReader(file)
	records, err := reader.ReadAll()
	if err != nil {
		fmt.Println("Error:", err)
		return
	}

	avail := make([]*LA, 0)
	time := setTimeValues()

	for _, record := range records {
		name := record[0]
		hours, err := strconv.Atoi(record[1])
		if err != nil {
			fmt.Println("Error:", err)
			continue
		}

		la := &LA{name: name, hours: hours, workedHours: 0}

		for i := 2; i < len(record); i++ {
			if index, ok := time[record[i]]; ok {
				if len(avail) <= index {
					avail = append(avail, make([]*LA, index-len(avail)+1)...)
				}
				avail[index] = la
			}
		}
	}

	for i, la := range avail {
		if la != nil {
			fmt.Printf("Time slot %d: %s\n", i, la.getName())
		} else {
			fmt.Printf("Time slot %d: No LA available\n", i)
		}
	}
}

func setTimeValues() map[string]int {
	time := make(map[string]int)
	csvFile := "time.csv"
	file, err := os.Open(csvFile)
	if err != nil {
		fmt.Println("Error:", err)
		return time
	}
	defer file.Close()

	reader := csv.NewReader(file)
	records, err := reader.ReadAll()
	if err != nil {
		fmt.Println("Error:", err)
		return time
	}

	for i, record := range records {
		time[record[0]] = i
	}

	return time
}
