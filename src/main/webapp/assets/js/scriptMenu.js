function changeTextAndClose(element) {
    var buttonText = element.innerText;
    var dropdown = document.getElementById("myDropdown");

    dropdown.classList.remove("active");
    dropdown.querySelector('.dropbtn').innerText = buttonText;
}

document.getElementById("myDropdown").addEventListener("click", function() {
    this.classList.toggle("active");
});


