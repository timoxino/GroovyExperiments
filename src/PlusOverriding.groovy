import groovy.transform.Immutable

@Immutable
class Money
{
    int amount
    String currency

    Money plus(Money other)
    {
        if(other == null) return this
        if(currency != other.currency) throw new IllegalArgumentException("Can't add $currency to $other.currency")
        return new Money(amount + other.amount, currency)
    }

    Money plus(Integer more)
    {
        return new Money(amount + more, currency)
    }
}

def buck = new Money(1, 'USD')

assert buck + buck == new Money(2, 'USD')
assert buck + 4 == new Money(5, 'USD')