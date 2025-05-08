create((DimX, DimY)) :- 
  DimX >= 0 , DimX < 8 , 
  DimY >= 0 , DimY < 8.

attack((FromX, _), (ToX, _)):- FromX = ToX.
attack((_, FromY), (_, ToY)):- FromY = ToY.
attack((FromX, FromY), (ToX, ToY)):-
  abs(FromX - ToX) =:= abs(FromY - ToY).
