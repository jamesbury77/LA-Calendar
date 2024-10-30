package CalendarApp

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
