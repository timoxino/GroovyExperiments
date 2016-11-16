class SizeFilter
{
    int limit

    boolean upTo(String value)
    {
        return value.size() < limit
    }

    boolean upTo(int value)
    {
        return value < limit
    }
}

def filter5 = new SizeFilter(limit: 5)
def filter6 = new SizeFilter(limit: 6)

Closure upTo5 = filter5.&upTo

def words = ['small', 'tiny', 'very big']
def digits = [1, 2, 3, 4, 5, 6, 7]

assert 'tiny' == words.find(upTo5)
assert 2 == words.findAll(filter6.&upTo).size()
assert 4 == digits.findAll(upTo5).size()
