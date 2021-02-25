console.log("Hello world!");
// use tsc to convert our ts into js
// then use node - name of js file- to print out your ts file.. lmao

let boolVariable: boolean = false;
let decimal: number = 6;
let bigIntVariable: bigint = 100n;

let strVariable: string = "Hello";
let oldArray: string[] = ["Frank", "Zair", "Mary", "Mack"];
// tuple = ordered set of data
// order and type matters
let tupleVar: [number, string, boolean];

tupleVar = [5, "Robert", false];

//enums

enum streetLight{
    Red,
    Yellow,
    Green
}

streetLight.Yellow;

// unknown types
// we're not going to make use of these in terms of where a type is contraint
// unknown and 'any' are like cousins lmao
// 'any' is a code smell