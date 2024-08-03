import std/sequtils
import std/sugar
import std/math

proc sum*(limit: int, factors: openArray[int]): int =
  var numbers = newSeq[int]()

  for f in factors.filter(x => x > 0):
    let
      ff = f # I don't know why tho
      count = limit div ff
      multis = toSeq(1..count).map(x => x * ff).filter(x => x < limit)

    for v in multis.filter(x => x notin numbers):
      numbers.add(v)

  numbers.sum
