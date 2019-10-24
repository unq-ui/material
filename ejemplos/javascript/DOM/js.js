// Objects
let tony = { name: 'tony', age: 50, avenger: true, planet: 'earth' };
let steve = {...tony, name: 'steve', age: 87 };
let thor = {...tony, name: 'thor', age: 1200, planet: 'asgard' };
let {planet, ...rest} = thor;

planet

// // Arrays
// let avengers = ['tony', 'steve', 'thor'];
// let assemble = [...avengers, 'strange', 'peter'];
// let more = ['bruce', 'natasha'];
// let all = [...assemble, ...more];
// let [first, second, ...rest] = all;

// // Functions
// function paramsToArray(...xs) {
//     console.log(xs);
// }
// paramsToArray(1, 2, 3, 4, 5) // [1, 2, 3, 4, 5]

// function obj({name, age}) {
//     return {name: name.toUpperCase(), age: age * 2}
// }
// obj(thor); // { name: 'THOR', age: 2400 }

// function spreadObj({ name, age, ...obj}) {
//     return {...obj, name: name.toUpperCase(), age: age * 2}
// }