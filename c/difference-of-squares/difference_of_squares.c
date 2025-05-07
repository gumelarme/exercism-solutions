#include "difference_of_squares.h"


unsigned int square_of_sum(unsigned int n){
  unsigned int total = 0;
  for (unsigned int i = 0; i < n; i++){
    total += i + 1; 
  }
  return total * total;
}

unsigned int sum_of_squares(unsigned int n){
  int total = 0;
  for(unsigned int i = 1; i < n + 1; i++ ){
    total += i * i; 
  }
  return total;
}

unsigned int difference_of_squares(unsigned int number){
  return square_of_sum(number) - sum_of_squares(number);
}
