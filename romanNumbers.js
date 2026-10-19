function toRoman(num) {
  const romanMap = [
    { value: 1000, numeral: 'M' },
    { value: 900, numeral: 'CM' },
    { value: 500, numeral: 'D' },
    { value: 400, numeral: 'CD' },
    { value: 100, numeral: 'C' },
    { value: 90, numeral: 'XC' },
    { value: 50, numeral: 'L' },
    { value: 40, numeral: 'XL' },
    { value: 10, numeral: 'X' },
    { value: 9, numeral: 'IX' },
    { value: 5, numeral: 'V' },
    { value: 4, numeral: 'IV' },
    { value: 1, numeral: 'I' }
  ];

  let result = '';
  for (const { value, numeral } of romanMap) {
    while (num >= value) {
      result += numeral;
      num -= value;
    }
  }
  return result;
}

QUnit.module('Arab - Római konverter');

QUnit.test('Alap karakterek és egyszerű hozzáadások', assert => {
  assert.strictEqual(toRoman(1), 'I');
  assert.strictEqual(toRoman(2), 'II');
  assert.strictEqual(toRoman(3), 'III');
  assert.strictEqual(toRoman(5), 'V');
  assert.strictEqual(toRoman(8), 'VIII');
  assert.strictEqual(toRoman(10), 'X');
});

QUnit.test('Kivonásos szabályok', assert => {
  assert.strictEqual(toRoman(4), 'IV');
  assert.strictEqual(toRoman(9), 'IX');
  assert.strictEqual(toRoman(40), 'XL');
  assert.strictEqual(toRoman(90), 'XC');
});

QUnit.test('Összetett és nagy számok', assert => {
  assert.strictEqual(toRoman(58), 'LVIII'); 
  assert.strictEqual(toRoman(1994), 'MCMXCIV'); 
  assert.strictEqual(toRoman(3999), 'MMMCMXCIX'); 
});