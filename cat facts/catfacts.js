const getRandomAnimalFacts = function(){

    //<!-- Make a button for random and a button for quantity-->
    //console.log("TESTING1");
    const animalType = $("#animals").val();
    $.get(
        
        `https://cat-fact.herokuapp.com/facts/random?animal_type=${animalType}`,
        function(data, textStatus, jqXHR){
    
            //console.log("TESTING2");
            // Below is CSS. get the ID of our tag with the ID of zip
            // const zipcode = $("#zip").val()
            // assign the variable within there zipcode to our API sp that we dp not have anything hard coded in there
        //https://cat-fact.herokuapp.com/facts/random?animal_type=${animals}

            //console.log(data.text);
           // const animalType = $("#animals").val();
           
            //$("#animals").text(data.text);
            $("#div1").text(data.text);

           // onchange = someFunction() will be how I can change my backgrounds based on user input mwahahhahaha
            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
    
        }
    )
    }
// solutions:
// 1.) have each of the 5 things be assigned to their own indivdual div within a div?
// welp didn't need that. Solved the solution without Eliot or Google at 2:38 PM

const get5RandomAnimalFacts = function() {
    const animalTypes = $("#animals").val();
    const animalCount = $("#count").val();
    $.get(
        `https://cat-fact.herokuapp.com/facts/random?animal_type=${animalTypes}&amount=${animalCount}`, 
        function(data, textStatus){ 
            //let str = "";

                for(let i =0; i < data.length; i++){
                    $("#orderedDiv").append('<li>' + data[i].text + '</li>');
                    
                     //str += data[i].text + "\n";
                     
                }
                
           // console.log(str);
           // $("#div2").text(str); // :D
           

            console.log(data);
            console.log(textStatus);

    })
}

// let a user to select an available animal type AND a the amount of facts they want to see about a given animal