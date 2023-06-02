// from https://www.codewars.com/kata/514b92a657cdc65150000006/train/javascript
function solution(number){
  return number > 0 ? [...Array(number)].map((_,i) => i).filter(i => i % 3 == 0 || i % 5 == 0).reduce((a, b) => a + b) : 0;
}