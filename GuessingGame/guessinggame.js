// guessing game 
// create the 4 squares first
// - each square will be identical

const divArray = []


let guessDiv = document.createElement("div");

// searches for tags with "body" as their name
let allBodyTags = document.getElementsByTagName("body");

let  bodyTag = allBodyTags[0];

//let guessHolder = document.getElementsByName("div");


guessDiv.style.height="150px"
guessDiv.style.width="450px"


bodyTag.appendChild(guessDiv);



for(let i = 0; i < 4; i++){
let numContainer = document.createElement("div");

numContainer.id="numDiv"+i;
numContainer.style.display="inline-block";
numContainer.style.height ="100px";
numContainer.style.width ="100px";
guessDiv.appendChild(numContainer);
divArray.push(numContainer);
numContainer.style.border="3px solid red"
}

let numInDivs = document.createElement("span");

numContainer.appendChild(numInDivs);

numContainer[0].innerHTML+= "TESTING";


const betterGGGen = function(){

    const digits = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  
    let answer = digits.splice( Math.trunc(Math.random() * (digits.length - 1) + 1 ), 1)[0];
  
    for( let i = 1; i < 4; i++ ){
  
      let randomIndex = Math.trunc(Math.random() * digits.length);
  
      let digit = digits.splice(randomIndex,1)[0];
      answer *= 10;
      answer += digit;
  
      //digits.splice(  )
  
  
    }
  
    return answer;
  
  }
  
//betterGGGen();
let secretNum = betterGGGen();  