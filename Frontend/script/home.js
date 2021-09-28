
let login_button = document.querySelector("[type=submit]");

let input_boxes = document.getElementsByTagName("Input");


login_button.addEventListener("click", (event) => 
{

    if(event.cancelable)
    {
        event.preventDefault();
    }

    login();
})

function login()
{
    let url = "http://localhost:4444/login" + "?username=" + input_boxes[0].value + "&?password=" + input_boxes[1].value;
    let xhr = new XMLHttpRequest;

    xhr.onreadystatechange = function()
    {
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            window.location.replace("main.html");
        }

    }

    xhr.open("POST",url);
    xhr.send();

}
