class Weekday implements Comparable<Weekday>
{
    private int index = 0
    private static def DAYS = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']

    Weekday(String day)
    {
        index = DAYS.indexOf(day)
    }

    Weekday previous()
    {
        return new Weekday(DAYS[index - 1])
    }

    Weekday next()
    {
        return new Weekday(DAYS[(index + 1) % DAYS.size()])
    }

    @Override
    int compareTo(Weekday another) {
        return index <=> another.index
    }

    @Override
    String toString()
    {
        return DAYS[index]
    }
}

def monday = new Weekday('Mon')
def friday = new Weekday('Fri')

workingDays = ''
(friday..monday).each { day ->
    workingDays += day.toString() + ' '
}

assert workingDays == 'Fri Thu Wed Tue Mon '
assert (++(new Weekday('Sun'))).toString() == 'Mon'
assert (--monday).toString() == 'Sun'
