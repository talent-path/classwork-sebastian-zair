const getWeather = function(){
    const zipcode = $("#zip").val()

$.get(
    // assign the variable within there zipcode to our API sp that we dp not have anything hard coded in there
    `http://api.openweathermap.org/data/2.5/weather?zip=${zipcode},US&appid=f584da4230b210ab25d3903b2eae560c&units=imperial`,
    function(data, textStatus, jqXHR){

        // Below is CSS. get the ID of our tag with the ID of zip
        $("#reportHeader").text(`Weather Report for ${data}`);
        $("#weatherDesc").text(date.weather[0].description);

        // point an image to a location by using the "src" attribute!
        let imageUrl = "http://openweathermap.org/img/wn/${data.weather[0].com}@2x.png";
        $("#weatherIcon").attr("src", ImageUrl);
        $("currentTemp").text(`${data.main.temp} degrees`);
        console.log(data);
        console.log(textStatus);
        console.log(jqXHR);

    }
)
}