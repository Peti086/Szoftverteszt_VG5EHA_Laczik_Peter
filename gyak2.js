function fizzBuzz(n) {
  if (n % 15 === 0) return 'FizzBuzz';
  if (n % 3 === 0) return 'Fizz';
  if (n % 5 === 0) return 'Buzz';
  return n;
}

QUnit.module('FizzBuzz Logic');

QUnit.test('Evaluates standard numbers and multiples of 3, 5, and 15', assert => {
  assert.strictEqual(fizzBuzz(1), 1);
  assert.strictEqual(fizzBuzz(2), 2);
  
  assert.strictEqual(fizzBuzz(3), 'Fizz');
  assert.strictEqual(fizzBuzz(6), 'Fizz');
  
  assert.strictEqual(fizzBuzz(5), 'Buzz');
  assert.strictEqual(fizzBuzz(10), 'Buzz');
  
  assert.strictEqual(fizzBuzz(15), 'FizzBuzz');
  assert.strictEqual(fizzBuzz(30), 'FizzBuzz');
});