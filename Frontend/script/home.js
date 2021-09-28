
let login_button = document.querySelector("[type=submit]");

let input_boxes = document.getElementsByTagName("Input");


login_button.addEventListener("click", (event) => 
{

    if(event.cancelable)
    {
        event.preventDefault();
    }

    window.location.replace("main.html");

})
