def quickSort(list)
{
    if (list.size() < 2) return list
    def pivot = list[list.size().intdiv(2)]
    def smaller = list.findAll { it < pivot }
    def equal = list.findAll { it == pivot }
    def bigger = list.findAll { it > pivot }
    return quickSort(smaller) + equal + quickSort(bigger)
}

assert quickSort([]) == []
assert quickSort([1]) == [1]
assert quickSort([3, 1, 2, 2]) == [1, 2, 2, 3]
assert quickSort(['a', 1.23f, 4, null]) == [null, 1.23f, 4, 'a']
assert quickSort('hello') == 'ehllo'.toList()
