// =============================================================
// JavaScript Basics: a runnable cheat sheet for beginners
// Run it with:  node javascript-basics.js
// Read top to bottom. Each section prints what it demonstrates.
// =============================================================

function section(title) {
  console.log(`\n===== ${title} =====`);
}

// -------------------------------------------------------------
// 1. Variables: let, const (avoid var)
// -------------------------------------------------------------
section("1. Variables");

let age = 20;          // can be reassigned
age = 21;
const name = "Ada";    // cannot be reassigned
// var oldStyle = 1;   // older keyword; function-scoped, avoid it

console.log(name, age);

// -------------------------------------------------------------
// 2. Data types
// -------------------------------------------------------------
section("2. Data types");

const aNumber = 42;          // number (integers and decimals share one type)
const aDecimal = 3.14;
const aString = "hello";     // string
const aBoolean = true;       // boolean
const nothing = null;        // deliberately empty
let notSet;                  // undefined: declared but no value
const aBigInt = 123n;        // bigint for very large integers

console.log(typeof aNumber, typeof aDecimal, typeof aString, typeof aBoolean);
console.log(typeof nothing, typeof notSet, typeof aBigInt); // "object" for null is a known quirk

// -------------------------------------------------------------
// 3. Operators
// -------------------------------------------------------------
section("3. Operators");

console.log(7 + 2, 7 - 2, 7 * 2, 7 / 2, 7 % 2, 2 ** 3); // 9 5 14 3.5 1 8

// Always use === and !== (strict). == converts types and surprises people.
console.log(5 === 5, 5 === "5", 5 == "5"); // true false true

// Logical operators
console.log(true && false, true || false, !true);

// ?? gives a fallback only for null or undefined
const username = null ?? "guest";
console.log(username);

// Increment / compound assignment
let count = 0;
count++;
count += 5;
console.log(count); // 6

// -------------------------------------------------------------
// 4. Strings
// -------------------------------------------------------------
section("4. Strings");

const first = "Grace";
const last = "Hopper";
const full = `${first} ${last}`;     // template literal (backticks)
console.log(full);
console.log(full.length);             // 12
console.log(full.toUpperCase());
console.log(full.includes("Hop"));    // true
console.log(full.slice(0, 5));        // "Grace"
console.log(full.split(" "));         // ["Grace", "Hopper"]
console.log("  trim me  ".trim());
console.log(full[0]);                 // "G"

// -------------------------------------------------------------
// 5. Conditionals
// -------------------------------------------------------------
section("5. Conditionals");

const score = 85;
if (score >= 90) {
  console.log("A");
} else if (score >= 80) {
  console.log("B");
} else {
  console.log("C or lower");
}

// Ternary: condition ? valueIfTrue : valueIfFalse
const result = score >= 60 ? "pass" : "fail";
console.log(result);

// switch
const day = "tue";
switch (day) {
  case "mon":
    console.log("Monday");
    break;
  case "tue":
    console.log("Tuesday");
    break;
  default:
    console.log("Some other day");
}

// Truthy / falsy: these are falsy: false, 0, "", null, undefined, NaN
if ("") console.log("never printed");
if ("text") console.log("non-empty strings are truthy");

// -------------------------------------------------------------
// 6. Loops
// -------------------------------------------------------------
section("6. Loops");

for (let i = 0; i < 3; i++) {
  console.log("for", i);
}

let w = 0;
while (w < 2) {
  console.log("while", w);
  w++;
}

const colors = ["red", "green", "blue"];
for (const color of colors) {        // for...of: values of an array/string
  console.log("of", color);
}

const person = { name: "Linus", lang: "C" };
for (const key in person) {          // for...in: keys of an object
  console.log("in", key, person[key]);
}

for (let i = 0; i < 10; i++) {
  if (i === 1) continue;             // skip this round
  if (i === 3) break;                // stop the loop
  console.log("break/continue", i);  // prints 0 and 2
}

// -------------------------------------------------------------
// 7. Functions
// -------------------------------------------------------------
section("7. Functions");

// Function declaration
function add(a, b) {
  return a + b;
}

// Arrow function
const multiply = (a, b) => a * b;

// Default parameter
function greet(who = "world") {
  return `Hello, ${who}!`;
}

// Rest parameter: collects any number of arguments into an array
function sum(...numbers) {
  let total = 0;
  for (const n of numbers) total += n;
  return total;
}

console.log(add(2, 3), multiply(2, 3), greet(), greet("Ada"), sum(1, 2, 3, 4));

// Functions are values: they can be passed to other functions (callbacks)
function applyTwice(fn, value) {
  return fn(fn(value));
}
console.log(applyTwice((x) => x * 2, 5)); // 20

// -------------------------------------------------------------
// 8. Scope and closures
// -------------------------------------------------------------
section("8. Scope and closures");

// let/const are block-scoped: they only exist inside the { } they are declared in
{
  const insideBlock = "only here";
  console.log(insideBlock);
}
// console.log(insideBlock); // ReferenceError

// A closure: an inner function remembers variables from where it was created
function makeCounter() {
  let n = 0;
  return () => ++n;
}
const counter = makeCounter();
console.log(counter(), counter(), counter()); // 1 2 3

// -------------------------------------------------------------
// 9. Arrays
// -------------------------------------------------------------
section("9. Arrays");

const nums = [5, 1, 4, 2, 3];
console.log(nums.length, nums[0], nums.at(-1)); // 5 5 3

nums.push(6);          // add to end
nums.pop();            // remove from end
nums.unshift(0);       // add to start
nums.shift();          // remove from start
console.log(nums.indexOf(4), nums.includes(10));

// The most useful array methods (they don't change the original):
const doubled = nums.map((n) => n * 2);            // transform each item
const evens = nums.filter((n) => n % 2 === 0);     // keep matching items
const total = nums.reduce((acc, n) => acc + n, 0); // combine into one value
const firstBig = nums.find((n) => n > 3);          // first match
console.log(doubled, evens, total, firstBig);
console.log(nums.some((n) => n > 4), nums.every((n) => n > 0));

// sort changes the array in place. Give numbers a compare function!
const sorted = [...nums].sort((a, b) => a - b);
console.log(sorted, nums.join("-"));

nums.forEach((n, index) => console.log(`index ${index}: ${n}`));

// -------------------------------------------------------------
// 10. Objects
// -------------------------------------------------------------
section("10. Objects");

const book = {
  title: "Dune",
  year: 1965,
  author: { name: "Frank Herbert" },
  describe() {
    return `${this.title} (${this.year})`;   // "this" is the object
  },
};

console.log(book.title, book["year"], book.author.name, book.describe());
book.pages = 412;              // add a property
delete book.pages;             // remove a property
console.log(Object.keys(book));
console.log(Object.entries({ a: 1, b: 2 }));
console.log(book.publisher?.name); // optional chaining: undefined instead of an error

// -------------------------------------------------------------
// 11. Destructuring and spread
// -------------------------------------------------------------
section("11. Destructuring and spread");

const { title, year } = book;          // pull properties into variables
const [firstNum, secondNum] = [10, 20]; // pull items out of an array
console.log(title, year, firstNum, secondNum);

const moreNums = [...[1, 2], 3];             // copy/combine arrays
const updatedBook = { ...book, year: 2021 }; // copy object, override a field
console.log(moreNums, updatedBook.year, book.year);

// -------------------------------------------------------------
// 12. Classes
// -------------------------------------------------------------
section("12. Classes");

class Animal {
  #secret = "private field"; // # makes a field private

  constructor(name) {
    this.name = name;
  }

  speak() {
    return `${this.name} makes a sound.`;
  }

  static create(name) {       // called on the class, not an instance
    return new Animal(name);
  }
}

class Dog extends Animal {     // inheritance
  speak() {
    return `${this.name} barks.`;
  }
}

console.log(Animal.create("Generic").speak());
console.log(new Dog("Rex").speak());
console.log(new Dog("Rex") instanceof Animal); // true

// -------------------------------------------------------------
// 13. Error handling
// -------------------------------------------------------------
section("13. Error handling");

function divide(a, b) {
  if (b === 0) {
    throw new Error("Cannot divide by zero");
  }
  return a / b;
}

try {
  console.log(divide(10, 2));
  console.log(divide(1, 0));
} catch (err) {
  console.log("Caught:", err.message);
} finally {
  console.log("finally always runs");
}

// -------------------------------------------------------------
// 14. Useful built-ins
// -------------------------------------------------------------
section("14. Useful built-ins");

console.log(Math.round(4.6), Math.floor(4.6), Math.ceil(4.1), Math.max(1, 9, 3));
console.log(Math.floor(Math.random() * 6) + 1); // random 1..6
console.log(Number("42"), parseInt("42px"), parseFloat("3.5"), String(99));
console.log(Number.isNaN(Number("abc")));       // true
console.log((3.14159).toFixed(2));              // "3.14"

const now = new Date();
console.log(now.getFullYear());

// JSON: convert between objects and text
const json = JSON.stringify({ a: 1, list: [1, 2] });
console.log(json, JSON.parse(json).list);

// Map and Set
const ages = new Map();
ages.set("Ada", 36).set("Alan", 41);
console.log(ages.get("Ada"), ages.has("Alan"), ages.size);

const unique = new Set([1, 2, 2, 3, 3]);
console.log([...unique]); // [1, 2, 3]

// -------------------------------------------------------------
// 15. Asynchronous code: callbacks, Promises, async/await
// -------------------------------------------------------------
section("15. Async (output appears at the end)");

// setTimeout runs a function later; the rest of the program keeps going
setTimeout(() => console.log("\n[async] setTimeout finished"), 0);

// A Promise represents a value that will be ready later
function wait(ms, value) {
  return new Promise((resolve) => setTimeout(() => resolve(value), ms));
}

wait(10, "promise value").then((v) => console.log("[async] then:", v));

// async/await: the cleaner way to work with Promises
async function loadData() {
  try {
    const a = await wait(20, "first");
    const b = await wait(20, "second");
    console.log("[async] await:", a, b);

    // Run several at once and wait for all of them
    const all = await Promise.all([wait(10, 1), wait(10, 2)]);
    console.log("[async] Promise.all:", all);
  } catch (err) {
    console.log("[async] error:", err.message);
  }
}
loadData();

// In a browser or Node 18+, fetch() loads data from the web:
// const response = await fetch("https://api.example.com/data");
// const data = await response.json();

// -------------------------------------------------------------
// 16. Modules (sharing code between files)
// -------------------------------------------------------------
// CommonJS (Node default):
//   module.exports = { add };             // in math.js
//   const { add } = require("./math.js"); // in another file
//
// ES modules (browsers, and Node with .mjs or "type": "module"):
//   export function add(a, b) { ... }     // in math.js
//   import { add } from "./math.js";      // in another file

// -------------------------------------------------------------
// 17. The browser DOM (only works in a web page, not in Node)
// -------------------------------------------------------------
// const button = document.querySelector("#myButton");
// const output = document.getElementById("output");
// button.addEventListener("click", () => {
//   output.textContent = "Clicked!";
//   output.classList.add("highlight");
// });
// const item = document.createElement("li");
// item.textContent = "New item";
// document.querySelector("ul").appendChild(item);

section("Done with the synchronous part");
