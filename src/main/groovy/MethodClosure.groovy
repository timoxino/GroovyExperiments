class SizeFilter
{
    int limit

    boolean upTo(String value)
    {
        return value.size() < limit
    }
}

def filter5 = new SizeFilter(limit: 5)
def filter6 = new SizeFilter(limit: 6)

Closure upTo5 = filter5.&upTo

def words = ['small', 'tiny', 'very big']

assert 'tiny' == words.find(upTo5)
assert 2 == words.findAll(filter6.&upTo).size()
