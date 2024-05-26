import std/strutils
import std/sequtils

proc hey*(s: string): string =
  var 
    message = s.strip()
    isQuestion = message.endsWith("?")
    isYelling = message.any(isAlphaAscii) and not message.any(isLowerAscii) 
  
  if message.len == 0:
    return "Fine. Be that way!"

  if isQuestion and isYelling:
      return "Calm down, I know what I'm doing!"

  if isQuestion:
      return "Sure."

  if isYelling:
      return "Whoa, chill out!"

  return "Whatever."

